package com.javarush.test.level30.lesson15.big01;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server
{

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message){
        try{
            for(Connection connection : connectionMap.values()){
                connection.send(message);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            ConsoleHelper.writeMessage("Сообщение не отправлено");
        }
    }

    private static class Handler extends Thread{
        private Socket socket;

        private Handler(Socket socket)
        {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {

            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();


                if (message.getType() == MessageType.USER_NAME) {

                    if (message.getData() != null && !message.getData().isEmpty()) {

                        if (connectionMap.get(message.getData()) == null) {

                            connectionMap.put(message.getData(), connection);

                            connection.send(new Message(MessageType.NAME_ACCEPTED));

                            return message.getData();
                        }
                    }
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {

            for (String key : connectionMap.keySet()) {
                Message message = new Message(MessageType.USER_ADDED, key);

                if (!key.equals(userName)) {
                    connection.send(message);
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {

            while (true) {

                Message message = connection.receive();

                if (message.getType() == MessageType.TEXT) {

                    String text = userName + ": " + message.getData();

                    Message newMessage = new Message(MessageType.TEXT, text);
                    sendBroadcastMessage(newMessage);
                } else {
                    ConsoleHelper.writeMessage("Error");
                }
            }
        }

        @Override
        public void run() {

            ConsoleHelper.writeMessage("Установленно соединение с адресом " + socket.getRemoteSocketAddress());
            String clientName = null;

            try (Connection connection = new Connection(socket)) {
                //Выводить сообщение, что установлено новое соединение с удаленным адресом
                ConsoleHelper.writeMessage("Подключение к порту: " + connection.getRemoteSocketAddress());
                //Вызывать метод, реализующий рукопожатие с клиентом, сохраняя имя нового клиента
                clientName = serverHandshake(connection);
                //Рассылать всем участникам чата информацию об имени присоединившегося участника (сообщение с типом USER_ADDED)
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, clientName));
                //Сообщать новому участнику о существующих участниках
                sendListOfUsers(connection, clientName);
                //Запускать главный цикл обработки сообщений сервером
                serverMainLoop(connection, clientName);


            } catch (IOException e) {
                ConsoleHelper.writeMessage("Ошибка при обмене данными с удаленным адресом");
            } catch (ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Ошибка при обмене данными с удаленным адресом");
            }

            //После того как все исключения обработаны, удаляем запись из connectionMap
            connectionMap.remove(clientName);
            //и отправлялем сообщение остальным пользователям
            sendBroadcastMessage(new Message(MessageType.USER_REMOVED, clientName));

            ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто");

        }
    }

    public static void main(String[] args)
    {
        ConsoleHelper.writeMessage("Введите порт сервера");
        int serverPort = ConsoleHelper.readInt();

        try (ServerSocket serverSocket =new ServerSocket(serverPort))
        {
            ConsoleHelper.writeMessage("Сервер был успешно запущен");
            while (true)
            {
                Socket connectedSocket = serverSocket.accept();
                Handler handlerForAdding = new Handler(connectedSocket);
                handlerForAdding.start();
            }
        }  catch (IOException e)
        {
            ConsoleHelper.writeMessage("Ошибка при запуске сервера. " + e.getMessage());
        }
    }
}

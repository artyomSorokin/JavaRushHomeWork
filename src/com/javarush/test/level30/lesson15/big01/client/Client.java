package com.javarush.test.level30.lesson15.big01.client;



import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client
{
    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress() {

        ConsoleHelper.writeMessage("������� ����� �������: ");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {

        ConsoleHelper.writeMessage("������� ���� �������: ");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {

        ConsoleHelper.writeMessage("������� ��� ������������: ");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSentTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {

        try {
            connection.send(new Message(MessageType.TEXT, text));

        } catch (IOException e) {
            ConsoleHelper.writeMessage("������ ��������");
            clientConnected = false;
        }
    }

    public void run() {

        // ��������� ����� �������� ����� � ������� ������ getSocketThread
        SocketThread socketThread = getSocketThread();
        // �������� ��������� ����� ��� daemon, ��� ����� ��� ����, ����� ��� ������
        // �� ��������� ��������������� ����� ��������� �������������.
        socketThread.setDaemon(true);
        // ��������� ��������������� �����
        socketThread.start();

        // ��������� ������� ����� �������, ���� �� �� ������� ����������� �� ������� ������
        try {
            synchronized (this) {
                this.wait();
            }
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("������");
            return;
        }

        //����� ����, ��� ����� �������� �����������, ������� �������� clientConnected
        if (clientConnected) {
            ConsoleHelper.writeMessage("���������� �����������. ��� ������ �������� ������� 'exit'.");

            //�������� ��������� � ������� ���� ������ ���������. ���� ����� ������� ������� 'exit', �� ����� �� �����
            while (clientConnected) {
                String message;
                if (!(message = ConsoleHelper.readString()).equals("exit")) {
                    if (shouldSentTextFromConsole()) {
                        sendTextMessage(message);
                    }
                } else {
                    return;
                }
            }
        }
        else {
            ConsoleHelper.writeMessage("��������� ������ �� ����� ������ �������.");
        }
    }



    public class SocketThread extends Thread{

        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage("�������� " + userName + " ������������� � ����");
        }

        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage("�������� " + userName + " ������� ���");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this){
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException{
            while(true){
                Message message = connection.receive();
                if(message.getType() == MessageType.NAME_REQUEST){
                    String userName = getUserName();
                    Message userNameMessage = new Message(MessageType.USER_NAME, userName);
                    connection.send(userNameMessage);
                }
                else if(message.getType() == MessageType.NAME_ACCEPTED){
                    notifyConnectionStatusChanged(true);
                    return;
                }
                else{
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException{
            while (true)
            {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT)
                {
                    processIncomingMessage(message.getData());
                }
                else if(message.getType() == MessageType.USER_ADDED){
                    informAboutAddingNewUser(message.getData());
                }
                else if(message.getType() == MessageType.USER_REMOVED){
                    informAboutDeletingNewUser(message.getData());
                }
                else{
                    throw new IOException("Unexpected MessageType");
                }

            }
        }

        public void run(){
            String serverAddress = getServerAddress();
            int serverPort = getServerPort();
            try
            {
                Socket socket = new Socket(serverAddress,serverPort);
                Client.this.connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            }
            catch (IOException e)
            {
                notifyConnectionStatusChanged(false);
            }
            catch (ClassNotFoundException e)
            {
                notifyConnectionStatusChanged(false);
            }
        }
    }

    public static void main(String[] args) {

        Client client = new Client();
        client.run();
    }


}

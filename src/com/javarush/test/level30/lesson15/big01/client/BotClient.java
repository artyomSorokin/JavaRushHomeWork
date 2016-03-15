package com.javarush.test.level30.lesson15.big01.client;


import com.javarush.test.level30.lesson15.big01.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client
{

    // 18.4.	Добавь метод main. Он должен создавать новый объект BotClient и вызывать у
    // него метод run().
    public static void main(String[] args)
    {
        BotClient botClient = new BotClient();
        botClient.run();
    }


    // 18.3.1.	getSocketThread(). Он должен создавать и возвращать объект класса BotSocketThread.
    @Override
    protected SocketThread getSocketThread()   {
        return  new BotSocketThread();
    }
    // 18.3.2.	shouldSentTextFromConsole(). Он должен всегда возвращать false. Мы не хотим,
    // чтобы бот отправлял текст введенный в консоль.
    @Override
    protected boolean shouldSentTextFromConsole()   {
        return false;
    }
    /* 18.3.3.	getUserName(), метод должен генерировать новое имя бота, например:
     date_bot_XX, где XX – любое число от 0 до 99. Этот метод должен возвращать
     каждый раз новое значение, на случай, если на сервере захотят
     зарегистрироваться несколько ботов, у них должны быть разные имена.
    */
    @Override
    protected String getUserName()  {
        int numberOfBot = (int) (Math.random()*99);
        return "date_bot_" +numberOfBot;
    }
    /*
    18.2.	В классе BotClient создай внутренний класс BotSocketThread унаследованный от
 SocketThread. Класс BotSocketThread должен быть публичным.
     */
    public class BotSocketThread extends Client.SocketThread    {
        /*
        Задание 19.
            Сегодня будем реализовывать класс BotSocketThread, вернее переопределять некоторые
        его методы, весь основной функционал он уже унаследовал от SocketThread.
        19.1.	Переопредели метод clientMainLoop():
        19.1.1.	С помощью метода sendTextMessage() отправь сообщение с текстом
        "Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды."
        19.1.2.	Вызови реализацию clientMainLoop() родительского класса.
        19.2.	Переопредели метод processIncomingMessage(String message). Он должен
        следующим образом обрабатывать входящие сообщения:
        19.2.1.	Вывести в консоль текст полученного сообщения message.
        19.2.2.	Получить из message имя отправителя и текст сообщения. Они разделены ": ".
        19.2.3.	Отправить ответ в зависимости от текста принятого сообщения. Если текст
        сообщения:
        "дата" – отправить сообщение содержащее текущую дату в формате "d.MM.YYYY";
        "день" – в формате"d";
        "месяц" - "MMMM";
        "год" - "YYYY";
        "время" - "H:mm:ss";
        "час" - "H";
        "минуты" - "m";
        "секунды" - "s".
        Указанный выше формат используй для создания объекта SimpleDateFormat. Для
        получения текущей даты необходимо использовать класс Calendar и метод
        getTime().
        Ответ должен содержать имя клиента, который прислал запрос и ожидает ответ,
        например, если Боб отправил запрос "время", мы должны отправить ответ
        "Информация для Боб: 12:30:47".
        Наш бот готов. Запусти сервер, запусти бота, обычного клиента и убедись, что все работает правильно.
        Помни, что message бывают разных типов и не всегда содержат ":"
         */
//19.1.	Переопредели метод clientMainLoop():
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            //19.1.1.	С помощью метода sendTextMessage() отправь сообщение с текстом
            //"Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды."
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            //19.1.2.	Вызови реализацию clientMainLoop() родительского класса.
            super.clientMainLoop();
        }
        //19.2.	Переопредели метод processIncomingMessage(String message). Он должен
        @Override
        protected void processIncomingMessage(String message)   {
            //19.2.1.	Вывести в консоль текст полученного сообщения message.
            ConsoleHelper.writeMessage(message);
            //19.2.2.	Получить из message имя отправителя и текст сообщения. Они разделены ": ".
            if (message.contains(": "))
            {
                String nameOfSender_Text[] = message.split(": ");
                String nameOfSender = "";
                nameOfSender= nameOfSender_Text[0];
                String text = "";
                text = nameOfSender_Text[1];
                SimpleDateFormat format = null;

                if ("дата".equalsIgnoreCase(text)) {
                    format = new SimpleDateFormat("d.MM.YYYY");
                }
                else if ("день".equalsIgnoreCase(text)) {
                    format = new SimpleDateFormat("d");
                }
                else if ("месяц".equalsIgnoreCase(text)) {
                    format = new SimpleDateFormat("MMMM");
                }
                else if ("год".equalsIgnoreCase(text)) {
                    format = new SimpleDateFormat("YYYY");
                }
                else if ("время".equalsIgnoreCase(text)) {
                    format = new SimpleDateFormat("H:mm:ss");
                }
                else if ("час".equalsIgnoreCase(text)) {
                    format = new SimpleDateFormat("H");
                }
                else if ("минуты".equalsIgnoreCase(text)) {
                    format = new SimpleDateFormat("m");
                }
                else if ("секунды".equalsIgnoreCase(text)) {
                    format = new SimpleDateFormat("s");
                }

                if (format != null)
                {
                    sendTextMessage("Информация для " + nameOfSender + ": " + format.format(Calendar.getInstance().getTime()));
                }



            }


        }



    }
}

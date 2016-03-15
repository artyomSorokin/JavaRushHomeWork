package com.javarush.test.level25.lesson07.home02;

import java.net.Socket;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.io.IOException;

public abstract class SocketTask<T> implements CancellableTask<T> {
    private Socket socket;

    protected synchronized void setSocket(Socket socket) {
        this.socket = socket;
    }

    public synchronized void cancel() {
        try
        {

                socket.close();

        }
        catch(IOException e){

        }
        //close all resources here
    }

    public RunnableFuture<T> newTask() {
        return new FutureTask<T>(this) {
            public boolean cancel(boolean mayInterruptIfRunning) {
                try
                {
                    socket.close();
                }
                catch(Exception e){

                }
                finally{
                    super.cancel(mayInterruptIfRunning);
                }
                //close all resources here by using proper SocketTask method
                //call super-class method in finally block
                return true;
            }
        };
    }
}
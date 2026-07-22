package demo07_TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(12345);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("服务器启动成功");
        ExecutorService ES = Executors.newFixedThreadPool(8);


        while(!serverSocket.isClosed()){
            Socket socket = null;
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                if(serverSocket.isClosed()){
                    System.out.println("服务器关闭");
                    break;
                }else{
                    e.printStackTrace();
                }
            }
            ES.submit(new receiveFileTask(socket));
        }

        ES.shutdown();
        serverSocket.close();
    }
}

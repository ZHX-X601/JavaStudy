package demo03_TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        Socket socket = serverSocket.accept();
        System.out.println("客户端连接成功");
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        socket.close();
        serverSocket.close();
    }
}

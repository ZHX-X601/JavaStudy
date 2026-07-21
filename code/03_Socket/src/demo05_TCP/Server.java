package demo05_TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("服务器启动成功");
        Socket socket = serverSocket.accept();
        System.out.println("客户端连接成功");

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

        OutputStream os = socket.getOutputStream();

        String str = null;
        while ((str = br.readLine()) != null) {
            System.out.println("客户端："+str);
            os.write("服务器已收到\n".getBytes());
            os.flush();
        }



        socket.close();
        serverSocket.close();
    }
}

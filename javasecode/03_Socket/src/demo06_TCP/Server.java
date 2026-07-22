package demo06_TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("服务器启动成功");
        Socket socket = serverSocket.accept();
        System.out.println("客户端连接成功");
        InputStream is = socket.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(is);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String Fname= UUID.randomUUID().toString().replace("-","");
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("03_Socket/src/demo06_TCP/sFile/"+Fname+".txt"));

        int len;
        byte[] b = new byte[1024*8];
        while ((len = bis.read(b))  != -1) {
            bos.write(b,0,len);
        }
        bos.flush();
        bos.close();

        bw.write("文件接收成功");
        bw.newLine();
        bw.flush();
        bw.close();

        serverSocket.close();
        socket.close();
    }
}

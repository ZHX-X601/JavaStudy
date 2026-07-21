package demo03_TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Clinet {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("127.0.0.1",12345);
        System.out.println("连接服务器成功");
        OutputStream os = socket.getOutputStream();
        os.write("hello word,你好\n".getBytes());
        os.flush();
        Thread.sleep(10000000000L);

        socket.close();
    }
}

package demo06_TCP;

import java.io.*;
import java.net.Socket;


/*
1.客户端发送文件到服务器端
2.添加反馈机制
3.
 */
public class Clinet {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",12345);
        System.out.println("连接服务器成功");
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream(new File("03_Socket/src/demo06_TCP/cFile/测试.txt"));
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        int len;
        byte[] b = new byte[1024*8];
        while ((len = bis.read(b))  != -1) {
            os.write(b,0,len);
        }
        os.flush();
        //关闭输出流
        socket.shutdownOutput();

        //读取服务器端返回的消息
        String line = br.readLine();
        System.out.println(line);
        br.close();

        bis.close();
        socket.close();
    }
}

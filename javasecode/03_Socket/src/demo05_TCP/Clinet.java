package demo05_TCP;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/*
客户端多次发送数据
服务器端多次接收数据

+

服务器收到并反馈给客户端
*/

public class Clinet {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",12345);
        System.out.println("连接服务器成功");
        OutputStream os = socket.getOutputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("请输入要发送的内容");
            String str =  sc.nextLine();
            if(str.equals("exit")){
                System.out.println("客户端退出");
                break;
            }else{
                os.write((str+"\n").getBytes());
                os.flush();
                String ss=br.readLine();
                System.out.println(ss);
            }
        }

        socket.close();
    }
}

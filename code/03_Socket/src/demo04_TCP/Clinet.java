package demo04_TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/*
客户端多次发送数据
服务器端多次接收数据
*/

public class Clinet {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",12345);
        System.out.println("连接服务器成功");
        OutputStream os = socket.getOutputStream();
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
            }
        }

        socket.close();
    }
}

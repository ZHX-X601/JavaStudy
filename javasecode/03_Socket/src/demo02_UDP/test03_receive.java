package demo02_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class test03_receive {
    public static void main(String[] args) throws IOException {
        MulticastSocket DS = new MulticastSocket(12345);
        InetAddress IP = InetAddress.getByName("224.0.0.1");
        DS.joinGroup(IP);

        byte[] b = new byte[1024];
        DatagramPacket dp = new DatagramPacket(b, b.length);

        //接收数据,阻塞式方法
        DS.receive(dp);

        byte[] data = dp.getData();
        System.out.println("接收的数据为："+new String(data,0,dp.getLength()));
        InetAddress ia = dp.getAddress();
        int port = dp.getPort();
        System.out.println("接收的客户端IP地址："+ia.getHostAddress());
        System.out.println("接收的客户端端口号："+port);


    }
}
/*
D:\develop\jdk\jdk17\bin\java.exe "-javaagent:D:\develop\IntelliJ IDEA 2025.2\lib\idea_rt.jar=4132" -Dfile.encoding=UTF-8 -classpath D:\文件\markdown\JavaStudy\code\out\production\网络编程 test01.test03
接收的数据为：hello word,你好
接收的客户端IP地址：127.0.0.1
接收的客户端端口号：55167

进程已结束，退出代码为 0
 */
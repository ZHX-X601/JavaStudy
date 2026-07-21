package demo01_UPD;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class test02_sent {
    public static void main(String[] args) throws IOException {

        DatagramSocket DS = new DatagramSocket();
        InetAddress IP = InetAddress.getByName("127.0.0.1");//255.255.255.255则表示广播地址

        int port = 12345;
        byte[] b = "hello word,你好".getBytes();
        DatagramPacket dp = new DatagramPacket(b, b.length,IP,port);
        DS.send(dp);
    }
}


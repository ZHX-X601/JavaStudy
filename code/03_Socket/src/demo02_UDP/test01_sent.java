package demo02_UDP;

import java.io.IOException;
import java.net.*;

public class test01_sent {
    public static void main(String[] args) throws IOException {
        MulticastSocket DS = new MulticastSocket();
        InetAddress IP = InetAddress.getByName("224.0.0.1");
        int port = 12345;
        byte[] b = "hello word,你好".getBytes();
        DatagramPacket dp = new DatagramPacket(b, b.length,IP,port);
        DS.send(dp);
    }
}


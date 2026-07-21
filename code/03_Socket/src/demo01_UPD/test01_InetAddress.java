package demo01_UPD;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class test01_InetAddress {
    public static void main(String[] args) throws UnknownHostException {

        //根据IP地址获取InetAddress对象
        InetAddress localHost = InetAddress.getByName("192.168.5.143");


        System.out.println(localHost.getHostAddress());//192.168.5.143
        System.out.println(localHost.getHostName());//192.168.5.143

        System.out.println("-----------------");

        //根据本地主机名获取InetAddress对象
        localHost = InetAddress.getLocalHost();
        System.out.println(localHost.getHostAddress());//192.168.5.143
        System.out.println(localHost.getHostName());//LAPTOP-V01TTBBG

        System.out.println("-----------------");

        localHost = InetAddress.getByName("LAPTOP-V01TTBBG");
        System.out.println(localHost.getHostAddress());//192.168.5.143
        System.out.println(localHost.getHostName());//LAPTOP-V01TTBBG


    }
}

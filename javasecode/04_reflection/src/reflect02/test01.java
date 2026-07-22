package reflect02;

public class test01 {
    public static void main(String[] args) {
        BigStar bigStar=new BigStar("张三",18);
        Star starProxy=ProxyUtil.newProxyInstance(bigStar);

        System.out.println(starProxy.sing("你好"));

        System.out.println("-----------------");

        starProxy.dance();
    }
}

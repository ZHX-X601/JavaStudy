import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class test06_Charset {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s1="java你好";
        byte[] utf8 = s1.getBytes();//默认使用utf-8编码

        System.out.println(Arrays.toString(utf8));
        //[106, 97, 118, 97, -28, -67, -96, -27, -91, -67]
        // j    a    v    a   你             好



        byte[] gbk = s1.getBytes("GBK");//指定使用GBK编码编码
        System.out.println(Arrays.toString(gbk));
        //[106, 97, 118, 97, -60, -29, -70, -61]
        // j    a    v    a   你        好

        String Sutf8 = new String(utf8,"UTF-8");//使用utf-8编码解码
        System.out.println(Sutf8);
        //java你好

        String Sgbk = new String(gbk,"GBK");//使用GBK编码解码
        System.out.println(Sgbk);
        //java你好

        Sutf8=new String(utf8,"GBK");//utf8使用GBK编码解码
        System.out.println(Sutf8);
        //java浣犲ソ

        Sgbk=new String(gbk,"UTF-8");//gbk使用utf8编码解码
        System.out.println(Sgbk);
        //java���


    }
}

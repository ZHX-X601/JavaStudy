import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

public class test08 {
    public static void main(String[] args) throws IOException, IOException {
        //
        // 指定读取utf-8编码的文件
        FileReader fr = new FileReader("day1 IO/字符.txt", Charset.forName("UTF-8"));
        int len;
        char [] a=new char[8];
        while((len=fr.read(a))!= -1){
            System.out.print(new String(a,0,len));
        }
        fr.close();
    }
}

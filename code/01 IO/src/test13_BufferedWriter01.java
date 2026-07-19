import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class test13_BufferedWriter01{
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("01 IO/字符.txt",Charset.forName("UTF-8"),true));
        bw.write("hello world");

        //字符缓冲输出流特有方法：newLine()，用于多平台换行
        bw.newLine();
        bw.write("hello你好world");
        bw.newLine();

        bw.close();
    }
}

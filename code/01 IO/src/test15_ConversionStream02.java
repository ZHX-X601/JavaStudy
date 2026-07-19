import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class test15_ConversionStream02 {
    public static void main(String[] args) throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("01 IO/test_GBK.txt",true), Charset.forName("GBK"));
        osw.write("hello world");
        osw.close();
    }
}

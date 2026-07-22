import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class test14_ConversionStream01 {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("01 IO/test_GBK.txt"),"GBK");

        int a;
        while((a=isr.read())!=-1){
            System.out.print((char)a);
        }

        isr.close();
    }
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

public class test12_BufferedReader01{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("01 IO/字符.txt", Charset.forName("UTF-8") ));

        //字符缓冲流特有方法：readLine()，用于读取一行文本，遇到文件末尾返回null表示读取完成
        String line;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }
        br.close();

    }
}

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class test01 {
    public static void main(String[] args) throws IOException {
        File file = new File("day1 IO/test.txt");

        // true 表示追加写入
        FileOutputStream fos = new FileOutputStream(file, true);

        fos.write("hello".getBytes());
//        fos.write('\r');
//        fos.write('\n');

        // 写入换行符
        fos.write("\r\n".getBytes());
        String str = "abcee\n";
        byte[] buffer = str.getBytes();
        fos.write(buffer);
        fos.close();
    }
}

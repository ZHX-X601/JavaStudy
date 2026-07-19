import java.io.FileWriter;
import java.io.IOException;

public class test09_CharacterStream03{
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("01 IO/字符.txt", true);//true 表示追加写入
        fw.write("hello world");
        fw.flush();//刷新缓冲区,将数据写入文件

        fw.write(97);
        fw.write("hello你好world",5,2);
        char[] a = {'a','b','c','d','e'};
        fw.write(a);
        fw.write(a,3,2);
        fw.close();
    }
}

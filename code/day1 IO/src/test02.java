import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class test02 {
    public static void main(String[] args) throws IOException {
        File file = new File("day1 IO/test.txt");
        FileInputStream fis = new FileInputStream(file);

//        逐个读取
//        int a=fis.read();
//        System.out.println((char)a);

//        循环读取
        int a;
        while((a=fis.read())!=-1){
            System.out.println((char)a);
        }
        fis.close();
    }
}

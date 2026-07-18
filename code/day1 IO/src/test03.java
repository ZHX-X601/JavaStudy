import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class test03 {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        FileInputStream fis = new FileInputStream("day1 IO/Generic PnP Monitor (Area) 2026-07-18 06-20 PM.mp4");
        FileOutputStream fos = new FileOutputStream("day1 IO/copy/test.mp4");
        int a;

        // 循环读取,逐个字节读取
        while((a=fis.read())!=-1){
            fos.write(a);
        }
        fos.close();
        fis.close();
        long endTime = System.currentTimeMillis();
        System.out.println("复制时间:"+(endTime-startTime)+"ms");//复制时间:10139ms
    }
}

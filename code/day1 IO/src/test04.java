import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class test04 {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        FileInputStream fis = new FileInputStream("day1 IO/Generic PnP Monitor (Area) 2026-07-18 06-20 PM.mp4");
        FileOutputStream fos = new FileOutputStream("day1 IO/copy/test.mp4");

        byte[] buffer = new byte[1024*1024*5];

        int len;

        // 循环读取,逐个缓冲区读取,速度更快
        while((len=fis.read(buffer))!= -1){
            fos.write(buffer,0,len);
        }
        fos.close();
        fis.close();
        long endTime = System.currentTimeMillis();
        System.out.println("复制时间:"+(endTime-startTime)+"ms");//复制时间:4ms
    }
}

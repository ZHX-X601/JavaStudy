import java.io.*;

public class test11_bufferedStream02 {
    public static void main(String[] args) throws IOException {
        long startTime=System.currentTimeMillis();

        //缓冲流默认缓冲区大小为8192字节
        //1.创建输入缓冲流，关联基本文件输入流
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream("01 IO/Generic PnP Monitor (Area) 2026-07-18 06-20 PM.mp4"));

        //2.创建输出缓冲流，关联基本文件输出流
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("01 IO/copy/test.mp4"));

        //每次从缓冲区读取1024个字节，直到读取到-1表示读取到文件末尾
        int len;
        byte[] buf=new byte[1024];
        while((len=bis.read(buf))!=-1){
            bos.write(buf,0,len);
        }

        //3.关闭流，底层基本流也会关闭
        bos.close();
        bis.close();

        long endTime=System.currentTimeMillis();
        System.out.println("复制时间："+(endTime-startTime)+"ms");//复制时间：4ms
    }
}

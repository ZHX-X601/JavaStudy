package demo07_TCP;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class receiveFileTask implements Runnable{
    private Socket socket;
    public receiveFileTask(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        String Fname = UUID.randomUUID().toString().replace("-", "");
        try (BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("03_Socket/src/demo07_TCP/sFile/" + Fname + ".txt"))
        ){
            System.out.println("客户端连接成功");
            int len;
            byte[] b = new byte[1024 * 8];
            while ((len = bis.read(b)) != -1) {
                bos.write(b, 0, len);
            }
            bos.flush();
            bos.close();

            bw.write("文件接收成功");
            bw.newLine();
            bw.flush();
            bw.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

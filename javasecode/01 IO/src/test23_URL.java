import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class test23_URL {
    public static void main(String[] args) throws IOException {
        URL url= new URL("https://www.cnblogs.com/Alkaid2077/p/21169603");
        URLConnection c = url.openConnection();
        InputStreamReader isr = new InputStreamReader(c.getInputStream());
        char[] cbuf = new char[1024];
        int len;

        StringBuffer sb = new StringBuffer();
        while((len=isr.read(cbuf))!=-1){
            sb.append(new String(cbuf,0,len));
        }
        System.out.println("当前工作目录: " + System.getProperty("user.dir"));
        //System.out.println(sb.toString());
        File file = FileUtil.writeString(sb.toString(), new File("01 IO/testhtml.html"),"UTF-8");
        System.out.println(file);
        System.out.println(file.exists());
        isr.close();
    }
}

import java.io.File;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        File file = new File("day1 IO/txt.txt");
        if(file.exists()){
            System.out.println("文件存在");
        }else{
            file.createNewFile();
            System.out.println("文件创建成功");
        }
    }
}

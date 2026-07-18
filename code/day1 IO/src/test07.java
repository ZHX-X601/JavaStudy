import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class test07 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("day1 IO/字符.txt");
        int a;
        while((a=fr.read())!=-1){
            System.out.print((char)a);
        }
        fr.close();
    }

}

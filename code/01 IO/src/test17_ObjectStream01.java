import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class test17_ObjectStream01 {
    public static void main(String[] args) throws IOException {
        Student s1 = new Student("张三", 18, "13800000000", "北京市海淀区");
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("01 IO/对象.txt"));
        oos.writeObject(s1);
        oos.close();

    }
}

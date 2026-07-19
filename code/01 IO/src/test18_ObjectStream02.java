import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class test18_ObjectStream02 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("01 IO/对象.txt"));
        Student s=(Student)ois.readObject();
        System.out.println(s);
        ois.close();
    }
}

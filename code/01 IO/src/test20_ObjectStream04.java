import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class test20_ObjectStream04 {
    public static void main(String[] args) throws IOException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("01 IO/对象.txt"));
        ArrayList<Student> stus=(ArrayList<Student>)ois.readObject();
        ois.close();
        for(Student s:stus){
            System.out.println(s);
        }
    }
}

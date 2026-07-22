import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class test19_ObjectStream03 {
    public static void main(String[] args) throws IOException {
        ArrayList<Student>  stus = new ArrayList<>();
        stus.add(new Student("zhangsan",18,"13800000000","北京市海淀区"));
        stus.add(new Student("lisi",19,"13800000001","北京市海淀区"));
        stus.add(new Student("wangwu",20,"13800000002","北京市海淀区"));

        //序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("01 IO/对象.txt"));
        oos.writeObject(stus);
        oos.close();
    }
}

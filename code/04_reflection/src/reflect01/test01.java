package reflect01;

public class test01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz1 = Class.forName("reflect01.Student");
        System.out.println(clazz1);

        Class clazz2 = Student.class;
        System.out.println(clazz2);

        Student st = new Student();
        Class clazz3 = st.getClass();
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);
    }
}

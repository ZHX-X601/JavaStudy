package reflect01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class test02 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class clazz = Class.forName("reflect01.Student");

        //创建对象,调用无参构造方法
        Student st = (Student) clazz.newInstance();
        System.out.println(st);

        System.out.println("-----------------");

        //获取有参构造方法
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        //创建对象,调用有参构造方法
        Student st2 = (Student) constructor.newInstance("张三", 18);
        System.out.println(st2);

        System.out.println("-----------------");

        Field field = clazz.getDeclaredField("name");
        //设置访问权限
        field.setAccessible(true);
        System.out.println(field.get(st2));

        //设置值
        field.set(st2, "李四");
        System.out.println(field.get(st2));

        System.out.println("-----------------");

        //获取方法
        Method method = clazz.getMethod("sing", String.class);
        method.invoke(st2, "XX");
    }
}

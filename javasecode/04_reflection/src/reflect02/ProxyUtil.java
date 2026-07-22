package reflect02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {
    public static Star newProxyInstance(BigStar bigStar){
        Star starProxy =(Star)Proxy.newProxyInstance(bigStar.getClass().getClassLoader(),
                new Class[]{Star.class},
                new InvocationHandler(){
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if(method.getName().equals("sing")){
                            System.out.println("代理开始准备唱歌场地");
                        }else if(method.getName().equals("dance")){
                            System.out.println("代理开始准备跳舞场地");
                        }
                        return method.invoke(bigStar, args);
                    }
                });
        return starProxy;
    }
}

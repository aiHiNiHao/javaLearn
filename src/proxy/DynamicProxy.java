package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {
    public static void main(String[] args) {
        User user = new User();
        DynamicUserProxy proxy = new DynamicUserProxy(user);
        Iuser iuser = (Iuser) Proxy.newProxyInstance(Iuser.class.getClassLoader(), new Class[]{Iuser.class}, proxy);
        iuser.eat("banana");

    }
}

class DynamicUserProxy implements InvocationHandler {
    private Object object;

    public DynamicUserProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(object, args);
        return null;
    }
}

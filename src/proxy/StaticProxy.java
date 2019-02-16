package proxy;

public class StaticProxy {
    public static void main(String[] args) {
        UserProxy proxy = new UserProxy();
        proxy.eat("apple");
    }
}

interface Iuser {
    void eat(String s);
}

class User implements Iuser {
    @Override
    public void eat(String s) {
        System.out.println("eat " + s);
    }
}

class UserProxy implements Iuser {
    User user = new User();

    @Override
    public void eat(String s) {
        user.eat(s);
    }
}
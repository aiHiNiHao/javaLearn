package equals;

import java.util.HashSet;
import java.util.Set;

public class EqualsTest {

    public static void main(String[] args) {
        String s1 = "sss";
        String s2 = "sss";
        String s3 = new String("sss");//true
        String s4 = new String("sss");//false

        System.out.println(s1 == s2);
        System.out.println(s3 == s4);

        String s5 = null;
        String s6 = null;
        System.out.println(s5 == s6);//true

        P p1 = new P();
        P p2 = new P();
        System.out.println(p1.hashCode() + "--" + p2.hashCode());
        System.out.println(p1.equals(p2));//true

        Q q1 = new Q();
        Q q2 = new Q();
        System.out.println(q1.hashCode() + "--" + q2.hashCode());
        System.out.println(q1.equals(q2));//false
        System.out.println("------------------------------");


        //下面的例子证明了在创建了该类散列表的情况下：
        // set里不允许有重复元素，而决定重复不重复由equals方法决定，hashcode只是用来排列位置的依据
        // o1和o2的hashcode相等，equals也返回true,被认为是同一个元素
        // o1和o3的hashCode相同，但是equals方法返回false，所以不认为是同一个对象，
        // equals 方法返回true，他俩的hashcode一定相等，但是反过来不一定成立，充分不必要条件
        Set<O> set = new HashSet();
        O o1 = new O(111, "aaa");
        O o2 = new O(111, "aaa");
        O o3 = new O(111, "AAA");
        set.add(o1);
        set.add(o2);
        set.add(o3);
        System.out.println(o1.hashCode() + "--" + o2.hashCode() + "--" + o3.hashCode());
        System.out.println(o1 == o2);//false ==比较的是该对象的内存地址，和hashcode，equals没有关系。
        System.out.println(o1.equals(o2));
        System.out.println(o1.equals(o3));
        System.out.println(set);

        O o = new O(222, "aaa");
        O o11 = o;
        O o22 = o;
        System.out.println(o == o11);//true;
        System.out.println(o22 == o11);//true
    }


    static class P {
        public int age;

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof P) {
                P p = (P) obj;
                return p.age == age;
            }
            return super.equals(obj);
        }


    }

    /**
     * 光重写hashCode方法不会起作用
     */
    static class Q {
        public int age = 100;

        @Override
        public int hashCode() {
            return age;
        }
    }

    static class O {
        public int age;
        public String name;

        public O(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof O) {
                O o = (O) obj;
                return o.name.equals(name) && o.age == age;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return name.toLowerCase().hashCode() + age;
        }

        @Override
        public String toString() {
            return "[" + name + "-" + age + "]";
        }
    }


    /**
     * 如果重载了父类的equals方法，掉用哪个方法，就执行哪个方法，符合面对对象的规则
     */
    static class A{
        int i;

        public A(int a){
            i = a;
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        public boolean equals(A a){
            return i == a.i;
        }

        public static void main(String[] args){
            A a = new A(1);
            A a1 = new A(1);

            System.out.println(a.equals(a1));
        }
    }
}

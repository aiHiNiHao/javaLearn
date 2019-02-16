package datastructure;

public class ListTest {


    public static void main(String[] args){
        LijingLinkedStack <Integer> stack = new LijingLinkedStack<>(10);
        for (int i = 0; i < 15; i++) {
            stack.push(i);
        }

        System.out.println(stack);//输出 14, 13, 12,... 6, 5.

        stack.pop();

        System.out.println(stack);
    }
}

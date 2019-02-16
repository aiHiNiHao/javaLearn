package datastructure;

import java.util.Stack;

/**
 * Create by lijing
 * 特色：规定容量为 maxLength，元素入栈，如果容量已经达到最大，就把栈底的移除，而不是抛异常
 */
public class LijingLinkedStack<T> {

    private Node head;
    private int maxLength;
    private int size;

    public LijingLinkedStack(int size) {
        maxLength = size;
    }

    public void push(T element) {

        if (size >= maxLength) {
            removeBottom();
        }

        head = new Node(element, head);
        size ++;
    }

    public T pop(){
        if (head == null) return null;

        T element = head.data;

        head = head.next;

        size --;
        return element;
    }

    public T getTop(){
        return head.data;
    }


    public void removeBottom() {
        if (head == null) return;

        Node node = head;

        if (node.next == null){
            head = null;
            size --;
        }else{
            while (node.next != null) {
                if (node.next.next == null){
                    node.next = null;
                    size -- ;
                    return;
                }else{
                    node = node.next;
                }
            }
        }



    }

    public int size() {

        return size;
    }

    private class Node {
        public T data;
        public Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(Node node) {
            this.data = node.data;
            this.next = node.next;
        }
    }
}

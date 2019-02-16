package datastructure;

public class LijingLinkedList<T> {
	private Node head;
    private int length;

    public LijingLinkedList() {

    }

    public boolean add(T data) {
        if (this.head == null) {
            this.head = new Node(data, null);
            this.length++;
        } else {
            Node temp = this.head;
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = new Node(data, null);
            length++;
        }
        return true;
    }

    public boolean add(int index, T data) {
        if (this.head == null) {
            return add(data);
        }
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("index 应该满足 0<=index<=length");
        }

        if (index == 0) {
            Node node = new Node(data, this.head);
            this.head = node;
        } else {
            Node temp = this.head;
            int i = 0;
            while (temp.next != null && i < index - 1) {
                temp = temp.next;
                i++;
            }

            Node node = new Node(data, null);
            Node next = temp.next;
            temp.next = node;
            node.next = next;
        }

        length++;

        return true;

    }

    public T remove(int index) {

        if (this.head == null){
            throw new RuntimeException("list is empty，can't execute remove");
        }
        if (this.head == null || index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("index 应该满足 0<=index<length");
        }

        Node temp = this.head;
        if (index == 0) {
            this.head = temp.next;
            length--;
            return temp.data;
        } else {
            int i = 0;


            while (temp.next != null && i < index - 1) {
                temp = temp.next;
                i++;
            }

            Node next = temp.next;
            temp.next = temp.next.next;
            next.next = null;
            length--;

            return next.data;
        }

    }

    public T set(int index, T data) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("index 应该满足 0<=index<length");
        }

        if (index == 0){
            Node temp = this.head;
            Node node = new Node(data,head.next);
            this.head = node;
            return temp.data;
        }else{
            int i = 0;
            Node temp = this.head;
            while (temp.next != null && i<index-1){
                temp = temp.next;
                i++;
            }

            Node old = temp.next;
            Node node = new Node(data,temp.next.next);
            temp.next = node;
            return old.data;
        }

    }

    public T get(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("index 应该满足 0<=index<length");
        }
        if (index == 0){
            return this.head.data;
        }else{
            int i = 0;
            Node temp = this.head;
            while (temp.next!= null&& i<index){
                temp = temp.next;
                i++;
            }

            return temp.data;
        }

    }


    private class Node {
        public T data;
        public Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}

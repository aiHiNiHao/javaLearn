package datastructure;

import java.util.Iterator;

public class LijingArrayList<T> implements Iterator{
	private final int DEFAULTLENGTH = 20;
    private T[] table;
    private int length;

    public LijingArrayList() {
        this.table = (T[]) new Object[DEFAULTLENGTH];
    }

    public LijingArrayList(int length) {
        if (length<1){
            throw new RuntimeException("容量不能低于1");
        }
        this.table = (T[]) new Object[length];
    }

    public boolean add(T data) {
        if (data == null)return false;

        if (length >= this.table.length) {
            enlarge();
            this.table[length] = data;
            length++;
        } else {
            this.table[length] = data;
            length++;
        }

        return true;
    }

    public boolean add(int index, T data) {
        if (data == null){
            return false;
        }

        if (length == 0){
            this.table[0] = data;
            length++;
            return true;
        }

        if (index<0){
            index = 0;
        }

        if (index>length){
            index = length;
        }

        if (index>=this.table.length || this.length == this.table.length){
            enlarge();
        }

        for (int i = length;i>index;i--){

            this.table[i] = this.table[i-1];
        }

        this.table[index] = data;
        length++;
        return true;
    }


    private void enlarge(){
        T[] temp = (T[]) new Object[table.length * 2];
        for (int i = 0; i < table.length; i++) {
            temp[i] = this.table[i];
        }
        this.table = temp;
    }


    public T remove(int index) {
        T data = null;
        if (index<0||index>=this.length){
            throw new IndexOutOfBoundsException("index 应该满足 0<=index<length");
        }

        data = this.table[index];

        int i = index;
        while(i<length-1){
            this.table[i] = this.table[i+1];
            i++;
        }

        return data;
    }

    public T set(int index, T data) {
        if (index>=length || index<0){
            throw new IndexOutOfBoundsException("index 应该满足 0<=index<length");
        }

        T old = this.table[index];
        this.table[index] = data;

        return old;
    }

    public T get(int index) {
        if (index>=length || index<0){
            throw new IndexOutOfBoundsException("index 应该满足 0<=index<length");
        }


        return this.table[index];
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    @Override
    public void remove() {

    }

    
}

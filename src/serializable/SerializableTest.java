package serializable;

import java.io.*;

public class SerializableTest implements Serializable {

    private static final long serialVersionUID = 871238749032L;

    private int age;
    private String name;

    public SerializableTest(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public static void main(String[] args) {
        SerializableTest serializable = new SerializableTest(12, "lili");
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("lili.obj"));
            outputStream.writeObject(serializable);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("lili.obj"));
            SerializableTest serializableTest = (SerializableTest) inputStream.readObject();
            inputStream.close();

            System.out.println(serializableTest.name);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

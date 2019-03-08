package designmode;

public class SingleInstanceTest {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Car instance = Car.getInstance();
                    System.out.println(instance);
                }
            }).start();
        }
    }
}
class Car{
    private static Car car;

    private Car(){

    }

    public static Car getInstance(){
        if (car ==null){

            synchronized (Car.class){

                if (car == null){
                    car = new Car();
                }
            }
        }
        return car;
    }

}
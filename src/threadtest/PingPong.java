package threadtest;

public class PingPong extends Thread {
    String whatToSay;
    int timeDelay;

    PingPong(String whatToSay, int timeDelay) {
        this.timeDelay = timeDelay;
        this.whatToSay = whatToSay;
    }

    @Override
    public void run() {

        try {
            for (; ; ) {
                System.out.println("what == " + whatToSay);
                sleep(timeDelay);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        new PingPong("ping", 33).start();
        new PingPong("PONG", 100).start();
    }
}

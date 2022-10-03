package firstTask;

public class Main {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        MyThread2 runnableThread = new MyThread2();
        Thread myThread2 = new Thread(runnableThread);
        myThread1.start();
        myThread2.start();
    }
}

package firstTask;

public class MyThread2 implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("5 seconds passed");
        }
    }
}

package firstTask;

public class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 1;; i++) {
            System.out.println("Time after program start: "+i+" sec");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

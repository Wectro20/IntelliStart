package secondTask;

public class Main {
    public static void main(String[] args) {
        Multithreading multithreading = new Multithreading(15);

        Thread threadA = new Thread(multithreading::fizz);
        Thread threadB = new Thread(multithreading::buzz);
        Thread threadC = new Thread(multithreading::fizzbuzz);
        Thread threadD = new Thread(multithreading::number);

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }
}

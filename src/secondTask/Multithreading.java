package secondTask;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Multithreading extends Thread {
    private final int n;

    private final Lock lock = new ReentrantLock();

    private final AtomicInteger counter = new AtomicInteger(1);

    private final Queue<String> numbers = new LinkedList<>();

    public Multithreading(int n) {
        this.n = n;
    }

    public void fizz() {
        while (counter.get() <= n) {
            lock.lock();
            try {
                if (counter.get() % 3 == 0 && counter.get() % 5 != 0 && numbers.size() == 0) {
                    numbers.add("fizz");
                    counter.incrementAndGet();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void buzz() {
        while (counter.get() <= n) {
            lock.lock();
            try {
                if (counter.get() % 3 != 0 && counter.get() % 5 == 0 && numbers.size() == 0) {
                    numbers.add("buzz");
                    counter.incrementAndGet();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void fizzbuzz() {
        while (counter.get() <= n) {
            lock.lock();
            try {
                if (counter.get() % 3 == 0 && counter.get() % 5 == 0 && numbers.size() == 0) {
                    numbers.add("fizzbuzz");
                    counter.incrementAndGet();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void number() {
        while (counter.get() <= n) {
            lock.lock();
            if (numbers.size() == 1) {
                System.out.print(numbers.poll() + (counter.get() <= n ? ", " : ""));
            }
            if (counter.get() % 3 != 0 && counter.get() % 5 != 0 && counter.get() <= n) {
                System.out.print(counter.getAndIncrement() + (counter.get() <= n ? ", " : ""));
            }
            lock.unlock();
        }
    }
}


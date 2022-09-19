package Queue;

public class MyQueue<T> {
    private Node<T> head, tail;
    private int queueSize;

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public MyQueue() {
        head = null;
        tail = null;
        queueSize = 0;
    }

    public boolean isEmpty() {
        return (queueSize == 0);
    }

    public int size() {
        return queueSize;
    }

    public void add(T data) {
        Node<T> oldRear = tail;
        tail = new Node<>(data);
        tail.data = data;
        tail.next = null;
        if (isEmpty()) {
            head = tail;
        } else {
            oldRear.next = tail;
        }
        queueSize++;
    }

    public void remove(int index) {
        if (head == null) {
            return;
        }
        Node<T> next = head;
        Node<T> prev = head;
        int currentIndex = 0;

        if (currentIndex == index) {
            head = head.next;
            queueSize--;
            return;
        }

        while (next != null) {
            if (currentIndex == index) {
                prev.next = next.next;
                break;
            }
            prev = next;
            next = next.next;
            currentIndex++;
        }
        queueSize--;
    }

    public void clear() {
        if (head == null) {
            return;
        }
        Node<T> current = head;
        Node<T> next = head.next;
        head.next = null;
        head = null;
        while (next != null) {
            current = next;
            next = current.next;
            current.next = null;
        }
        queueSize = 0;
        System.out.println("Queue cleared");
    }

    public T poll() {
        T data = head.data;
        head = head.next;
        if (isEmpty()) {
            tail = null;
        }
        queueSize--;
        System.out.println("Element " + data + " removed from the queue");
        return data;
    }

    public T peek() {
        return head.data;
    }

    public String toString() {
        Node<T> temp = head;
        T result;
        StringBuilder S = new StringBuilder();
        if (head == null) {
            System.out.println("Queue is empty");
        } else {
            while (temp != null) {
                result = temp.data;
                S.append(result).append(" ");
                temp = temp.next;
            }
        }
        return S.toString();
    }
}

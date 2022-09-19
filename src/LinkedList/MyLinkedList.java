package LinkedList;

public class MyLinkedList<T> {
    Node<T> head, tail = null;
    private int size = 0;


    static class Node<T> {
        T data;
        Node<T> next;
        Node<T> previous;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    public void add(T data) {
        Node<T> temp = new Node<T>(data);

        if (head == null) {
            head = tail = temp;
            head.previous = null;
        } else {
            tail.next = temp;
            temp.previous = tail;
            tail = temp;
        }
        tail.next = null;
        size++;
    }

    public void remove(int index) {
        if (head == null) {
            return;
        }
        Node<T> current = head;
        Node<T> next = head.next;
        Node<T> tempPrev;
        Node<T> tempNext;
        int currentIndex = 0;

        if (currentIndex == index) {
            head = next;
            next.previous = null;
            size--;
            return;
        }

        while (next.next != null) {
            if (currentIndex == index) {
                tempPrev = current.previous;
                tempNext = current.next;
                tempPrev.next = tempNext;
                tempNext.previous = tempPrev;
                break;
            }
            current = next;
            next = current.next;
            currentIndex++;
        }
        size--;
    }

    public void clear() {
        if (head == null) {
            return;
        }
        Node<T> current = head;
        Node<T> next = head.next;
        head.next = null;
        head.previous = null;
        head = null;
        while (next != null) {
            current = next;
            next = current.next;
            current.next = null;
            current.previous = null;
        }
        size = 0;
        System.out.println("List cleared");
    }

    public int size() {
        return size;
    }

    public T getElement(int index) {
        Node<T> temp = head;
        T result = null;

        for (int i = 0; temp != null && i <= index; i++) {
            if (index >= size) {
                System.out.println("No such element in list");
                return null;
            } else {
                result = temp.data;
                temp = temp.next;
            }
        }

        return result;
    }

    public String toString() {
        Node<T> temp = head;
        T result;
        StringBuilder S = new StringBuilder();
        if (head == null) {
            System.out.println("List is empty");
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

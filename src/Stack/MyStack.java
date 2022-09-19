package Stack;

public class MyStack<T> {
    private Node<T> top;
    private int stackSize;

    private static class Node<T> {
        private T data;
        private Node<T> prev = null;

        Node(T data) {
            this.data = data;
        }
    }

    public MyStack() {
        this.top = null;
        this.stackSize = 0;
    }

    public int size() {
        return stackSize;
    }

    public void push(T data) {
        Node<T> temp = new Node<>(data);

        if (top != null) {
            temp.prev = top;
        }
        top = temp;
    }

    public void remove(int index) {
        if (top == null) {
            return;
        }
        Node<T> prev = top;
        Node<T> current = top;
        int currentIndex = 0;

        if (currentIndex == index) {
            top = top.prev;
            stackSize--;
            return;
        }

        while (current != null) {
            if (currentIndex == index) {
                prev.prev = current.prev;
                break;
            }
            prev = current;
            current = current.prev;
            currentIndex++;
        }
        stackSize--;
    }

    public void clear() {
        if (top == null) {
            return;
        }
        Node<T> prev = top;
        Node<T> temp;
        top = null;
        while (prev != null) {
            temp = prev;
            prev = prev.prev;
            temp.prev = null;
        }
    }

    public T pop() {
        if (top == null) {
            System.out.println("The stack is empty");
            return null;
        }
        top = top.prev;

        return top.data;
    }

    public T peek() {
        if (top == null) {
            System.out.println("The stack is empty");
            return null;
        }
        return top.data;
    }

    public String toString() {
        Node<T> temp = top;
        T result;
        StringBuilder S = new StringBuilder();
        if (top == null) {
            System.out.println("Stack is empty");
        } else {
            while (temp != null) {
                result = temp.data;
                S.append(result).append(" ");
                temp = temp.prev;
            }
        }
        return S.toString();
    }
}

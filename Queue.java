//firstIn-firstOut

public class Queue {
    public static void main(String[] args) {
        List li = new List();
        li.enQueue(10);
        li.enQueue(11);
        li.enQueue(12);
        li.enQueue(13);
        System.out.println("Size: " + li.size());
        System.out.println("Queue is Empty: " + li.isEmpty());
        System.out.println("Queue is Full: " + li.isFull());
        li.display();
        System.out.println("Remove the first two node");
        li.deQueue();
        li.deQueue();
        li.display();

    }
}

class List {

    Node front, rear;

    class Node {
        int data;
        Node next;

        Node(int val) {
            data = val;
            next = null;
        }
    }

    List() {
        front = null;
    }

    void enQueue(int val) {

        Node newNode = new Node(val);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear = front;
            for (; rear.next != null; rear = rear.next);
            rear.next = newNode;
        }
    }

    void deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
        } else {
            Node temp = front;
            front = front.next;
            temp.next = null;
        }

    }

    boolean isFull() {

        return (front != null) ? true : false;
    }

    boolean isEmpty() {
        return (front == null) ? true : false;
    }

    int size() {
        int size = 0;
        Node rear = front;
        for (; rear != null; size += 1, rear = rear.next)
            ;
        return size;
    }

    void display() {
        rear = front;
        for (; rear != null; System.out.println(rear.data), rear = rear.next)
            ;
    }

}

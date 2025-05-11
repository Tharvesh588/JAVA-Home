//firstIn-firstOut

public class Queue {
    public static void main(String[] args) {
        List li = new List();
        li.create_queue_in_size(5);
        li.enQueue(10);
        li.enQueue(11);
        li.enQueue(12);
        li.enQueue(13);
        System.out.println("Size: " + li.size());
        System.out.println("List is Empty: "+li.isEmpty());
        System.out.println("List is Full: "+li.isFull());
        li.display();

    }
}

class List {

    Node front;

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

    int create_queue_in_size(int size){

        return size;
    }
    void enQueue(int val) {

        Node newNode = new Node(val);
        if (isEmpty()){
            front = newNode;
        }
        else{
            Node temp = front;
            for( ;temp.next!= null;temp = temp.next);
            temp.next = newNode;
        }
    }

    void deQueue(int val) {

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
        for (; rear != null; size += 1, rear = rear.next);
        return size;
    }
    void display() {
        Node rear = front;
        for (; rear != null;System.out.println(rear.data), rear = rear.next);
    }

}

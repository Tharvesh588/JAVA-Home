class List {
    Node head;

    List() { // constructor
        head = null;
    }

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void insertElement(int d) {
        Node newNode = new Node(d);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    void display() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node temp = head;
            for (; temp != null; System.out.print(temp.data + " "), temp = temp.next)
                ;
        }
    }

    void nth_Node_from_last(int n) {
        Node t = head, r = head;
        for (; n > 0; r = r.next, n--)
            ;
        for (; r != null; t = t.next, r = r.next)
            ;
        System.out.println(t.data);
    }

    void createLoop() {
        Node temp = head;
        for (; temp.next != null; temp = temp.next)
            ;
        temp.next = head.next.next.next;
    }

    void detectLoop() {
        Node r = head.next;
        Node t = head;
        // odd even
        for (; (r.next != null && r.next.next != null) && (r != t); r = r.next.next, t = t.next)
            ;
        if (r == t) {
            System.out.println("Loop is Detected");
        } else {
            System.out.println("Loop is not Detected");
        }
    }

}

public class FloydCycle_list {
    public static void main(String[] args) {
        System.out.println("Floydcycle (Rabbit & Tortoise)Method");

        List l = new List();
        l.insertElement(0);
        l.insertElement(1);
        l.insertElement(3);
        l.insertElement(5);
        l.insertElement(6);
        l.insertElement(7);
        l.insertElement(2);
        l.insertElement(8);
        l.insertElement(9);

        l.display();
        System.out.println("");
        l.nth_Node_from_last(3);
        //Create loop 
        System.out.println("");
        l.createLoop();
        l.detectLoop();
    }
}

public class LinkedList {
        public static void main(String[] args) {
                SLL sl = new SLL();
                sl.iBegin(3);
                sl.iBegin(4);
                sl.iBegin(5);
                sl.iBegin(6);
                sl.iLast(10);
                sl.iLast(20);
                sl.display();
                System.out.println();
                sl.iMiddle();
                System.out.println("Element Deleted");
                sl.dBegin();
                sl.dLast();
                sl.display();

        }
}

class SLL {
        Node head;

        SLL() { // constructor
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

        void display() {
                if (head == null) {
                        System.out.println("List is empty");
                } else {
                        Node temp = head;
                        for (; temp != null; System.out.println(temp.data + " "), temp = temp.next)
                                ;
                }
        }

        void iBegin(int d) {
                Node newNode = new Node(d);
                if (head == null) {
                        head = newNode;
                } else {
                        newNode.next = head;
                        head = newNode;
                }
        }

        void iLast(int d) {
                Node newNode = new Node(d);
                if (head == null) {
                        head = newNode;
                } else {
                        Node temp = head;
                        for (; temp.next != null; temp = temp.next)
                                ;
                        temp.next = newNode;

                }
        }

        void iMiddle() {
                if (head == null) {
                        System.out.println("List is MT");
                } else {
                        Node r = head, t = head;
                        for (; r.next != null && r.next.next != null; r = r.next.next, t = t.next)
                                ;
                        System.out.println("Middle Element: " + t.data);
                }
        }

        void dBegin() {
                if (head == null) {
                        System.out.println("List seems to be MT");
                } else {
                        Node temp = head;
                        head = temp.next;
                        temp.next = null;

                }
        }

        void dLast() {
                if (head == null) {
                        System.out.println("List seems to be MT");
                } else {
                        Node temp = head;
                        for (; temp.next.next != null; temp = temp.next);
                        temp.next = null;
                }
        }

}
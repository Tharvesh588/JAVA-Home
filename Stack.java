class List{
    Node top; 
    List(){
        top = null;
    }
    class Node{
        int data;
        Node next;
        Node(int val){
            data = val;
            next = null;
        }
    }

    void push(int d){
        Node newnode = new Node(d);
        if (top == null){
            top = newnode;
        }
        else{
            newnode.next = top;
            top = newnode;
        }
    }

    void pop(){
        if (top == null) {
            System.out.println("Stak is UnderFlow");
        } else {
            Node temp = top;
            top = top.next;
            temp.next = null; 
        }
    }

    void peek(){
        if (top == null) {
            System.out.println("Stack is Empty");
        } else {
            System.out.println("Peek element: "+top.data);
        }
    }

    void display(){
        if (top == null) {
            System.out.println("Stack is UnderFlow / Empty");            
        }
        else{
            Node temp = top;
            for(;temp!=null;System.out.println(temp.data),temp = temp.next);
        }
    }
}


class Array{

}

public class Stack {
    public static void main(String[] args) {
        List l= new List();
        l.push(10);
        l.push(20);
        l.push(30);
        l.push(40);
        l.display();
        System.out.println("");
        l.pop();
        l.display();
        System.out.println("");
        l.peek(); 
    }
}

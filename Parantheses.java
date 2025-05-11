
class Stack {
    Node top;

    Stack() {
        top = null;
    }

    class Node {
        char data;
        Node next;

        Node(char val) {
            data = val;
            next = null;
        }
    }

    void push(char ch) {
        Node newnode = new Node(ch);
        if (top == null) {
            top = newnode;
        } else {
            newnode.next = top;
            top = newnode;
        }
    }

    void pop() {
        if (top == null) {
            System.out.println("Stack is underflow");
        } else {
            top = top.next;
        }
    }

    char peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            return ' ';
        } else {
            return top.data;
        }
    }

    boolean isBalanced(String s) {
        for (int i = 0; i < s.length(); i++) 
        {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                push(c);
            } 
            else if (c == ')' || c == ']' || c == '}') {
                if (top == null) {
                    return false;
                }

                char t = peek();
                if ((c == ')' && t == '(') || (c == ']' && t == '[') || (c == '}' && t == '{')) {
                    return true;
                }
                pop();
            }
        }

        return (top == null)?true:false;
    }
}


public class Parantheses {
    public static void main(String[] args) {
        Stack s = new Stack();

        String test1 = "(){}[]";
        String test2 = "({[]})";
        String test3 = "({[})]";
        String test4 = "(";

        System.out.println(test1 + ": " + s.isBalanced(test1));
        System.out.println(test2 + ": " + s.isBalanced(test2));
        System.out.println(test3 + ": " + s.isBalanced(test3));
        System.out.println(test4 + ": " + s.isBalanced(test4));
    }
}

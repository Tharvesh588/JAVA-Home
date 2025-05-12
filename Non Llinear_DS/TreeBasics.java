public class TreeBasics {
    public static void main(String[] args) {
        BSTree bs = new BSTree();
        bs.insertData(4);
        bs.insertData(3);
        bs.insertData(2);
        bs.insertData(5);

        bs.inOrder_Display();   
        bs.preOrder_Display();  
        bs.postOrder_Display(); 
    }
}

class BSTree {
    private Child root;

    class Child {
        Child left, right;
        int data;

        Child(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }

    void insertData(int val) {
        root = insertRec(root, val);
    }

    private Child insertRec(Child node, int val) {
        if (node == null) {
            return new Child(val);
        }
        if (val < node.data) {
            node.left = insertRec(node.left, val);
        } else if (val > node.data) {
            node.right = insertRec(node.right, val);
        }
        return node;
    }

    void inOrder_Display() {
        System.out.print("InOrder: ");
        inOrderHelper(root);
        System.out.println();
    }

    void preOrder_Display() {
        System.out.print("PreOrder: ");
        preOrderHelper(root);
        System.out.println();
    }

    void postOrder_Display() {
        System.out.print("PostOrder: ");
        postOrderHelper(root);
        System.out.println();
    }

    private void inOrderHelper(Child node) {
        if (node != null) {
            inOrderHelper(node.left);
            System.out.print(node.data + " ");
            inOrderHelper(node.right);
        }
    }

    private void preOrderHelper(Child node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderHelper(node.left);
            preOrderHelper(node.right);
        }
    }

    private void postOrderHelper(Child node) {
        if (node != null) {
            postOrderHelper(node.left);
            postOrderHelper(node.right);
            System.out.print(node.data + " ");
        }
    }
}

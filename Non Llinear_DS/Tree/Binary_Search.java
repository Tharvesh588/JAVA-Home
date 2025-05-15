public class Binary_Search {
    public static void main(String[] args) {
        Tree t=new Tree();
        t.insert(1);
        t.insert(20);
        t.insert(13);
        t.insert(41);
        t.insert(14);
        t.insert(17);

    }

}

class Tree {
    Node root;

    Tree(){
        root = null;
    }

    class Node {
        Node left, right;
        int data;
        
        Node(int d){
            left = right = null;
            this.data = d;
        }
    }

    void insert(int val){
        root = insertLeaf(root, val);      
    }
    
    Node insertLeaf(Node root, int val){
        if(root == null){
            Node leafNode = new Node(val);
            root = leafNode;

        }

        else{
            if(val < root.data){
                root = insertLeaf(root.left,val);
            }
            if (val>root.data){
                root = insertLeaf(root.right,val);
            }
        }
        return root;

    }
    
    void display_in(){
        inorder(root);
    }
    void inorder(Node root){
        if(root!=null){
            inorder(root.left);

        }
    }
        
}
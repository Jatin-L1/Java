package Trees;

public class BST {
    public class node {
        private int value;
        private int height;
        private node left;
        private node right;

        public node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private node root;

    public BST() {

    }

    public int height(node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int value){
        root = insert(root, value);

    }
    public node insert(int value , node node){
        if (node==null) {
            node = new node(value);
            return node;
        }
        if (value <node.value) {
            node.left = insert(value, node.left);
            
        }
        if (value>node.value) {
            node.right = insert(value, node.right);
        }
        node.height = Math.max(height(node.left) , height(node.right))+1;
        return node;
    }

    public void display() {
        display(root, "Root Node: ");
    }

    public void display(node node, String details) {
        if (node==null) {
            return; 
        }
        System.out.println(details+node.getValue());

        display(node.left , "Left child of "+node.getValue()+" : ");
        display(node.right , "Right child of "+node.getValue()+" : ");
    }

}

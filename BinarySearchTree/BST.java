package BinarySearchTree;

public class BST {
    public static void main(String[] args) {
        Tree intTree = new Tree();
        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);

        intTree.inOrder();
        System.out.println("----------------");
        System.out.println(intTree.get(30));
        System.out.println(intTree.get(22));
        System.out.println(intTree.get(170));
        System.out.println("----------------");
        System.out.println(intTree.min());
        System.out.println(intTree.max());

    }
}

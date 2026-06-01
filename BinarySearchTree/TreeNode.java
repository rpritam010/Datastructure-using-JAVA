package BinarySearchTree;

public class TreeNode {

    private int data;
     TreeNode leftChild;

     TreeNode rightChild;

    public TreeNode(int data) {
        this.data= data;
    }

    public void insert(int value){
        if(value == data){
            return;
        }

        if(value <data){
            if(leftChild == null){
                leftChild = new TreeNode(value);
            }
            else {
                leftChild.insert(value);
            }
        }

        else {
            if(rightChild == null){
                rightChild = new TreeNode(value);
            }else {
                rightChild.insert(value);
            }
        }
    }

    public void inOrder(){
        if(leftChild !=null){
            leftChild.inOrder();
        }
        System.out.print("Data = " +data +",");

        if(rightChild !=null){
            rightChild.inOrder();
        }
    }

    public int min(){
        if(leftChild == null ){
            return data;
        }else{
            return leftChild.min();
        }
    }

    public int max(){
        if(rightChild == null){
            return data;
        }else {
            return rightChild.max();
        }
    }

    public Integer get(int value){
        if (value == data){
            return data;
        }
        if (value <data){
            if(leftChild !=null){
               return leftChild.get(value);
            }
        }else {
            if(rightChild !=null){
                return rightChild.get(value);
            }
        }
        return null;
    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}

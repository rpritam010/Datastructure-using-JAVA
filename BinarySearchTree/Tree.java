package BinarySearchTree;

public class Tree {

    private TreeNode root;

    public void insert(int value){
        if(root == null){
            root = new TreeNode(value);
        }else{
            root.insert(value);
        }
    }

    public int min(){
        if(root == null){
            return Integer.MIN_VALUE;
        }else {
            return root.min();
        }
    }

    public int max(){
        if(root == null){
            return Integer.MAX_VALUE;
        }else{
            return root.max();
        }
    }
    public void inOrder(){
        if(root !=null){
            root.inOrder();
        }
    }
    public Integer get(int value){
        if(root !=null){
            return root.get(value);
        }
        return null;
    }

    public void delete(int value){

        root = delete(root,value);
    }

    private TreeNode delete(TreeNode subTreeRoot,int value){
        if(subTreeRoot ==null){
            return subTreeRoot;
        }
        if(value <subTreeRoot.getData()){
            subTreeRoot.setLeftChild(delete(subTreeRoot.getLeftChild(),value));
        } else if (value > subTreeRoot.getData()) {
            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), value));
        }
        else {
            if(subTreeRoot.getLeftChild() == null){
                return subTreeRoot.getRightChild();
            } else if (subTreeRoot.getRightChild()==null) {
                return subTreeRoot.getLeftChild();
            }
        }
        return subTreeRoot;
    }
}

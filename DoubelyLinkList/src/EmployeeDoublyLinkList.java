public class EmployeeDoublyLinkList {

    private EmployeeNode head;
    private EmployeeNode tail;
    private int size;

    public void addToFront(Employee employee){
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        if(head == null){
            tail = node;
        }
        else {
            head.setPrevious(node);
        }
        head = node;
        size++;
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return head == null;
    }

    public  void addToEnd (Employee employee){
        EmployeeNode node = new EmployeeNode(employee);

        if(tail == null){
            head = node;
        }else{
            tail.setNext(node);
            node.setPrevious(tail);
        }
        tail =node;
        size++;
    }
    public EmployeeNode removeFromFront(){

        if(isEmpty()){
            return null;
        }
        EmployeeNode removeNode = head;

        if(head.getNext() == null){
            tail = null;
        }else{
            head.getNext().setPrevious(null);
        }
        head = head.getNext();
        size--;
        removeNode.setNext(null);
        return  removeNode;
    }

    public EmployeeNode removeFromEnd(){
        if(isEmpty()){
            return null;
        }
        EmployeeNode removeNode = tail;

        if(tail.getNext() == null){
            head = null;
        }
        else{
            tail.getPrevious().setNext(null);
        }
        tail = tail.getPrevious();
        size--;
        removeNode.setPrevious(null);
        return  removeNode;
    }

    public void printList(){
        EmployeeNode current = head;
        System.out.println("Head ->");

        while (current !=null){
            System.out.println(current);
            System.out.println("<=>");
            current = current.getNext();
        }
        System.out.println("null");
    }
}

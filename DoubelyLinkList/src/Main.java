import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();


        Employee pritam = new Employee("Pritam", "Raj", "123");
        Employee Megha = new Employee("Megha","Kumari", "234");
        Employee Tom = new Employee("Tom","Jerry","567");

        EmployeeDoublyLinkList list = new EmployeeDoublyLinkList();
        list.addToFront(pritam);
        list.addToFront(Megha);
        list.addToFront(Tom);

        list.printList();


        System.out.println("Add at front "+ list.getSize());

        Employee billEnd = new Employee("Bill","End","78");

        list.addToEnd(billEnd);

        list.printList();


        System.out.println("Add at the end "+ list.getSize());
        list.removeFromFront();

        list.printList();


        System.out.println("Remove from front "+ list.getSize());

        list.removeFromEnd();

        list.printList();


        System.out.println("Remove from End "+ list.getSize());
        
    }
}
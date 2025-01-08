import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();


        employeeList.add(new Employee("Pritam", "Raj", "123"));
        employeeList.add(new Employee("Megha","Kumari", "234"));
        employeeList.add(new Employee("Tom","Jerry","567"));

        employeeList.forEach(System.out::println);

        System.out.println("Second Employee" + employeeList.get(2));

        System.out.println("Is the list is empty "+employeeList.isEmpty());

        employeeList.set(2,new Employee("Oggy" ,"Cockroach","987"));
        System.out.println("Second Employee after replace" + employeeList.get(2));

        System.out.println("The size of the list is " + employeeList.size());

        Employee [] employeArray = employeeList.toArray(employeeList.toArray(new Employee[employeeList.size()]));

        for (Employee employee: employeArray) {
            System.out.println("The employee array is "+ employee);
        }

    System.out.println(employeeList.contains(new Employee("Megha" ,"Kumari","234")));

        employeeList.remove(2);
        employeeList.forEach(System.out::println);

    }
}
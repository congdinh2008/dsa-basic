import java.time.LocalDate;

public class EmployeeListTest {
    public static void main(String[] args) {
        EmployeeList list = new EmployeeList();

        list.addFirst(new Employee("123", "Cong Dinh", LocalDate.of(1999, 9, 9)));
        list.addFirst(new Employee("123", "Quynh Dinh", LocalDate.of(1999, 9, 9)));
        list.addFirst(new Employee("123", "Van Nguyen", LocalDate.of(1999, 9, 9)));
        list.addFirst(new Employee("123", "An Dinh", LocalDate.of(1999, 9, 9)));
        list.addFirst(new Employee("123", "an dinh", LocalDate.of(1999, 9, 9)));

        list.traverse();
        list.deleteByName("Cong Dinh");

        System.out.println("List after delete");
        list.traverse();

        EmployeeList result = list.searchByName("An Dinh");
        System.out.println("Result search by 'an dinh':");
        result.traverse();
    }
}

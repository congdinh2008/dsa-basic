import java.time.LocalDate;
import java.util.LinkedList;

public class StudentLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Student> list = new MyLinkedList<Student>();

        Student cong = new Student();
        cong.setId(1);
        cong.setName("Cong Dinh");
        cong.setEmail("cong@example.com");

        list.addFirst(cong);

        list.traverse();

        MyLinkedList<Employee> employees = new MyLinkedList<Employee>();

        Employee tuan = new Employee("1234", "Nguyen Tuan", LocalDate.of(2001, 12, 12));
        employees.addFirst(tuan);

        employees.addFirst(new Employee("2345", "Huy Nguyen", LocalDate.of(1992, 2, 28)));

        employees.traverse();


        MyLinkedList<Double> numbers = new MyLinkedList<Double>();

        numbers.addFirst(3.14);
        numbers.addFirst(1.25);
        numbers.addFirst(6.34);

        System.out.println(numbers.getHead());
        System.out.println(numbers.getTail());

        LinkedList<String> names = new LinkedList<String>();
    }
}

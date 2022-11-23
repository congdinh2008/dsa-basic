public class Ex04 {
    public static void main(String[] args) {

        fib(3);
    }

    public static int fib(int number) {

        int result = 0;

        if (number <= 2) {
            result = number - 1;
            return result;
        }
        result = fib(number - 1) + fib(number - 2);
        System.out.println(result);
        return result;
    }
}

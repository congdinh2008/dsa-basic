public class RecFact {
    public static void main(String[] args) {
        int number = 10;

        System.out.println(fact(number));
    }

    private static int fact(int number) {
        if (number == 1) {
            return 1;
        }
        return number * fact(number - 1);
    }
}

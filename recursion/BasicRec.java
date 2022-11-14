/**
 * BasicRec
 */
public class BasicRec {

    public static void main(String[] args) {
        int numbers[] = { 4, 0, 5, 6, -9, 28, 17 };

        printArray(numbers, 0);
    }

    public static void printArray(int arr[], int index) {
        if (index == arr.length) {
            return;
        }
        System.out.println(arr[index]);
        printArray(arr, index + 1);
    }
}
#include <iostream>
using namespace std;

void bubbleSort(int numbers[], int size)
{
    // Bubble Sort array => Time Complexity = O(n^2)
    for (int i = 0; i < size; i++)
    {
        for (int j = 0; j < size - i - 1; j++)
        {
            if (numbers[j] > numbers[j + 1])
            {
                int temp = numbers[j];
                numbers[j] = numbers[j + 1];
                numbers[j + 1] = temp;
            }
        }
    }
}

void printArray(int numbers[], int size)
{
    for (int i = 0; i < size; i++)
    {
        cout << numbers[i] << endl;
    }
}

void merge(int numbers[], int p, int q, int r)
{
    int n1 = q - p + 1;
    int n2 = r - q;
    int left[n1], right[n2];

    // Nap gia tri vao mang left
    for (int i = 0; i < n1; i++)
    {
        left[i] = numbers[p + i];
    }

    // Nap gia tri vao mang right
    for (int j = 0; j < n2; j++)
    {
        right[j] = numbers[q + j + 1];
    }

    int i = 0, j = 0, k = p;
    // Merge gia tri trong left va right vao numbers array theo thu tu be den lon
    while (i < n1 && j < n2)
    {
        if (left[i] <= right[j])
        {
            numbers[k] = left[i];
            i++;
        }
        else
        {
            numbers[k] = right[j];
            j++;
        }
        k++;
    }

    // When we run out of elements in either L or M,
    // pick up the remaining elements and put in A[p..r]
    while (i < n1)
    {
        numbers[k] = left[i];
        i++;
        k++;
    }

    while (j < n2)
    {
        numbers[k] = right[j];
        j++;
        k++;
    }
}

void mergeSort(int numbers[], int p, int r)
{
    // Divide
    if (p < r)
    {
        int q = p + (r - p) / 2;
        // Conquer
        mergeSort(numbers, p, q);
        mergeSort(numbers, q + 1, r);
        merge(numbers, p, q, r);
    }
}

int main(int argc, char *argv[])
{
    int numbers[] = {10, 11, -2, 33, -4, 25, 5};
    int size = sizeof(numbers) / sizeof(numbers[0]);

    // Print array
    printArray(numbers, size);

    mergeSort(numbers, 0, size - 1);
    // bubbleSort(numbers);

    cout << "Array of numbers after sort" << endl;
    printArray(numbers, size);

    cout << "End Program" << endl;
}

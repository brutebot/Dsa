import java.util.Scanner;

// P3: Linear search and binary search on student IDs
public class StudentSearch {

    static int linearSearch(int[] ids, int key) {
        for (int i = 0; i < ids.length; i++)
            if (ids[i] == key) return i;
        return -1;
    }

    // IDs must be sorted
    static int binarySearch(int[] ids, int key) {
        int low = 0, high = ids.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (ids[mid] == key) return mid;
            else if (key < ids[mid]) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] studentIds = {101, 105, 110, 115, 120, 125, 130};
        System.out.print("Enter Student ID: ");
        int key = sc.nextInt();

        int linearResult = linearSearch(studentIds, key);
        if (linearResult != -1) {
            System.out.println("Linear Search: Student Found");
            System.out.println("Index: " + linearResult);
        } else System.out.println("Linear Search: Student Not Found");

        int binaryResult = binarySearch(studentIds, key);
        if (binaryResult != -1) {
            System.out.println("Binary Search: Student Found");
            System.out.println("Index: " + binaryResult);
        } else System.out.println("Binary Search: Student Not Found");
        sc.close();
    }
}

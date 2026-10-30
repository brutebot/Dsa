import java.util.Scanner;

// P5: Stack operations demonstrated through recursive factorial
public class FactorialStack {

    static int factorial(int n) {
        if (n == 0 || n == 1) return 1;   // base condition
        return n * factorial(n - 1);      // recursive call (pushed on call stack)
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int result = factorial(n);
        System.out.println("Factorial of " + n + " = " + result);
        sc.close();
    }
}

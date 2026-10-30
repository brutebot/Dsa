import java.util.Scanner;

// P6: Printer queue (FIFO) - add and delete print jobs
public class PrinterQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] queue = new String[10];
        int front = 0;   // next job to print
        int rear = -1;   // last job added
        String choice;

        do {
            System.out.println("\n1.Add Job 2.Print and Delete Job 3.Display 4.Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    if (rear == queue.length - 1) {
                        System.out.println("Queue is full.");
                    } else {
                        System.out.print("Enter document name: ");
                        rear++;
                        queue[rear] = sc.nextLine();
                        System.out.println("Job added.");
                    }
                    break;
                case "2":
                    if (front > rear) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Printing: " + queue[front]);
                        front++;
                        System.out.println("Job printed and deleted from queue.");
                    }
                    break;
                case "3":
                    if (front > rear) System.out.println("Queue is empty.");
                    for (int i = front; i <= rear; i++)
                        System.out.println(queue[i]);
                    break;
                case "4":
                    System.out.println("Exiting.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (!choice.equals("4"));
        sc.close();
    }
}

import java.util.Scanner;

// Node represents one book in the linked list
class Node {
    int id;
    String name;
    Node next;

    Node(int id, String name) {
        this.id = id;
        this.name = name;
        this.next = null;
    }
}

// P4: Book add, delete and issue using a linked list
public class Books {
    static Node head = null;

    static void addBook(int id, String name) {
        Node newBook = new Node(id, name);
        if (head == null) head = newBook;
        else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newBook;
        }
        System.out.println("Book Added Successfully!");
    }

    static void deleteBook(int id) {
        Node temp = head;
        if (temp != null && temp.id == id) {
            head = temp.next;
            System.out.println("Book Deleted Successfully!");
            return;
        }
        while (temp != null && temp.next != null) {
            if (temp.next.id == id) {
                temp.next = temp.next.next;
                System.out.println("Book Deleted Successfully!");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book Not Found!");
    }

    static void issueBook(int id) {
        Node temp = head;
        while (temp != null) {
            if (temp.id == id) {
                System.out.println("Book Issued: " + temp.name);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book Not Found!");
    }

    static void display() {
        Node temp = head;
        System.out.println("\nBooks in Library:");
        while (temp != null) {
            System.out.println(temp.id + " - " + temp.name);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        addBook(101, "Java");
        addBook(102, "Data Structures");
        addBook(103, "Python");
        display();

        System.out.print("\nEnter Book ID to Issue: ");
        int id = sc.nextInt();
        issueBook(id);

        System.out.print("\nEnter Book ID to Delete: ");
        id = sc.nextInt();
        deleteBook(id);
        display();
        sc.close();
    }
}

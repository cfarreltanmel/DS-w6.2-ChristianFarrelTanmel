package Soal4;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Visitor {
    String name;
    int money;
    public Visitor(String name, int money) {
        this.name = name;
        this.money = money;
    }
    @Override
    public String toString() {
        return name;
    }
}
public class GreedyQueueApp {
    public static void main(String[] args) {
        System.out.println("WELCOME TO DIAMOND HEIGHTS PARK RIDE");
        System.out.println("Enter the number of visitors (between 1 and 1000): ");
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter some numbers.");
            scanner.close();
            return;
        }
        int queueLength = scanner.nextInt();
        if (queueLength < 1 || queueLength > 1000) {
            System.out.println("The visitor count must be between 1 and 1000.");
            scanner.close();
            return;
        }
        System.out.println("Enter the names of the visitors (separated by space): ");
        String[] names = new String[queueLength];
        for (int i = 0; i < queueLength; i++) {
            if (scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter the names of the visitors.");
                scanner.close();
                return;
            } else {
                names[i] = scanner.next();
            }
        }
        System.out.println("Enter the money each visitor has (separated by space): ");
        String[] money = new String[queueLength];
        for (int i = 0; i < queueLength; i++) {
            if (scanner.hasNextInt()) {
                money[i] = scanner.next();
            } else {
                System.out.println("Invalid input. Please enter the money for each visitor.");
                scanner.close();
                return;
            }
        }
        Queue<Visitor> queue = new LinkedList<>();
        for (int i = 0; i < queueLength; i++) {
            queue.offer(new Visitor(names[i], Integer.parseInt(money[i])));
        }
        Queue<Visitor> sortedQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            Visitor currentVisitor = queue.poll();
            if (sortedQueue.isEmpty()) {
                sortedQueue.offer(currentVisitor);
            } else {
                Queue<Visitor> tempQueue = new LinkedList<>();
                boolean inserted = false;
                while (!sortedQueue.isEmpty()) {
                    Visitor v = sortedQueue.poll();
                    if (!inserted && currentVisitor.money > v.money) {
                        tempQueue.offer(currentVisitor);
                        inserted = true;
                    }
                    tempQueue.offer(v);
                }
                if (!inserted) {
                    tempQueue.offer(currentVisitor);
                }
                sortedQueue = tempQueue;
            }
        }
        while (!sortedQueue.isEmpty()) {
            System.out.print(sortedQueue.poll() + " ");
        }
        scanner.close();
    }
}
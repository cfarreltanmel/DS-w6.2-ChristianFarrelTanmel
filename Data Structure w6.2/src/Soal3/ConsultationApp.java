package Soal3;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Student {
    String name;
    int chances;
    public Student(String name, int chances) {
        this.name = name;
        this.chances = chances;
    }
}
public class ConsultationApp {
    public static void main(String[] args) {
        System.out.println("WELCOME THE GREAT KASMIR");
        System.out.println("Enter the number of students that want to consult (between 5 and 20): ");
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter some numbers.");
            scanner.close();
            return;
        }
        int queueLength = scanner.nextInt();
        if (queueLength < 5 || queueLength > 20) {
            System.out.println("The student count must be between 5 and 20.");
            scanner.close();
            return;
        }
        System.out.println("Enter the names of the students (separated by space): ");
        String[] names = new String[queueLength];
        for (int i = 0; i < queueLength; i++) {
            if (scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter the names of the students.");
                scanner.close();
                return;
            } else {
                names[i] = scanner.next();
            }
        }
        System.out.println("Enter the consultation chances for each student (separated by space): ");
        String[] chances = new String[queueLength];
        for (int i = 0; i < queueLength; i++) {
            if (scanner.hasNextInt()) {
                chances[i] = scanner.next();
            } else {
                System.out.println("Invalid input. Please enter the consultation chances for each student.");
                scanner.close();
                return;
            }
        }
        Queue<Student> queue = new LinkedList<>();
        for (int i = 0; i < queueLength; i++) {
            queue.offer(new Student(names[i], Integer.parseInt(chances[i])));
        }
        while (!queue.isEmpty()) {
            Student currentStudent = queue.poll();
            currentStudent.chances--;
            String status;
            if (currentStudent.chances > 0) {
                status = "Try Again";
                queue.offer(currentStudent);
            } else {
                status = "Get Out";
            }
            System.out.println(currentStudent.name + "|" + status + "|" + currentStudent.chances);
        }
        scanner.close();
    }
}
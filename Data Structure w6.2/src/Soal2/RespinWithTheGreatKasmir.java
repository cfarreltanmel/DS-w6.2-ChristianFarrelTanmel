package Soal2;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class RespinWithTheGreatKasmir {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the number of operations (between 1 and 1000): ");
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (n < 1 || n > 1000) {
                System.out.println("The number of operations must be between 1 and 1000.");
                scanner.close();
                return;
            }
            boolean isStack = true;
            boolean isQueue = true;
            boolean isPQ = true;
            Stack<Integer> stack = new Stack<>();
            Queue<Integer> queue = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < n; i++) {
                System.out.println("Input the operation type (1 for insert, 2 for remove): ");
                int type = scanner.nextInt();
                System.out.println("Input the value: ");
                int value = scanner.nextInt();
                if (type == 1) { 
                    if (isStack) stack.push(value);
                    if (isQueue) queue.offer(value);
                    if (isPQ) pq.offer(value);
                } else if (type == 2) { 
                    // Check Stack (Last-In, First-Out)
                    if (isStack) {
                        if (stack.isEmpty() || stack.pop() != value) {
                            isStack = false;
                        }
                    }
                    // Check Queue (First-In, First-Out)
                    if (isQueue) {
                        if (queue.isEmpty() || queue.poll() != value) {
                            isQueue = false;
                        }
                    }
                    // Check Priority Queue (Largest First)
                    if (isPQ) {
                        if (pq.isEmpty() || pq.poll() != value) {
                            isPQ = false;
                        }
                    }
                }
            }
            if (isStack && !isQueue && !isPQ) {
                System.out.println("stack");
            } else if (!isStack && isQueue && !isPQ) {
                System.out.println("queue");
            } else if (!isStack && !isQueue && isPQ) {
                System.out.println("priority queue");
            } else if (!isStack && !isQueue && !isPQ) {
                System.out.println("none");
            } else {
                System.out.println("not sure");
            }
            System.out.println("Input the number of operations again (between 1 and 1000). If you want to exit, type a letter: ");
        }
        scanner.close();
    }
}
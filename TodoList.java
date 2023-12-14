import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {

    private ArrayList<String> tasks;
    private Scanner scanner;

    public TodoList() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        todoList.start();
    }

    public void start() {
        int choice;
        do {
            System.out.println("\nTodo List Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. View Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    markAsCompleted();
                    break;
                case 3:
                    viewTasks();
                    break;
                case 4:
                    System.out.println("Exiting the todo list. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);
    }

    private void addTask() {
        System.out.print("Enter the task: ");
        scanner.nextLine(); // Consume the newline character
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    private void markAsCompleted() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available to mark as completed.");
            return;
        }

        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }

        System.out.print("Enter the task number to mark as completed: ");
        int taskNumber = scanner.nextInt();

        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            System.out.println("Task '" + tasks.get(taskNumber - 1) + "' marked as completed!");
            tasks.remove(taskNumber - 1);
        } else {
            System.out.println("Invalid task number. Please try again.");
        }
    }

    private void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}

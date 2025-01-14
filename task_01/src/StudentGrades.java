import java.util.ArrayList;
import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();
        int grade;
        String input;
        
        // Collect grades from the teacher
        System.out.println("Enter the grades of the students. Type 'done' to finish.");
        
        while (true) {
            System.out.print("Enter grade (or type 'done' to finish): ");
            input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            
            try {
                grade = Integer.parseInt(input);
                grades.add(grade);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid grade.");
            }
        }
        
        // Check if there are grades to process
        if (grades.isEmpty()) {
            System.out.println("No grades entered.");
        } else {
            // Calculate average, highest, and lowest scores
            int sum = 0;
            int highest = grades.get(0);
            int lowest = grades.get(0);
            
            for (int g : grades) {
                sum += g;
                if (g > highest) {
                    highest = g;
                }
                if (g < lowest) {
                    lowest = g;
                }
            }
            
            double average = (double) sum / grades.size();
            
            // Display the results
            System.out.println("\nResults:");
            System.out.println("Average grade: " + average);
            System.out.println("Highest grade: " + highest);
            System.out.println("Lowest grade: " + lowest);
        }
        
        scanner.close();
    }
}

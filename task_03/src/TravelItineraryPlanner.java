import java.util.ArrayList;
import java.util.Scanner;

public class TravelItineraryPlanner {
    
    // Store details like destinations, dates, preferences, and budget
    static class Itinerary {
        String destination;
        String startDate;
        String endDate;
        String accommodation;
        String activities;
        double budget;
        double estimatedCost;

        public Itinerary(String destination, String startDate, String endDate, String accommodation, String activities, double budget) {
            this.destination = destination;
            this.startDate = startDate;
            this.endDate = endDate;
            this.accommodation = accommodation;
            this.activities = activities;
            this.budget = budget;
            this.estimatedCost = 0.0;
        }

        // Simulate calculating the estimated cost
        public void calculateEstimatedCost() {
            double accommodationCost = accommodation.equals("hotel") ? 100 : 50; // simple cost model
            double activityCost = activities.equals("sightseeing") ? 50 : 100; // simple cost model
            estimatedCost = accommodationCost * 3 + activityCost * 2; // 3 days accommodation + 2 activities
        }

        // Display itinerary details
        public void displayItinerary() {
            System.out.println("\nYour Travel Itinerary to " + destination + ":");
            System.out.println("Travel Dates: " + startDate + " to " + endDate);
            System.out.println("Accommodation: " + accommodation);
            System.out.println("Activities: " + activities);
            System.out.println("Estimated Travel Cost: $" + estimatedCost);
            System.out.println("Your budget: $" + budget);
            if (estimatedCost <= budget) {
                System.out.println("This itinerary is within your budget!");
            } else {
                System.out.println("Warning: This itinerary exceeds your budget!");
            }
            System.out.println("Weather: Sunny (simulated)");
        }
    }//end static class Itinerary

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Itinerary> itineraries = new ArrayList<>();
        
        // Main loop for the user interface
        while (true) {
            System.out.println("\nWelcome to the Travel Itinerary Planner!");
            System.out.println("1. Create a new itinerary");
            System.out.println("2. Exit");
            System.out.print("Please choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            if (choice == 1) {
                // Create a new itinerary
                System.out.print("\nEnter your destination: ");
                String destination = scanner.nextLine();

                System.out.print("Enter the start date (YYYY-MM-DD): ");
                String startDate = scanner.nextLine();

                System.out.print("Enter the end date (YYYY-MM-DD): ");
                String endDate = scanner.nextLine();

                System.out.print("Choose accommodation (hotel/hostel): ");
                String accommodation = scanner.nextLine();

                System.out.print("Choose activities (sightseeing/adventure): ");
                String activities = scanner.nextLine();

                System.out.print("Enter your budget: $");
                double budget = scanner.nextDouble();
                scanner.nextLine(); // Consume newline character

                // Create and store the itinerary
                Itinerary itinerary = new Itinerary(destination, startDate, endDate, accommodation, activities, budget);
                itinerary.calculateEstimatedCost();
                itineraries.add(itinerary);

                // Display the generated itinerary
                itinerary.displayItinerary();
            } else if (choice == 2) {
                System.out.println("Thank you for using the Travel Itinerary Planner! Goodbye.");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}//end class TravelItineraryPlanner

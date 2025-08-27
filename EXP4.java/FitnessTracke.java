package exp4;

import java.util.Scanner;

class FitnessTracker {
    
    private String name;
    private int age;
    private double weight;  
    private double height;  
    private int steps;
    private double caloriesBurned;

    public FitnessTracker(String name, int age, double weight, double height, int steps, double caloriesBurned) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.steps = steps;
        this.caloriesBurned = caloriesBurned;
    }

    public double calculateBMI() {
        double heightInMeters = height / 100; 
        return weight / (heightInMeters * heightInMeters);
    }

 
    public void updateSteps(int steps) {
        this.steps += steps;
        System.out.println("Steps updated. Total steps: " + this.steps);
    }

 
    public void updateCalories(double calories) {
        this.caloriesBurned += calories;
        System.out.println("Calories updated. Total calories burned: " + this.caloriesBurned);
    }
    public void displayDetails() {
        System.out.println("\n--- Fitness Tracker Details ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Height: " + height + " cm");
        System.out.println("Steps Walked: " + steps);
        System.out.println("Calories Burned: " + caloriesBurned);
        System.out.printf("BMI: %.2f\n", calculateBMI());
    }
}

public class PersonalFitnessApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your Name: ");
        String name = sc.nextLine();

        System.out.print("Enter your Age: ");
        int age = sc.nextInt();

        System.out.print("Enter your Weight (kg): ");
        double weight = sc.nextDouble();

        System.out.print("Enter your Height (cm): ");
        double height = sc.nextDouble();

        System.out.print("Enter initial Steps: ");
        int steps = sc.nextInt();

        System.out.print("Enter initial Calories burned: ");
        double calories = sc.nextDouble();

        FitnessTracker tracker = new FitnessTracker(name, age, weight, height, steps, calories);

        int choice;
        do {
            System.out.println("\n--- Personal Fitness Tracker Menu ---");
            System.out.println("1. Update Steps");
            System.out.println("2. Update Calories");
            System.out.println("3. Display Fitness Info");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter steps to add: ");
                    int addSteps = sc.nextInt();
                    tracker.updateSteps(addSteps);
                    break;

                case 2:
                    System.out.print("Enter calories to add: ");
                    double addCalories = sc.nextDouble();
                    tracker.updateCalories(addCalories);
                    break;

                case 3:
                    tracker.displayDetails();
                    break;

                case 4:
                    System.out.println("Exiting... Stay Healthy!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}





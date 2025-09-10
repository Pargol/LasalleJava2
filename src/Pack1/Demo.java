package Pack1;

import java.util.Scanner;

public class Demo {
	 private static final String PASSWORD = "password";

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.println("=== Welcome to the Computer Store Management System ===");

	        // Ask for max number of computers
	        System.out.print("Enter the maximum number of computers your store can hold: ");
	        int maxComputers = sc.nextInt();
	        Computer[] inventory = new Computer[maxComputers];
	        int computerCount = 0;

	        int choice;
	        do {
	            // Display menu
	            System.out.println("\n=== Main Menu ===");
	            System.out.println("1. Enter new computers (password required)");
	            System.out.println("2. Update a computer information (password required)");
	            System.out.println("3. Display all computers by a specific brand");
	            System.out.println("4. Display all computers under a certain price");
	            System.out.println("5. Quit");
	            System.out.print("Enter your choice (1-5): ");
	            choice = sc.nextInt();

	            switch (choice) {
	                case 1:
	                    if (checkPassword(sc)) {
	                        System.out.print("How many computers do you want to add? ");
	                        int n = sc.nextInt();
	                        if (n > maxComputers - computerCount) {
	                            System.out.println("Not enough space! You can only add " + (maxComputers - computerCount));
	                        } else {
	                            for (int i = 0; i < n; i++) {
	                                System.out.println("Enter computer #" + (i + 1));
	                                sc.nextLine(); // consume newline
	                                System.out.print("Brand: ");
	                                String brand = sc.nextLine();
	                                System.out.print("Model: ");
	                                String model = sc.nextLine();
	                                System.out.print("Serial Number (SN): ");
	                                long sn = sc.nextLong();
	                                System.out.print("Price: ");
	                                double price = sc.nextDouble();

	                                inventory[computerCount++] = new Computer(brand, model, sn, price);
	                            }
	                        }
	                    }
	                    break;

	                case 2:
	                    if (checkPassword(sc)) {
	                        System.out.print("Enter the computer number (index 0 - " + (computerCount - 1) + "): ");
	                        int idx = sc.nextInt();
	                        if (idx < 0 || idx >= computerCount || inventory[idx] == null) {
	                            System.out.println("Invalid index. No computer found.");
	                        } else {
	                            Computer comp = inventory[idx];
	                            int updateChoice;
	                            do {
	                                System.out.println("\nComputer #" + idx);
	                                System.out.println(comp);
	                                System.out.println("\nWhat would you like to update?");
	                                System.out.println("1. Brand");
	                                System.out.println("2. Model");
	                                System.out.println("3. Serial Number");
	                                System.out.println("4. Price");
	                                System.out.println("5. Quit");
	                                System.out.print("Enter choice: ");
	                                updateChoice = sc.nextInt();
	                                sc.nextLine();

	                                switch (updateChoice) {
	                                    case 1:
	                                        System.out.print("Enter new brand: ");
	                                        comp.setBrand(sc.nextLine());
	                                        break;
	                                    case 2:
	                                        System.out.print("Enter new model: ");
	                                        comp.setmodel(sc.nextLine());
	                                        break;
	                                    case 3:
	                                        System.out.print("Enter new SN: ");
	                                        comp.setSN(sc.nextLong());
	                                        break;
	                                    case 4:
	                                        System.out.print("Enter new price: ");
	                                        comp.setPrice(sc.nextDouble());
	                                        break;
	                                    case 5:
	                                        System.out.println("Exiting update menu...");
	                                        break;
	                                    default:
	                                        System.out.println("Invalid choice!");
	                                }
	                            } while (updateChoice != 5);
	                        }
	                    }
	                    break;

	                case 3:
	                    sc.nextLine(); // clear buffer
	                    System.out.print("Enter brand to search for: ");
	                    String brandSearch = sc.nextLine();
	                    findComputersByBrand(inventory, computerCount, brandSearch);
	                    break;

	                case 4:
	                    System.out.print("Enter maximum price: ");
	                    double maxPrice = sc.nextDouble();
	                    findCheaperThan(inventory, computerCount, maxPrice);
	                    break;

	                case 5:
	                    System.out.println("Thank you for using the Computer Store System. Goodbye!");
	                    break;

	                default:
	                    System.out.println("Invalid choice. Please enter 1–5.");
	            }
	        } while (choice != 5);
	    }

	    // Password checker
	    private static boolean checkPassword(Scanner sc) {
	        for (int i = 0; i < 3; i++) {
	            System.out.print("Enter password: ");
	            String entered = sc.next();
	            if (entered.equals(PASSWORD)) {
	                return true;
	            }
	            System.out.println("Incorrect password. Try again.");
	        }
	        return false;
	    }

	    // Search by brand
	    public static void findComputersByBrand(Computer[] inventory, int count, String brand) {
	        boolean found = false;
	        for (int i = 0; i < count; i++) {
	            if (inventory[i].getBrand().equalsIgnoreCase(brand)) {
	                System.out.println("\nComputer #" + i);
	                System.out.println(inventory[i]);
	                found = true;
	            }
	        }
	        if (!found) {
	            System.out.println("No computers found for brand: " + brand);
	        }
	    }

	    // Search by price this is my fun
	    public static void findCheaperThan(Computer[] inventory, int count, double price) {
	        boolean found = false;
	        for (int i = 0; i < count; i++) {
	            if (inventory[i].getPrice() < price) {
	                System.out.println("\nComputer #" + i);
	                System.out.println(inventory[i]);
	                found = true;
	            }
	        }
	        if (!found) {
	            System.out.println("No computers found cheaper than $" + price);
	        }
	    }
	}
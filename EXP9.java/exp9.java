import java.io.*;
import java.util.*;

public class exp9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n----- File Handling Menu -----");
            System.out.println("1. Create a new file");
            System.out.println("2. Rename a file");
            System.out.println("3. Delete a file");
            System.out.println("4. Create a directory");
            System.out.println("5. Find absolute path of a file");
            System.out.println("6. Display all files in a directory");
            System.out.println("7. Low Stock Alert Report");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter directory name: ");
                    String dirName = sc.nextLine();
                    File directory = new File(dirName);
                    if (!directory.exists()) directory.mkdir();

                    System.out.print("Enter file name to create inside that directory: ");
                    String fileName = sc.nextLine();
                    File newFile = new File(directory, fileName);
                    try {
                        if (newFile.createNewFile())
                            System.out.println("File created successfully inside " + dirName);
                        else
                            System.out.println("File already exists.");
                    } catch (IOException e) {
                        System.out.println("Error creating file.");
                    }
                    break;

                case 2:
                    System.out.print("Enter current file name: ");
                    String oldName = sc.nextLine();
                    System.out.print("Enter new file name: ");
                    String newName = sc.nextLine();
                    File oldFile = new File(oldName);
                    File renamedFile = new File(newName);
                    if (oldFile.renameTo(renamedFile))
                        System.out.println("File renamed successfully.");
                    else
                        System.out.println("Error renaming file.");
                    break;

                case 3:
                    System.out.print("Enter file name to delete: ");
                    String delName = sc.nextLine();
                    File delFile = new File(delName);
                    if (delFile.delete())
                        System.out.println("File deleted successfully.");
                    else
                        System.out.println("Error deleting file.");
                    break;

                case 4:
                    System.out.print("Enter new directory name: ");
                    String newDir = sc.nextLine();
                    File dir = new File(newDir);
                    if (dir.mkdir())
                        System.out.println("Directory created successfully!");
                    else
                        System.out.println("Directory already exists or cannot be created.");
                    break;

                case 5:
                    System.out.print("Enter file name: ");
                    String absFile = sc.nextLine();
                    File abs = new File(absFile);
                    System.out.println("Absolute Path: " + abs.getAbsolutePath());
                    break;

                case 6:
                    System.out.print("Enter directory name: ");
                    String dirname = sc.nextLine();
                    File listDir = new File(dirname);
                    if (listDir.exists() && listDir.isDirectory()) {
                        String[] files = listDir.list();
                        System.out.println("Files in " + dirname + ":");
                        for (String file : files)
                            System.out.println(file);
                    } else {
                        System.out.println("Directory not found!");
                    }
                    break;

                case 7:
                    try {
                        File file = new File("inventory.txt");
                        Scanner fileReader = new Scanner(file);
                        FileWriter fw = new FileWriter("low_stock_alert.txt");
                        fw.write("----- LOW STOCK ALERT REPORT -----\n\n");
                        fw.write(String.format("%-15s %-10s %-10s\n", "Product", "Stock", "Price"));
                        fw.write("------------------------------------\n");

                        boolean found = false;
                        while (fileReader.hasNextLine()) {
                            String line = fileReader.nextLine();
                            String[] parts = line.split(",");
                            String name = parts[0].trim();
                            int stock = Integer.parseInt(parts[1].trim());
                            int price = Integer.parseInt(parts[2].trim());
                            if (stock < 5) {
                                fw.write(String.format("%-15s %-10d %-10d\n", name, stock, price));
                                found = true;
                            }
                        }
                        if (!found)
                            fw.write("No low stock products found.\n");

                        fileReader.close();
                        fw.close();
                        System.out.println("Low stock report written to low_stock_alert.txt");
                    } catch (Exception e) {
                        System.out.println("Error processing inventory file.");
                    }
                    break;

                case 8:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 8);
        sc.close();
    }
}


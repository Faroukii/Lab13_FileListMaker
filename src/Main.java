import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {


         class Lab13_FileListMaker {

            private static boolean needsToBeSaved = false;
            private static ArrayList<String> itemList = new ArrayList<String>();
            private static String currentFilename = "";

            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                boolean quit = false;
                while (!quit) {
                    System.out.print("Enter command (A, D, V, O, S, C, Q): ");
                    // This is where the commands are being coded
                    String command = sc.nextLine().toUpperCase();
                    switch (command) {
                        case "A":
                            addItem();
                            break;
                        case "D":
                            deleteItem();
                            break;
                        case "V":
                            viewList();
                            break;
                        case "O":
                            loadList();
                            break;
                        case "S":
                            saveList();
                            break;
                        case "C":
                            clearList();
                            break;
                        case "Q":
                            quit = quitProgram();
                            break;
                        default:
                            System.out.println("Invalid command.");
                    }
                }
                sc.close();
            }

            private static void addItem() {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter item to add: ");
                String item = sc.nextLine();
                itemList.add(item);
                needsToBeSaved = true;
                System.out.println("Item added.");
                //This is where the messages are being implemented
            }

            private static void deleteItem() {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter index of item to delete: ");
                int index = sc.nextInt();
                sc.nextLine(); // consume the rest of the line
                if (index < 1 || index > itemList.size()) {
                    System.out.println("Invalid index.");
                    //this is when the index is invalid
                } else {
                    itemList.remove(index - 1);
                    needsToBeSaved = true;
                    System.out.println("Item deleted.");
                }// this is when the item has been deleted
            }

            private static void viewList() {
                System.out.println("List contents:");
                for (int i = 0; i < itemList.size(); i++) {
                    System.out.println((i + 1) + ". " + itemList.get(i));
                    //here is where you can view the list
                }
            }

            private static void loadList() {
                Scanner sc = new Scanner(System.in);
                if (needsToBeSaved) {
                    System.out.print("Current list has unsaved changes. Do you want to save it first? (Y/N) ");
                    String answer = sc.nextLine().toUpperCase();
                    if (answer.equals("Y")) {
                        saveList();
                        //this is the reminder to save
                    }
                }
                System.out.print("Enter filename to load: ");
                String filename = sc.nextLine();
                File file = new File(filename + ".txt");
                if (file.exists()) {
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        String line;
                        itemList.clear();
                        while ((line = reader.readLine()) != null) {
                            itemList.add(line);
                        }
                        currentFilename = filename;
                        needsToBeSaved = false;
                        System.out.println("List loaded.");
                        reader.close();
                    } catch (IOException e) {
                        System.out.println("Error reading file: " + e.getMessage());
                    }
                } else {
                    System.out.println("File not found.");
                    //error loading file
                }
            }

            private static void saveList() {
                if (currentFilename.isEmpty()) {
                    Scanner sc = new Scanner(System);

                }
}
        }
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MarkdownGenerator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder markdownContent = new StringBuilder();


        System.out.print("Enter Markdown file name (without .md): ");
        String fileName = scanner.nextLine() + ".md";

        while (true) {

            System.out.println("\n--- Markdown Menu ---");
            System.out.println("1. Add Heading");
            System.out.println("2. Add Bold Text");
            System.out.println("3. Add Italic Text");
            System.out.println("4. Save & Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter heading text: ");
                    String heading = scanner.nextLine();
                    markdownContent.append("## ").append(heading).append("\n\n");
                    break;

                case 2:
                    System.out.print("Enter bold text: ");
                    String bold = scanner.nextLine();
                    markdownContent.append("**").append(bold).append("**\n\n");
                    break;

                case 3:
                    System.out.print("Enter italic text: ");
                    String italic = scanner.nextLine();
                    markdownContent.append("*").append(italic).append("*\n\n");
                    break;

                case 4:
                    saveToFile(fileName, markdownContent.toString());
                    System.out.println("Markdown file saved successfully!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }


    private static void saveToFile(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
        } catch (IOException e) {
            System.out.println("Error writing file!");
        }
    }
}

package Java_Notes_Application;
import java.util.Scanner;
public class NotesApp {
    public static void main(String[] args) {
        NotesManager notesManager = new NotesManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("[1] Add new note");
            System.out.println("[2] Update note");
            System.out.println("[3] Delete note");
            System.out.println("[4] Display all notes");
            System.out.println("[5] Save notes to file");
            System.out.println("[6] Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter note title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter note content: ");
                    String content = scanner.nextLine();
                    notesManager.addNote(new Note(title, content));
                    break;
                case 2:
                    notesManager.displayAllNotes();
                    System.out.print("Enter the index of the note to update: ");
                    int updateIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter updated note title: ");
                    String updatedTitle = scanner.nextLine();
                    System.out.print("Enter updated note content: ");
                    String updatedContent = scanner.nextLine();
                    notesManager.updateNote(updateIndex - 1, new Note(updatedTitle, updatedContent));
                    break;
                case 3:
                    notesManager.displayAllNotes();
                    System.out.print("Enter the index of the note to delete: ");
                    int deleteIndex = scanner.nextInt();
                    notesManager.deleteNote(deleteIndex - 1);
                    break;
                case 4:
                    notesManager.displayAllNotes();
                    break;
                case 5:
                    notesManager.saveNotesToFile();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
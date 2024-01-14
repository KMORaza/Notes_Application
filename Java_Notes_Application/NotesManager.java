package Java_Notes_Application;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class NotesManager {
    private List<Note> notes;
    public NotesManager() {
        this.notes = new ArrayList<>();
    }
    public void addNote(Note note) {
        notes.add(note);
    }
    public void updateNote(int index, Note updatedNote) {
        if (index >= 0 && index < notes.size()) {
            notes.set(index, updatedNote);
        } else {
            System.out.println("Invalid index for updating note.");
        }
    }
    public void deleteNote(int index) {
        if (index >= 0 && index < notes.size()) {
            notes.remove(index);
        } else {
            System.out.println("Invalid index for deleting note.");
        }
    }
    public void displayAllNotes() {
        for (int i = 0; i < notes.size(); i++) {
            System.out.println("Note #" + (i + 1) + ":\n" + notes.get(i) + "\n");
        }
    }
    public void saveNotesToFile() {
        try (FileWriter writer = new FileWriter(System.getProperty("user.home") + "/Desktop/notes.txt")) {
            for (Note note : notes) {
                writer.write(note.getTitle() + "\n" + note.getContent() + "\n\n");
            }
            System.out.println("Notes saved to desktop as 'notes.txt'");
        } catch (IOException e) {
            System.out.println("Error saving notes to file: " + e.getMessage());
        }
    }
}
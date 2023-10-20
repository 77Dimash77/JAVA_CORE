package org.example.pok3;

import org.example.pok3.fileutil.FileUtil;
import org.example.pok3.note.Note;

import java.util.Scanner;

public class NotesApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите заметку: ");
        String noteText = scanner.nextLine();
        Note note = new Note(noteText);
        FileUtil.appendNoteToFile(note);
        System.out.println("Дозапись в файл: " + note.getTimestamp() + " -> " + note.getText());
    }
}

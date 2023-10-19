package org.example.pok3.fileutil;


import org.example.pok3.note.Note;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
    private static final String FILE_PATH = "notes.txt";

    public static void appendNoteToFile(Note note) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(note.getTimestamp() + " -> " + note.getText());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

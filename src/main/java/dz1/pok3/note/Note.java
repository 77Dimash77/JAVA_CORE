package org.example.pok3.note;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Note {
    private String text;
    private String timestamp;

    public Note(String text) {
        this.text = text;
        this.timestamp = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
    }

    public String getText() {
        return text;
    }

    public String getTimestamp() {
        return timestamp;
    }
}

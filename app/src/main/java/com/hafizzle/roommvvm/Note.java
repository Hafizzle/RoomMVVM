package com.hafizzle.roommvvm;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table") //At compile time, Room will create sqlite table for this object.
public class Note {

    /*
    Columns.

    You may also use @Ignore to ignore any fields that you don't want to be added.

    All columns will be named after the variable. You may also change the name using
    @ColumnInfo(name = "").
     */

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    private String description;

    private int priority;

    //id will automatically be auto generated, so we don't need to include it in the constructor.
    public Note(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    //Room will use this method to set the id on the note object.
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}

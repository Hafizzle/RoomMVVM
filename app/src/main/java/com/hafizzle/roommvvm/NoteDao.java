package com.hafizzle.roommvvm;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/*
    Note Data Access Object.
    Interface was annotated with @Dao to let room know this interface is a Dao.
    Daos must be either interfaces or abstract classes.

    Create a Dao per Entity (depends on use case)
    Create interface, annotate it & room will automatically generate the necessary code.

    If the annotations do NOT fill requirements, you can also use @Query and make your own query.
    For example -
    @Query("DELETE FROM note_table")
    void deleteAllNotes();

    Room will check if note_table table matches the column of Note object.

    LiveData will check if any rows/columns were changed in the table, and update accordingly.
    For example -
    @Query("Select * FROM note_table ORDER BY priority DESC")
    LiveData<List<Note>> getAllNotes();

*/

@Dao
public interface NoteDao {

    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    @Query("DELETE FROM note_table")
    void deleteAllNotes();

    @Query("Select * FROM note_table ORDER BY priority DESC")
    LiveData<List<Note>> getAllNotes();








}

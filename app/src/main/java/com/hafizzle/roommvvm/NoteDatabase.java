package com.hafizzle.roommvvm;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/*
Every time database changed, change version number.
(In test, usually keep version at 1, and change in production)

synchronized - one thread. We want only one instance to avoid separate/duplicate instances.
public static synchronized NoteDatabase getInstance(Context context)

.fallbackToDestructiveMigration() deletes last version database to avoid duplicate.
 */

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase instance;

    public abstract NoteDao noteDao();

    public static synchronized NoteDatabase getInstance(Context context) {
        //Instantiate database only if database does not yet exist.
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    NoteDatabase.class, "note_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}

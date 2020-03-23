package com.hafizzle.roommvvm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    /*
    Activities and fragments have callback methods that can save and restore variables between
    configuration changes (changing screen orientation, etc), but it's usually tedious and
    error prone, and usually only suitable for small amounts of data. Not to mention, you will
    need to restart async methods correctly if doing so.

    By putting the data in ViewModel, the data does not get lost between configuration changes. The
    data in the viewmodel is closed when the actual application or fragment is over as well.

    AndroidViewModel is a subclass of ViewModel.

    Do NOT use a activity or fragment context in the Viewmodel - the ViewModel needs to retain
    data after a configuration change, and if a activity/fragment context is used it will reset.
    Use the application context.
     */
    private NoteRespository repository;
    private LiveData<List<Note>> allNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        repository = new NoteRespository(application);
        allNotes = repository.getAllNotes();
    }

    public void insert(Note note){
        repository.insert(note);
    }

    public void update(Note note){
        repository.update(note);
    }

    public void delete(Note note){
        repository.delete(note);
    }

    public void deleteAllNotes(){
        repository.deleteAllNotes();
    }

    public LiveData<List<Note>> getAllNotes(){
        return allNotes;
    }
}

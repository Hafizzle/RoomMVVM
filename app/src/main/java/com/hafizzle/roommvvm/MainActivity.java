package com.hafizzle.roommvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    /*
    //Room + ViewModel + LiveData + RecyclerView(MVVM)

    We don't create a NoteViewModel in Oncreate, or it will init every time onCreate is called during
    configuration changes.
     */

    private NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Will destroy this viewmodel when the activity(this) is finished.
        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        //.observe is a LiveData method.
        //Observer onChanged listens whenever data being observed by LiveData changes.
        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                //update RecyclerView
                Toast.makeText(MainActivity.this, "onChanged (Placeholder for RecyclerView)",
                        Toast.LENGTH_SHORT).show();
            }
        });


    }
}

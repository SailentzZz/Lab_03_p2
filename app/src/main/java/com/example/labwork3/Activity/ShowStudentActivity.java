package com.example.labwork3.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.labwork3.DBHelper;
import com.example.labwork3.Student;
import com.example.labwork3.R;
import com.example.labwork3.StudentsRecyclerAdapter;

import java.util.ArrayList;

public class ShowStudentActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_student);
        DBHelper dbHelper = new DBHelper(getApplicationContext());
        ArrayList<Student> students = dbHelper.readAll();
        recyclerView = findViewById(R.id.showRecyclerView);
        StudentsRecyclerAdapter studentsRecyclerAdapter = new StudentsRecyclerAdapter(students);
        recyclerView.setAdapter(studentsRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
    }
}

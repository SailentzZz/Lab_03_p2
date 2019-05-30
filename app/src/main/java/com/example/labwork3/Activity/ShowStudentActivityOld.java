package com.example.labwork3.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.labwork3.DBHelper;
import com.example.labwork3.StudentOld;
import com.example.labwork3.R;
import com.example.labwork3.StudentsRecyclerAdapterOld;

import java.util.ArrayList;

public class ShowStudentActivityOld extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_student_old);
        DBHelper dbHelper = new DBHelper(getApplicationContext());
        ArrayList<StudentOld> students = dbHelper.readAllOld();
        recyclerView = findViewById(R.id.showRecyclerViewOld);
        StudentsRecyclerAdapterOld studentsRecyclerAdapter = new StudentsRecyclerAdapterOld(students);
        recyclerView.setAdapter(studentsRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
    }
}

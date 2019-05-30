package com.example.labwork3;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class StudentsRecyclerAdapter extends RecyclerView.Adapter {

    private ArrayList<Student> students;

    public StudentsRecyclerAdapter(ArrayList<Student> students){
        super();
        this.students = students;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_recycler_item, parent, false);
        return new StudentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        StudentViewHolder studentViewHolder = (StudentViewHolder) viewHolder;
        studentViewHolder.surname.setText(students.get(i).getSurname());
        studentViewHolder.name.setText(students.get(i).getName());
        studentViewHolder.patronymic.setText(students.get(i).getPatronymic());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }
}

package com.example.lab4_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.lab4_3.tasks.TaskListContent;

public class AddingActivity extends AppCompatActivity implements TaskFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);
    }

    public void addingItem(View view) {
        EditText taskTitleEditTxt= findViewById(R.id.Name);
        EditText surnameEditTxt=findViewById(R.id.Surname);
        EditText taskDescriptionEditTxt=findViewById(R.id.PhoneNumber);
        EditText birthdayEditTxt=findViewById(R.id.Birthday);

        String taskTitle=taskTitleEditTxt.getText().toString();
        String taskDescription=taskDescriptionEditTxt.getText().toString();
        String surname=surnameEditTxt.getText().toString();
        String birthday=birthdayEditTxt.getText().toString();
        String selectedImage="4";

        if(taskTitle.isEmpty()&& taskDescription.isEmpty()){
            TaskListContent.addItem(new TaskListContent.Task("Task."+TaskListContent.ITEMS.size()+1,
                    getString(R.string.default_title), surname,
                    getString(R.string.default_description), birthday, selectedImage));
        }
        else{
            if(taskTitle.isEmpty())
                taskTitle=getString(R.string.default_title);
            if(taskDescription.isEmpty())
                taskDescription=getString(R.string.default_description);
            TaskListContent.addItem(new TaskListContent.Task("Task."+TaskListContent.ITEMS.size()+1,
                    taskTitle, surname, taskDescription, birthday, selectedImage));
        }

        //((TaskFragment) getSupportFragmentManager().findFragmentById(R.id.taskFragment)).notifyDataChange();

        taskTitleEditTxt.setText("");
        birthdayEditTxt.setText("");
        surnameEditTxt.setText("");
        taskDescriptionEditTxt.setText("");
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    @Override
    public void onListFragmentClickInteraction(TaskListContent.Task task, int position) {
    }

    @Override
    public void onListFragmentLongClickInteraction(int position) {

    }

    @Override
    public void onDeleteClickInteraction(int position) {

    }
}

package com.example.tirocinio2.progettoso2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NewTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
    }

    public void addItem (View v){
        EditText field = (EditText) findViewById(R.id.editText);
        String newTask = field.getText().toString();
        MainActivity mAct = new MainActivity();
        mAct.makeList(new String[]{newTask});
    }
}

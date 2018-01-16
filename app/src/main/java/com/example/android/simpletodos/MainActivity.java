package com.example.android.simpletodos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView todoListTextView = (TextView)findViewById(R.id.tv_todo_list);
        todoListTextView.setText("Finish the TODO app");
    }
}

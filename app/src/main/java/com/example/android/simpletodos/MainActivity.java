package com.example.android.simpletodos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayDeque;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mTodoListRecyclerView;
    private TodoAdapter mTodoAdapter;
    private TextView mTodoListTextView;
    private EditText mTodoEntryEditText;



    private ArrayDeque<String> mTodoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTodoListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mTodoListRecyclerView.setHasFixedSize(true);

        /*mTodoListTextView =
               (TextView)findViewById(R.id.tv_todo_list);

        */
        mTodoEntryEditText =
                (EditText)findViewById(R.id.et_todo_entry);

        Button addTodoButton =
                (Button)findViewById(R.id.btn_add_todo);

        mTodoAdapter = new TodoAdapter();
        mTodoListRecyclerView.setAdapter(mTodoAdapter);

        addTodoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String todoText =
                        mTodoEntryEditText.getText().toString();
                if (!TextUtils.isEmpty(todoText)) {
                    mTodoAdapter.addTodo(todoText);
                    mTodoEntryEditText.setText("");
                    for (String todo : mTodoList) {
                        mTodoListTextView.append(todo + "\n\n");
                    }
                    mTodoEntryEditText.setText("");
                }
            }
        });


    }
}

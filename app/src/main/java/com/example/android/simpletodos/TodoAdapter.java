package com.example.android.simpletodos;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by wongnich on 1/20/18.
 */

public class TodoAdapter
        extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {

    private ArrayList<String> mTodoList;

    public TodoAdapter() {
        mTodoList = new ArrayList<String>();
    }


    public void addTodo(String todo) {
        mTodoList.add(todo);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mTodoList.size();
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup viewGroup,
                                             int viewType) {
        LayoutInflater inflater =
                LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.todo_list_item, viewGroup,        //We can use R class to refer to any in resources
                false);
        TodoViewHolder viewHolder = new TodoViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder,
                                 int position) {
        String todo =
                mTodoList.get(mTodoList.size() - position - 1);
        holder.bind(todo);
    }


    /*Our Todo View Holder class*/
    class TodoViewHolder extends RecyclerView.ViewHolder {
        private TextView mTodoTextView;

        public TodoViewHolder(View itemView) {
            super(itemView);
            mTodoTextView =
                    (TextView)itemView.findViewById(R.id.tv_todo_text);
        }

        void bind(String todo) {
            mTodoTextView.setText(todo);
        }


    }


}

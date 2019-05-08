package com.example.android_todo_first;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] mTodos;
    private int mTodoIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /* call the super class onCreate to complete the creation
         of activity with state changes */
        super.onCreate(savedInstanceState);

        // set the user interface layout for this Activity
        setContentView(R.layout.activity_main);

        // initialize member TextView so we can manipulate it later
        final TextView TodoTextView;
        TodoTextView = (TextView) findViewById(R.id.textViewTodo);

        // read the todo array from res/values/strings.xml
        Resources res = getResources();
        mTodos = res.getStringArray(R.array.todos);

        // display the first task from mTodo array in the TodoTextView
        TodoTextView.setText(mTodos[mTodoIndex]);

        Button buttonNext, buttonPrev;
        buttonNext = (Button) findViewById(R.id.buttonNext);
        buttonPrev = (Button) findViewById(R.id.buttonPrev);

        // OnClick listener for the  Next button
        buttonNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(mTodoIndex==5){
                    mTodoIndex = 0;
                    TodoTextView.setText(mTodos[mTodoIndex]);

                }else{
                    mTodoIndex += 1;
                    TodoTextView.setText(mTodos[mTodoIndex]);
                }

            }
        });

        buttonPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mTodoIndex==0){
                    mTodoIndex = 5;
                    TodoTextView.setText(mTodos[mTodoIndex]);

                }else{
                    mTodoIndex -= 1;
                    TodoTextView.setText(mTodos[mTodoIndex]);

                }
            }
        });
    }


}


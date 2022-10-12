package com.xd.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonTrue;
    private Button buttonFalse;
    private Button buttonNext;
    private TextView textView;

    private Question[] questions = new Question[]{
        new Question(R.string.qActivity, true),
        new Question(R.string.qVersion, false),
        new Question(R.string.qListener, true),
        new Question(R.string.qResources, true),
        new Question(R.string.qFindResources, false),
    };
    private int currentQuestion;

    private void checkAnswer(boolean userAnswer){
        Question question = questions[currentQuestion];
        int resultMsg = (userAnswer == question.GetAnswer() ? R.string.correctAnswer : R.string.incorrectAnswer);

        Toast.makeText(this, resultMsg, Toast.LENGTH_SHORT).show();
    }

    private void setNextQuestion(){
        textView.setText(questions[currentQuestion].GetId());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonTrue = findViewById(R.id.buttonTrue);
        buttonFalse = findViewById(R.id.buttonFalse);
        buttonNext = findViewById(R.id.buttonNext);
        textView = findViewById(R.id.textView);

        buttonTrue.setOnClickListener(v -> checkAnswer(true));
        buttonFalse.setOnClickListener(v -> checkAnswer(false));
        buttonNext.setOnClickListener(v -> {
            currentQuestion = (currentQuestion + 1)%questions.length;
            setNextQuestion();
        });

        setNextQuestion();
    }


}
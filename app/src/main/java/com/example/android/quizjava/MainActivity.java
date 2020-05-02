package com.example.android.quizjava;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int numberOfQuestion = 0;   //number of question
    int score = 0;
    int stop = 0; //Turn off the result button when you press it a second time





    StringBuilder noteQuestion =new StringBuilder();
    StringBuilder summary =new StringBuilder();



    ArrayList<Integer> Question = new ArrayList<Integer>();        //this array list for Questions

    ArrayList<Integer> Answers1 = new ArrayList<Integer>();        //this array list for answer 1

    ArrayList<Integer> Answers2 = new ArrayList<Integer>();        //this array list for answer 2

    ArrayList<Integer> Answers3 = new ArrayList<Integer>();        //this array list for answer 3

    ArrayList<Integer> Answers4 = new ArrayList<Integer>();        //this array list for answer 4

    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private TextView displayQuestion;
    private TextView result;
    private EditText editText;
    private CheckBox answer1;
    private CheckBox answer2;
    private CheckBox answer3;
    private CheckBox answer4;

    {


//        Resources res = getResources();
//        String[] Question = res.getStringArray(R.array.question_array);



        //this array list for Questions
        Question.add(R.string.q1);
        Question.add(R.string.q2);
        Question.add(R.string.q3);
        Question.add(R.string.q4);
        Question.add(R.string.q5);
        Question.add(R.string.q6);
        Question.add(R.string.q7);
    }

    {
        //this array list for answer 1
        Answers1.add(R.string.q1_an1);
        Answers1.add(R.string.q2_can1);
        Answers1.add(R.string.q3_an1);
        Answers1.add(R.string.q4_an1);
        Answers1.add(R.string.q5_an1);
        Answers1.add(R.string.q6_can1);
        Answers1.add(R.string.q7_an1);
    }

    {
        //this array list for answer 2
        Answers2.add(R.string.q1_an2);
        Answers2.add(R.string.q2_an2);
        Answers2.add(R.string.q3_can2);
        Answers2.add(R.string.q4_an2);
        Answers2.add(R.string.q5_an2);
        Answers2.add(R.string.q6_an2);
        Answers2.add(R.string.q7_an2);

    }

    {
        //this array list for answer 3
        Answers3.add(R.string.q1_an3);
        Answers3.add(R.string.q2_an3);
        Answers3.add(R.string.q3_an3);
        Answers3.add(R.string.q4_can3);
        Answers3.add(R.string.q5_an3);
        Answers3.add(R.string.q6_an3);
        Answers3.add(R.string.q7_can3);
    }

    {
        //this array list for answer 4
        Answers4.add(R.string.q1_can4);
        Answers4.add(R.string.q2_an4);
        Answers4.add(R.string.q3_an4);
        Answers4.add(R.string.q4_an4);
        Answers4.add(R.string.q5_can4);
        Answers4.add(R.string.q6_an4);
        Answers4.add(R.string.q7_an4);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);

        radioButton1 = (RadioButton) findViewById(R.id.radio1);
        radioButton2 = (RadioButton) findViewById(R.id.radio2);
        radioButton3 = (RadioButton) findViewById(R.id.radio3);
        radioButton4 = (RadioButton) findViewById(R.id.radio4);

        editText = (EditText) findViewById(R.id.name);

        displayQuestion = (TextView) findViewById(R.id.question);

        result = (TextView) findViewById(R.id.result);

        answer1 = (CheckBox) findViewById(R.id.checkbox1);
        answer2 = (CheckBox) findViewById(R.id.checkbox2);
        answer3 = (CheckBox) findViewById(R.id.checkbox3);
        answer4 = (CheckBox) findViewById(R.id.checkbox4);



    }

    /**
     * This method is called when the next button is clicked.
     */
    public void nextQuestionAndAnswers(View view) {
        if (!(radioButton1.isChecked() || radioButton2.isChecked() || radioButton3.isChecked() || radioButton4.isChecked())) {
            Toast.makeText(this, "Please Choose One Answer To Go To The Next Question", Toast.LENGTH_SHORT).show();
            return;
        }
        checkForCorrectAnswers();
        numberOfQuestion++;
        if (numberOfQuestion <= 6) {
            clean();
        }
        next();
    }

    /**
     * Display questions and answers whenever the user clicks next
     * This method is called when the next button is clicked.
     */

    public void next() {
        if (numberOfQuestion >= 7) {
            Toast.makeText(this, "Scroll down to see Question 8", Toast.LENGTH_SHORT).show();
            return;
        }

        displayQuestion.setText(Question.get(numberOfQuestion));
        radioButton1.setText(Answers1.get(numberOfQuestion));
        radioButton2.setText(Answers2.get(numberOfQuestion));
        radioButton3.setText(Answers3.get(numberOfQuestion));
        radioButton4.setText(Answers4.get(numberOfQuestion));
    }

    /**
     * This method is called when the try again button is clicked.
     * Returns everything to 0
     */
    public void again(View view) {
        numberOfQuestion = 0;
        score = 0;
        next();
        clean();
       summary.delete(0,summary.length());
        editText.getText().clear();
        stop = 0;
    }


    /**
     * this method Check For Correct Answers
     * It adds a point whenever the answer is correct
     */

    public void checkForCorrectAnswers() {

        boolean radio1 = radioButton1.isChecked();
        boolean radio2 = radioButton2.isChecked();
        boolean radio3 = radioButton3.isChecked();
        boolean radio4 = radioButton4.isChecked();

        switch (numberOfQuestion) {

            case 0:  //Check the answer to the question 1
                if (radioButton4.isChecked()) {
                    score++;
                }
                noteQuestion.append("\nQuestion Number 1: ").append(radio4);
                break;
            case 1:  //Check the answer to the question 2
                if (radioButton1.isChecked()) {
                    score++;
                }
                noteQuestion.append("\nQuestion Number 2: ").append(radio4);
                break;
            case 2:  //Check the answer to the question 3
                if (radioButton2.isChecked()) {
                    score++;
                }
                noteQuestion.append("\nQuestion Number 3: ").append(radio2);
                break;
            case 3:  //Check the answer to the question 4
                if (radioButton3.isChecked()) {
                    score++;
                }
                noteQuestion.append("\nQuestion Number 4: ").append(radio3);
                break;
            case 4: //Check the answer to the question 5
                if (radioButton4.isChecked()) {
                    score++;
                }
                noteQuestion.append("\nQuestion Number 5: ").append(radio4);
                 break;
            case 5:  //Check the answer to the question 6
                if (radioButton1.isChecked()) {
                    score++;
                }
                noteQuestion.append("\nQuestion Number 6: ").append(radio1);
                break;
            case 6:  //Check the answer to the question 7
                if (radioButton3.isChecked()) {
                    score++;
                }
                noteQuestion.append("\nQuestion Number 7: ").append(radio3);
                break;
        }
    }

    /**
     * This method removes the verification of Radiobutton whenever the user presses the next button
     * This method removes the verification of CheckBox whenever the user presses the next button
     */

    public void clean() {
        radioGroup.clearCheck();
        answer1.setChecked(false);
        answer2.setChecked(false);
        answer3.setChecked(false);
        answer4.setChecked(false);
    }

    /**
     * This method provides the result and observations to the user
     *
     * @param name of the user
     * @return summary
     */

    public StringBuilder notes(String name) {
        StringBuilder summary =new StringBuilder();
        String note;
        if (score >= 7) {
            note = "Excellent ";
        } else if (score >= 5) {
            note = "Good ";
        } else if (score == 4) {
            note = "Medium ";
        } else {
            note = "Bad ";
        }
        summary.append(note).append(name).append(" your score is: ").append(score).append("/8").append("\n").append(noteQuestion);
         return summary;
    }


    /**
     * This method is called when the result button is clicked.
     */

    public void result(View view) {
        if (stop > 0) {
            Toast.makeText(this, "Please enter try again button to play ", Toast.LENGTH_SHORT).show();
            return;
        }
        //Verify that the user has entered his name or not
        if (TextUtils.isEmpty(editText.getText().toString())) {
            Toast.makeText(this, "Please enter your name ", Toast.LENGTH_SHORT).show();
            return;
        }
        //Verify that the user answered all questions
        if (numberOfQuestion < 7) {
            Toast.makeText(this, "Please answer all questions", Toast.LENGTH_SHORT).show();
            return;
        }

        if ((!answer1.isChecked() && !answer2.isChecked() && !answer3.isChecked() && !answer4.isChecked()) || (answer1.isChecked() && answer2.isChecked() && answer3.isChecked() && answer4.isChecked())) {
            Toast.makeText(this, " Please Choose two answers to Question 8", Toast.LENGTH_SHORT).show();
            return;
        }
        //Check the answer to question 8
        if ((answer2.isChecked() && answer3.isChecked()) && !(answer1.isChecked() || answer4.isChecked())) {
            score++;
            noteQuestion.append("\nQuestion Number 8: true") ;
        } else {
            noteQuestion.append("\nQuestion Number 8: false") ;
        }

        String playerName = editText.getText().toString();
        StringBuilder summary = notes(playerName);
        displaymessage(summary);
        stop++;
    }

    /**
     * This method displays the result on the screen.
     *
     * @param message observations
     */
    private void displaymessage(StringBuilder message) {
        result.setText(message);
    }
}



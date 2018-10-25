package com.example.novaa.infs3634assignment;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.EventLog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.EventListener;
import java.util.Random;


public class   QuizFragment extends Fragment implements EventListener {

    //Created buttons for the 4 multiple choice options.
    Button answer1, answer2, answer3, answer4;

    //created TextView to display score count and question.
    TextView score, question;

    //created a private class for Questions so it can be accessed through the Questions() method.
    private Questions mQuestions = new Questions();
    private String mAnswer;

    //initialise mScore as 0 otherwise score counting will not begin from 0.
    private int mScore = 0;

    //used to determine the size of the array.
    private int mQuestionLength = mQuestions.mQuestions.length;

    //declared the Random variable 'r' so that we can use this variable to generate a random selection of questions.
    Random r;


    public QuizFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //generate a random question.
        r = new Random();

        //reference answer1 button to answer1 array, answer2 for answer2 array, etc.
        answer1 = (Button) view.findViewById(R.id.answer1);
        answer2 = (Button) view.findViewById(R.id.answer2);
        answer3 = (Button) view.findViewById(R.id.answer3);
        answer4 = (Button) view.findViewById(R.id.answer4);

        score = (TextView) view.findViewById(R.id.score);
        question = (TextView) view.findViewById(R.id.question);

        //create score by using mScore variable to display score count at the top of the App page.
        score.setText("Score: " + mScore);

        //generate next question randomly using this method.
        updateQuestion(r.nextInt(mQuestionLength));




        //creates an action for when the user selects answer1 button.
        //If the user clicks on the first answer and it is correct, it will display "Correct!" and move on to the next question.
        //If it is incorrect, it will display 'Game Over!', and ask the user to choose whether to go back to home or play again.
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer1.getText() == mAnswer) {
                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion(r.nextInt(mQuestionLength));
                    Toast.makeText(getActivity(), "Correct Answer!", Toast.LENGTH_SHORT).show();


                } else {
                    gameOver();


                }

            }
        });

        //If the user clicks on the second answer and it is correct, it will display "Correct!" and move on to the next question.
        //If it is incorrect, it will display 'Game Over!', and ask the user to choose whether to go back to home or play again.
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer2.getText() == mAnswer) {
                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion(r.nextInt(mQuestionLength));
                    Toast.makeText(getActivity(), "Correct Answer!", Toast.LENGTH_SHORT).show();


                } else {
                    gameOver();
                }


            }
        });


        //If the user clicks on the third answer and it is correct, it will display "Correct!" and move on to the next question.
        //If it is incorrect, it will display 'Game Over!', and ask the user to choose whether to go back to home or play again.
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer3.getText() == mAnswer) {
                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion(r.nextInt(mQuestionLength));
                    Toast.makeText(getActivity(), "Correct Answer!", Toast.LENGTH_SHORT).show();


                } else {
                    gameOver();
                }

            }
        });


        //If the user clicks on the fourth answer and it is correct, it will display "Correct!" and move on to the next question.
        //If it is incorrect, it will display 'Game Over!', and ask the user to choose whether to go back to home or play again.
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer4.getText() == mAnswer) {
                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion(r.nextInt(mQuestionLength));
                    Toast.makeText(getActivity(), "Correct Answer!", Toast.LENGTH_SHORT).show();


                } else {
                    gameOver();
                }

            }
        });

    }




    //created a private void method named 'updateQuestion'.
    //this will generate the number of questions asked, that is the number of questions correctly asked by the user.
    private void updateQuestion ( int num){
        question.setText(mQuestions.getQuestion(num));
        answer1.setText(mQuestions.getChoice1(num));
        answer2.setText(mQuestions.getChoice2(num));
        answer3.setText(mQuestions.getChoice3(num));
        answer4.setText(mQuestions.getChoice4(num));

        mAnswer = mQuestions.getCorrectAnswer((num));


    }

    // https://developer.android.com/reference/android/app/AlertDialog - source explicitly used for this section.
    // AlertDialog is a small window which prompts the user to choose whether they want to return to home or play again.
    // It also displays the final score for that round.
    //.setMessage: set the message to display using the given resource id.
    //.setCancelable removes 'CANCEL' button in the AlertDialog.
    //.setPositiveButton allows the user to start QuizActivity activity by pressing on "NEW GAME".

    private void gameOver() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder
                .setMessage("Game Over! Your score is " + mScore + " points.")
                .setCancelable(false)
                .setPositiveButton("NEW GAME",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(getContext(), NavigationBar.class);
                                intent.putExtra("button", 2);
                                startActivity(intent);
                                getActivity().finish();

                            }
                        })

                //.setNegativeButton allows the user to finish the QuizActivity activity and return to the Main Activity "HOME".
                .setNegativeButton("HOME",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                getActivity().finish();

                            }
                        });

        //allows the AlertDialog popup message to be initialised and shown to the user.
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}


package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mTextView;
    private Button mTopButton;
    private Button mBottomButton;
    //private Obj storyBanque;

    int[] T1 = {
            R.string.T1_Story,
            R.string.T1_Ans1,
            R.string.T1_Ans2
    };
    int[] T2 = {
            R.string.T2_Story,
            R.string.T2_Ans1,
            R.string.T2_Ans2
    };
    int[] T3 = {
            R.string.T3_Story,
            R.string.T3_Ans1,
            R.string.T3_Ans2
    };
    int[] endsIds = {
            R.string.T4_End,
            R.string.T5_End,
            R.string.T6_End
    };
    private int state = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.storyTextView);
        mTopButton = (Button) findViewById(R.id.buttonTop);
        mBottomButton = (Button) findViewById(R.id.buttonBottom);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewGroup layout = (ViewGroup) mTopButton.getParent();
                state = state == 0? 1 : state;
                switch (state){
                    case 1:
                        //T1-> Ans2 -> T2
                        mTextView.setText(T2[0]);
                        mTopButton.setText(T2[1]);
                        mBottomButton.setText(T2[2]);
                        state = 2;
                        break;
                    case 2:
                        mTextView.setText(R.string.T4_End);


                        if(null!=layout) {
                            //for safety only  as you are doing onClick
                            layout.removeView(mTopButton);
                            layout.removeView(mBottomButton);
                        }
                        //T2-> Ans2 -> T4_end
                        //state = 4;
                        break;
                    case 3:
                        mTextView.setText(R.string.T5_End);
                        if(null!=layout) {
                            //for safety only  as you are doing onClick
                            layout.removeView(mTopButton);
                            layout.removeView(mBottomButton);
                        }
                        //T3-> Ans2 -> T5_end
                        //state = 5;
                        break;
                }
            }
        });

        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewGroup layout = (ViewGroup) mTopButton.getParent();
                state = state == 0? 1 : state;
                switch (state){
                    case 1:
                        //T1-> Ans1 -> T3
                        mTextView.setText(T3[0]);
                        mTopButton.setText(T3[1]);
                        mBottomButton.setText(T3[2]);
                        state = 3;
                        break;
                    case 3:
                        //T3-> Ans1 -> T6_end
                        mTextView.setText(R.string.T6_End);
                        if(null!=layout) {
                            //for safety only  as you are doing onClick
                            layout.removeView(mTopButton);
                            layout.removeView(mBottomButton);
                        }
                        state = 6;
                        break;
                    case 2:
                        //T2-> Ans1 -> T3
                        mTextView.setText(T3[0]);
                        mTopButton.setText(T3[1]);
                        mBottomButton.setText(T3[2]);
                        state = 3;
                        break;
                }
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:




        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:


    }
}

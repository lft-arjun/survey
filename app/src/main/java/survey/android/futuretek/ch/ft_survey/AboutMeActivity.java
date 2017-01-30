/**
 * Copyright (C) futuretek AG 2016
 * All Rights Reserved
 *
 * @author Artan Veliju
 */
package survey.android.futuretek.ch.ft_survey;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Class tell about the your self
 *
 */
public class AboutMeActivity extends BaseActivity {
    private String userName;
    private Button nextBtn;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLACK));

        nextBtn = (Button) findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(AboutMeActivity.this, SkillsActivity.class));
            }
        });

    }

    protected void onResume() {
        super.onResume();
        nextBtn.setTextColor(Color.GRAY);
        nextBtn.setEnabled(false);
        ((ViewGroup)findViewById(R.id.textLayout)).removeAllViews();
        //get User name from database
        userName=getDatabase().get("usersName");
        List<String> textArray;
        /**
         * Add text to display about yourself
         *
         */
        textArray = new ArrayList<>();
        textArray.add("My name is Arjun Sunar. I'm a Full Stack developer with over 5 years of experience in web based applications. My experience includes building and deploying scalable web based solutions. I have consistently delivered projects on time and under budget earning me a good reputation among my colleagues and clients.\n");
        textArray.add("Working with international companies, I have developed skills required to work collaboratively within a team of varying size and skills. Among other skills, my ability to communicate with client & to grasp their business needs is often appreciated. My programming expertise include PHP(Laravel4.x Laravel 5.x, Zend1 and Zend2, YII2), Ruby on Rails, AngularJS, Jquery, Bootstrap 3.");
        //Display the next button and activate
        animateText(textArray, new AnimationListDone() {
            public void done() {
                Button nextBtn = ((Button) findViewById(R.id.nextBtn));
                nextBtn.setTextColor(Color.GREEN);
                nextBtn.setEnabled(true);
            }
        });
    }
}
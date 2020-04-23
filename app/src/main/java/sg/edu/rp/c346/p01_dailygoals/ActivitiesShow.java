package sg.edu.rp.c346.p01_dailygoals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivitiesShow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities_show);

        Intent i = getIntent();
        String[] info = i.getStringArrayExtra("info");
        TextView tv1 = (TextView) findViewById(R.id.textView1);
        tv1.setText("Read up materials before class: " + info[0] +
                "\n Arrive on time so as not to miss important part of the lesson: " + info[1] +
                "\n Attempt the problem myslef: " + info[2] +
                "\n Reflection: " + info[3]);

        Button btn = (Button) findViewById(R.id.buttonBack);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}

package sg.edu.rp.c346.p01_dailygoals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg1, rg2, rg3;
    EditText et1;

    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg1 = findViewById(R.id.radioGroup1);
        rg2 = findViewById(R.id.radioGroup2);
        rg3 = findViewById(R.id.radioGroup3);
        et1 = findViewById(R.id.editTextQ4);



        int rec1 = pref.getInt("rb1", -1);
        int rec2 = pref.getInt("rb2", -1);
        int rec3 = pref.getInt("rb3", -1);
        String rec4 = pref.getString("et1", null);

        rg1.check(rec1);
        rg2.check(rec2);
        rg3.check(rec3);
        et1.setText(rec4);

        Button btn = (Button) findViewById(R.id.buttonSubmit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int selectedButtonId1 = rg1.getCheckedRadioButtonId();
                int selectedButtonId2 = rg2.getCheckedRadioButtonId();
                int selectedButtonId3 = rg3.getCheckedRadioButtonId();

                RadioButton rb1 = (RadioButton) findViewById(selectedButtonId1);
                RadioButton rb2 = (RadioButton) findViewById(selectedButtonId2);
                RadioButton rb3 = (RadioButton) findViewById(selectedButtonId3);

                String[] info = {rb1.getText().toString(),
                        rb2.getText().toString(),
                        rb3.getText().toString(),
                        et1.getText().toString()};
                Intent i = new Intent(MainActivity.this, ActivitiesShow.class);
                i.putExtra("info", info);
                startActivity(i);


                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("rb1", selectedButtonId1);
                editor.putInt("rb2", selectedButtonId2);
                editor.putInt("rb3", selectedButtonId3);
                editor.putString("et1", et1.getText().toString());
                editor.commit();

            }
        });

    }
}

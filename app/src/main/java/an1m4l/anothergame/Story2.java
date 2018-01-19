package an1m4l.anothergame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Story2 extends AppCompatActivity {

    int goblinHP = 5;  //TODO var wont update, maybe need to go to sharedprefs too
    int goblinAtt = 5;
    int playerAtt = 0;
    int playerTurn = 0;
    int goblinTurn = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story2);


        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            if (goblinHP > 0) {

                SharedPreferences sharedPref = getSharedPreferences("playerInfo", Context.MODE_PRIVATE);
                int playerHP = sharedPref.getInt("playerHP", 0);
                String playerWPN = sharedPref.getString("playerWPN", "");
                SharedPreferences.Editor editor = sharedPref.edit();

                Random roll = new Random();

                playerAtt = roll.nextInt(5);
                playerTurn = goblinHP - playerAtt;

                goblinAtt = roll.nextInt(3);
                goblinTurn = playerHP - goblinAtt;


                editor.putInt("playerHP", goblinTurn);
                editor.apply();



                TextView textView = findViewById(R.id.textView);
                textView.setText("hp: " + playerHP + "\nweapon: " + playerWPN + "\n\ngolin hp: " + goblinHP);


            } else {
                Intent startIntent = new Intent(getApplicationContext(), Story1.class);
                startActivity(startIntent);
            }

            }
        });



        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), Story1.class);
                startActivity(startIntent);

            }
        });
    }
}


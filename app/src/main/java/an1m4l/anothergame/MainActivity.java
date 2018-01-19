package an1m4l.anothergame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPref = getSharedPreferences("playerInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sharedPref.edit();
        editor.putString("playerWPN", "Knife");
        editor.putInt("playerHP", 10);
        editor.apply();

            Button buttonStart = findViewById(R.id.buttonStart);
            buttonStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent startIntent = new Intent(getApplicationContext(), Story1.class);
                    startActivity(startIntent);

                }
            });
    }
}

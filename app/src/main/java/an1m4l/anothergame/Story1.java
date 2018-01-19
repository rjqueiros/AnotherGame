package an1m4l.anothergame;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class Story1 extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story1);

        SharedPreferences sharedPref = getSharedPreferences("playerInfo", Context.MODE_PRIVATE);
        String playerWPN = sharedPref.getString("playerWPN", "");
        int playerHP = sharedPref.getInt("playerHP", 0);

        TextView txtStory1 = findViewById(R.id.txtStory1);
        txtStory1.setText("hp: " + playerHP + "\nweapon: " + playerWPN);

    }

}

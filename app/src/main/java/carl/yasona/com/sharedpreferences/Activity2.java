package carl.yasona.com.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    TextView tMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        tMsg = findViewById(R.id.tvMsg);
    }
    public void prevActivity(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void greet(View v){
        SharedPreferences sp = getSharedPreferences("data", MODE_PRIVATE);
        String name = sp.getString("uname", null); // s = key, s1 = defvalue
        String password = sp.getString("pass", null);
        String message = "Hello " + name + ". Your password is " + password;
        tMsg.setText(message);
    }
}

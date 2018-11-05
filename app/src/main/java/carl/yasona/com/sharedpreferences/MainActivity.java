package carl.yasona.com.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tName, tPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tName = findViewById(R.id.etName);
        tPwd = findViewById(R.id.etPwd);
    }

    public void nextActivity(View v){
        Intent i = new Intent(this, Activity2.class);
        startActivity(i);
    }

    public void saveData(View v){
        String name = tName.getText().toString();
        String pwd = tPwd.getText().toString();
        SharedPreferences sp = getSharedPreferences("data", MODE_PRIVATE); //paper
        SharedPreferences.Editor writer = sp.edit(); //pen
        writer.putString("uname", name);
        writer.putString("pass", pwd);
        writer.commit();
        Toast.makeText(this, "Saved Successfully",Toast.LENGTH_LONG).show();
    }
}

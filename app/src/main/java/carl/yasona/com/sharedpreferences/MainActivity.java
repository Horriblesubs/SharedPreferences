package carl.yasona.com.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    TextView tName, tPwd;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tName = findViewById(R.id.etName);
        tPwd = findViewById(R.id.etPwd);
    }

    public void nextActivity(View v) {
        Intent i = new Intent(this, Activity2.class);
        startActivity(i);
    }

    public void saveData(View v) {
        name = tName.getText().toString();
        String pwd = tPwd.getText().toString();
        SharedPreferences sp = getSharedPreferences("data", MODE_PRIVATE); //paper
        SharedPreferences.Editor writer = sp.edit(); //pen
        writer.putString("uname", name);
        writer.putString("pass", pwd);
        writer.commit();
        Toast.makeText(this, "Saved Successfully", Toast.LENGTH_LONG).show();
    }

    public void saveInternal(View v) {
        FileOutputStream fos = null;
        String name2 = tName.getText().toString();
        try {
            fos = openFileOutput("internal.txt", MODE_PRIVATE);
            fos.write(name2.getBytes());
            Toast.makeText(this, "Data saved in the internal file...", Toast.LENGTH_LONG);
        } catch (Exception e) {
            Toast.makeText(this, "Error writing to internal file..", Toast.LENGTH_LONG);
        }finally{
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveExternal(View v){
        File folder = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(folder, "external.txt");
        FileOutputStream fos = null;
        String name2 = tName.getText().toString();
        try {
            fos = new FileOutputStream(file);
            fos.write(name2.getBytes());
            Toast.makeText(this, "Data saved in the external file...", Toast.LENGTH_LONG);
        } catch (Exception e) {
            Toast.makeText(this, "Error writing to external file..", Toast.LENGTH_LONG);
        }finally{
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void saveCache(View v){
        File folder = getCacheDir(); //External Cache - getExternalCacheDir();
        File file = new File(folder, "cache.txt");
        FileOutputStream fos = null;
        String name2 = tName.getText().toString();
        try {
            fos = new FileOutputStream(file);
            fos.write(name2.getBytes());
            Toast.makeText(this, "Data saved in the external file...", Toast.LENGTH_LONG);
        } catch (Exception e) {
            Toast.makeText(this, "Error writing to external file..", Toast.LENGTH_LONG);
        }finally{
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


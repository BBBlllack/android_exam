package edu.hebut.ActivityLifeCycle.exam6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import edu.hebut.ActivityLifeCycle.R;

public class InternalFileDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_file_demo);
        File fileDir = this.getFilesDir();
        File file = new File(fileDir, "shj.txt");
        TextView textView = findViewById(R.id.exam6_display_edittext);
        EditText editText = findViewById(R.id.exam6_write_edittext);
        findViewById(R.id.exam6_write_disk).setOnClickListener(v -> {
            try {
                OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file));
                osw.write(editText.getText().toString());
                osw.close();
                Toast.makeText(this, "写入文件成功!", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        findViewById(R.id.exam6_read_disk).setOnClickListener(v -> {
            try {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(file)
                        )
                );
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                br.close();
                String fileContent = sb.toString();
                textView.setText(fileContent);
                Toast.makeText(this, "显示文件内容成功", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
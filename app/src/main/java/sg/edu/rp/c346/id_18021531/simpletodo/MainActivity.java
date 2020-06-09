package sg.edu.rp.c346.id_18021531.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  EditText et;
  Button btnAdd, btnClear;
  ListView lv;
    ArrayList<String> alTask;
    ArrayAdapter<String> aaTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.editText);
        btnAdd = findViewById(R.id.button);
        btnClear = findViewById(R.id.button2);
        lv =  findViewById(R.id.listview);

        alTask = new ArrayList<>();
        aaTask = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, alTask);
        lv.setAdapter(aaTask);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newTask = et.getText().toString();


                alTask.add(newTask);
                aaTask.notifyDataSetChanged();
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.setText("");
                alTask.clear();
                aaTask.notifyDataSetChanged();
            }
        });

    }
}

package ru.ashukhardin.kinoteka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SerialActivity extends AppCompatActivity {
    private TextView serial_names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serial);
        serial_names = findViewById(R.id.tV_serial_name);

        String[] serials = {"1","2","3","4"};
        serial_names.setText("");
        for (String serial:serials) {
            serial_names.append(serial+"\n");
        }
    }
}
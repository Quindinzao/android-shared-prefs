package com.quindinzao.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_PREFERENCE = "FilePreference";
    private EditText editName;
    private TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);
        txtName = findViewById(R.id.txtName);

        recoveryData();
    }

    public void saveData(View view) {
        String name = editName.getText().toString();
        
        if (!name.isEmpty()) {
            SharedPreferences sharedPreferences = getSharedPreferences(FILE_PREFERENCE, 0);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("my_name", name);
            editor.apply();
        } else {
            editName.setError(getText(R.string.text_field_is_empty));
        }
    }

    private void recoveryData() {
        SharedPreferences sharedPreferences = getSharedPreferences(FILE_PREFERENCE, 0);
        String recoveredName = sharedPreferences.getString("my_name", "");
        txtName.setText(recoveredName);
    }
}
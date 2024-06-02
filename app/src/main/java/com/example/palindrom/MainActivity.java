package com.example.palindrom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private  EditText editText;
    private Button checkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        checkButton = findViewById(R.id.checkButton);
        editText = findViewById(R.id.editText);
        checkButton.setOnClickListener(view -> {
            String text = editText.getText().toString().trim();
            Intent intent;
            if (isPalindrome(text)) {
                intent = new Intent(MainActivity.this, TrueActivity.class);
                intent.putExtra("word", text);
                startActivity(intent);
            } else {
                intent = new Intent(MainActivity.this, FalseActivity.class);
                intent.putExtra("word", text);
                startActivity(intent);
            }
        });
    }
    private boolean isPalindrome(String str){
        int length = str.length();
        for (int i = 0; i < length / 2; i ++){
            if (str.charAt(i) != str.charAt(length - 1 - i)){
                return false;
            }
        }
        return true;
    }


}
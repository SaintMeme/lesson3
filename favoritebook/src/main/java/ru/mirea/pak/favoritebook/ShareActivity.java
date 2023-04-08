package ru.mirea.pak.favoritebook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ShareActivity extends AppCompatActivity {

    EditText textUserBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        textUserBook = findViewById(R.id.editTextUserBook);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            TextView devBookText = findViewById(R.id.textViewDevBook);
            String devBook = extras.getString(MainActivity.KEY);
            devBookText.setText(String.format("Любимая книга разработчика: %s", devBook));
        }
    }
    public void shareButton(View view) {
        String text ="Ваша любимая книга: " + textUserBook.getText();
        Intent data = new Intent();
        data.putExtra(MainActivity.USER_MESSAGE, text);
        setResult(Activity.RESULT_OK, data);
        finish();
    }
}
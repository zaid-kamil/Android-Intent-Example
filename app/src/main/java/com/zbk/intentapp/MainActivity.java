package com.zbk.intentapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editName;
    private EditText editEmail;
    private EditText editCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(this);
        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editCountry = findViewById(R.id.editCountry);
    }


    @Override
    public void onClick(View v) {
        String name = editName.getText().toString();
        String email = editEmail.getText().toString();
        String country = editCountry.getText().toString();
        Intent i = new Intent(this,DetailActivity.class);
        i.putExtra("name",name);
        i.putExtra("email",email);
        i.putExtra("country",country);
        startActivity(i);
    }
}

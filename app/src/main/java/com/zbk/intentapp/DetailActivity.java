package com.zbk.intentapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

public class DetailActivity extends AppCompatActivity {

    private TextView textName;
    private TextView textEmail;
    private TextView textCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textName = findViewById(R.id.textName);
        textEmail = findViewById(R.id.textEmail);
        textCountry = findViewById(R.id.textCountry);
        updateUI();
    }

    private void updateUI() {
        Intent i = getIntent();
        if (i.hasExtra("name")) {
            textName.setText(i.getStringExtra("name"));
        }
        if (i.hasExtra("email")) {
            textEmail.setText(i.getStringExtra("email"));
        }
        if (i.hasExtra("country")) {
            textCountry.setText(i.getStringExtra("country"));
        }
    }

    public void share(View v) {
        String name = textName.getText().toString();
        String country = textCountry.getText().toString();
        String email = textEmail.getText().toString();
        String shareText = "Send from my app\n" + name + "\n" + email + "\n" + country;
        String mime = "text/plain";
        ShareCompat.IntentBuilder
                .from(this) //The Activity that launches this share Intent (this).
                .setType(mime) //The MIME type of the item to be shared.
                .setChooserTitle("where do want to share") //title
                .setText(shareText) //The actual text to be shared
                .startChooser();

    }

    public void viewMap(View v) {
        String country=textCountry.getText().toString();
        // Parse the location and create the intent.
        Uri addressUri = Uri.parse("geo:0,0?q=" + country);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        // Find an activity to handle the intent, and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "no app can complete this", Toast.LENGTH_SHORT).show();
        }
    }

}

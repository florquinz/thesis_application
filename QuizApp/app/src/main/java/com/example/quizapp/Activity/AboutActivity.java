package com.example.quizapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.quizapp.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class AboutActivity extends AppCompatActivity {

    MaterialCardView reviewCard, developerCard;
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        reviewCard = findViewById(R.id.reviewCard);
        backBtn = findViewById(R.id.aboutBackBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AboutActivity.this, MainActivity.class));
            }
        });


        reviewCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://cplusplus.com/files/tutorial.pdf");
                Intent likelng = new Intent(Intent.ACTION_VIEW, uri);
                likelng.setPackage("com.google.android");
                try {
                    startActivity(likelng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://cplusplus.com/files/tutorial.pdf")));
                }
            }
        });

        developerCard = findViewById(R.id.developerCard);

        developerCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.facebook.com/profile.php?id=61554095173850");
                Intent likelng = new Intent(Intent.ACTION_VIEW, uri);
                likelng.setPackage("com.facebook.android");
                try {
                    startActivity(likelng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/profile.php?id=61554095173850")));
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Create a MaterialAlertDialogBuilder
        MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(AboutActivity.this);
        alertDialogBuilder.setTitle("c++ Programming Quiz App");
        alertDialogBuilder.setMessage("Do you want to go back?");
        alertDialogBuilder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alertDialogBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Finish the current activity (AboutActivity) and navigate back to the MainActivity
                startActivity(new Intent(AboutActivity.this, MainActivity.class));
                finish();
            }
        });
        alertDialogBuilder.show();
    }

}
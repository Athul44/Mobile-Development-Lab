package com.example.sjcet.grvialbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;



public class MainActivity extends AppCompatActivity {

    private Context context;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        gridView = findViewById(R.id.gridView);

        // Sample images (replace with your image resource IDs)
        final int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4};

        ImageAdapter adapter = new ImageAdapter(this, images);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Display an alert dialog on item click
                showImageDialog(images[position]);
            }
        });
    }

    private void showImageDialog(int imageResId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Selected Image");
        builder.setMessage("You selected an image!");

        ImageView imageView = new ImageView(context);
        imageView.setImageResource(imageResId);
        builder.setView(imageView);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();
    }
}


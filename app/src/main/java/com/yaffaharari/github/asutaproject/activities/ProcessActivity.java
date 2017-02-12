package com.yaffaharari.github.asutaproject.activities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.nfc.Tag;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ceylonlabs.imageviewpopup.ImagePopup;
import com.yaffaharari.github.asutaproject.ImageFragment;
import com.yaffaharari.github.asutaproject.R;

import uk.co.senab.photoview.PhotoViewAttacher;

public class ProcessActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = "ProcessActivity";

    ImageButton img1, img2, img3, img4;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process);
        init();

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        Glide.with(getApplicationContext())
                .load(R.drawable.img4)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(img4);
    }

    private void init() {
        img1 = (ImageButton) findViewById(R.id.img1);
        img2 = (ImageButton) findViewById(R.id.img2);
        img3 = (ImageButton) findViewById(R.id.img3);
        img4 = (ImageButton) findViewById(R.id.img4);
        frameLayout = (FrameLayout)findViewById(R.id.fragment_layout);
    }

    @Override
    public void onClick(View v) {
        int imageId = 0;
        String imageName = v.getResources().getResourceEntryName(v.getId());
        switch (imageName){
            case "img1":
                imageId = R.drawable.img1;
                break;
            case "img2":
                imageId = R.drawable.img2;
                break;
            case "img3":
                imageId = R.drawable.img3;
                break;
        }
        ImageFragment imageFragment = ImageFragment.newInstance(imageId);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_layout, imageFragment)
                .addToBackStack(null)
                .commit();
    }
}




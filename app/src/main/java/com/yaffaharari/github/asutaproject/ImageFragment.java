package com.yaffaharari.github.asutaproject;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ceylonlabs.imageviewpopup.ImagePopup;

import uk.co.senab.photoview.PhotoViewAttacher;


public class ImageFragment extends Fragment {

    private static final String IMG_ID = "imgId";
    private ImageView mImageView;
    int imgId;
    PhotoViewAttacher mAttacher;

    public ImageFragment() {
    }

    public static ImageFragment newInstance(int imgId) {
        ImageFragment fragment = new ImageFragment();
        Bundle args = new Bundle();
        args.putInt(IMG_ID, imgId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            imgId = getArguments().getInt(IMG_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_image, container, false);
        mImageView = (ImageView)v.findViewById(R.id.imageView);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        onSetSelectedImage();
    }

    private void onSetSelectedImage() {
        mImageView.setImageResource(imgId);
        mAttacher = new PhotoViewAttacher(mImageView);
        mAttacher.update();
    }

}

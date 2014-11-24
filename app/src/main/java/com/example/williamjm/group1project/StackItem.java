package com.example.williamjm.group1project;

import android.graphics.drawable.Drawable;

/**
 * Created by user on 11/20/14.
 */
public class StackItem {

    public String text;
    public Drawable img;

    public StackItem(String text,Drawable photo)
    {
        this.img = photo;
        this.text = text;
    }

    public String getText()
    {
        return this.text;
    }


    public String toString() {
        return this.text;
    }

}
package com.example.williamjm.group1project;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class StackAdapter extends ArrayAdapter<StackItem> {

    private ArrayList<StackItem> items;
    private Context contex;

    public StackAdapter(Context context, int textViewResourceId,
                        ArrayList<StackItem> objects) {
        super(context, textViewResourceId, objects);

        this.items = objects;
        this.contex = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater)
                    contex.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.item, null);
        }

        StackItem m = items.get(position);

        if (m != null) {
            TextView text = (TextView) v.findViewById(R.id.TestText);
            ImageView img = (ImageView) v.findViewById(R.id.imageView);

            if (text != null) {
                text.setText(m.text);
                img.setImageDrawable(m.img);

            }
        }
        return v;
    }
}

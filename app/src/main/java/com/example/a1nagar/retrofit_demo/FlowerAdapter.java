package com.example.a1nagar.retrofit_demo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a1nagar.retrofit_demo.model.Flower;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FlowerAdapter extends ArrayAdapter<Flower> {

    private Context context;
    private List<Flower> flowerList;

    public FlowerAdapter(Context context, int resource, List<Flower> objects) {
        super(context, resource, objects);
        this.context = context;
        this.flowerList = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_flower,parent,false);

        Flower flower = flowerList.get(position);
        TextView tv = (TextView) view.findViewById(R.id.textView);
        tv.setText(flower.getName().toString());
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);

        Picasso.with(this.context)
                .load(MainActivity.IMAGE_URL+flower.getPhoto())
                .into(imageView);

//        imageView.setImageBitmap(flower.getBitmap());

        return view;

    }
}

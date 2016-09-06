package com.mark1.novem.appebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by masterUNG on 9/6/2016 AD.
 */
public class MyAdapter extends BaseAdapter{

    //Explicit
    private Context context;
    private String[] titleStrings, priceStrings, iconStrings;

    public MyAdapter(Context context,
                     String[] titleStrings,
                     String[] priceStrings,
                     String[] iconStrings) {
        this.context = context;
        this.titleStrings = titleStrings;
        this.priceStrings = priceStrings;
        this.iconStrings = iconStrings;
    }   // Constructor

    @Override
    public int getCount() {
        return titleStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view1 = layoutInflater.inflate(R.layout.cover_listview, viewGroup, false);

        //Bind Widget
        TextView titleTextView = (TextView) view1.findViewById(R.id.textView);
        TextView priceTextView = (TextView) view1.findViewById(R.id.textView2);
        ImageView imageView = (ImageView) view1.findViewById(R.id.imageView);

        //Show View
        titleTextView.setText(titleStrings[i]);
        priceTextView.setText("ราคา = " + priceStrings[i] + " บาท");
        Picasso.with(context).load(iconStrings[i]).resize(120, 150).into(imageView);

        return view1;
    }
}   // Main Class

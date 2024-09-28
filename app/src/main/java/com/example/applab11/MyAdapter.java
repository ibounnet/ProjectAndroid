package com.example.applab11;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.applab11.model.Food;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Food> values;
    private Context context;

    // Constructor
    public MyAdapter(List<Food> values, Context context) {
        this.values = values;
        this.context = context;
    }

    // ViewHolder class to represent each food item in the RecyclerView
    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgView;
        public TextView txtHeader;
        public TextView txtFooter;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            imgView = (ImageView) v.findViewById(R.id.imageView);
            txtHeader = (TextView) v.findViewById(R.id.drink_name);
            txtFooter = (TextView) v.findViewById(R.id.drink_price);
        }
    }

    // Inflate the row layout and return a ViewHolder object
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.activity_menu_detail, parent, false); // เปลี่ยนชื่อไฟล์ XML ตามที่คุณตั้งไว้
        return new ViewHolder(v);
    }

    // Bind the data to the views in each ViewHolder
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Food food = values.get(position);
        holder.txtHeader.setText(food.getFood_name());
        holder.txtFooter.setText(food.getFood_price() + " บาท");

        // Load the image using Glide
        Glide.with(context)
                .load(food.getFood_image())
                .into(holder.imgView);

        // Set up click listener for the image to open MenuDetailActivity
        holder.imgView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MenuDetailActivity.class);
                intent.putExtra("image_url", food.getFood_image());
                intent.putExtra("menu_name", food.getFood_name());
                intent.putExtra("menu_price", "ราคา: ฿" + food.getFood_price());
                context.startActivity(intent);
            }
        });
    }

    // Return the total number of items in the list
    @Override
    public int getItemCount() {
        return values.size();
    }
}

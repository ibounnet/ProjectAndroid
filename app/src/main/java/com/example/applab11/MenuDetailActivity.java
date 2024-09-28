package com.example.applab11;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MenuDetailActivity extends AppCompatActivity {

    private ImageView menuImageView;
    private TextView menuNameTextView;
    private TextView menuPriceTextView;
    private Button addOrderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail);

        menuImageView = findViewById(R.id.menuImageView);
        menuNameTextView = findViewById(R.id.menuNameTextView);
        menuPriceTextView = findViewById(R.id.menuPriceTextView);
        addOrderButton = findViewById(R.id.addOrderButton);


        String menuName = getIntent().getStringExtra("menu_name");
        String menuPrice = getIntent().getStringExtra("menu_price");
        int imageResId = getIntent().getIntExtra("image_res_id", R.drawable.default_image);


        menuNameTextView.setText(menuName);
        menuPriceTextView.setText(menuPrice);
        menuImageView.setImageResource(imageResId); // ใช้ resource ID

        addOrderButton.setOnClickListener(v -> {
            addOrder(menuName, menuPrice);
        });
    }

    private void addOrder(String menuName, String menuPrice) {
        Toast.makeText(getApplicationContext(), menuName + " added to order ka!", Toast.LENGTH_SHORT).show();
    }
}

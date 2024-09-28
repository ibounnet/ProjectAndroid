package com.example.applab11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ImageView imageViewEspresso = findViewById(R.id.imageView);
        TextView drinkNameEspresso = findViewById(R.id.drink_name);
        TextView drinkDescriptionEspresso = findViewById(R.id.drink_description);
        TextView drinkPriceEspresso = findViewById(R.id.drink_price);

        ImageView imageViewLatte = findViewById(R.id.imageView2);
        TextView drinkNameLatte = findViewById(R.id.drink_name2);
        TextView drinkDescriptionLatte = findViewById(R.id.drink_description2);
        TextView drinkPriceLatte = findViewById(R.id.drink_price2);

        ImageView imageViewCappuccino = findViewById(R.id.imageView3);
        TextView drinkNameCappuccino = findViewById(R.id.drink_name3);
        TextView drinkDescriptionCappuccino = findViewById(R.id.drink_description3);
        TextView drinkPriceCappuccino = findViewById(R.id.drink_price3);

        ImageView imageViewMocha = findViewById(R.id.imageView4);
        TextView drinkNameMocha = findViewById(R.id.drink_name4);
        TextView drinkDescriptionMocha = findViewById(R.id.drink_description4);
        TextView drinkPriceMocha = findViewById(R.id.drink_price4);

        // ตั้งค่าข้อมูลเมนู
        drinkNameEspresso.setText(R.string.espresso);
        drinkDescriptionEspresso.setText(R.string.espresso_description);
        drinkPriceEspresso.setText(R.string.drink_price_espresso);
        imageViewEspresso.setImageResource(R.drawable.espresso);

        drinkNameLatte.setText(R.string.latte);
        drinkDescriptionLatte.setText(R.string.latte_description);
        drinkPriceLatte.setText(R.string.drink_price_latte);
        imageViewLatte.setImageResource(R.drawable.latte);

        drinkNameCappuccino.setText(R.string.cappuccino);
        drinkDescriptionCappuccino.setText(R.string.cappuccino_description);
        drinkPriceCappuccino.setText(R.string.drink_price_cappuccino);
        imageViewCappuccino.setImageResource(R.drawable.cappuccino);

        drinkNameMocha.setText(R.string.mocha);
        drinkDescriptionMocha.setText(R.string.mocha_description);
        drinkPriceMocha.setText(R.string.drink_price_mocha);
        imageViewMocha.setImageResource(R.drawable.mocha);

        // ตั้งค่าการคลิกที่ภาพ
        imageViewEspresso.setOnClickListener(v -> onDrinkClick(v, R.string.espresso, R.string.drink_price_espresso, R.drawable.espresso));
        imageViewLatte.setOnClickListener(v -> onDrinkClick(v, R.string.latte, R.string.drink_price_latte, R.drawable.latte));
        imageViewCappuccino.setOnClickListener(v -> onDrinkClick(v, R.string.cappuccino, R.string.drink_price_cappuccino, R.drawable.cappuccino));
        imageViewMocha.setOnClickListener(v -> onDrinkClick(v, R.string.mocha, R.string.drink_price_mocha, R.drawable.mocha));
    }

    public void onDrinkClick(View view, int nameResId, int priceResId, int imageResId) {
        Intent intent = new Intent(this, MenuDetailActivity.class);

        String menuName = getString(nameResId);
        String menuPrice = getString(priceResId);

        // ส่งข้อมูลไปยัง MenuDetailActivity
        intent.putExtra("menu_name", menuName);
        intent.putExtra("menu_price", menuPrice);
        intent.putExtra("image_res_id", imageResId);

        startActivity(intent);
    }
}

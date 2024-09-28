package com.example.applab11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonMenu = findViewById(R.id.buttonMenu);
        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // เปิดหน้าเมนู
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        // เพิ่มการหน่วงเวลา 5 วินาทีสำหรับ splash screen
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // เปิดหน้าเมนูโดยอัตโนมัติ (ถ้าต้องการ)
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
                finish(); // ปิด MainActivity
            }
        }, 5000); // 5000 มิลลิวินาที = 5 วินาที
    }
}

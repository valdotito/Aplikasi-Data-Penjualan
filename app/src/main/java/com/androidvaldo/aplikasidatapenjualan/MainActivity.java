package com.androidvaldo.aplikasidatapenjualan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

     public void Pindah(View view) {
         Intent Intent = new Intent(MainActivity.this,Main2Activity.class);
         startActivity(Intent);
     }
 }
package com.nayanatech.nayanarestaurant.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.nayanatech.nayanarestaurant.R;

public class PaymentPage extends AppCompatActivity {
    private ImageView icic_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        icic_iv=findViewById(R.id.icici_bank_iv);
        icic_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),NetBankingActivity.class);
                startActivity(intent);
            }
        });
    }
}

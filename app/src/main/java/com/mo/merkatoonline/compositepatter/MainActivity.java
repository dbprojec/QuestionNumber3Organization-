package com.mo.merkatoonline.compositepatter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mo.merkatoonline.compositepatter.CompositeDesingPattern.CompositeDesingPatternClass;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView ceo, markting, production;
    CompositeDesingPatternClass compositeDesingPatternClass = new CompositeDesingPatternClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compositeDesingPatternClass.makeEmployeeList();
        //Finding the views
        ceo = findViewById(R.id.ceoTextView);
        ceo.setOnClickListener(this);

        markting = findViewById(R.id.marketingVPTextView);
        markting.setOnClickListener(this);

        production = findViewById(R.id.productionVPTextView);
        production.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == ceo){
            System.out.println("Under " + compositeDesingPatternClass.boss.print());
        }else if(view == markting){
            System.out.println("Under " + compositeDesingPatternClass.marketingEmpVP.print());
        }else if(view == production){
            System.out.println("Under " + compositeDesingPatternClass.productionVP.print());
        }
    }
}

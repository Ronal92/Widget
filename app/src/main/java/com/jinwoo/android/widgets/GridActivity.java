package com.jinwoo.android.widgets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GridActivity extends AppCompatActivity implements View.OnClickListener {

    Button gridBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        gridBtn = (Button) findViewById(R.id.btn1);
        gridBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn1 :
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
        }
    }
}

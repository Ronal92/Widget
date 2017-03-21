package com.jinwoo.android.widgets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // 1. 사용할 위젯의 변수를 선언한다.
    Button btnGrid;
    Button calculator;
    Button widget;
    Button unitconverter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //
        setContentView(R.layout.activity_main);

        // 2. 선언된 변수에 xml의 위젯 id를 가져와서 담아준다.
        btnGrid = (Button) findViewById(R.id.btnGrid);
        calculator = (Button) findViewById(R.id.calculator);
        widget = (Button) findViewById(R.id.widgetbtn);
        unitconverter = (Button) findViewById(R.id.unitconverter);
        // 3. 변수(위젯)을 리스너에 달아준다.

        btnGrid.setOnClickListener(this);
        calculator.setOnClickListener(this);
        widget.setOnClickListener(this);
        unitconverter.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Intent intent;
        switch(view.getId()){
            // 안드로이드 메이저 컴포넌트를 로드하기 위해서는
            // intent를 통해서 로드할 컴포넌트(GridActivity)를 지정해야 한다.
            case R.id.btnGrid:
                intent = new Intent(this, GridActivity.class);
                startActivity(intent);
                break;

            case R.id.calculator :
                intent = new Intent(this, CalculatorActivity.class);
                startActivity(intent);
                break;

            case R.id.widgetbtn:
                intent = new Intent(this,WidgetActivity.class);
                startActivity(intent);
                break;
            case R.id.unitconverter:
                intent = new Intent(this, UnitActivity.class);
                startActivity(intent);
                break;
        }
    }
}

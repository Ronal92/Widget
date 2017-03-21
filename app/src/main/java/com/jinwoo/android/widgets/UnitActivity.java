package com.jinwoo.android.widgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class UnitActivity extends AppCompatActivity {

    Button btnLength, btnArea, btnWeight;
    LinearLayout layoutLength, layoutArea, layoutWeight;

    Spinner unitspinner1, unitspinner2;
    ArrayList<String> unitStr = new ArrayList<>(); // 단위들을 저장한다.

    EditText inputnum1;
    EditText inputnum2;

    String selectedUnit1 = "";
    String selectedUnit2 = "";


//    EditText et;
//    et = (EditText)findViewById(R.id.);
//    Toast.makeText(this, "EditText:"+et.getText().toString(),Toast.LENGTH_SHORT);
//     et.setEnabled(false); Edit 텍스트 사용 안되게 <<모든 위젯
//     et.setKeyListener(null);                       << Edit 위젯만

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit);



        // 1. 위젯 가져오기
        btnLength = (Button) findViewById(R.id.btnLength);
        btnArea = (Button) findViewById(R.id.btnArea);
        btnWeight = (Button) findViewById(R.id.btnWeight);

        layoutLength = (LinearLayout)findViewById(R.id.layoutLengh);
        layoutArea = (LinearLayout)findViewById(R.id.layoutArea);
        layoutWeight = (LinearLayout)findViewById(R.id.layoutWeight);

        inputnum1 = (EditText) findViewById(R.id.inputnum1);
        inputnum2 = (EditText) findViewById(R.id.inputnum2);

        // 2. 버튼 리스너 등록
        btnLength.setOnClickListener(clickListener);
        btnWeight.setOnClickListener(clickListener);
        btnArea.setOnClickListener(clickListener);

        // 스피너
        unitspinner1 = (Spinner)findViewById(R.id.unitspinner1);
        unitspinner2 = (Spinner)findViewById(R.id.unitspinner2);

        unitStr.add("Milimeter(mm)");
        unitStr.add("Centimeter(cm)");
        unitStr.add("Meter(m)");
        unitStr.add("Kelometer(km)");
        unitStr.add("inch(in)");
        unitStr.add("feet(ft)");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, unitStr
        );

        unitspinner1.setAdapter(adapter);
        unitspinner2.setAdapter(adapter);

        unitspinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            // 사용자가 Spinner 입력하면 EditText 초기화(왼쪽 스피너)
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(UnitActivity.this, unitStr.get(position), Toast.LENGTH_SHORT).show();
                selectedUnit = unitStr.get(position);
                inputnum1.setText("");
                inputnum2.setText("");
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        unitspinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        })

        // EditText Listener
        inputnum1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            // 사용자가 단위를 바꾸면 계산한다. (값, 선택된 단위)
            @Override
            public void afterTextChanged(Editable s) {
                String changedInput = Converter(inputnum1.getText().toString(), selectedUnit);
                inputnum2.setText(changedInput);
            }
        });
    }

    // 보여줄 화면을 구분한다.
    View.OnClickListener clickListener = new View.OnClickListener(){
        public void onClick(View view){
            //클릭이 발생하면 모두 지운다.
            layoutLength.setVisibility(View.GONE);
            layoutArea.setVisibility(View.GONE);
            layoutWeight.setVisibility(View.GONE);

            // 해당하는 화면만 보여준다.
            switch(view.getId()){
                case R.id.btnLength:
                    layoutLength.setVisibility(View.VISIBLE);
                    break;
                case R.id.btnArea:
                    layoutArea.setVisibility(View.VISIBLE);
                    break;
                case R.id.btnWeight:
                    layoutWeight.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

    private String Converter(String inputnum, String selectedUnit){
        String res = "";
        double d = 0d;

            //에러 처리
        if(inputnum.equals("")){
            inputnum = "0";
        }
        else if(selectedUnit.equals("Milimeter(mm)")){
            d = (double)Integer.parseInt(inputnum) * 0.01;
           res = String.valueOf(d) ;
        }else if(selectedUnit.equals("Centimeter(cm)")){
            res = String.valueOf(Integer.parseInt(inputnum));
        }else if(selectedUnit.equals("Meter(m)")){
            res = String.valueOf(Integer.parseInt(inputnum) * 100) ;
        }
        return res;
    }


}

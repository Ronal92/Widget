package com.jinwoo.android.widgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class WidgetActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    ToggleButton tgbtn;
    CheckBox cbapple;
    CheckBox cbbanana;
    CheckBox cbcherry;
    RadioGroup rg;
    Spinner spn1;

    TextView sbTv;
    SeekBar sb1;

    ArrayList<String> months = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);

        // 컴파운드 계열 버튼작성
        tgbtn = (ToggleButton)findViewById(R.id.tgbtn);
        cbapple = (CheckBox)findViewById(R.id.cbapple);
        cbbanana = (CheckBox)findViewById(R.id.cbbanana);
        cbcherry = (CheckBox)findViewById(R.id.cbcherry);


        rg = (RadioGroup)findViewById(R.id.rdgroup);




        // 리스너를 달아준다.
        tgbtn.setOnCheckedChangeListener(this);
        cbapple.setOnCheckedChangeListener(this);
        cbbanana.setOnCheckedChangeListener(this);
        cbcherry.setOnCheckedChangeListener(this);

        // Anonymous 클래스
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.rdanaconda :
                        //바깥 Widget의 상속받은
                        Toast.makeText(WidgetActivity.this, "Anaconda 라디오 버튼", Toast.LENGTH_SHORT).show();
                          break;
                    case R.id.rdbear :
                        Toast.makeText(WidgetActivity.this, "Bear 라디오 버튼", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rdcat :
                        Toast.makeText(WidgetActivity.this, "Cat 라디오 버튼", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        //3. 스피너
        spn1 = (Spinner)findViewById(R.id.spn1);

        int i,j = 0;                          // pre 스피너에 들어갈 데이터를 동적으로 정의하세요
        for(i = 0, j = 0 ; i < 100; i++){    // 데이터는 올해부터 100년전까지
            j = 2017 - i;
            months.add(j + "");
        }

        // 3.1 스피너 데이터 아답터로 생성
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, months
                //컨텍스트,            스피너에서 사용할 레이아웃,        배열데이터
        );
        // 3.2  스피너에 아답터 등록
        spn1.setAdapter(adapter);
        // 3.3
        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(WidgetActivity.this, "선택된 아이템" + months.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // 4. SeekBar
        sb1 = (SeekBar)findViewById(R.id.sb1);
        sbTv = (TextView) findViewById(R.id.sbTv);

        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
               @Override
               public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                   sbTv.setText(progress + ""); // !!중요 integer 인자를 string으로 줘라.
               }

               @Override
               public void onStartTrackingTouch(SeekBar seekBar) {

               }

               @Override
               public void onStopTrackingTouch(SeekBar seekBar) {

               }
           });

    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch(buttonView.getId()){
            case R.id.tgbtn :
                Toast.makeText(this, "토글됨="+isChecked, Toast.LENGTH_SHORT).show();
                break;
            case R.id.cbapple :
                Toast.makeText(this, "사과 체크됨"+isChecked, Toast.LENGTH_SHORT).show();
                break;
            case R.id.cbbanana :
                Toast.makeText(this, "바나나 체크됨"+isChecked, Toast.LENGTH_SHORT).show();
                break;
            case R.id.cbcherry :
                Toast.makeText(this, "체리 체크됨"+isChecked, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

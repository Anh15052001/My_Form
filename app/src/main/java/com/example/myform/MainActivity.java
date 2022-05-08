package com.example.myform;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    protected EditText edtMSSV, edtName, edtValid, edtPhone, edtEmail, edtCountry;
    RadioButton radioButton1, radioButton2;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBoxForce;
    TextView textViewDate;
    TextView showDate;
    Button btnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        textViewDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int year = 2022;
                int month = 5;
                int day = 9;
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        Log.v("TAG", i+" "+i1+" "+i2);
                        showDate.setText(i2+"/"+i1+"/"+i);
                    }
                }, year, month, day);
                dialog.show();
            }
        });
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckInformation();
            }

        });


    }
    public void CheckInformation()
    {
        String name = edtName.getText().toString();
        String mssv = edtMSSV.getText().toString();
        String cccd = edtValid.getText().toString();
        String phone = edtPhone.getText().toString();
        String email = edtEmail.getText().toString();
        //String born = showDate.getText().toString();
        if (name.length()==0)
        {
            edtName.setBackgroundResource(R.drawable.back);
        }
        if (mssv.length()==0)
        {
            edtMSSV.setBackgroundResource(R.drawable.back);

        }
        if(cccd.length()==0)
        {
            edtValid.setBackgroundResource(R.drawable.back);
        }
        if(phone.length()==0)
        {
            edtPhone.setBackgroundResource(R.drawable.back);
        }
        if (email.length()==0)
        {
            edtEmail.setBackgroundResource(R.drawable.back);
        }
        if (!radioButton1.isChecked() && !radioButton2.isChecked())
        {
            radioButton1.setBackgroundResource(R.drawable.back);
            radioButton2.setBackgroundResource(R.drawable.back);
        }
        if (!checkBoxForce.isChecked())
        {
            checkBoxForce.setBackgroundResource(R.drawable.back);
        }
        if (name.length()==0||mssv.length()==0||cccd.length()==0||phone.length()==0||email.length()==0
        ||(!radioButton1.isChecked() && !radioButton2.isChecked())||!checkBoxForce.isChecked())
        {
            Toast.makeText(this, "Bạn nhập thiếu thông tin", Toast.LENGTH_SHORT).show();
        }
        else {

            Toast.makeText(this, "Nhập dữ liệu thành công", Toast.LENGTH_LONG).show();
        }


    }
    private void Anhxa()
    {
        btnCheck = (Button)findViewById(R.id.btnCheck);
        edtMSSV = (EditText) findViewById(R.id.MSSV);
        edtName = (EditText) findViewById(R.id.name);
        edtValid = (EditText) findViewById(R.id.valid);
        edtPhone = (EditText) findViewById(R.id.phone);
        edtEmail = (EditText) findViewById(R.id.email);
        edtCountry = (EditText) findViewById(R.id.hometown);
        textViewDate = (TextView)findViewById(R.id.calendar);
        radioButton1 = (RadioButton)findViewById(R.id.rb1);
        radioButton2 = (RadioButton)findViewById(R.id.rb2);
        showDate = (TextView)findViewById(R.id.date_time);
        checkBox1 = (CheckBox) findViewById(R.id.cb1);
        checkBox2 = (CheckBox) findViewById(R.id.cb2);
        checkBox3 = (CheckBox) findViewById(R.id.cb3);
        checkBox4 = (CheckBox) findViewById(R.id.cb4);
        checkBoxForce = (CheckBox) findViewById(R.id.rbforce);
    }
}
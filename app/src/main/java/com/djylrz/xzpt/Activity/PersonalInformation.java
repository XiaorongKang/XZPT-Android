package com.djylrz.xzpt.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import com.djylrz.xzpt.R;

public class PersonalInformation extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "PersonalInformation";

    private EditText name;
    private TextView showBirthday;
    private EditText education;
    private EditText school;
    private EditText major;
    private TextView showWorkTime;
    private int birthYear;//记录选择的出生年
    private int birthMonth;//月
    private int birthDay;//日
    private int workYear;//记录工作的年
    private int workMonth;//月
    private int workDay;//日
    private String Name;
    private String Education;
    private String School;
    private String Major;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pernoal_information);
        Button birthday = (Button) findViewById(R.id.birthday_button);//生日选择
        birthday.setOnClickListener(this);

        Button worktime = (Button) findViewById(R.id.workTime_button);
        worktime.setOnClickListener(this);

        Button next = (Button)findViewById(R.id.info_next_button);//下一步按钮
        next.setOnClickListener(this);

        showBirthday = (TextView)findViewById(R.id.show_birthday);
        showWorkTime = (TextView)findViewById(R.id.show_worktime);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.birthday_button:
                //获取生日
                new DatePickerDialog(PersonalInformation.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        birthYear=year;//出生年
                        birthMonth=monthOfYear+1;//出生月
                        birthDay=dayOfMonth;//出生日
                        showBirthday.setText("您的出生日期是："+String.format("%d-%d-%d",year,monthOfYear+1,dayOfMonth));
                    }
                },1970,1,2).show();
                break;
            case R.id.workTime_button:
                //获取工作日期
                new DatePickerDialog(PersonalInformation.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        workYear=year;
                        workMonth=monthOfYear+1;
                        workDay=dayOfMonth;
                        showWorkTime.setText("您参与工作的时间是："+String.format("%d-%d-%d",year,monthOfYear+1,dayOfMonth));
                    }
                },1970,1,2).show();
                break;
            case R.id.info_next_button:
                //下一步按钮
                //点击下一步按钮之后再获取信息
                name = (EditText)findViewById(R.id.info_name);
                education = (EditText)findViewById(R.id.info_education);

                school = (EditText)findViewById(R.id.info_school);

                major = (EditText)findViewById(R.id.info_major);


                Major = major.getText().toString();//专业
                Name = name.getText().toString();//名字
                Education = education.getText().toString();//学历
                School = school.getText().toString();//学校
                Intent intent = new Intent(PersonalInformation.this, MainActivity.class);
                //传递参数
                //todo：把当前获取的所有个人信息传递到JobIntention.java—to欧文
                startActivity(intent);
                break;

            default:
                break;
        }
    }
}


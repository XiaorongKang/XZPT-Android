package com.djylrz.xzpt.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.djylrz.xzpt.R;

public class EditProjectActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText project;
    private Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_project);
        project = (EditText) findViewById(R.id.project_edittext);
        save = (Button) findViewById(R.id.save_button);
        save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save_button:
                //todo 是否保存成功验证 ->小榕

                finish();
        }
    }
}
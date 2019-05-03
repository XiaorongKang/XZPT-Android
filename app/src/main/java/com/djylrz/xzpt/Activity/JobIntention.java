package com.djylrz.xzpt.Activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.djylrz.xzpt.R;
import com.djylrz.xzpt.bean.PostResult;
import com.djylrz.xzpt.bean.TempResponseData;
import com.djylrz.xzpt.bean.User;
import com.djylrz.xzpt.utils.PostParameterName;
import com.djylrz.xzpt.utils.VolleyNetUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class JobIntention extends BaseActivity implements View.OnClickListener{

    private static final String TAG = "JobIntention";

    private EditText job;
    private EditText workCity;
    private Spinner industry;
    private EditText basicSalary;
    private EditText topSalary;
    private Spinner workTime;
    private Button save;
    private ArrayAdapter<String> workTimeAdapter;
    private ArrayAdapter<String> industryLabelAdapter;
    private String[] workTimes = new String[] {"默认","995","996","955"};
    private String[] industryLabel = new String[] {"默认", "测试|开发|运维类", "产品|需求|项目类", "运营|编辑|客服类", "市场|商务类", "销售类", "综合职能|高级管理", "金融类", "文娱|传媒|艺术|体育", "教育|培训", "商业服务|专业服务", "贸易|批发|零售|租赁业", "交通|运输|物流|仓储", "房地产|建筑|物业", "生产|加工|制造", "能源矿产|农林牧渔", "化工|生物|制药|医护", "公务员|其他"};

    private User user = new User();
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_intention);
        job = (EditText)findViewById(R.id.info_job);
        workCity = (EditText) findViewById(R.id.info_location);
        industry = (Spinner) findViewById(R.id.info_industry);
        basicSalary = (EditText) findViewById(R.id.info_basic_salary);
        topSalary = (EditText) findViewById(R.id.info_top_salary);
        workTime = (Spinner) findViewById(R.id.work_time_spinner);
        save = (Button) findViewById(R.id.info_next_button);
        save.setOnClickListener(this);

        //行业标签
        industryLabelAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,industryLabel);
        industryLabelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        industry.setAdapter(industryLabelAdapter);
        //行业标签下拉框点击事件
        industry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(JobIntention.this,"行业标签"+workTimes[position], Toast.LENGTH_SHORT).show();
                user.setIndustryLabel(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //工作时间
        workTimeAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,workTimes);
        workTimeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        workTime.setAdapter(workTimeAdapter);
        //工作时间下拉框点击事件
        workTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(JobIntention.this,"工作时间制度"+workTimes[position], Toast.LENGTH_SHORT).show();
                user.setWorkTime(position+1);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        getStudenInfo();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.info_next_button:
                //todo 保存填入的数据 ->小榕
                VolleyNetUtil.getInstance().setRequestQueue(getApplicationContext());//获取requestQueue

                //保存参数
                user.setStationLabel(job.getText().toString());//期待职业
                user.setExpectedCity(workCity.getText().toString());//工作地点
                user.setExpectSalary(basicSalary.getText().toString()+"k-"+topSalary.getText().toString()+"k");
                //发送修改求职意向请求
                Log.d(TAG, "onClick: "+PostParameterName.POST_URL_UPDATE_USER_INRO+user.getToken());
                try {
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(PostParameterName.POST_URL_UPDATE_USER_INRO+user.getToken(),new JSONObject(new Gson().toJson(user)),
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    final PostResult postResult = new Gson().fromJson(response.toString(),PostResult.class);
                                    Log.d(TAG, "onResponse: 修改个人信息"+response.toString());
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            switch(postResult.getResultCode()){
                                                case "200":{
                                                    Toast.makeText(JobIntention.this, "修改个人信息成功", Toast.LENGTH_SHORT).show();
                                                    finish();//保存成功，结束当前页面
                                                }break;
                                                default:{
                                                    Toast.makeText(JobIntention.this, "修改个人信息失败", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                            JobIntention.this.finish();
                                        }
                                    });
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("TAG", error.getMessage(), error);
                        }});
                    VolleyNetUtil.getInstance().getRequestQueue().add(jsonObjectRequest);//添加request
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }

    private void getStudenInfo(){
        //用户已经登录，查询个人信息并显示
        VolleyNetUtil.getInstance().setRequestQueue(getApplicationContext());//获取requestQueue
        SharedPreferences userToken = getSharedPreferences("token",0);
        token = userToken.getString(PostParameterName.STUDENT_TOKEN,null);
        if (token != null){
            Log.d(TAG, "onCreate: TOKEN is "+token);
            user.setToken(token);

            try {
                Log.d(TAG, "onCreate: 获取个人信息，只填了token"+new Gson().toJson(user));
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(PostParameterName.POST_URL_GET_USER_BY_TOKEN+user.getToken(),new JSONObject(new Gson().toJson(user)),
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Log.d(TAG, "onResponse: 返回"+response.toString());
                                Type jsonType = new TypeToken<TempResponseData<User>>() {}.getType();
                                final TempResponseData<User> postResult = new Gson().fromJson(response.toString(), jsonType);
                                Log.d(TAG, "onResponse: "+postResult.getResultCode());
                                user = postResult.getResultObject();
                                user.setToken(token);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        //todo:获取信息显示在编辑框上
                                        initpage(user);//初始化页面信息
                                    }
                                });
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("TAG", error.getMessage(), error);
                    }});
                VolleyNetUtil.getInstance().getRequestQueue().add(jsonObjectRequest);//添加request
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }



    //初始化界面信息
    public void initpage(User user) {
        Log.d(TAG, "onCreate: ");
        job.setText(user.getStationLabel());
        workCity.setText(user.getExpectedCity());
        industry.setSelection((int)user.getIndustryLabel());

        if (user.getExpectSalary() != null){
            // 按指定模式在字符串查找ak-bk
            String pattern = "([1-9]\\d*)(k-)([1-9]\\d*)(k)";
            // 创建 Pattern 对象
            Pattern r = Pattern.compile(pattern);
            // 现在创建 matcher 对象
            Matcher matcher = r.matcher(user.getExpectSalary());

            basicSalary.setText(matcher.group(1));
            topSalary.setText(matcher.group(3));
        }


        workTime.setSelection((int)user.getWorkTime());
    }

}



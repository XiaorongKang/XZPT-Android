package com.djylrz.xzpt.utils;

public class PostParameterName {
    public static final String HOST = "http://101.132.142.40:8080/XZPT-Java-1.0-SNAPSHOT";

    public static final String TOKEN = "token";//token，企业token，
    public static final String STUDENT_TOKEN = "student_token";//学生token
    public static final String STUDENT_USER_JSON = "student_user_json";//登录之后获取用户信息存到本地SharedPreferences的key


    public static final String POST_URL_LOGIN = HOST+"/user/login";//学生登录接口
    public static final String POST_URL_LOGIN_WITH_TOKEN = HOST + "/user/vertifytoken?token=";//学生token登录
    public static final String POST_URL_REGISTER = HOST+"/user/register?code=";//用户注册接口
    public static final String POST_URL_GETVERIFICATIONCODE = HOST+"/getverificationcode/";//获取验证码接口
    public static final String POST_URL_GET_USER_BY_TOKEN = HOST +"/user/getuserbytoken?token=";//查看用户信息
    public static final String POST_URL_UPDATE_USER_INRO = HOST + "/user/updateinfo?token=";//修改用户信息
    public static final String POST_URL_RESET_PASSWORD = HOST +"/user/resetpasswd?";//找回密码URL
    public static final String POST_URL_GET_RECOMMEND =HOST + "/user/getrecommend?token=";//学生获取推荐信息

    public static final String POST_URL_COMPANY_LOGIN = HOST + "/company/login/";//企业登录接口
    public static final String POST_URL_COMPANY_LOGIN_WITH_TOKEN = HOST + "/company/vertifytoken?token=";//企业token登录
    public static final String POST_URL_COMPANY_RELEASE_RECRUITMENT = HOST + "/company/releaserecruitment?token=";//企业token登录

    public static final String REQUEST_CODE = "code";
    public static final String REQUEST_EMAIL = "email";
    public static final String REQUEST_PASSWORD = "passwd";
    public static final String REQUEST_USERTYPE = "";


    public static final String RESPOND_RESULTCODE = "resultCode";
    public static final String RESPOND_RESULMSG = "resultMsg";
    public static final String RESPOND_RESULTOBJECT = "resultObject";

}

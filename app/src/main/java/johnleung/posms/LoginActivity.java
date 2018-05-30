package johnleung.posms;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LoginActivity extends AppCompatActivity {
    private String TAG = "ACTION";
    private Button btnLogin, btnRegister;
    private String uid, upwd, uname;
//    private ViewPager mViewPager = MainActivity.mViewPager;
    private String input_id, input_password;

    private boolean login = true;

    MainActivity main = new MainActivity();

//    onViewPagerChanged

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d(TAG,"Entered Login");

//        Intent intent = getIntent();
//        boolean noLogin = intent.getBooleanExtra("noLogin", true);

//        login = !(!(noLogin));

        SharedPreferences result = getSharedPreferences("personal", 0);
        uid = result.getString("uid", "");
        upwd = result.getString("upwd", "");
        uname = result.getString("uname", "");

        TextView loginid = findViewById(R.id.user_id);
        TextView loginpwd = findViewById(R.id.user_pwd);

        input_id = loginid.getText().toString();

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(true){
//                if(uid.equals(input_id)){
//                    setCurrentItem

//                    main.mainViewPagerOnPageChangeListener.onPageSelected(4);

//                    try {
//                        Method m = MainActivity.class.getDeclaredMethod("onViewPagerChanged", int.class);
//                        m.setAccessible(true);
//                        m.invoke(main);
//
//                    } catch (NoSuchMethodException e) {
//                        e.printStackTrace();
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                    } catch (InvocationTargetException e) {
//                        e.printStackTrace();
//                    }
                    // Login success
                    LoginActivity.super.onBackPressed();

                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(register);
            }
        });

    }



}

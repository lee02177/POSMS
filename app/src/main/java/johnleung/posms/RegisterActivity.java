package johnleung.posms;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    private static String TAG = "ACTION";
    Button reg, clear;
    TextView uid, pwd, name;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Intent intent = getIntent();

        reg = (Button) findViewById(R.id.btnRegister);
        clear = (Button) findViewById(R.id.btnClear);
        uid = (TextView) findViewById(R.id.uid);
        pwd = (TextView) findViewById(R.id.pwd);
        name = (TextView) findViewById(R.id.name);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences result = getSharedPreferences("personal",0);

                String userid = uid.getText().toString();
                String userpwd = pwd.getText().toString();
                String username = name.getText().toString();
                result.edit()
                        .putString("uid", userid)
                        .putString("upwd", userpwd)
                        .putString("uname", username)
                        .commit();
                finish();


            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uid.setText("");
                pwd.setText("");
                name.setText("");
            }
        });

    }
}

package johnleung.posms;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {
    private static String TAG = "ACTION";
    Button reg, clear;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        reg = (Button) findViewById(R.id.btnRegister);
        clear = (Button) findViewById(R.id.btnClear);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

//    public void register(View view){
//        SharedPreferences result = getSharedPreferences("personal",0);
//
//        if (result.contains("uid")){
//            if (result.contains("upwd")) {
//                AlertDialog.Builder d = new AlertDialog.Builder(MainActivity.this);
//                d.setTitle("警告!")
//                        .setMessage("已註冊")
//                        .setCancelable(false);
//                d.setPositiveButton("確定", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//                d.show();
//            }
//        }else {
//            Intent it = new Intent(MainActivity.this, Main2Activity.class);
//            startActivity(it);
//        }
//    }

}

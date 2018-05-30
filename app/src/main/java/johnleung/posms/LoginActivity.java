package johnleung.posms;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    private String TAG = "ACTION";


    Button btnLogin = (Button) findViewById(R.id.btnLogin);
//    Button btnRegister = (Button) findViewById(R.id.btnRegister);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        Log.d(TAG,"Entered Login");



    }
}

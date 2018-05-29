package johnleung.posms;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import org.w3c.dom.Text;

import johnleung.posms.R;

public class ProductDetailsActivity extends FragmentActivity {
    private Toolbar mToolBar;
    private BottomNavigationView navigation;

    private TextView tvProd_nm;
    private TextView tvProd_desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prod_detl);

        // setup Toolbar
        mToolBar = (Toolbar) findViewById(R.id.mainToolbar);

        // set up bottom navigation bar
        navigation = (BottomNavigationView) findViewById(R.id.navigation);

        Bundle bundle = getIntent().getExtras();

        tvProd_nm = (TextView) findViewById(R.id.prod_detl_prod_nm);
        tvProd_desc = (TextView) findViewById(R.id.prod_detl_prod_desc);

        tvProd_nm.setText("Product " + bundle.getString("prod_id"));
    }
}

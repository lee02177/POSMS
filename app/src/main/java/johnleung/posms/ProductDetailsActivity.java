package johnleung.posms;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.math.BigDecimal;

import johnleung.posms.R;
import johnleung.posms.Util.Utils;
import johnleung.posms.bean.OrderBean;
import johnleung.posms.bean.ProductBean;
import johnleung.posms.db.TestData;

import static johnleung.posms.Util.Utils.popAlertDialog;
import static johnleung.posms.Util.Utils.popOrderDialog;

public class ProductDetailsActivity extends FragmentActivity {
    private static final String TAG = "ProductDetailsActivity";
    private Toolbar mToolBar;
    private BottomNavigationView navigation;

    private ProductBean mProduct;

    private ImageView ivProd_image;
    private TextView tvProd_nm;
    private TextView tvProd_price;
    private TextView tvProd_desc;

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            if (item.getItemId() == R.id.navigation_order)
                popOrderDialog(ProductDetailsActivity.this, mProduct);
            if (item.getItemId() == R.id.navigation_favorite)
            {
                TestData.myFavorite.add(mProduct);
                popAlertDialog(ProductDetailsActivity.this, "Success", mProduct.getProd_nm() + " is added to favorite!");
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prod_detl);

        // setup Toolbar
        mToolBar = (Toolbar) findViewById(R.id.mainToolbar);
        mToolBar.setTitle("Details");
        // set up bottom navigation bar
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        Bundle bundle = getIntent().getExtras();
        mProduct = (ProductBean)bundle.getSerializable("product");

        ivProd_image = (ImageView)  findViewById(R.id.prod_image);
        tvProd_nm = (TextView) findViewById(R.id.prod_nm);
        tvProd_price = (TextView) findViewById(R.id.prod_price);
        tvProd_desc = (TextView) findViewById(R.id.prod_desc);

        ivProd_image.setImageResource(mProduct.getImage());
        tvProd_nm.setText(mProduct.getProd_nm());
        tvProd_price.setText("$" + mProduct.getPrice());
        tvProd_desc.setText(mProduct.getProd_desc());
    }

}

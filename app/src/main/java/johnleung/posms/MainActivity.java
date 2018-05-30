package johnleung.posms;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import johnleung.posms.adapter.MainFragmentAdapter;
import johnleung.posms.fragment.AccountFragment;
import johnleung.posms.fragment.HomeFragment;
import johnleung.posms.fragment.NotificationsFragment;
import johnleung.posms.fragment.OrderFragment;

public class MainActivity extends AppCompatActivity {

    private LoginActivity loginActivity;

    private ViewPager mViewPager;
    private HomeFragment homeFragment;
    private OrderFragment orderFragment;
    private NotificationsFragment notificationsFragment;
    private AccountFragment accountFragment;
    private MenuItem prevMenuItem;

    private static boolean isViewPageScrollable = false;
    private static boolean noLogin = true;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        public void onFragmentChanged() {
            if (noLogin) {
                Intent login = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(login);
            }
            else {
                noLogin = false;
            }
        }

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setTitle("POSMS");
                    mViewPager.setCurrentItem(0);
                    return true;
//                case R.id.navigation_dashboard:
//                    return true;
                case R.id.navigation_order:
                    setTitle("My Order");
                    mViewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    setTitle("Notification");
                    mViewPager.setCurrentItem(2);
                    return true;
                case R.id.navigation_account:
                    setTitle("Hi, User Name!");
                    mViewPager.setCurrentItem(3);

                    if(noLogin)
                        return false;
                    else {
                        noLogin = false;
                        return true;
                    }
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // setup view pager
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    navigation.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: "+position);
                navigation.getMenu().getItem(position).setChecked(true);
                prevMenuItem = navigation.getMenu().getItem(position);

//                onFragmentChanged();

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });

        setupViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager)
    {
        MainFragmentAdapter adapter = new MainFragmentAdapter(getSupportFragmentManager());
        homeFragment = new HomeFragment();
        orderFragment = new OrderFragment();
        notificationsFragment = new NotificationsFragment();
        accountFragment = new AccountFragment();
        adapter.addFragment(homeFragment);
        adapter.addFragment(orderFragment);
        adapter.addFragment(notificationsFragment);
        adapter.addFragment(accountFragment);
        viewPager.setAdapter(adapter);
//        if (!isViewPageScrollable)
//            viewPager.setOnTouchListener(null);
    }

}

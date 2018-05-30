package johnleung.posms;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import johnleung.posms.adapter.MainFragmentAdapter;
import johnleung.posms.fragment.AccountFragment;
import johnleung.posms.fragment.FavoriteFragment;
import johnleung.posms.fragment.HomeFragment;
import johnleung.posms.fragment.NotificationsFragment;
import johnleung.posms.fragment.OrderFragment;

public class MainActivity extends AppCompatActivity {

    private LoginActivity loginActivity;

    private ViewPager mViewPager;
    private Toolbar mToolBar;
    private BottomNavigationView navigation;
    /**
     * Fragment
     */
    private HomeFragment homeFragment;
    private FavoriteFragment favoriteFragment;
    private OrderFragment orderFragment;
    private NotificationsFragment notificationsFragment;
    private AccountFragment accountFragment;

    private final String[] TAB_TITLE = new String[]{
//            "POSMS","My Favorite","My Order","Notification","My Account"
            "POSMS","My Favorite","My Order","My Account"
    };
    private MenuItem prevMenuItem;

    private static boolean isViewPageScrollable = false;
    private static boolean noLogin = true;

    /**
     * page change listener for main view pager
     */
    ViewPager.OnPageChangeListener mainViewPagerOnPageChangeListener = new ViewPager.OnPageChangeListener() {
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
            onViewPagerChanged(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    /**
     * Item selected listener for bottom navigation bar
     */
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    onViewPagerChanged(0);
                    return true;
                case R.id.navigation_favorite:
                    onViewPagerChanged(1);
                    return true;
                case R.id.navigation_order:
                    onViewPagerChanged(2);
                    return true;
//                case R.id.navigation_notifications:
//                    favoriteFragment.loadFavorites();
//                    onViewPagerChanged(3);
//                    return true;
                case R.id.navigation_account:
                    if(noLogin)
                    {
                        // open login page and reject on click action
                        Intent login = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(login);
                        return false;
                    }

                    onViewPagerChanged(4);
                    noLogin = false; // TODO: save with user name
                    return true;
                default:
                    return false;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setup Toolbar
        mToolBar = (Toolbar) findViewById(R.id.mainToolbar);
        setSupportActionBar(mToolBar);

        // setup view pager
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.addOnPageChangeListener(mainViewPagerOnPageChangeListener);
        setupViewPager(mViewPager);
        
        // set up bottom navigation bar
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void setupViewPager(ViewPager viewPager)
    {
        MainFragmentAdapter adapter = new MainFragmentAdapter(getSupportFragmentManager());
        homeFragment = new HomeFragment();
        favoriteFragment = new FavoriteFragment();
        orderFragment = new OrderFragment();
//        notificationsFragment = new NotificationsFragment();
        accountFragment = new AccountFragment();
        adapter.addFragment(homeFragment);
        adapter.addFragment(favoriteFragment);
        adapter.addFragment(orderFragment);
//        adapter.addFragment(notificationsFragment);
        adapter.addFragment(accountFragment);
        viewPager.setAdapter(adapter);
    }

    private void onViewPagerChanged(int position)
    {
        mToolBar.setTitle(TAB_TITLE[position]);
        mViewPager.setCurrentItem(position);
    }

    @Override
    public void onBackPressed() {
        if (mViewPager.getCurrentItem() == 0)
        {
            homeFragment.loadCategory();
        }
    }
}

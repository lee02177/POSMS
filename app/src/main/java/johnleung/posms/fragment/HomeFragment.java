package johnleung.posms.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import johnleung.posms.ProductDetailsActivity;
import johnleung.posms.R;

public class HomeFragment extends Fragment {
    private final String TAG = "HomeFragment";
    private View mView;
    private ActionBar mActionBar;
    private Menu mMenu;
    private GridView mGridView;
    private List<Map<String, Object>> categories = new ArrayList<Map<String, Object>>();
    private String menu_mode = "CATEGORY";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView =  inflater.inflate(R.layout.fragment_home, container, false);

        // get main action bar
        mActionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();

        // Define component
        mGridView = (GridView) mView.findViewById(R.id.gv_home);

        // load category by default
        loadCategory();

        return mView;
    }

    AdapterView.OnItemClickListener onCategoryClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // load product by category id
            loadProduct(id + "");
            menu_mode = "PRODUCT";

        }
    };

    AdapterView.OnItemClickListener onProductClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(getActivity(), ProductDetailsActivity.class);
            intent.putExtra("prod_id", position + "");
            startActivity(intent);
        }
    };

    public void loadCategory()
    {
        // TODO: FunLeung - get category from database
        setupTestData("Category");

        // setup menu title to POSMS
        mActionBar.setTitle("POSMS");
        mActionBar.setDisplayHomeAsUpEnabled(false);

        SimpleAdapter adapter = new SimpleAdapter(this.getContext(),
                categories, R.layout.grid_item_home, new String[]{"image", "title"},
                new int[]{R.id.image, R.id.title});

        mGridView.setAdapter(adapter);
        mGridView.setOnItemClickListener(onCategoryClickListener);
    }

    public void loadProduct(String cate_id)
    {
        // TODO: FunLeung - get product by category id from database
        setupTestData("Product");

        // setup menu title to category name
//        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setTitle("Category " + cate_id);

        SimpleAdapter adapter = new SimpleAdapter(mView.getContext(),
                categories, R.layout.grid_item_home, new String[]{"image", "title"},
                new int[]{R.id.image, R.id.title});
        mGridView.setAdapter(adapter);
        mGridView.setOnItemClickListener(onProductClickListener);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                loadCategory();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setupTestData(String key)
    {
        categories.clear();
        for (int i=0;i<10; i++)
        {
            Map<String, Object> aCateogry = new HashMap<String, Object>();
            aCateogry.put("image", key.equals("Category") ? R.drawable.apple : R.drawable.watermelon);
            aCateogry.put("title", key + " " + i);
            categories.add(aCateogry);
        }
    }
}

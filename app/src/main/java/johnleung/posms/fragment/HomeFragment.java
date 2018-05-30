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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import johnleung.posms.ProductDetailsActivity;
import johnleung.posms.R;
import johnleung.posms.bean.CategoryBean;
import johnleung.posms.bean.ProductBean;

import static johnleung.posms.db.TestData.categories;
import static johnleung.posms.db.TestData.products;

public class HomeFragment extends Fragment {
    private final String TAG = "HomeFragment";
    private View mView;
    private ActionBar mActionBar;
    private Menu mMenu;
    private GridView mGridView;
    private ProductBean[] mProduct;

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
            loadProduct(position);
            mProduct = products[position];
        }
    };

    AdapterView.OnItemClickListener onProductClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(getActivity(), ProductDetailsActivity.class);
            intent.putExtra("product",(Serializable)mProduct[position]);
            startActivity(intent);
        }
    };

    public void loadCategory()
    {
        List<Map<String, Object>> all_cates = new ArrayList<Map<String, Object>>();
        for(CategoryBean aCategory: categories)
        {
            Map<String, Object> tmpl = new HashMap<String, Object>();
            tmpl.put("image", aCategory.getImages());
            tmpl.put("title", aCategory.getCate_nm());
            all_cates.add(tmpl);
        }

        // setup menu title to POSMS
        mActionBar.setTitle("POSMS");
        mActionBar.setDisplayHomeAsUpEnabled(false);

        SimpleAdapter adapter = new SimpleAdapter(this.getContext(),
                all_cates, R.layout.grid_item_home, new String[]{"image", "title"},
                new int[]{R.id.image, R.id.title});

        mGridView.setAdapter(adapter);
        mGridView.setOnItemClickListener(onCategoryClickListener);
    }

    public void loadProduct(int pos)
    {
        List<Map<String,Object>> all_prods = new ArrayList<Map<String,Object>>();
        for(ProductBean aProduct : products[pos])
        {
            Map<String, Object> tmpl = new HashMap<String, Object>();
            tmpl.put("image", aProduct.getImage());
            tmpl.put("title", aProduct.getProd_nm());
            tmpl.put("price", "$" + aProduct.getPrice());
            all_prods.add(tmpl);
        }
        // setup menu title to category name
//        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setTitle(categories[pos].getCate_nm());

        SimpleAdapter adapter = new SimpleAdapter(mView.getContext(),
                all_prods, R.layout.grid_item_product, new String[]{"image", "title", "price"},
                new int[]{R.id.image, R.id.title, R.id.price});
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

}

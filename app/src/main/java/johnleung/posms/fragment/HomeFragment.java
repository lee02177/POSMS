package johnleung.posms.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
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

import johnleung.posms.MainActivity;
import johnleung.posms.R;
import johnleung.posms.bean.CategoryBean;

public class HomeFragment extends Fragment {
    private View mView;
    private GridView mGridView;
    private List<Map<String, Object>> categories = new ArrayList<Map<String, Object>>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView =  inflater.inflate(R.layout.fragment_home, container, false);

        // Define component
        mGridView = (GridView) mView.findViewById(R.id.gv_home);

        // setup test data
        setupTestData("Category");

        SimpleAdapter adapter = new SimpleAdapter(this.getContext(),
                categories, R.layout.grid_item_home, new String[]{"image", "title"},
                new int[]{R.id.image, R.id.title});

        mGridView.setAdapter(adapter);
        mGridView.setOnItemClickListener(onCategoryClickListener);

        return mView;
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

    AdapterView.OnItemClickListener onCategoryClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            setupTestData("Product");
            SimpleAdapter adapter = new SimpleAdapter(mView.getContext(),
                    categories, R.layout.grid_item_home, new String[]{"image", "title"},
                    new int[]{R.id.image, R.id.title});
            mGridView.setAdapter(adapter);
            mGridView.setOnItemClickListener(onProductClickListener);
            getActivity().setTitle("Category " + position);
        }
    };

    AdapterView.OnItemClickListener onProductClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(mView.getContext(),
                    "Item clicked : " + position, Toast.LENGTH_SHORT).show();
        }
    };


}

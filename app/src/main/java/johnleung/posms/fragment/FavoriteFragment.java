package johnleung.posms.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import johnleung.posms.R;
import johnleung.posms.bean.ProductBean;
import johnleung.posms.db.TestData;

public class FavoriteFragment extends Fragment {
    private View mView;
    private ListView lv_favorite;
    private List<Map<String,Object>> mFavorites = new ArrayList<Map<String,Object>>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView =  inflater.inflate(R.layout.fragment_favorite, container, false);

        lv_favorite = mView.findViewById(R.id.lv_favorite);

        return mView;
    }

    /**
     *  Call load favorites if fragment visible
     */
    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
        if (menuVisible)
        {
            loadFavorites();
        }
    }

    public void loadFavorites()
    {
        for (ProductBean aProduct : TestData.myFavorite)
        {
            Map<String, Object> tmpl = new HashMap<String, Object>();
            tmpl.put("prod_nm", aProduct.getProd_nm());
            tmpl.put("prod_price", aProduct.getPrice());
            tmpl.put("prod_image", aProduct.getImage());
            mFavorites.add(tmpl);
        }

        SimpleAdapter adapter = new SimpleAdapter(mView.getContext(), mFavorites,
                R.layout.listviewitem_favorite, new String[]{"prod_nm","prod_price","prod_image"},
                new int[]{R.id.prod_nm, R.id.prod_price, R.id.prod_image});

        lv_favorite.setAdapter(adapter);
    }
}

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

public class NotificationsFragment extends Fragment {
    private View mView;
    private ListView lv_noti;
    private List<Map<String, Object>> notifications = new ArrayList<Map<String, Object>>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView =  inflater.inflate(R.layout.fragment_notifications, container, false);

        lv_noti = mView.findViewById(R.id.lv_noti);

        setupTestData();

        SimpleAdapter adapter = new SimpleAdapter(mView.getContext(), notifications,
                R.layout.listviewitem_notification, new String[]{"noti_header","noti_dt","noti_detl"},
                new int[]{R.id.noti_header, R.id.noti_dt, R.id.noti_detl});

        lv_noti.setAdapter(adapter);
        return mView;
    }

    private void setupTestData()
    {
        notifications.clear();
        for (int i=0; i<5; i++)
        {
            Map<String, Object> aNoti = new HashMap<String, Object>();
            aNoti.put("noti_header", "Header " + i);
            aNoti.put("noti_dt", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
            aNoti.put("noti_detl", "Here is a long long long long content.");
            notifications.add(aNoti);
        }
    }
}

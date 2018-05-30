package johnleung.posms.fragment;

import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import johnleung.posms.R;

public class LoginFragment extends Fragment {
    private static final String TAG = "ACTION";
    private View mView;

    public LoginFragment() {
//        onCreateView(getLayoutInflater(),contain);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_account, container, false);

//        title = mView.findViewById(R.id.textView);
//        title.setVisibility(View.INVISIBLE);

//        btnScanQR = (Button) mView.findViewById(R.id.btnScanQr);
//        btnScanQR.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Toast.makeText(mView.getContext(),
////                    "Button clicked ", Toast.LENGTH_SHORT).show();
//
//                try {
//                    Log.d(TAG, "Scan QR Code Button Clicked");
//
//                    Intent intent = new Intent();
//                    intent.setPackage("com.google.zxing.client.android");
//                    intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
//                    startActivityForResult(intent, 0);
//                } catch (ActivityNotFoundException anfe){
//                    Log.d(TAG, anfe.toString());
//                }
//
//            }
//        });



        return mView;

    }

}

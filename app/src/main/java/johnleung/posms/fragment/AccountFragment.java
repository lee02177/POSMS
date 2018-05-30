package johnleung.posms.fragment;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import johnleung.posms.LoginActivity;
import johnleung.posms.R;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

public class AccountFragment extends Fragment {
    private String TAG= "ACTION";   //Logcat
    private static boolean FLAG_LOGIN = true;

    private View mView;
    private Button btnScanQR;
    private TextView title;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_account, container, false);

        ////TODO: Test
//        FLAG_LOGIN = false;
//        FLAG_LOGIN = true;


        FLAG_LOGIN = false;


        title = mView.findViewById(R.id.textView);
        title.setVisibility(View.INVISIBLE);

        btnScanQR = (Button) mView.findViewById(R.id.btnScanQr);
        btnScanQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(mView.getContext(),
//                    "Button clicked ", Toast.LENGTH_SHORT).show();

            try {
                Log.d(TAG, "Scan QR Code Button Clicked");

                Intent intent = new Intent();
                intent.setPackage("com.google.zxing.client.android");
                intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intent, 0);
            } catch (ActivityNotFoundException anfe){
                Log.d(TAG, anfe.toString());
            }

            }
        });

        return mView;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String contents = intent.getStringExtra("SCAN_RESULT");
                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
                // Handle successful scan
            } else if (resultCode == RESULT_CANCELED) {
                // Handle cancel
            }
        }
    }


    /*
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                @Nullable Bundle savedInstanceState) {
            final Activity activity = getActivity();
            View root = inflater.inflate(R.layout.fragment_main, container, false);
            CodeScannerView scannerView = root.findViewById(R.id.scanner_view);
            mCodeScanner = new CodeScanner(activity, scannerView);
            mCodeScanner.setDecodeCallback(new DecodeCallback() {
                @Override
                public void onDecoded(@NonNull final Result result) {
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(activity, result.getText(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });
            scannerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mCodeScanner.startPreview();
                }
            });
            return root;
        }

        @Override
        public void onResume() {
            super.onResume();
            mCodeScanner.startPreview();
        }

        @Override
        public void onPause() {
            mCodeScanner.releaseResources();
            super.onPause();
        }
        */
}

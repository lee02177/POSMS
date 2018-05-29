package johnleung.posms.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import johnleung.posms.R;

public class AccountFragment extends Fragment {
    private View mView;
    private Button btnScanQR;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_account, container, false);
        btnScanQR = (Button) mView.findViewById(R.id.btnScanQr);
        btnScanQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mView.getContext(),
                    "Button clicked ", Toast.LENGTH_SHORT).show();
            }
        });



        return mView;

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

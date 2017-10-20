package com.xiaozi.android.qrcode.scanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xiaozi.framework.libs.BaseActivity;
import com.xiaozi.framework.libs.utils.Logger;
import com.xiaozi.framework.libs.view.QRCodeView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class MainActivity extends BaseActivity {
    private Button mGenerateQRCodeButton = null;
    private Button mScannerButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Logger.init(BuildConfig.DEBUG);
        initView();
    }

    @Override
    protected void initView() {
        super.initView();
        mGenerateQRCodeButton = findViewById(R.id.main_generate_qrcode_button);
        mScannerButton = findViewById(R.id.main_scanner_button);

        mGenerateQRCodeButton.setOnClickListener(mOnClickListener);
        mScannerButton.setOnClickListener(mOnClickListener);
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = null;

            switch (v.getId()) {
                case R.id.main_generate_qrcode_button:
                    intent = new Intent(mActivity, GenerateQRCodeActivity.class);
                    startActivity(intent);
                    break;
                case R.id.main_scanner_button:
                    intent = new Intent(mActivity, ScannerActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}

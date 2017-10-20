package com.xiaozi.android.qrcode.scanner;

import android.os.Bundle;
import android.widget.TextView;

import com.xiaozi.framework.libs.BaseActivity;

/**
 * Created by user on 2017-10-20.
 */

public class ScanResultActivity extends BaseActivity {
    private TextView mResultTextView = null;

    private String mResultString = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_result);

        mResultString = getIntent().getStringExtra("scan_result");
        initView();
    }

    @Override
    protected void initView() {
        super.initView();
        mResultTextView = findViewById(R.id.scan_result_text_view);

        mResultTextView.setText(mResultString);
    }
}

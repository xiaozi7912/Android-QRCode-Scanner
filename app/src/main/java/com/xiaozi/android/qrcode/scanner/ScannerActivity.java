package com.xiaozi.android.qrcode.scanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.google.zxing.Result;
import com.xiaozi.android.qrcode.scanner.utils.Compressor;
import com.xiaozi.framework.libs.BaseActivity;
import com.xiaozi.framework.libs.utils.Logger;

import java.io.IOException;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by user on 2017-10-20.
 */

public class ScannerActivity extends BaseActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    protected void initView() {
        super.initView();
        mScannerView = findViewById(R.id.scanner_preview_view);

        mScannerView.setAutoFocus(true);
    }

    @Override
    public void handleResult(Result result) {
        Logger.i(LOG_TAG, "handleResult");
        Logger.d(LOG_TAG, "handleResult result.getText : " + result.getText());
        String uncompressedString = null;
        try {
            uncompressedString = Compressor.uncompress(result.getText());
            Logger.d(LOG_TAG, "handleResult uncompressedString : " + uncompressedString);
            Intent intent = new Intent(mActivity, ScanResultActivity.class);
            intent.putExtra("scan_result", uncompressedString);
            startActivity(intent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mScannerView.resumeCameraPreview(this);
    }
}

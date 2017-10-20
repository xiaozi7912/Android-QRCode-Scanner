package com.xiaozi.android.qrcode.scanner;

import android.os.Bundle;

import com.xiaozi.android.qrcode.scanner.utils.Compressor;
import com.xiaozi.framework.libs.BaseActivity;
import com.xiaozi.framework.libs.utils.Logger;
import com.xiaozi.framework.libs.view.QRCodeView;

import java.io.IOException;

/**
 * Created by user on 2017-10-20.
 */

public class GenerateQRCodeActivity extends BaseActivity {
    private QRCodeView mQRCodeView = null;


    private final static String CHARSET_NAME = "UTF-8";
    private final static String QRCODE_CONTENT = "{\"type\":\"report\",\"basic\":{\"lab_name\":\"健康力醫事檢驗所\",\"report_date\":\"106/08/09\",\"send_unit\":\"姚醫師診所\"},\"report\":[{\"name\":\"生化檢查\",\"data\":[{\"name\":\"血糖檢查\",\"data\":[{\"name\":\"飯前血糖檢查\",\"data\":\"76\",\"min\":\"70\",\"max\":\"100\",\"unit\":\"mg/dL\"}]},{\"name\":\"腎功能檢查\",\"data\":[{\"name\":\"尿素氮\",\"data\":\"13\",\"min\":\"7\",\"max\":\"20\",\"unit\":\"mg/dL\"},{\"name\":\"肌酸酐(Cr)\",\"data\":\"0.93\",\"min\":\"0.44\",\"max\":\"1.27\",\"unit\":\"mg/dL\"},{\"name\":\"尿酸\",\"data\":\"6.8\",\"min\":\"2.6\",\"max\":\"7.2\",\"unit\":\"mg/dL\"},{\"name\":\"腎絲球過濾率eGFR\",\"data\":\"99.00\",\"min\":\"60\",\"max\":\"\",\"unit\":\"mL/min/1.73m2\"}]},{\"name\":\"肝膽功能檢查\",\"data\":[{\"name\":\"草酸轉胺基?(GOT)\",\"data\":\"13\",\"min\":\"0\",\"max\":\"41\",\"unit\":\"U/L\"},{\"name\":\"丙酮轉氨基?(GPT)\",\"data\":\"13\",\"min\":\"0\",\"max\":\"40\",\"unit\":\"U/L\"},{\"name\":\"胺酸轉移?素(GGT)\",\"data\":\"11\",\"min\":\"7\",\"max\":\"50\",\"unit\":\"U/L\"},{\"name\":\"鹼性磷酸?\",\"data\":\"54\",\"min\":\"38\",\"max\":\"126\",\"unit\":\"U/L\"},{\"name\":\"總蛋白\",\"data\":\"7.4\",\"min\":\"6.4\",\"max\":\"8.2\",\"unit\":\"g/dL\"},{\"name\":\"白蛋白\",\"data\":\"4.9\",\"min\":\"3.4\",\"max\":\"5\",\"unit\":\"g/dL\"},{\"name\":\"球蛋白\",\"data\":\"2.5\",\"min\":\"2.5\",\"max\":\"3.6\",\"unit\":\"g/dL\"},{\"name\":\"總膽紅素\",\"data\":\"1.0\",\"min\":\"0.3\",\"max\":\"1.2\",\"unit\":\"mg/dL\"},{\"name\":\"直接膽紅素\",\"data\":\"0.21\",\"min\":\"0.1\",\"max\":\"0.5\",\"unit\":\"mg/dL\"}]},{\"name\":\"血脂肪檢查\",\"data\":[{\"name\":\"三酸甘油脂\",\"data\":\"58\",\"min\":\"0\",\"max\":\"150\",\"unit\":\"mg/dL\"},{\"name\":\"總膽固醇\",\"data\":\"157\",\"min\":\"0\",\"max\":\"200\",\"unit\":\"mg/dL\"},{\"name\":\"高密度脂蛋白膽固醇\",\"data\":\"56\",\"min\":\"40\",\"max\":\"\",\"unit\":\"mg/dL\"},{\"name\":\"低密度脂蛋白膽固醇\",\"data\":\"90\",\"min\":\"\",\"max\":\"130\",\"unit\":\"mg/dL\"}]}]}]}";
    private final static String TEST_STRING = "測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_qrcode);

        initView();
    }

    @Override
    protected void initView() {
        super.initView();
        mQRCodeView = findViewById(R.id.main_qrcodeview);

        String compressedString = null;
        String uncompressedString = null;

        try {
            compressedString = Compressor.compress(QRCODE_CONTENT);
            Logger.d(LOG_TAG, "initView QRCODE_CONTENT.length : " + QRCODE_CONTENT.length());
            Logger.d(LOG_TAG, "initView compressedString.length : " + compressedString.length());
            mQRCodeView.setContent(compressedString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            uncompressedString = Compressor.uncompress(compressedString);
            Logger.d(LOG_TAG, "initView uncompressedString : " + uncompressedString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

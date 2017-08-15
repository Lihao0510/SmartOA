package com.oridway.oridwayoa.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.zxing.Result;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.URIParsedResult;
import com.mylhyl.zxing.scanner.OnScannerCompletionListener;
import com.mylhyl.zxing.scanner.ScannerView;
import com.oridway.oridcore.utils.LogUtil;
import com.oridway.oridcore.utils.ToastUtil;
import com.oridway.oridwayoa.R;

import butterknife.BindView;

public class ScanActivity extends BaseActivity {

    @BindView(R.id.sv_scanner)
    ScannerView scannerView;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, ScanActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int setLayoutRes() {
        return R.layout.activity_scan;
    }

    @Override
    protected void initActivity() {
        scannerView.setDrawText("请扫描签到用二维码进行打卡\n只有外业人员可以有效打卡", true, 20);
        scannerView.setOnScannerCompletionListener(new OnScannerCompletionListener() {
            @Override
            public void OnScannerCompletion(Result rawResult, ParsedResult parsedResult, Bitmap barcode) {
                switch (parsedResult.getType()) {
                    case ADDRESSBOOK:
                        break;
                    case URI:
                        LogUtil.debugLog(((URIParsedResult) parsedResult).getURI());
                        break;
                    case TEXT:
                        LogUtil.debugLog(rawResult.getText());
                        break;
                }
                ToastUtil.showToast("无效的二维码!");
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        scannerView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        scannerView.onResume();
    }
}

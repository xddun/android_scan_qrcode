package com.example.gen_qr_code;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import android.content.Intent;
import android.widget.Button;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {
    private Button scanButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scanButton = findViewById(R.id.scanButton);
        scanButton.setOnClickListener(v -> {

            // 打开摄像头并显示预览
            IntentIntegrator integrator = new IntentIntegrator(MainActivity.this);
            integrator.setBeepEnabled(true);
            integrator.setCameraId(0); // 选择摄像头，0为后置摄像头，1为前置摄像头
            integrator.setOrientationLocked(false); // 是否锁定屏幕方向
            integrator.initiateScan();

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // 处理扫描结果
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            String contents = result.getContents();
            if (contents != null && !contents.isEmpty()) {
                // 扫描成功，可以根据需要进行处理
                Intent intent = new Intent(this, ScanResultActivity.class);
                intent.putExtra("scan_result", contents);
                startActivity(intent);
            }
        }
    }

}

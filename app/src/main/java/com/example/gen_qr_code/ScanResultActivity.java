package com.example.gen_qr_code;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScanResultActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_result);


        TextView resultTextView = findViewById(R.id.resultTextView);
        String scanResult = getIntent().getStringExtra("scan_result");
        resultTextView.setText(scanResult);

        TextView result_title = findViewById(R.id.result_title);
        result_title.setText("扫描结果：");
    }
}

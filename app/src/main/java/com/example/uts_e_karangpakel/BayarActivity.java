package com.example.uts_e_karangpakel;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BayarActivity extends AppCompatActivity {
    TextView ttlpemb, kmbl;
    EditText byr;
    private String total;
    private String KEY_TOTAL = "TOTAL";
    int all, ibyr, selisih;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayar);
        ttlpemb = findViewById(R.id.total);
        kmbl = findViewById(R.id.kembali);
        byr = findViewById(R.id.bayar);

        Bundle extras = getIntent().getExtras();
        total = extras.getString(KEY_TOTAL);
        ttlpemb.setText(total);
        byr.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    sisa();
                    kmbl.setText(Integer.toString(selisih));
                    return false;
                }
                return false;
            }
        });
    }

    public double sisa () {
        all = Integer.parseInt(total);
        ibyr = Integer.parseInt((byr.getText().toString()));
        selisih = ibyr - all;
        return selisih;
    }

}

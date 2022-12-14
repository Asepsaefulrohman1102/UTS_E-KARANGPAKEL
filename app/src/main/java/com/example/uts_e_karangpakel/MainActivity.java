package com.example.uts_e_karangpakel;

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    CardView card1,card2,card3,card4,card5,card6;


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.wa:
                Uri uri = Uri.parse("smsto:" + "085640748658");
                Intent sendIntent = new Intent(Intent.ACTION_SENDTO, uri);
                sendIntent.setPackage("com.whatsapp");
                startActivity(sendIntent);
                return true;
            case R.id.sms:
                String sms = "tel:085640748658";
                startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse(sms)));
                return true;
            case R.id.loc:
                Intent mapIntent = (new Intent(Intent.ACTION_VIEW, Uri.parse("geo:DroidCafe")));
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
                return true;
            case R.id.update:
                startActivity(new Intent(getBaseContext(), com.example.uts_e_karangpakel.UpdateActivity.class));
                return true;
            case R.id.logout:
                //Menghapus Status login dan kembali ke Login Activity
                com.example.uts_e_karangpakel.Preferences.clearLoggedInUser(getBaseContext());
                startActivity(new Intent(getBaseContext(), com.example.uts_e_karangpakel.LoginActivity.class));
                finish();
                return true;
        }return false;
    }

    TextView gbr1number, gbr2number, gbr3number, gbr4number, gbr5number, gbr6number;
    TextView pkt1, pkt2, pkt3, pkt4, pkt5, pkt6, ttl;
    int number1, number2, number3, number4, number5, number6;
    int result1, result2, result3, result4, result5, result6;
    int total;
    Button btn1, btn2, btn3, btn4, btn5, btn6;
    private String KEY_TOTAl = "TOTAL";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gbr1number = findViewById(R.id.counter1);
        btn1 = findViewById(R.id.reduce1);
        pkt1 = findViewById(R.id.paketan1);
        gbr2number = findViewById(R.id.counter2);
        btn2 = findViewById(R.id.reduce2);
        pkt2 = findViewById(R.id.paketan2);
        gbr3number = findViewById(R.id.counter3);
        btn3 = findViewById(R.id.reduce3);
        pkt3 = findViewById(R.id.paketan3);
        gbr4number = findViewById(R.id.counter4);
        btn4 = findViewById(R.id.reduce4);
        pkt4 = findViewById(R.id.paketan4);
        gbr5number = findViewById(R.id.counter5);
        btn5 = findViewById(R.id.reduce5);
        pkt5 = findViewById(R.id.paketan5);
        gbr6number = findViewById(R.id.counter6);
        btn6 = findViewById(R.id.reduce6);
        pkt6 = findViewById(R.id.paketan6);
        ttl = findViewById(R.id.all);

        //menampilkan detail paket dengan cardview
        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);
        card5 = findViewById(R.id.card5);
        card6 = findViewById(R.id.card6);

        // card1.setOnClickListener(new View.OnClickListener() {
        //     @Override
        //     public void onClick(View v) {
        //         Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        //         intent.putExtra("paket", "Paket 1");
        //         intent.putExtra("harga", "Rp. 10.000");
        //         intent.putExtra("detail", "Paket 1 adalah paket yang berisi 1 buah kopi dengan 1 buah es krim");
        //         startActivity(intent);
        //     }
        // });

        // card2.setOnClickListener(new View.OnClickListener() {
        //     @Override
        //     public void onClick(View v) {
        //         Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        //         intent.putExtra("paket", "Paket 2");
        //         intent.putExtra("harga", "Rp. 15.000");
        //         intent.putExtra("detail", "Paket 2 adalah paket yang berisi 1 buah kopi dengan 2 buah es krim");
        //         startActivity(intent);
        //     }
        // });

        // card3.setOnClickListener(new View.OnClickListener() {
        //     @Override
        //     public void onClick(View v) {
        //         Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        //         intent.putExtra("paket", "Paket 3");
        //         intent.putExtra("harga", "Rp. 20.000");
        //         intent.putExtra("detail", "Paket 3 adalah paket yang berisi 1 buah kopi dengan 3 buah es krim");
        //         startActivity(intent);
        //     }
        // });

        // card4.setOnClickListener(new View.OnClickListener() {
        //     @Override
        //     public void onClick(View v) {
        //         Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        //         intent.putExtra("paket", "Paket 4");
        //         intent.putExtra("harga", "Rp. 25.000");
        //         intent.putExtra("detail", "Paket 4 adalah paket yang berisi 1 buah kopi dengan 4 buah es krim");
        //         startActivity(intent);
        //     }
        // });

        // card5.setOnClickListener(new View.OnClickListener() {
        //     @Override
        //     public void onClick(View v) {
        //         Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        //         intent.putExtra("paket", "Paket 5");
        //         intent.putExtra("harga", "Rp. 30.000");
        //         intent.putExtra("detail", "Paket 5 adalah paket yang berisi 1 buah kopi dengan 5 buah es krim");
        //         startActivity(intent);
        //     }
        // });

        // card6.setOnClickListener(new View.OnClickListener() {
        //     @Override
        //     public void onClick(View v) {
        //         Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        //         intent.putExtra("paket", "Paket 6");
        //         intent.putExtra("harga", "Rp. 35.000");
        //         intent.putExtra("detail", "Paket 6 adalah paket yang berisi 1 buah kopi dengan 6 buah es krim");
        //         startActivity(intent);
        //     }
        // });

        //menuju ke halaman paket1, paket2, dst
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.uts_e_karangpakel.paket1.class);
                startActivity(intent);
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.uts_e_karangpakel.paket2.class);
                startActivity(intent);
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.uts_e_karangpakel.paket3.class);
                startActivity(intent);
            }
        });

        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.uts_e_karangpakel.paket4.class);
                startActivity(intent);
            }
        });

        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.uts_e_karangpakel.paket5.class);
                startActivity(intent);
            }
        });

        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.uts_e_karangpakel.paket6.class);
                startActivity(intent);
            }
        });



        
        


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private String formatRupiah(Double number) {
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format(number);
    }

    public void count1(View view) {
        number1 = number1 + 1;
        gbr1number.setText(Integer.toString(number1));
        result1 = number1 * 150000;
        pkt1.setText(Integer.toString(result1));
        Total();
        ttl.setText(Integer.toString(total));

    }

    public void reduce1(View view) {
        if (number1 == 0) {
            Toast.makeText(getApplicationContext(), "data kosong", Toast.LENGTH_SHORT).show();
        }else{
            number1 = number1 - 1;
        }
        gbr1number.setText(Integer.toString(number1));
        result1 = number1 * 150000;
        pkt1.setText(Integer.toString(result1));
        Total();
        ttl.setText(Integer.toString(total));
    }

    public void count2(View view) {
        number2 = number2 + 1;
        gbr2number.setText(Integer.toString(number2));
        result2 = number2 * 300000;
        pkt2.setText(Integer.toString(result2));
        Total();
        ttl.setText(Integer.toString(total));

    }

    public void reduce2(View view) {
        if (number2 == 0) {
            Toast.makeText(getApplicationContext(), "data kosong", Toast.LENGTH_SHORT).show();
        }else{
            number2 = number2 - 1;
        }
        gbr2number.setText(Integer.toString(number2));
        result2 = number2 * 300000;
        pkt2.setText(Integer.toString(result2));
        Total();
        ttl.setText(Integer.toString(total));

    }

    public void count3(View view) {
        number3 = number3 + 1;
        gbr3number.setText(Integer.toString(number3));
        result3 = number3 * 160000;
        pkt3.setText(Integer.toString(result3));
        Total();
        ttl.setText(Integer.toString(total));

    }

    public void reduce3(View view) {
        if (number3 == 0) {
            Toast.makeText(getApplicationContext(), "data kosong", Toast.LENGTH_SHORT).show();
        }else{
            number3 = number3 - 1;
        }
        gbr2number.setText(Integer.toString(number3));
        result3 = number3 * 160000;
        pkt3.setText(Integer.toString(result3));
        Total();
        ttl.setText(Integer.toString(total));

    }

    public void count4(View view) {
        number4 = number4 + 1;
        gbr4number.setText(Integer.toString(number4));
        result4 = number4 * 50000;
        pkt4.setText(Integer.toString(result4));
        Total();
        ttl.setText(Integer.toString(total));

    }

    public void reduce4(View view) {
        if (number4 == 0) {
            Toast.makeText(getApplicationContext(), "data kosong", Toast.LENGTH_SHORT).show();
        }else{
            number4 = number4 - 1;
        }
        gbr4number.setText(Integer.toString(number4));
        result4 = number4 * 50000;
        pkt4.setText(Integer.toString(result4));
        Total();
        ttl.setText(Integer.toString(total));

    }

    public void count5(View view) {
        number5 = number5 + 1;
        gbr5number.setText(Integer.toString(number5));
        result5 = number5 * 80000;
        pkt5.setText(Integer.toString(result5));
        Total();
        ttl.setText(Integer.toString(total));

    }

    public void reduce5(View view) {
        if (number5 == 0) {
            Toast.makeText(getApplicationContext(), "data kosong", Toast.LENGTH_SHORT).show();
        }else{
            number5 = number5 - 1;
        }
        gbr5number.setText(Integer.toString(number5));
        result5 = number5 * 80000;
        pkt5.setText(Integer.toString(result5));
        Total();
        ttl.setText(Integer.toString(total));

    }

    public void count6(View view) {
        number6 = number6 + 1;
        gbr6number.setText(Integer.toString(number6));
        result6 = number6 * 200000;
        pkt6.setText(Integer.toString(result6));
        Total();
        ttl.setText(Integer.toString(total));

    }

    public void reduce6(View view) {
        if (number6 == 0) {
            Toast.makeText(getApplicationContext(), "data kosong", Toast.LENGTH_SHORT).show();
        }else{
            number6 = number6 - 1;
        }
        gbr6number.setText(Integer.toString(number6));
        result6 = number6 * 200000;
        pkt6.setText(Integer.toString(result6));
        Total();
        ttl.setText(Integer.toString(total));

    }

    public int Total  () {
        total = 0;
        total = result1 + result2 + result3 + result4 + result5 + result6;
        return total;
    }

    public void klik (View v) {
        String ttlpemb = ttl.getText().toString();
        Intent i = new Intent(MainActivity.this, com.example.uts_e_karangpakel.BayarActivity.class);
        i.putExtra(KEY_TOTAl,ttlpemb);
        startActivity(i);
    }

}


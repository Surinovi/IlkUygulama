package com.ab2016.neval.ilkuygulama;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Spinner spin1;
    private ImageView img1;
    private double[] priceArray = {5.5,4.75,2};
    private double secilen=5.5;
    private SeekBar seek1;
    private TextView tv1;
    private int adet=3;
    private String odemeSekli ="Nakit";
    private double toplam =0;
    private boolean fatura = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        img1 = (ImageView) findViewById(R.id.img1);

        spin1 = (Spinner) findViewById(R.id.spin1);
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        img1.setImageResource(R.drawable.hamburger);
                        break;
                    case 1:
                        img1.setImageResource(R.drawable.patates);
                        break;
                    case 2:
                        img1.setImageResource(R.drawable.cola);
                        break;

                }
                secilen = priceArray[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        tv1 = (TextView) findViewById(R.id.tv_seek);

        seek1 = (SeekBar) findViewById(R.id.seek1);
        seek1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                tv1.setText("Adet Secin("+(progress+1)+"):");
                adet = progress+1;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn1:
                toplam+=adet*secilen;
                break;
            case R.id.btn2:
                seek1.setProgress(2);
                spin1.setSelection(0);
                break;
            case R.id.btn3:
                if(fatura)
                    Toast.makeText(this,"Fatura:\nOdeme Sekli: "+odemeSekli+"\nToplam: "+toplam+"",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(this,"Odeme Sekli: "+odemeSekli+"\nToplam: "+toplam+"",Toast.LENGTH_LONG).show();
                break;
            case R.id.radioButton1:
                odemeSekli="Nakit";
                break;
            case R.id.radioButton2:
                odemeSekli="POS";
                break;
            case R.id.chk:
                fatura=!fatura;
                break;
        }
    }

    private void displayToast(String msg) {

        Toast toast = Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT);
        // Appears in the center
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);

        // Appears in the top-left corner
        // toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
        toast.show();

        // To use Toast in one go
        // Appear in the center bottom by default
        // Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
    }

    private void makeAndShowDialogBox(String message) {

        AlertDialog.Builder myDialogBox = new AlertDialog.Builder(this);

        // set message, title, and icon
        myDialogBox.setTitle("Fatura");
        myDialogBox.setMessage(message);
        myDialogBox.setIcon(R.drawable.yemeksepeti);

        // Set three option buttons
        myDialogBox.setPositiveButton("Kapat",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // whatever should be done when answering "YES" goes
                        // here

                    }
                });

        myDialogBox.create();
        myDialogBox.show();
    }




}

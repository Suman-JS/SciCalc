package com.rocky.scicalc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //    private Button btnClear;
    private EditText editText;
    private float res1;
    private boolean Add,Sub,Mul,Div,Mod;

    private void StorePrev()
    {
        try {
            res1 = Float.parseFloat( editText.getText () + "");
        }
       catch (Exception e)
       {
           Toast.makeText (MainActivity.this, "Please Enter a Value First", Toast.LENGTH_SHORT).show ();
       }
    }
    private void SetFalse()
    {
        Add = Sub = Div = Mul = Mod  = false;
    }
    private void Reset()
    {
        this.res1 = 0;
        editText.setText (null);
        SetFalse();
    }
    @Override
    public void onBackPressed () {
        AlertDialog.Builder builder = new AlertDialog.Builder (this);
        builder.setMessage ("Are You Sure?").setCancelable (false).setPositiveButton ("Yes", (dialog, i) -> {
            MainActivity.super.onBackPressed ();
            MainActivity.this.finish ();
            System.exit (0);
        })
                .setNegativeButton ("No", (dialogInterface, i) -> dialogInterface.cancel());
        AlertDialog alertDialog = builder.create ();
        alertDialog.show ();
    }

    @SuppressLint ({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        Button btn0 = findViewById (R.id.btn0);
        Button btn1 = findViewById (R.id.btn1);
        Button btn2 = findViewById (R.id.btn2);
        Button btn3 = findViewById (R.id.btn3);
        Button btn4 = findViewById (R.id.btn4);
        Button btn5 = findViewById (R.id.btn5);
        Button btn6 = findViewById (R.id.btn6);
        Button btn7 = findViewById (R.id.btn7);
        Button btn8 = findViewById (R.id.btn8);
        Button btn9 = findViewById (R.id.btn9);
        Button btnAdd = findViewById (R.id.btnAdd);
        Button btnSub = findViewById (R.id.btnSub);
        Button btnMul = findViewById (R.id.btnMul);
        Button btnDiv = findViewById (R.id.btnDiv);
        Button btnPoint = findViewById (R.id.btnpoint);
        Button btnAdv = findViewById (R.id.btnAdv);
        Button btnmod = findViewById (R.id.btnmod);
        Button btnClear = findViewById (R.id.btnClear);
        Button btnReset = findViewById (R.id.btnReset);
        Button btnresult = findViewById (R.id.btnresult);
        editText = findViewById (R.id.editText);


        btn1.setOnClickListener (v -> editText.setText (editText.getText ()+ "1"));
        btn2.setOnClickListener (v -> editText.setText (editText.getText ()+ "2"));
        btn3.setOnClickListener (v -> editText.setText (editText.getText ()+ "3"));
        btn4.setOnClickListener (v -> editText.setText (editText.getText ()+ "4"));
        btn5.setOnClickListener (v -> editText.setText (editText.getText ()+ "5"));
        btn6.setOnClickListener (v -> editText.setText (editText.getText ()+ "6"));
        btn7.setOnClickListener (v -> editText.setText (editText.getText ()+ "7"));
        btn8.setOnClickListener (v -> editText.setText (editText.getText ()+ "8"));
        btn9.setOnClickListener (v -> editText.setText (editText.getText ()+ "9"));
        btn0.setOnClickListener (v -> editText.setText (editText.getText ()+ "0"));
        btnPoint.setOnClickListener (v -> editText.setText (editText.getText ()+ "."));



        btnAdd.setOnClickListener (v -> {
            if (editText == null)
            {
                assert false;
                editText.setText ("");
            }
            else
            {
                StorePrev ();
                SetFalse ();
                Add = true;
                editText.setText (null);
            }
        });
        btnSub.setOnClickListener (v -> {
            if (editText == null)
            {
                assert false;
                editText.setText ("");
            }
            else
            {
                StorePrev ();
                SetFalse ();
                Sub = true;
                editText.setText (null);
            }
        });
        btnMul.setOnClickListener (v -> {
            if (editText == null)
            {
                assert false;
                editText.setText ("");
            }
            else
            {
                StorePrev ();
                SetFalse ();
                Mul = true;
                editText.setText (null);
            }
        });
        btnDiv.setOnClickListener (v -> {
            if (editText == null)
            {
                assert false;
                editText.setText ("");
            }
            else
            {
                StorePrev ();
                SetFalse ();
                Div = true;
                editText.setText (null);
            }
        });
        btnmod.setOnClickListener (v -> {
            if (editText == null)
            {
                assert false;
                editText.setText ("");
            }
            else
            {
                StorePrev ();
                SetFalse ();
                Mod = true;
                editText.setText (null);
            }
        });
        btnresult.setOnClickListener (v -> {
            if (Add)
            {
                editText.setText ( res1 + Float.parseFloat (editText.getText () + "") + "");
            }
            if (Sub)
            {
                editText.setText ( res1 - Float.parseFloat (editText.getText () + "") + "");
            }
            if (Mul)
            {
                editText.setText ( res1 * Float.parseFloat (editText.getText () + "") + "");
            }
            if (Div)
            {
                editText.setText ( res1 / Float.parseFloat (editText.getText () + "") + "");
            }
            if (Mod)
            {
                editText.setText ( res1 % Float.parseFloat (editText.getText () + "") + "");
            }
        });

        btnReset.setOnClickListener (v -> Reset ());
    }
}
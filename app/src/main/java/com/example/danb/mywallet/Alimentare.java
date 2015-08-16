package com.example.danb.mywallet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Dan B on 8/13/2015.
 */

public class Alimentare extends Activity {

    Button add;
    Button bac;
    EditText textSO;
    TextView t;
    double so;
    double venit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alim);
        add = (Button) findViewById(R.id.add);
        textSO=(EditText)findViewById(R.id.editText);
        Intent inti = getIntent();
        venit = inti.getExtras().getDouble("sumaa", 0.00);


        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                so = Double.parseDouble(textSO.getText().toString());
                venit = venit + so;
                t = (TextView) findViewById(R.id.t);
                String s = Double.toString(venit);
                t.setText(s);

            }
        });


        bac= (Button)findViewById(R.id.bac);
        bac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("blablabla");
                Intent intent = new Intent(Alimentare.this, MainActivity.class);
                intent.putExtra("suma",venit);
                System.out.println(venit);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });


    }


    public void onRestart ()
    {
        super.onRestart();
        finish();
    }

}


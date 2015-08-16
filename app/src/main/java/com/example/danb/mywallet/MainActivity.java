package com.example.danb.mywallet;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends Activity {

    Button alimentare;
    Button adaug;
    Button lis;
    TextView te;
    double a;
    private static final int REQUEST_CODE = 1;
    private Bitmap bitmap;
    private ImageView imageView;
    double venit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.res);
        alimentare = (Button)findViewById(R.id.alimentare);


        alimentare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent inti = new Intent(MainActivity.this, Alimentare.class);
                inti.putExtra("sumaa",venit);
                startActivityForResult(inti, 100);
            }
        });
        adaug = (Button)findViewById(R.id.adaug);
        lis= (Button)findViewById(R.id.li);
        lis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, chiarLista.class);
                startActivity(i);
            }
        });

        pickImage(adaug);
        te = (TextView) findViewById(R.id.te);
        String x = Double.toString(a);
        te.setText(x);




    }
    public void pickImage(View v) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, REQUEST_CODE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        System.out.print(requestCode);
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK)
            try {
                // We need to recyle unused bitmaps
                if (bitmap != null) {
                    bitmap.recycle();
                }
                InputStream stream = getContentResolver().openInputStream(
                        data.getData());
                bitmap = BitmapFactory.decodeStream(stream);
                stream.close();
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            else if(requestCode==100){
            System.out.println("aaaaa");
            //Intent inte = getIntent();
            a = data.getDoubleExtra("suma",0.00);}



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



}

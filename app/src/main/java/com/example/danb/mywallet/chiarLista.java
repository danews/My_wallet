package com.example.danb.mywallet;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dan B on 8/14/2015.
 */
public class chiarLista extends ListActivity {
    private TextView casetaSelectata;
    private Button butonAdauga;
    private EditText casetaNoua;
    private List<String> cumparaturi;
    ArrayAdapter<String> cumparaturiAdapter;
    @Override
    public void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainii);
        butonAdauga=(Button)findViewById(R.id.butonAd);
        casetaSelectata=(TextView)findViewById(R.id.casetaSelectata);
        casetaNoua=(EditText)findViewById(R.id.casetaNoua);
        butonAdauga.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                cumparaturi.add(casetaNoua.getText().toString());
                casetaNoua.setText("");
                cumparaturiAdapter.notifyDataSetChanged();
            }


        });
    cumparaturi = new ArrayList<String>();
    cumparaturiAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cumparaturi);
    setListAdapter(cumparaturiAdapter);
}
    @Override
    public void onListItemClick(ListView list, View v, int position, long id)
    {
        casetaSelectata.setText(cumparaturi.get(position));
    }

    public void onRestart ()
    {
        super.onRestart();
        finish();
    }
}




package com.example.danb.mywallet;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dan B on 8/14/2015.
 */
public class cumparaturiAdapter extends BaseAdapter {

    private ListActivity context;
    private ArrayList<Cumparatura> cumparaturi;


    public  cumparaturiAdapter(ListActivity context) {
        this.context= context;
        cumparaturi= new ArrayList<Cumparatura>();
    }

    public void adaugaCumparatura (String nume)
    {
        Cumparatura c= new Cumparatura();
        c.nume = nume;
        cumparaturi.add(c);
        this.notifyDataSetChanged();
    }


    @Override
    public View getView (int position, View convertView, ViewGroup list)
    {
        View element;

        LayoutInflater inflater = context.getLayoutInflater();
        element=(View)inflater.inflate(R.layout.mainiii,null);

        TextView nume = (TextView)element.findViewById(R.id.element_nume);
        CheckBox cb = (CheckBox)element.findViewById(R.id.element_cb);

        nume.setText(cumparaturi.get(position).nume);

        return element;



    }
    public  int getCount(){
        return  cumparaturi.size();
    }
    @Override
    public Object getItem (int position){
        return cumparaturi.get(position);
    }
    @Override
    public long getItemId(int position)
    {
        return 0;
    }

}

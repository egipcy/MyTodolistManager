package com.example.egipcy.mytodolistmanager;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class MyListAdapter extends BaseAdapter
{
    private Context c;
    private ArrayList<Task> al;

    MyListAdapter(Context context, ArrayList<Task> cia)
    {
        c = context;
        al = cia;
    }

    @Override
    public View getView(int position, View convert_view, ViewGroup parent)
    {
        LayoutInflater inflator = (LayoutInflater)
                c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflator.inflate(R.layout.list, null);
        TextView tv_task = (TextView) row.findViewById(R.id.tv_task);
        CheckBox cb_task = (CheckBox) row.findViewById(R.id.cb_task);
        tv_task.setText(al.get(position).getName());
        cb_task.setChecked(al.get(position).isChecked());
        cb_task.setTag(position);
        return row;
    }

    @Override
    public int getCount() { return al.size(); }
    @Override
    public Object getItem(int position) { return al.get(position); }
    @Override
    public long getItemId(int position) { return position; }
}

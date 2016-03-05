package com.example.egipcy.mytodolistmanager;


import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends ListActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {

    ListView list;
    ArrayList<Task> array;
    MyListAdapter mSchedule;
    Button btn_task;
    EditText et_task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.list = getListView();

        this.array = new ArrayList<Task>();

        this.mSchedule = new MyListAdapter(this.getBaseContext(), this.array);

        this.list.setAdapter(this.mSchedule);

        this.btn_task = (Button) findViewById(R.id.btn_task);
        this.btn_task.setOnClickListener(this);

        this.et_task = (EditText) findViewById(R.id.et_task);

        this.list.setOnItemLongClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.btn_task:
                Task new_task = new Task();
                new_task.setName(this.et_task.getText().toString());
                this.array.add(new_task);
                this.mSchedule.notifyDataSetChanged();

                this.et_task.setText("");
                break;
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
    {
        if(parent == this.list)
        {
            this.array.remove(position);
            this.mSchedule.notifyDataSetChanged();
            return true;
        }

        return false;
    }

    public void MyHandler(View v)
    {
        CheckBox cb = (CheckBox) v;
        int position = Integer.parseInt(cb.getTag().toString());
        Task modified_task = this.array.get(position);
        modified_task.setChecked(cb.isChecked());
        this.array.set(position, modified_task);
    }
}

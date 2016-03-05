package com.example.egipcy.mytodolistmanager;


import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = getListView();

        ArrayList<Task> array = new ArrayList<Task>();
        Task task1 = new Task();
        task1.setName("Task #1");
        task1.setChecked(false);

        Task task2 = new Task();
        task2.setName("Task #2");
        task2.setChecked(true);

        array.add(task1);
        array.add(task2);
        MyListAdapter mSchedule = new MyListAdapter(this.getBaseContext(), array);

        list.setAdapter(mSchedule);
    }
}

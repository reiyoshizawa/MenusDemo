package com.example.yoshizawarei.menusdemo;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private ArrayAdapter<String> mArrayAdapter;
    private ArrayList<String> mDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDataList = new ArrayList<>();
        mDataList.add("World Cup");
        mDataList.add("World Series");
        mDataList.add("NBA");
        mDataList.add("Stanley Cup");

        mListView = findViewById(R.id.listView);

        mArrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, mDataList);

        mListView.setAdapter(mArrayAdapter);


        // cotext menu
        registerForContextMenu(mListView);

        // popup menu
        final ImageButton starButton = findViewById(R.id.starButton);
        starButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(MainActivity.this, starButton);
                popup.getMenuInflater().inflate(
                        R.menu.popup_menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.pu1:
                                // sort
                                return true;
                            case R.id.pu2:
                                // sort
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                popup.show();
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Object obj = mListView.getItemAtPosition(info.position);
        String title = obj.toString();
        toast(title);
        switch (item.getItemId()) {
            case R.id.ct1:
                // edit
                toast(item.getTitle().toString());
                return true;
            case R.id.ct2:
                // delete
                toast(item.getTitle().toString());
                return true;
            case R.id.ct3:
                // share
                toast(item.getTitle().toString());
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // inflate our menu xml view
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    public void toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.op1:
                // settings
                toast(item.getTitle().toString());
                return true;
            case R.id.op2:
                // about
                toast(item.getTitle().toString());
                return true;
            case R.id.op3:
                // logout
                toast(item.getTitle().toString());
                return true;
            case R.id.op4:
                // search
                toast(item.getTitle().toString());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

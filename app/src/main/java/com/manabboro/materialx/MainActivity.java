package com.manabboro.materialx;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.manabboro.materialx.adapter.MainAdapter;
import com.manabboro.materialx.toolbar.MainMenuToolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainAdapter.OnItemClickListener {

    private RecyclerView mMainRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mMainRecyclerView = findViewById(R.id.mMainRecyclerView);
        mMainRecyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mMainRecyclerView.setLayoutManager(manager);

        MainAdapter adapter = new MainAdapter(this, getMainItems());
        adapter.setItemClickListener(this);
        mMainRecyclerView.setAdapter(adapter);


    }

    private List<MainAdapter.Item> getMainItems() {

        List<MainAdapter.Item> itemList = new ArrayList<>();
        itemList.add(new MainAdapter.Item("Toolbar"));

        return itemList;
    }


    @Override
    public void onItemClick(int position) {
        switch (position) {
            default:
            case 0:
                startActivity(new Intent(this, MainMenuToolbar.class));
                break;
        }

    }
}

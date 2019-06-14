package com.manabboro.materialx.toolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.manabboro.materialx.R;
import com.manabboro.materialx.adapter.MainAdapter;
import com.manabboro.materialx.adapter.SubMenuAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainMenuToolbar extends AppCompatActivity implements SubMenuAdapter.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_toolbar);



        RecyclerView mRecyclerView = findViewById(R.id.mRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);

        SubMenuAdapter adapter = new SubMenuAdapter(this, getSubMenuItems());
        adapter.setItemClickListener(this);
        mRecyclerView.setAdapter(adapter);

    }

    private List<SubMenuAdapter.Item> getSubMenuItems() {
        List<SubMenuAdapter.Item> itemList = new ArrayList<>();
        itemList.add(new SubMenuAdapter.Item("Light"));
        itemList.add(new SubMenuAdapter.Item("Dark"));
        return itemList;
    }


    @Override
    public void onItemClick(int position) {
        switch (position) {
            default:
            case 0: //Light
                break;
            case 1: // Dark
                break;
        }

    }
}

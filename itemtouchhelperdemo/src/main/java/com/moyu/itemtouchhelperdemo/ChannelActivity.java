package com.moyu.itemtouchhelperdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChannelActivity extends AppCompatActivity {

    @BindView(R.id.recy)
    RecyclerView mRecy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);
        ButterKnife.bind(this);

        init();
    }

    private void init() {

        final List<ChannelEntity> items = new ArrayList<>();
        for (int i = 0; i < 18; i++) {
            ChannelEntity entity = new ChannelEntity();
            entity.setName("频道" + i);
            items.add(entity);
        }
        final List<ChannelEntity> otherItems = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ChannelEntity entity = new ChannelEntity();
            entity.setName("其他" + i);
            otherItems.add(entity);
        }

        GridLayoutManager manager = new GridLayoutManager(this, 4);
        mRecy.setLayoutManager(manager);

        ItemDragHelperCallback callback = new ItemDragHelperCallback();
        final ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(mRecy);

        final ChannelAdapter adapter = new ChannelAdapter(this, helper, items, otherItems);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int viewType = adapter.getItemViewType(position);
                return viewType == ChannelAdapter.TYPE_MY || viewType == ChannelAdapter.TYPE_OTHER ? 1 : 4;
            }
        });
        mRecy.setAdapter(adapter);

        adapter.setOnMyChannelItemClickListener(new ChannelAdapter.OnMyChannelItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(ChannelActivity.this, items.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}

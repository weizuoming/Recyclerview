package com.example.hello.day06_recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private int[] imgId = new int[]{
            R.drawable.z13,
            R.drawable.z14,
            R.drawable.z15,
            R.drawable.z17
    };
    private RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //RcyclerView找到控件，设置适配器
        rv = (RecyclerView) findViewById(R.id.recyclerView);
        ArrayList<User> list = new ArrayList<>();
        //初始化数据
        for (int i = 0; i < 100; i++) {
            String conent = i + "林志玲";
            int img = imgId[i % imgId.length];
            User user = new User(img, conent);
            list.add(user);
        }
        //设置布局管理器
        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        //设置动画
        rv.setItemAnimator(new DefaultItemAnimator());
        //设置适配器
        final MyAdapter adapter = new MyAdapter(MainActivity.this, list);
        rv.setAdapter(adapter);
        //设置条目点击事件
        adapter.setOnMyItemClickListener(new MyAdapter.MyItemClick() {
            @Override
            public void itemClick(View view, int postion) {
                Toast.makeText(MainActivity.this,"---"+postion,Toast.LENGTH_SHORT).show();
                User user = new User(R.mipmap.ic_launcher, "hello 机器人");
//				adapter.addUser(user,postion);
                adapter.removeUser(postion);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.one:
                //listView
                rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                break;
            case R.id.two:
                //gridview
                rv.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
                break;
            case R.id.three:
//流失布局
                rv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

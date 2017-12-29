package com.example.hello.day06_recyclerview;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 韦作铭 on 2017/12/29.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private Context context;
    private ArrayList<User> list;
    private MyItemClick myItemClick;//监听器

    public MyAdapter(Context context, ArrayList<User> list){
        this.context = context;
        this.list = list;
    }
    //创建ViewHolder的时候
    //实例化ViewHolder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //条目布局
        View view = LayoutInflater.from(context).inflate(R.layout.item, null);
        //实例化ViewHolder ,将布局传入
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }
    //当绑定ViewHolder的时候
    //给控件设置数据
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.getTextView().setText(list.get(position).getContent());
        holder.getImageView().setImageResource(list.get(position).getImageId());
        //设置点击事件
        if (myItemClick!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //调用接口里面的方法
                    myItemClick.itemClick(holder.itemView,position);
                }
            });
        }
    }
    //条目数量
    @Override
    public int getItemCount() {
        return list.size();
    }
    //定义接口，实现条目点击事件
    public interface MyItemClick{
        void itemClick(View view,int postion);
    }

    public void setOnMyItemClickListener(MyItemClick myItemClick){
        this.myItemClick = myItemClick;
    }
    //添加数据
    public void addUser(User user,int position){
        list.add(position,user);
        //更新适配器
        notifyItemInserted(position);//参数，位置，在那里插入了数据
    }

    //删除数据
    public void removeUser(int position){
        list.remove(position);
        //通知适配器
        notifyItemRemoved(position);
    }
    //ViewHolder
    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.image);
            this.textView = itemView.findViewById(R.id.content);
        }
        //getter  setter

        public ImageView getImageView() {
            return imageView;
        }

        public void setImageView(ImageView imageView) {
            this.imageView = imageView;
        }

        public TextView getTextView() {
            return textView;
        }

        public void setTextView(TextView textView) {
            this.textView = textView;
        }
    }
}

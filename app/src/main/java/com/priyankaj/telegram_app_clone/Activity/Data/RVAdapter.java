package com.priyankaj.telegram_app_clone.Activity.Data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.priyankaj.telegram_app_clone.R;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder>
{
    private ArrayList<CustomPojo> list_members=new ArrayList<>();
    private final LayoutInflater inflater;
    View view;
    MyViewHolder holder;
    private Context context;

    public RVAdapter(Context context){
        this.context=context;
        inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view=inflater.inflate(R.layout.list_items, parent, false);
        holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        CustomPojo list_items=list_members.get(position);
        holder.user_name.setText(list_items.getName());
        holder.content.setText(list_items.getContent());
        holder.time.setText(list_items.getTime());
    }

    @Override
    public int getItemCount() {
        return list_members.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView user_name,content,time;
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            user_name=(TextView)itemView.findViewById(R.id.user_name);
            content=(TextView)itemView.findViewById(R.id.content);
            time=(TextView)itemView.findViewById(R.id.time);

        }

        @Override
        public void onClick(View v) {

        }
    }

    public void setListContent(ArrayList<CustomPojo> list_members){
        this.list_members=list_members;
        notifyItemRangeChanged(0,list_members.size());
    }
}
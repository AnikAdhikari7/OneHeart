package com.example.oneheart.screens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oneheart.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<Triple> arr;
    public Adapter(Context context,ArrayList<Triple> arr)
    {
        this.context=context;
        this.arr=arr;
    }
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        holder.img.setImageResource(arr.get(position).img);
        holder.txtname.setText(arr.get(position).name);
        holder.txtnumber.setText(arr.get(position).number);
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtname,txtnumber;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtname=itemView.findViewById(R.id.textView2);
            txtnumber=itemView.findViewById(R.id.textView);
            img=itemView.findViewById(R.id.imageView);
        }
    }
}


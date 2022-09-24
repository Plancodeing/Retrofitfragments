package com.example.androidui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {
    ArrayList<Data> employeelist;

    public MyListAdapter(ArrayList<Data> employeelist) {
        this.employeelist = employeelist;
    }

    @NonNull
    @Override
    public MyListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyListAdapter.ViewHolder holder, int position) {
        holder.f1.setText("Name :"+employeelist.get(position).getId().toString());
        holder.f2.setText("Salary :"+employeelist.get(position).getUserId().toString());
        holder.f3.setText("Age :"+employeelist.get(position).getTitle());
        holder.f4.setText("Age :"+employeelist.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return employeelist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView f1,f2,f3,f4;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            f1 = itemView.findViewById(R.id.e1);
            f2 = itemView.findViewById(R.id.f2);
            f3 = itemView.findViewById(R.id.f3);
            f4 = itemView.findViewById(R.id.f4);

        }
    }

}

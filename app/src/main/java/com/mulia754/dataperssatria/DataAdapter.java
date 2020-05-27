package com.mulia754.dataperssatria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataHolder>
{

    Context context;
    ArrayList<MyModel> arrayList;

    public DataAdapter(Context context, ArrayList<MyModel> arrayList)
    {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.my_layout,parent,false);
         return new DataHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull DataHolder holder, int position) {

        holder.tv_name.setText(arrayList.get(position).getNama_pers());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void filterList(ArrayList<MyModel> filterlist)
    {

        arrayList=filterlist;
        notifyDataSetChanged();
    }

    public class DataHolder extends RecyclerView.ViewHolder
    {
        TextView tv_name;

        public DataHolder(@NonNull View itemView) {
            super(itemView);

            tv_name=itemView.findViewById(R.id.tv_data);
        }
    }

}

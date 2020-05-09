package com.example.rough3adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewViewHolder>
{
    private List<viewLeadsItem> data;
    private Context mContext;

//    public RecyclerViewAdapter(Context data, List<viewLeadsItem> mContext) {
//        this.mContext = mContext;
//        this.data = data;
//
//    }


    public RecyclerViewAdapter(List<viewLeadsItem> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.RecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_leads_list_item, parent, false);
        return new RecyclerViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.RecyclerViewViewHolder holder, int position) {
        viewLeadsItem user =data.get(position);

        holder.tv_CustFname.setText(user.getLead_cust_firstname());
        holder.tv_CustLname.setText(user.getLead_cust_lastname());
        holder.tv_CustEmail.setText(user.getLead_cust_email());
        holder.tv_CustMobile.setText(user.getLead_cust_mobile());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public void setfilter(List<viewLeadsItem>actorsList){
        data=new ArrayList<>();
        data.addAll(actorsList);
        notifyDataSetChanged();

    }

    public class RecyclerViewViewHolder extends RecyclerView.ViewHolder{

        TextView tv_CustFname;
        TextView tv_CustLname;
        TextView tv_CustEmail;
        TextView tv_CustMobile;
        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_CustFname =itemView.findViewById(R.id.tv_CustFname);
            tv_CustLname =itemView.findViewById(R.id.tv_CustLname);
            tv_CustEmail =itemView.findViewById(R.id.tv_CustEmail);
            tv_CustMobile =itemView.findViewById(R.id.tv_CustMobile);
        }
    }

//    public void updateList(List<viewLeadsItem> newList)
//    {
//        data=new ArrayList<>();
//        data.addAll(newList);
//        notifyDataSetChanged();
//    }
}


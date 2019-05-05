package com.yu.attention.srt;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yu.attention.R;
import com.yu.attention.widget.SquartTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luyanjun
 * @description
 */
public class SrtAdapter extends RecyclerView.Adapter<SrtAdapter.MyViewHolder> {


    private List<Integer> mData = new ArrayList<>();
    private ItemClickListener itemClickListener;

    public SrtAdapter(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setData(List<Integer> data){
        this.mData = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_srt,viewGroup,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int position) {
        int x = mData.get(position);
        myViewHolder.mTextView.setText(x+"");
        myViewHolder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemClickListener != null){
                    itemClickListener.onItemClick(position);
                }
            }
        });
    }

    interface ItemClickListener{
        void onItemClick(int position);
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        SquartTextView mTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.tv_num);
        }
    }

}

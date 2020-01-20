package com.example.sampaldemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class BallsListAdapter extends RecyclerView.Adapter<BallsListAdapter.ViewHolder> {

    private List<BallsListModel> modelList;
    private Context context;

    public BallsListAdapter(List modelList, Context context) {
        this.modelList = modelList;
        this.context = context;

    }

    @NonNull
    @Override
    public BallsListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View list = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_ball_item, parent, false);
        BallsListAdapter.ViewHolder viewlist = new BallsListAdapter.ViewHolder(list);
        return viewlist;

    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @Override
    public void onBindViewHolder(@NonNull BallsListAdapter.ViewHolder holder, final int position) {



        holder.ball_number_tv.setText( (modelList.get(position).getBallNumber() ));
        holder.commentry_text_tv.setText( (modelList.get(position).getText()));

    }


    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ball_number_tv,commentry_text_tv;

        public ViewHolder(View view) {
            super(view);

            ball_number_tv = view.findViewById(R.id.ball_number_tv);
            commentry_text_tv = view.findViewById(R.id.commentry_text_tv);

        }
    }

}

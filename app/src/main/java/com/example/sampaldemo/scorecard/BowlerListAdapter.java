package com.example.sampaldemo.scorecard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.sampaldemo.R;

import java.util.List;


public class BowlerListAdapter extends RecyclerView.Adapter<BowlerListAdapter.ViewHolder> {

    private ICallback iCallback;
    private List<BowlerListModel> modelList;
    private Context context;

    public BowlerListAdapter(List modelList, Context context, ICallback iCallback) {
        this.modelList = modelList;
        this.context = context;
        this.iCallback = iCallback;

    }

    @NonNull
    @Override
    public BowlerListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View list = LayoutInflater.from(parent.getContext()).inflate(R.layout.bowler_list_item, parent, false);
        BowlerListAdapter.ViewHolder viewlist = new BowlerListAdapter.ViewHolder(list);
        return viewlist;

    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @Override
    public void onBindViewHolder(@NonNull BowlerListAdapter.ViewHolder holder, final int position) {



        holder.bowler_name_tv.setText( (modelList.get(position).getName() ));
        holder.bowler_over_tv.setText( (modelList.get(position).getOvers()));
        holder.bowler_maidan_tv.setText( (modelList.get(position).getMaidens()));
        holder.bowler_run_tv.setText( (modelList.get(position).getRunsConceded()));
        holder.bowler_wicket_tv.setText( (modelList.get(position).getWickets()));
        holder.bowler_er_tv.setText( (modelList.get(position).getEconomy()));



        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iCallback.onItemClick(position);

            }
        });

    }


    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView card_view;
        TextView bowler_name_tv,bowler_over_tv,bowler_maidan_tv,bowler_run_tv,bowler_wicket_tv,bowler_er_tv;

        public ViewHolder(View view) {
            super(view);

            card_view = view.findViewById(R.id.card_view);
            bowler_name_tv = view.findViewById(R.id.bowler_name_tv);
            bowler_over_tv = view.findViewById(R.id.bowler_over_tv);
            bowler_maidan_tv = view.findViewById(R.id.bowler_maidan_tv);
            bowler_run_tv = view.findViewById(R.id.bowler_run_tv);
            bowler_wicket_tv = view.findViewById(R.id.bowler_wicket_tv);
            bowler_er_tv = view.findViewById(R.id.bowler_er_tv);
        }
    }

}
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

public class BatsmanListAdapter extends RecyclerView.Adapter<BatsmanListAdapter.ViewHolder> {

    private ICallback iCallback;
    private List<DummyBatsmanListModel> modelList;
    private Context context;

    public BatsmanListAdapter(List modelList, Context context, ICallback iCallback) {
        this.modelList = modelList;
        this.context = context;
        this.iCallback = iCallback;

    }

    @NonNull
    @Override
    public BatsmanListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View list = LayoutInflater.from(parent.getContext()).inflate(R.layout.batsman_score_list_item, parent, false);
        BatsmanListAdapter.ViewHolder viewlist = new BatsmanListAdapter.ViewHolder(list);
        return viewlist;

    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @Override
    public void onBindViewHolder(@NonNull BatsmanListAdapter.ViewHolder holder, final int position) {



        holder.btsman_tv.setText( (modelList.get(position).getName()));
        holder.wicket_bowlr_tv.setText( (modelList.get(position).getHowOut()));
        holder.run_tv.setText( (modelList.get(position).getRuns()));
        holder.ball_tv.setText( (modelList.get(position).getBalls()));
        holder.four_tv.setText( (modelList.get(position).getFours()));
        holder.six_tv.setText( (modelList.get(position).getSixes()));
        holder.sr_tv.setText( (modelList.get(position).getStrikeRate()));



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
        TextView btsman_tv,wicket_bowlr_tv,run_tv,ball_tv,four_tv,six_tv,sr_tv;

        public ViewHolder(View view) {
            super(view);

            card_view = view.findViewById(R.id.card_view);
            btsman_tv = view.findViewById(R.id.btsman_tv);
            wicket_bowlr_tv = view.findViewById(R.id.wicket_bowlr_tv);
            run_tv = view.findViewById(R.id.run_tv);
            ball_tv = view.findViewById(R.id.ball_tv);
            four_tv = view.findViewById(R.id.four_tv);
            six_tv = view.findViewById(R.id.six_tv);
            sr_tv = view.findViewById(R.id.sr_tv);
        }
    }

}
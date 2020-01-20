package com.example.sampaldemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class CommentryListAdapter extends RecyclerView.Adapter<CommentryListAdapter.ViewHolder> {

    private List<CommentryListModel> modelList;
    private Context context;

    private List<BallsListModel> ballsListModels ;



    public CommentryListAdapter(List modelList, Context context, List ballsListModels) {
        this.modelList = modelList;
        this.context = context;
        this.ballsListModels = ballsListModels;

    }

    @NonNull
    @Override
    public CommentryListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View list = LayoutInflater.from(parent.getContext()).inflate(R.layout.commentry_list_item, parent, false);
        CommentryListAdapter.ViewHolder viewlist = new CommentryListAdapter.ViewHolder(list);
        //  Utility.setScaleAnimation(list);
        return viewlist;


    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @Override
    public void onBindViewHolder(@NonNull final CommentryListAdapter.ViewHolder holder, final int position) {


        String shortName=modelList.get(position).getShortName();
        String runsConceded=modelList.get(position).getRunsConcededinOver();
        String overs_number=modelList.get(position).getOvers_number();
        String bowlersName=modelList.get(position).getBowlersName();
        String extra_Conceded=modelList.get(position).getExtrasConcededinOver();
        String bowlingFigures=modelList.get(position).getBowlersBowlingFigures();
        String score=modelList.get(position).getBattingTeamsScore();



        holder.over_tv.setText("OVER "+overs_number);
        holder.total_runs_tv.setText("Total runs - "+runsConceded);
        holder.team_name_tv.setText(shortName);
        holder.score_tv.setText(score);
        holder.bowler_name_tv.setText(bowlersName);
        holder.runs_conceded_tv.setText(bowlingFigures);
        holder.total_extra_tv.setText(extra_Conceded);

        holder.recycler_view_balls.setLayoutManager(new LinearLayoutManager(context));
        BallsListAdapter ballsListAdapter = new BallsListAdapter(ballsListModels, context);
        holder.recycler_view_balls.setAdapter(ballsListAdapter);
        ballsListAdapter.notifyDataSetChanged();



    }


    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        TextView over_tv,total_runs_tv,team_name_tv,score_tv,bowler_name_tv,runs_conceded_tv,total_extra_tv;

        RecyclerView recycler_view_balls;


        public ViewHolder(View view) {
            super(view);

            over_tv = view.findViewById(R.id.over_tv);
            total_runs_tv = view.findViewById(R.id.total_runs_tv);
            team_name_tv = view.findViewById(R.id.team_name_tv);
            score_tv = view.findViewById(R.id.score_tv);
            bowler_name_tv = view.findViewById(R.id.bowler_name_tv);
            runs_conceded_tv = view.findViewById(R.id.runs_conceded_tv);
            total_extra_tv = view.findViewById(R.id.total_extra_tv);
            recycler_view_balls = view.findViewById(R.id.recycler_view_balls);


        }
    }

}
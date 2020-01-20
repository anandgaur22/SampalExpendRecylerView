package com.example.sampaldemo.scorecard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.sampaldemo.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ScorecardTeamListAdapter extends RecyclerView.Adapter<ScorecardTeamListAdapter.ViewHolder> {

    private ICallback iCallback;
    private List<ScorecardTeamListModel> modelList;
    private Context context;

    private List<BatsmanListModel> listModelBatsman ;
    private List<BowlerListModel> listModelBowler ;
    private List<DummyBatsmanListModel> dummyBatsmanListModels=new ArrayList<>();

    private String seriesid,matchid,flag;

    ArrayList<Integer> counter = new ArrayList<Integer>();

    int pos;



    public ScorecardTeamListAdapter(List modelList, Context context, ICallback iCallback,List listModelBatsman,List listModelBowler) {
        this.modelList = modelList;
        this.context = context;
        this.iCallback = iCallback;
        this.listModelBatsman = listModelBatsman;
        this.listModelBowler = listModelBowler;


        for (int i = 0; i < modelList.size(); i++) {
            counter.add(0);
        }


    }

    @NonNull
    @Override
    public ScorecardTeamListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View list = LayoutInflater.from(parent.getContext()).inflate(R.layout.scorecard_team_list_item, parent, false);
        ScorecardTeamListAdapter.ViewHolder viewlist = new ScorecardTeamListAdapter.ViewHolder(list);
        return viewlist;


    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @Override
    public void onBindViewHolder(@NonNull final ScorecardTeamListAdapter.ViewHolder holder, final int position) {


        String shortName=modelList.get(position).getShortName();
        String over=modelList.get(position).getOver();
        String run=modelList.get(position).getRun();
        String wicket=modelList.get(position).getWicket();
        String extra=modelList.get(position).getExtra();
        String bye=modelList.get(position).getBye();
        String lb=modelList.get(position).getLegBye();
        final String no_ball=modelList.get(position).getNoBall();
        String wide=modelList.get(position).getWide();
        seriesid=modelList.get(position).getSeriesid();
        matchid=modelList.get(position).getMatchid();
        flag=modelList.get(position).getFlags();


        holder.team_name_tv.setText(shortName );
        holder.score_tv.setText(run+"-"+wicket+" ("+over+")");
        holder.total_score_tv.setText(run+"-"+wicket+" ("+over+")");

        String all_extra= "b "+bye+", lb"+lb+", w"+wide+", nb"+no_ball;

        holder.extra_run_tv.setText(extra);
        holder.all_extra_tv.setText(all_extra);


        if(modelList.get(position).getFlags().equalsIgnoreCase("0")){

            holder.recycler_view_batsman.setVisibility(View.GONE);
            holder.recycler_view_bowler.setVisibility(View.GONE);
            holder.show_score_card_rl.setVisibility(View.GONE);

        }else {

            holder.recycler_view_batsman.setVisibility(View.VISIBLE);
            holder.recycler_view_bowler.setVisibility(View.VISIBLE);
            holder.show_score_card_rl.setVisibility(View.VISIBLE);

        }

        Log.d("", "onBindViewHolder: "+flag);




    }


    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        CardView card_view;
        TextView team_name_tv,score_tv;
        ImageView expand_more_iv,expand_less_iv;

        TextView NoData_tv_batsman,extra_run_tv,all_extra_tv,total_score_tv,NoData_tv_bowler;
        RecyclerView recycler_view_batsman,recycler_view_bowler;
        ProgressBar progressbar_batsman,progressbar_bowler;
        RelativeLayout show_score_card_rl;


        public ViewHolder(View view) {
            super(view);

            card_view = view.findViewById(R.id.card_view);
            team_name_tv = view.findViewById(R.id.team_name_tv);
            expand_more_iv = view.findViewById(R.id.expand_more_iv);
            score_tv = view.findViewById(R.id.score_tv);
            expand_less_iv = view.findViewById(R.id.expand_less_iv);

            recycler_view_batsman = view.findViewById(R.id.recycler_view_batsman);
            NoData_tv_batsman = view.findViewById(R.id.NoData_tv_batsman);
            progressbar_batsman = view.findViewById(R.id.progressbar_batsman);
            extra_run_tv = view.findViewById(R.id.extra_run_tv);
            all_extra_tv = view.findViewById(R.id.all_extra_tv);
            total_score_tv = view.findViewById(R.id.total_score_tv);
            recycler_view_bowler = view.findViewById(R.id.recycler_view_bowler);
            NoData_tv_bowler = view.findViewById(R.id.NoData_tv_bowler);
            progressbar_bowler = view.findViewById(R.id.progressbar_bowler);
            show_score_card_rl = view.findViewById(R.id.show_score_card_rl);


            card_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //show_score_card_rl.setVisibility(View.VISIBLE);

                    ScorecardTeamListModel model =modelList.get(getLayoutPosition());
                    model.setFlags("1");
                    modelList.set(getLayoutPosition(),model);

                    Log.d("", "Flag_btsman: "+listModelBatsman.get(getLayoutPosition()).getFlag_btsman());

                    if (listModelBatsman.get(getLayoutPosition()).getFlag_btsman()==getLayoutPosition()){
                        Log.d("", "Flag_btsmanIf: "+listModelBatsman.get(getLayoutPosition()).getFlag_btsman());
                        for (int i = 0; i <listModelBatsman.size() ; i++) {
                            DummyBatsmanListModel dummyBatsmanListModel=new DummyBatsmanListModel();
                            if (listModelBatsman.get(getLayoutPosition()).getFlag_btsman()==getLayoutPosition()){
                                dummyBatsmanListModel.setId(listModelBatsman.get(i).getId());
                                dummyBatsmanListModel.setBalls(listModelBatsman.get(i).getBalls());
                                dummyBatsmanListModel.setBatsmen_imageURL(listModelBatsman.get(i).getBatsmen_imageURL());
                                dummyBatsmanListModel.setFallOfWicket(listModelBatsman.get(i).getFallOfWicket());
                                dummyBatsmanListModel.setFours(listModelBatsman.get(i).getFours());
                                dummyBatsmanListModel.setSixes(listModelBatsman.get(i).getSixes());
                                dummyBatsmanListModel.setName(listModelBatsman.get(i).getName());
                                dummyBatsmanListModel.setRuns(listModelBatsman.get(i).getRuns());
                                dummyBatsmanListModel.setHowOut(listModelBatsman.get(i).getHowOut());
                                Log.d("", "Flag_btsmanForInside: "+listModelBatsman.get(getLayoutPosition()).getFlag_btsman());
                                dummyBatsmanListModels.add(dummyBatsmanListModel);
                            }
                        }


                        recycler_view_batsman.setLayoutManager(new LinearLayoutManager(context));
                        BatsmanListAdapter adapterBatsman = new BatsmanListAdapter(dummyBatsmanListModels, context, iCallback);
                        recycler_view_batsman.setAdapter(adapterBatsman);
                        adapterBatsman.notifyDataSetChanged();

                    }

                    recycler_view_bowler.setLayoutManager(new LinearLayoutManager(context));
                    BowlerListAdapter adapterBowler = new BowlerListAdapter(listModelBowler, context, iCallback);
                    recycler_view_bowler.setAdapter(adapterBowler);
                    adapterBowler.notifyDataSetChanged();


                    notifyDataSetChanged();



                }
            });
        }
    }


}
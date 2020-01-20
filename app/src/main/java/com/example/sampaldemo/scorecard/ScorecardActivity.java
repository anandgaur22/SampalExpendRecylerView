package com.example.sampaldemo.scorecard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

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

public class ScorecardActivity extends AppCompatActivity {

    private ICallback iCallback;
    public ScorecardTeamListAdapter adapter;
    private BatsmanListAdapter adapterBatsman;
    private BowlerListAdapter adapterBowler;
    private List<ScorecardTeamListModel> listModel = new ArrayList<>();
    private Intent intent;

    String seriesid="2381",matchid="46132";


    int count=0;

    private List<BatsmanListModel> listModelBatsman = new ArrayList<>();
    private List<BowlerListModel> listModelBowler = new ArrayList<>();

    ProgressBar progressbar;
    RecyclerView recycler_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorecard);

        progressbar=findViewById(R.id.progressbar);
        recycler_view=findViewById(R.id.recycler_view);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setHasFixedSize(true);



        iCallback=new ICallback() {
            @Override
            public void onItemClick(int pos) {



            }
        };

        scorecard_team_list_networkCall();


    }

    private void scorecard_team_list_networkCall(){

      progressbar.setVisibility(View.VISIBLE);

        RequestQueue requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getApplicationContext()));
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://dev132-cricket-live-scores-v1.p.rapidapi.com/scorecards.php?"+"seriesid="+seriesid+"&matchid="+matchid, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    listModel.clear();
                    Log.d("", "onResponseMatches: "+response);

                    if (jsonObject.optString("status").equalsIgnoreCase("200")) {
                         progressbar.setVisibility(View.GONE);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("fullScorecard");

                        JSONArray jsonArray = jsonObject1.getJSONArray("innings");



                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject2 = jsonArray.getJSONObject(i);

                            ScorecardTeamListModel model = new ScorecardTeamListModel();

                            String innings_id = jsonObject2.getString("id");
                            String isDeclared = jsonObject2.getString("isDeclared");
                            String name = jsonObject2.getString("name");
                            String wicket = jsonObject2.getString("wicket");
                            String run = jsonObject2.getString("run");
                            String over = jsonObject2.getString("over");
                            String extra = jsonObject2.getString("extra");
                            String bye = jsonObject2.getString("bye");
                            String legBye = jsonObject2.getString("legBye");
                            String wide = jsonObject2.getString("wide");
                            String noBall = jsonObject2.getString("noBall");
                            String runRate = jsonObject2.getString("runRate");
                            String requiredRunRate = jsonObject2.getString("requiredRunRate");

                            /*series*/
                            JSONObject jsonObject3 = jsonObject2.getJSONObject("team");
                            String team_id = jsonObject3.getString("id");
                            String team_shortName = jsonObject3.getString("shortName");

                            model.setInnings_id(innings_id);
                            model.setIsDeclared(isDeclared);
                            model.setName(name);
                            model.setWicket(wicket);
                            model.setRun(run);
                            model.setOver(over);
                            model.setExtra(extra);
                            model.setBye(bye);
                            model.setLegBye(legBye);
                            model.setWide(wide);
                            model.setNoBall(noBall);
                            model.setRunRate(runRate);
                            model.setRequiredRunRate(requiredRunRate);
                            model.setShortName(team_shortName);
                            model.setSeriesid(seriesid);
                            model.setMatchid(matchid);
                            model.setFlags("0");

                            listModel.add(model);


                            JSONArray jsonArray2 = jsonObject2.getJSONArray("batsmen");

                            JSONArray jsonArray3 = jsonObject2.getJSONArray("bowlers");


                            for (int j = 0; j < jsonArray2.length(); j++) {
                                JSONObject jsonObject4 = jsonArray2.getJSONObject(j);

                                BatsmanListModel model1=new BatsmanListModel();

                                String batsmen_id = jsonObject4.getString("id");
                                String batsmen_name = jsonObject4.getString("name");
                                // String batsmen_imageURL = jsonObject4.getString("imageURL");
                                String batsmen_runs = jsonObject4.getString("runs");
                                String batsmen_balls = jsonObject4.getString("balls");
                                String batsmen_strikeRate = jsonObject4.getString("strikeRate");
                                String batsmen_fours = jsonObject4.getString("fours");
                                String batsmen_sixes = jsonObject4.getString("sixes");
                                String batsmen_howOut = jsonObject4.getString("howOut");
                                // String batsmen_fallOfWicket = jsonObject4.getString("fallOfWicket");
                                //String batsmen_fallOfWicketOver = jsonObject4.getString("fallOfWicketOver");
                                // String batsmen_fowOrder = jsonObject4.getString("fowOrder");

                                model1.setId(batsmen_id);
                                //  model1.setBatsmen_imageURL(batsmen_imageURL);
                                model1.setName(batsmen_name);
                                model1.setRuns(batsmen_runs);
                                model1.setBalls(batsmen_balls);
                                model1.setStrikeRate(batsmen_strikeRate);
                                model1.setFours(batsmen_fours);
                                model1.setSixes(batsmen_sixes);
                                model1.setHowOut(batsmen_howOut);
                                model1.setFlag_btsman(count);
                                // model.setFallOfWicket(batsmen_fallOfWicket);
                                //  model.setFallOfWicketOver(batsmen_fallOfWicketOver);
                                // model.setFowOrder(batsmen_fowOrder);


                                listModelBatsman.add(model1);

                                count++;
                            }


                            for (int k = 0; k < jsonArray3.length(); k++) {
                                JSONObject jsonObject5 = jsonArray3.getJSONObject(k);

                                BowlerListModel model2=new BowlerListModel();

                                String bowlers_id = jsonObject5.getString("id");
                                String bowlers_name = jsonObject5.getString("name");
                                String bowlers_runsConceded = jsonObject5.getString("runsConceded");
                                String bowlers_maidens = jsonObject5.getString("maidens");
                                String bowlers_wickets = jsonObject5.getString("wickets");
                                String bowlers_overs = jsonObject5.getString("overs");
                                String bowlers_wides = jsonObject5.getString("wides");
                                String bowlers_noBalls = jsonObject5.getString("noBalls");
                                String bowlers_economy = jsonObject5.getString("economy");


                                model2.setId(bowlers_id);
                                model2.setName(bowlers_name);
                                model2.setRunsConceded(bowlers_runsConceded);
                                model2.setMaidens(bowlers_maidens);
                                model2.setWickets(bowlers_wickets);
                                model2.setOvers(bowlers_overs);
                                model2.setWides(bowlers_wides);
                                model2.setNoBalls(bowlers_noBalls);
                                model2.setEconomy(bowlers_economy);
                                model2.setFlag_bowler(count);


                                listModelBowler.add(model2);

                                count++;

                            }

                            //  bowlerListModelHashMap.put(i,listModelBowler)
                        }


                        adapter = new ScorecardTeamListAdapter(listModel, getApplicationContext(), iCallback,listModelBatsman,listModelBowler);
                        recycler_view.setAdapter(adapter);
                        adapter.notifyDataSetChanged();



                    } else {

                       // Utility.customToastRedBottom("Some technical problem", getContext());

                        Toast.makeText(ScorecardActivity.this, "error", Toast.LENGTH_SHORT).show();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
               progressbar.setVisibility(View.GONE);

            }
        }) {
            @SuppressLint("LogNotTimber")
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("x-rapidapi-host", "dev132-cricket-live-scores-v1.p.rapidapi.com");
                headers.put("x-rapidapi-key", "8e8d41251fmsh873d50d3bce55b9p1a0a8fjsn062d76f0587d");
                Log.e("post_token", "" + headers);
                return headers;
            }
        };

        int socketTimeout = 30000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(policy);
        requestQueue.add(stringRequest);
    }

}

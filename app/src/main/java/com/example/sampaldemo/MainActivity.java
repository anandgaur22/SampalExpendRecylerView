package com.example.sampaldemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
import com.example.sampaldemo.scorecard.ScorecardActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    private String ballType,dateTime,text,isFallOfWicket,batsmanId,batsmanName,batsmanImageURL,bowlerId,
            bowlerName,bowlerImageURL,runs,battingTeamScore,offStrikeBatsmanId,wickets;

    private CommentryListAdapter adapter;
    JSONArray jsonArray3;
    JSONObject jsonObject3;
    private List<CommentryListModel> listModel = new ArrayList<>();
    private List<BallsListModel> ballsListModels = new ArrayList<>();

    ProgressBar progressbar;
    RecyclerView recycler_view;
    Button btn_scorecard;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressbar=findViewById(R.id.progressbar);
        recycler_view=findViewById(R.id.recycler_view);
        btn_scorecard=findViewById(R.id.btn_scorecard);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setHasFixedSize(true);



        btn_scorecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this, ScorecardActivity.class);
                startActivity(intent);

            }
        });

        commentry_list_networkCall();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void commentry_list_networkCall(){

      progressbar.setVisibility(View.VISIBLE);

        RequestQueue requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getApplicationContext()));
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://dev132-cricket-live-scores-v1.p.rapidapi.com/comments.php?"+"seriesid="+"2381"+"&matchid="+"46132", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    listModel.clear();
                    Log.d("", "onResponseMatches: "+response);

                    if (jsonObject.optString("status").equalsIgnoreCase("200")) {
                        progressbar.setVisibility(View.GONE);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("commentary");

                        JSONArray jsonArray = jsonObject1.getJSONArray("innings");


                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject2 = jsonArray.getJSONObject(i);

                            String innings_id = jsonObject2.getString("id");
                            String name = jsonObject2.getString("name");
                            String shortName = jsonObject2.getString("shortName");
                            String teamId = jsonObject2.getString("teamId");


                            JSONArray jsonArray2 = jsonObject2.getJSONArray("overs");


                            for (int j = 0; j < jsonArray2.length(); j++) {
                                jsonObject3 = jsonArray2.getJSONObject(j);

                                CommentryListModel model = new CommentryListModel();

                                String overs_id = jsonObject3.getString("id");
                                String uniqueOverId = jsonObject3.getString("uniqueOverId");
                                String number = jsonObject3.getString("number");

                                if (jsonObject3.has("overSummary")) {

                                    JSONObject jsonObject4 = jsonObject3.getJSONObject("overSummary");
                                    String bowlersId = jsonObject4.getString("bowlersId");
                                    String bowlersName = jsonObject4.getString("bowlersName");
                                    String bowlersBowlingFigures = jsonObject4.getString("bowlersBowlingFigures");
                                    String battingTeamsScore = jsonObject4.getString("battingTeamsScore");
                                    String runsConcededinOver = jsonObject4.getString("runsConcededinOver");
                                    String extrasConcededinOver = jsonObject4.getString("extrasConcededinOver");
                                    String wicketsTakeninOver = jsonObject4.getString("wicketsTakeninOver");

                                    model.setBowlersId(bowlersId);
                                    model.setBowlersName(bowlersName);
                                    model.setBowlersBowlingFigures(bowlersBowlingFigures);
                                    model.setBattingTeamsScore(battingTeamsScore);
                                    model.setRunsConcededinOver(runsConcededinOver);
                                    model.setExtrasConcededinOver(extrasConcededinOver);
                                    model.setWicketsTakeninOver(wicketsTakeninOver);
                                }

                                model.setId(innings_id);
                                model.setName(name);
                                model.setShortName(shortName);
                                model.setTeamId(teamId);
                                model.setOvers_id(overs_id);
                                model.setUniqueOverId(uniqueOverId);
                                model.setOvers_number(number);

                                listModel.add(model);

                                jsonArray3 = jsonObject3.getJSONArray("balls");

                                Log.d("", "jsonArray3.length: "+jsonArray3.length());


                            }


                            for (int k = 0; k < jsonArray3.length(); k++) {

                                JSONObject jsonObject5 = jsonArray3.getJSONObject(k);

                                BallsListModel model2 = new BallsListModel();

                                String  ballNumber = jsonObject5.getString("ballNumber");
                                String id = jsonObject5.getString("id");
                                String result = jsonObject5.getString("result");

                                Log.d("", "onResponseJ3: "+jsonArray3.toString());
                                Log.d("", "onResponseJ5: "+jsonObject5.toString());

                                Log.d("", "k.length: "+jsonArray3.length());



                                JSONArray jsonArray4 = jsonObject5.getJSONArray("comments");


                                //  for (int l = 0; l < jsonArray4.length(); l++) {

                                JSONObject jsonObject6 = jsonArray4.getJSONObject(0);

                                String comments_id = jsonObject6.getString("id");
                                ballType = jsonObject6.getString("ballType");
                                // dateTime = jsonObject6.getString("dateTime");
                                text = jsonObject6.getString("text");
                                isFallOfWicket = jsonObject6.getString("isFallOfWicket");
                                // batsmanId = jsonObject6.getString("batsmanId");
                                // batsmanName = jsonObject6.getString("batsmanName");
                                // batsmanImageURL = jsonObject6.getString("batsmanImageURL");
                                bowlerId = jsonObject6.getString("bowlerId");
                                bowlerName = jsonObject6.getString("bowlerName");
                                // bowlerImageURL = jsonObject6.getString("bowlerImageURL");
                                runs = jsonObject6.getString("runs");
                                battingTeamScore = jsonObject6.getString("battingTeamScore");
                                offStrikeBatsmanId = jsonObject6.getString("offStrikeBatsmanId");
                                wickets = jsonObject6.getString("wickets");


                                //   }

                                model2.setBallNumber(ballNumber);
                                model2.setId(id);
                                model2.setResult(result);
                                model2.setBallType(ballType);
                                model2.setDateTime(dateTime);
                                model2.setText(text);
                                model2.setIsFallOfWicket(isFallOfWicket);
                                model2.setBatsmanId(batsmanId);
                                model2.setBatsmanName(batsmanName);
                                // model2.setBatsmanImageURL(batsmanImageURL);
                                model2.setBowlerId(bowlerId);
                                model2.setBowlerName(bowlerName);
                                model2.setRuns(runs);
                                model2.setBattingTeamScore(battingTeamScore);
                                model2.setOffStrikeBatsmanId(offStrikeBatsmanId);
                                model2.setWickets(wickets);


                                ballsListModels.add(model2);

                            }
                        }

                        adapter = new CommentryListAdapter(listModel, getApplicationContext(),ballsListModels);
                        recycler_view.setAdapter(adapter);
                        adapter.notifyDataSetChanged();

                    } else {

                        Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();

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

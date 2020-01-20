package com.example.sampaldemo.scorecard;

public class BowlerListModel {

    private String id;
    private String name;
    private String runsConceded;
    private String maidens;
    private String wickets;
    private String overs;
    private String wides;
    private String noBalls;
    private String economy;
    private int flag_bowler;

    public int getFlag_bowler() {
        return flag_bowler;
    }

    public void setFlag_bowler(int flag_bowler) {
        this.flag_bowler = flag_bowler;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRunsConceded() {
        return runsConceded;
    }

    public void setRunsConceded(String runsConceded) {
        this.runsConceded = runsConceded;
    }

    public String getMaidens() {
        return maidens;
    }

    public void setMaidens(String maidens) {
        this.maidens = maidens;
    }

    public String getWickets() {
        return wickets;
    }

    public void setWickets(String wickets) {
        this.wickets = wickets;
    }

    public String getOvers() {
        return overs;
    }

    public void setOvers(String overs) {
        this.overs = overs;
    }

    public String getWides() {
        return wides;
    }

    public void setWides(String wides) {
        this.wides = wides;
    }

    public String getNoBalls() {
        return noBalls;
    }

    public void setNoBalls(String noBalls) {
        this.noBalls = noBalls;
    }

    public String getEconomy() {
        return economy;
    }

    public void setEconomy(String economy) {
        this.economy = economy;
    }
}

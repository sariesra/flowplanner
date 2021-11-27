package com.example.flowplanner;

public class akis {

    int id;
    String name;
    int dead_yil;
    int dead_ay;
    int dead_gun;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getDead_yil() { return dead_yil; }
    public void setDead_yil(int dead_yil) { this.dead_yil = dead_yil; }
    public int getDead_ay() { return dead_ay; }
    public void setDead_ay(int dead_ay) { this.dead_ay = dead_ay; }
    public int getDead_gun() { return dead_gun; }
    public void setDead_gun(int dead_gun) { this.dead_gun = dead_gun; }

    public akis(int id, String name, int dead_yil, int dead_ay, int dead_gün) {
        this.id = id;
        this.name = name;
        this.dead_yil = dead_yil;
        this.dead_ay = dead_ay;
        this.dead_gun = dead_gün;
    }

    public String toString(){

        return ""+id+"-"+name+"-"+dead_yil+"-"+dead_ay+"-"+dead_gun;
    }


}

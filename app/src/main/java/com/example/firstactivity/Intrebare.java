package com.example.firstactivity;

import java.util.Arrays;

public class Intrebare {
    private String text;
    private int IDraspunsCorect;
    private String[] raspunsuri;

    public Intrebare(String text, int IDraspunsCorect,String[] raspunsuri) {
        this.text = text;
        this.IDraspunsCorect = IDraspunsCorect;
        this.raspunsuri = raspunsuri;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIDraspunsCorect() {
        return IDraspunsCorect;
    }

    public void setIDraspunsCorect(int IDraspunsCorect) {
        this.IDraspunsCorect = IDraspunsCorect;
    }

    public String[] getRaspunsuri() {
        return raspunsuri;
    }

    public void setRaspunsuri(String[] raspunsuri) {
        this.raspunsuri = raspunsuri;
    }

    @Override
    public String toString() {
        return "Intrebare{" +
                "text='" + text + '\'' +
                ", IDraspunsCorect=" + IDraspunsCorect +
                ", raspunsuri=" + Arrays.toString(raspunsuri) +
                '}';
    }
}

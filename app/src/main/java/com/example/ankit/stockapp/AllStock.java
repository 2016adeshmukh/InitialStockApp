package com.example.ankit.stockapp;

/**
 * Created by Ankit on 6/3/16.
 */
public class AllStock {
    private String cc;
    private String dd;
    private String hh;
    private String ll;
    private String oo;
    private String vv;

    public AllStock()
    {

    }
    public double getC()
    {
        double c=Double.parseDouble(cc);
        return c;
    }
    public double getD()
    {
        double d=Double.parseDouble(dd);
        return d;
    }
    public double getH()
    {
        double h=Double.parseDouble(hh);
        return h;
    }
    public double getL()
    {
        double l=Double.parseDouble(ll);
        return l;
    }
    public double getO()
    {
        double o=Double.parseDouble(oo);
        return o;
    }
    public double getV()
    {
        double v=Double.parseDouble(vv);
        return v;
    }
}

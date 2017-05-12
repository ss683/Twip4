package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Shane on 4/21/2017.
 */
public class Calculations {
    public Calculations(int n) {
        score_1 = 0;
        score_2 = 0;
        total_1 = 0;
        total_2 = 0;
        ID = n;
    }

    public static void score(String[] gr1, String[] gr2, int start1, int start2, Calculations x, boolean q1) {
        boolean secret = true;
        double sum = 0;
        String holder;
        int place = start1;
        int locale = start2;
        while (place < gr1.length && !gr1[place].contains("+"))
            place++;
        if (place >= gr1.length) {
            secret=false;
        }
        while(secret)
        {
            Scanner inuse = new Scanner(gr1[place]);
            while (inuse.hasNext())
            {
                if (inuse.next().equalsIgnoreCase("+"))
                {
                    holder = inuse.next();
                    if (holder.contains(".")) {
                        sum = sum + Double.parseDouble(holder.substring(1)) / 10.0;
                        x.total_1 = x.total_1 + Double.parseDouble(holder.substring(1)) / 10.0;
                    }
                    else if (!holder.contains("w")) {
                        sum = sum + Double.parseDouble(holder);
                        x.total_1 = x.total_1 + Double.parseDouble(holder);
                    }
                }
            }
            if (place + 1 >= gr1.length || !gr1[place+1].contains("+"))
                break;
            else
                place++;
        }
        place++;
        while (place < gr1.length && !gr1[place].contains("+"))
        {
            if (gr1[place].length()==1)
            {
                sum = sum - Double.parseDouble(gr1[place])*0.25;
                x.total_1 = x.total_1- Double.parseDouble(gr1[place])*0.25;
                place ++;
                break;
            }
            place++;
        }

        while (locale < gr2.length && !gr2[locale].contains("+"))
            locale++;
        if (locale >= gr2.length)
            return;
        while(true)
        {
            Scanner inuse = new Scanner(gr2[locale]);
            while (inuse.hasNext())
            {
                if (inuse.next().equalsIgnoreCase("+"))
                {
                    holder = inuse.next();
                    if (holder.contains(".")) {
                        sum = sum + Double.parseDouble(holder.substring(1)) / 10.0;
                        x.total_2 = x.total_2 + Double.parseDouble(holder.substring(1)) / 10.0;
                    }
                    else if (!holder.contains("w")) {
                        sum = sum + Double.parseDouble(holder);
                        x.total_2 = x.total_2 + Double.parseDouble(holder);
                    }
                }
            }
            if (locale + 1 >= gr2.length || !gr2[locale+1].contains("+"))
                break;
            else
                locale++;
        }
        locale++;
        while (locale < gr2.length && !gr2[locale].contains("+"))
        {
            if (gr2[locale].length()==1)
            {
                sum = sum - Double.parseDouble(gr2[locale])*0.25;
                x.total_2 = x.total_2- Double.parseDouble(gr2[locale])*0.25;
                locale ++;
                break;
            }
            locale++;
        }
        if (q1) {
            x.score_1 = (sum / 2.0);
            score(gr1, gr2, place, locale, x, false);
        }
        else
            x.score_2=(sum/2.0);
        return;




    }
    public static void sout(Calculations hey, String[][] forth)
    {
        System.out.printf("%-10s| %-10s| %-10s| %-10s| %-10s| %-10s| %-10s|\n", readFile.search(forth, hey.ID), hey.ID, hey.score_1+hey.score_2,  hey.total_1, hey.total_2, hey.score_1, hey.score_2);
    }
    public double score_1;
    public double score_2;
    public double total_1;
    public double total_2;
    public int ID;
}

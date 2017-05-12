package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Shane on 4/20/2017.
 */
public class readFile {
    public static int linesNumber() throws Exception {
        FileReader reading = new FileReader("rawDataU6.txt");
        BufferedReader rawReading = new BufferedReader(reading);

        String lineOfText;
        int numOfLines = 0;

        while((lineOfText = rawReading.readLine()) != null)
            numOfLines++;

        rawReading.close();

        return numOfLines;
    }

    public static ArrayList<Double> totalScore(ArrayList<Double> linesArray, int lines) throws Exception
    {
        FileReader reading = new FileReader("rawDataU6.txt");
        BufferedReader rawReading = new BufferedReader(reading);
        Scanner delimit = new Scanner(System.in);


        for(int k = 0; k < lines; k++)
            linesArray.add(0.0);

        for(int i = 0; i < lines; i++) {
            String moreRefined = "";
            double total = 0;
            String line = rawReading.readLine().toLowerCase();
            String refinedLine = line.replace("/", "").replace(" ", "").replace("a", "").replace("\t", "").replace("b", "").replace("c", "").replace("d", "").replace("e", "").replace("f", "").replace("g", "").replace("h", "").replace("i", "").replace("j", "").replace("k", "").replace("l", "").replace("m", "").replace("n", "").replace("o", "").replace("p", "").replace("q", "").replace("r", "").replace("s", "").replace("t", "").replace("u", "").replace("v", "").replace("x", "").replace("y", "").replace("z", "").replace(",", "").replace("\"", "").replace(":", "").replace(";", "").replace("(", "").replace(")", "").replace("!", "").replace("@", "").replace("#", "").replace("=", "").replace(">", "").replace("<", "").replace("'", "").replace("-", "").trim();
            delimit = new Scanner(refinedLine).useDelimiter("\\s*\\+\\s*");
            if(refinedLine.contains("+")){
                while (delimit.hasNext()) {
                    String x = delimit.next();
                    if(x.substring(0,1).equals("1"))
                        total += 1;
                    else if(x.substring(0,1).equals("."))
                        total += 0.5;
                    moreRefined += x;
                }
            }
            else
                moreRefined = "n";
            if(moreRefined.substring(0,1).equals("1"))
                total -= 1;
                    linesArray.set(i, total);
            total = 0;
        }
        for(int j = 0; j < linesArray.size(); j++) {
            if (linesArray.get(j) == 0.0)
            {
                linesArray.remove(j);
            }
        }
        linesArray.remove(27);
        delimit.close();
        rawReading.close();
        return linesArray;
    }
    public static ArrayList<Integer> secret(ArrayList<Integer> secretNums, int lines) throws Exception {
        ArrayList<String> temp = new ArrayList();
        FileReader reading = new FileReader("rawDataU6.txt");
        BufferedReader rawReading = new BufferedReader(reading);

        for (int k = 0; k < lines; k++) {
            temp.add("");
        }

        for (int i = 0; i < temp.size(); i++) {
            String yo = "hey";
            String line = rawReading.readLine().toLowerCase();
            String refinedLine = line.replace("/", "").replace(" ", "").replace("\n", "").replace("a", "").replace("\t", "").replace("b", "").replace("c", "").replace("d", "").replace("e", "").replace("f", "").replace("g", "").replace("h", "").replace("i", "").replace("j", "").replace("w", "").replace("k", "").replace("l", "").replace("m", "").replace("n", "").replace("o", "").replace("p", "").replace("q", "").replace("r", "").replace("s", "").replace("t", "").replace("u", "").replace("v", "").replace("x", "").replace("y", "").replace("z", "").replace(",", "").replace("\"", "").replace(":", "").replace(";", "").replace("(", "").replace(")", "").replace("!", "").replace("@", "").replace("#", "").replace("=", "").replace(">", "").replace("<", "").replace("'", "").replace("-", "").trim();
            temp.set(i, refinedLine);
            if (temp.get(i).equals(""))
                temp.set(i, yo);
        }
        for (int n = 0; n < temp.size(); n++){
            if(temp.get(n).substring(0,1).equals(".")|| temp.get(n).substring(0,1).equals("0") || temp.get(n).substring(0,1).equals("h"))
                temp.remove(n);
        }
        for (int x = 0; x < temp.size(); x++)
        {
            if(temp.get(x).contains("hey")) {
                    temp.remove(x);
            }
        }
        for(int h = 0; h < temp.size(); h++) {
            temp.set(h, temp.get(h).substring(0,temp.get(h).indexOf("+")));
        }
        for(int b = 0; b < temp.size(); b++)
            secretNums.add(0);
        for(int c = 0; c < temp.size(); c++)
            secretNums.set(c, Integer.parseInt(temp.get(c)));

        return secretNums;
    }
    public static String[] getStuffDone (Scanner work)
    {
        String s = work.nextLine();
        String[] r;
        if (s.contains("+"))
        {
            r = s.split("\\t");
            for (int a = 0; a < r.length; a++) {
                r[a] = r[a].replaceAll("\"", "");
            }

            return r;
        }
        return getStuffDone(work);
    }
    public static boolean decoder() throws IOException
    {
        try {
            Scanner j = new Scanner(new File("names.txt")); //won't work without names.txt
        }
        catch (java.io.FileNotFoundException e)
        {
            return false;
        }
        return true;

    }
    public static String[][] count() throws IOException
    {
        String[][] enigma;
        int count = 0;
        Scanner kb = new Scanner(new File("names.txt"));
        while (kb.hasNextLine())
        {
            count++;
            kb.nextLine();
        }
        if (count > 0)
            enigma = new String[count][];
        else
            enigma=null;
        kb = new Scanner(new File("names.txt"));
        for (int t = 0; t < count; t++)
        {
            enigma[t] = kb.nextLine().split("\\s+");
        }
        return enigma;
    }
    public static String search(String[][] b, int c)
    {

        String noName = "";
        String f = String.valueOf(c);
        if (b != null)
        {
            for (int row = 0; row < b.length; row++)
                for (int col = 0; col < b[row].length; col++) {
                    if (f.equalsIgnoreCase(b[row][col])) {
                        col--;
                        noName = b[row][col];
                        col++;
                    }
                }

        }
        return noName;

    }
}

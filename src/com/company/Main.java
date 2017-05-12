package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) throws IOException {
            //DONE
            int numOfLines = 28;
            boolean moveOn = readFile.decoder();
            String[][] stuff = null;
            if (moveOn == true)
                stuff = readFile.count();
            System.out.print("|Names|   " +  "|Secret #| " +  "|Avg Score| " + "|First FRQ| " + "|Second FRQ| " + "|First Avg| " +  "|Second Average| \n");
            Scanner reader = new Scanner(new File("rawDataU6.txt"));
            Calculations importantInfo[] = new Calculations[numOfLines];
            for (int i = 0; i < importantInfo.length; i++)
                importantInfo[i] = new Calculations(i + 1);
            String lines [] = null;
            for (int j = 0; j < numOfLines; j++) {
                if (j+1 != 15 && j+1 != 21 && j+1 != 25 && j+1 != 26)
                    Calculations.score(readFile.getStuffDone(reader), readFile.getStuffDone(reader), 0, 0, importantInfo[j], true);
                else {
                    lines = readFile.getStuffDone(reader);
                    Calculations.score(lines, lines, 0, 0, importantInfo[j], true);
                }
            }
            for (int k = 0; k < numOfLines; k++)
                Calculations.sout(importantInfo[k], stuff);
        }

}

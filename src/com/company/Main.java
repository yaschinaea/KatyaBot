package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final String FILENAME = "C:\\Users\\katya\\KatyaBot\\src\\com\\company\\answers.txt";

    public static void main(String[] args) {

        BufferedReader br = null;
        FileReader fr = null;
        String lastLine;

        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            Scanner scanner = new Scanner(System.in);
            ArrayList<String> array = new ArrayList<>();
            Random rand = new Random();

            System.out.println(br.readLine());

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                array.add(sCurrentLine);
            }

            boolean talk = true;
            lastLine = array.get(array.size()-1);

            while (true) {

                String input = scanner.nextLine();

                if ("GoodBuy".equals(input)) {
                    System.out.println(lastLine);
                    break;
                }

                if ("Stop talking".equals(input)) {
                    talk = false;
                }

                if ("Start talking".equals(input)) {
                    talk = true;
                    continue;
                }

                if(talk) {
                    int randomIndex = rand.nextInt(array.size()-1);
                    System.out.println(array.get(randomIndex));
                }

            }

            scanner.close();
        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

    }

}

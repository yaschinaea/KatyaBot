package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static String FILENAME = "C:\\Users\\katya\\KatyaBot\\src\\com\\company\\answers.txt";

    private static ArrayList<String> GetFile() {
        BufferedReader br = null;
        FileReader fr = null;

        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            ArrayList<String> array = new ArrayList<>();
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                array.add(sCurrentLine);
            }
            return array;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();

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

    public static void main(String[] args) {


        String lastLine;
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        ArrayList<String> array = GetFile();

        System.out.println(array.get(0));

        boolean talk = true;
        lastLine = array.get(array.size() - 1);

        while (true) {

            String input = scanner.nextLine();

            if (input.contains("Use another file:")) {
                FILENAME = input.substring(17);
                array = GetFile();
            }

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

            if (talk) {
                int randomIndex = rand.nextInt(array.size() - 2) + 1;
                System.out.println(array.get(randomIndex));
            }

        }

        scanner.close();
    }

}


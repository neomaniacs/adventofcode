package datastructures;


import java.io.*;
import java.util.logging.Logger;
import java.util.logging.Level ;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static File file = new File("src/main/resources/input.txt");

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Start algo") ;
        try {
            parseText(file) ;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Stop algo") ;
    }

    private static void parseText(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str ;
        int i = 1 ;
        int allSum = 0 ;
        while ((str = br.readLine()) != null) {
            String result = extractNumberAndSum(str) ;
            allSum = allSum + Integer.parseInt(result) ;
            // Print the string
            // System.out.println(String.format("[%d] %s --> %d", i, str, result));
            i++;
        }
        System.out.println(String.format("The final result is %d", allSum));
    }

    private static String extractNumberAndSum(String line) {
        // remove all characters except int
        String lineInt = line.replaceAll("[^0-9]", "") ;
        // System.out.println(String.format("%s --> %s", line, lineInt));
        // check length
        int lineIntLenght = lineInt.length() ;
        // if 1
        if(lineInt.length() == 1){
            return lineInt + lineInt ;
        } else { // else
            String first = lineInt.substring(0, 1) ;
            String last = lineInt.substring(lineInt.length()-1) ;
            return first + last ;
        }
    }
}
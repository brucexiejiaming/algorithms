package BlackRock;

//public class Main {
//
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//
//    }
//
//}


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    public static final String SEPARATOR = "@";
    public static final String COLON = ":";
    public static final DecimalFormat decimalFormat = new DecimalFormat("#.00");
    /*
     * Complete the function below.
     *
     * Note: The questions in this test build upon each other. We recommend you
     * copy your solutions to your text editor of choice before proceeding to
     * the next question as you will not be able to revisit previous questions.
     */

    static String generateTransactions(String inputString) {
        StringBuilder sb = new StringBuilder();
        String[] portfolio = inputString.split(Main.COLON)[0].split(Main.SEPARATOR);
        String[] benchMarks = inputString.split(Main.COLON)[1].split(Main.SEPARATOR);
        Arrays.sort(portfolio);
        Arrays.sort(benchMarks);  
        double portfolioTotalValues = calculatePortfolioTotalValues(portfolio, benchMarks);
        double benchmarkTotalValues = calculateBenchmarkTotalValues(benchMarks);

        for (int i = 0; i < benchMarks.length; i++) {
            String[] onePortfolio = portfolio[i].split(",");
            String[] oneBenchMark = benchMarks[i].split(",");
            
            int portfolioQuantity = Integer.parseInt(onePortfolio[2]);
            int benchmarkQuantity = Integer.parseInt(oneBenchMark[2]);
            
            double price = Double.parseDouble(oneBenchMark[3]);
            // Expected NAV
            double benchmarkNAV = (price * benchmarkQuantity) / benchmarkTotalValues;
            double difference = portfolioTotalValues * benchmarkNAV - price * portfolioQuantity;
            double quantity = difference / price;
            
            formatOneRow(sb, onePortfolio[0], quantity);
        }
        int len = sb.length();
        sb.delete(len - 2, len);
        
        return sb.toString();  
    }

    public static int calculatePortfolioTotalValues (String[] portfolio, String[] benchMarks) {
        int totalValues = 0;
        for (int i = 0; i < benchMarks.length; i++) {
            String[] onePortfolio = portfolio[i].split(",");
            String[] oneBenchMark = benchMarks[i].split(",");
            
            int quantity = Integer.parseInt(onePortfolio[2]);
            double price = Double.parseDouble(oneBenchMark[3]);
            double values = quantity * price;
            totalValues += values;
        }
        return totalValues;
    }
    
    public static int calculateBenchmarkTotalValues (String[] benchMarks) {
        int totalValues = 0;
        for (int i = 0; i < benchMarks.length; i++) {
            String[] oneBenchMark = benchMarks[i].split(",");
            
            int quantity = Integer.parseInt(oneBenchMark[2]);
            double price = Double.parseDouble(oneBenchMark[3]);
            double values = quantity * price;
            totalValues += values;
        }
        return totalValues;
    }
    
    public static void formatOneRow (StringBuilder sb, String symbol, double quantity) {
        sb.append("[");
        if (quantity > 0.0) {
            sb.append("BUY, ");
        } else {
            sb.append("SELL, ");
        }
        sb.append(symbol);
        sb.append(", ");
        sb.append(Main.decimalFormat.format(quantity));
        sb.append("], ");
    }

    public static void main(String[] args) throws IOException{
        String res;
        //String _input = "VOD,Vodafone,10@GOOG,Google,15@MSFT,Microsoft,12:VOD,Vodafone,16,2@GOOG,Google,10,5@MSFT,Microsoft,25,6";
        String _input = "RIO,RIO TINTO PLC,746@AAL,ANGLO AMERICAN PLC,271:RIO,RIO TINTO PLC,688,13.9@AAL,ANGLO AMERICAN PLC,293,49.7";
        res = generateTransactions(_input);
        System.out.println(res);
    }
    
    
}
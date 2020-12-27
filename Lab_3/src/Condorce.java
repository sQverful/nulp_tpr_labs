import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Condorce {
    public static void main(String[] args) {

        String input = Util.readFile("part3.txt");
        System.out.println(condorce(input));
        
    }

    public static String condorce(String input) {
        StringBuilder sbResult = new StringBuilder();
        Pattern pattern = Pattern.compile(".+");
        Matcher matcher = pattern.matcher(input);

        String[][] values = new String[5][4];
        int pointer = 0;

        String temp;

        while (matcher.find()) {
            temp = matcher.group();
            values[pointer] = temp.split(",");
            pointer++;
        }

        int AB = 0;
        int AC = 0;
        int BA = 0;
        int BC = 0;
        int CA = 0;
        int CB = 0;

        Bord.Element[] elValues = new Bord.Element[5];

        for (int i = 0; i < 5; i++) {
            elValues[i] = new Bord.Element();
            elValues[i].value = Integer.parseInt(values[i][0]);
            for (int j = 0; j < values[i].length; j++) {
                int tp = j;
                if (values[i][j].contains("A")) {
                    elValues[i].index_A = (tp - 3) * -1;
                } else if (values[i][j].contains("B")) {
                    elValues[i].index_B = (tp - 3) * -1;
                } else if (values[i][j].contains("C")) {
                    elValues[i].index_C = (tp - 3) * -1;
                }
            }
        }


        for (int i = 0; i < elValues.length; i++) {
            if (elValues[i].index_A > elValues[i].index_B) {
                AB += elValues[i].value;
            } else {
                BA += elValues[i].value;
            }

            if (elValues[i].index_A > elValues[i].index_C) {
                AC += elValues[i].value;
            } else {
                CA += elValues[i].value;
            }

            if (elValues[i].index_B > elValues[i].index_C) {
                BC += elValues[i].value;
            } else {
                CB += elValues[i].value;
            }
        }

        sbResult.append("A>B = " + AB + " A>C = " + AC + " B>A = " + BA + " B>C = " + BC + " C>A = " + CA + " C>B = " + CB);

        int totalA = AB + BC;
        int totalB = BC + BA;
        int totalC = CB + CA;

        if (totalA > totalB && totalA > totalC) {
            sbResult.append(" Winner: A");
        }
        if (totalB > totalA && totalB > totalC) {
            sbResult.append(" Winner: B");
        }
        if (totalC > totalB && totalC > totalA) {
            sbResult.append(" Winner: C");
        }



        return sbResult.toString();
    }


    public static class Element extends Object {

        Element() {

        }
        int value;
        int index_A;
        int index_B;
        int index_C;

    }

}

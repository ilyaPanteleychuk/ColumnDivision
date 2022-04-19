package ua.com.foxminded.iliapanteleychuk.integerdivision.math;

import ua.com.foxminded.iliapanteleychuk.integerdivision.dataToDraw.Result;
import ua.com.foxminded.iliapanteleychuk.integerdivision.dataToDraw.Step;
import java.util.ArrayList;
import java.util.List;


public class Divider {

    public Result divide(int dividend, int divisor) {
        List<Step> steps = new ArrayList<>();
        char[] dividendArray = String.valueOf(dividend).toCharArray();
        int divisionResult = dividend / divisor;
        int i = 0;
        int k = 0;
        int position;
        int previousPosition;
        int partialDividend = Integer.parseInt(String.valueOf(dividendArray[0]));
        while (i <= dividendArray.length - 1) {
            position = k;
            if (partialDividend == 0) {
                partialDividend = Integer.parseInt(String.valueOf(dividendArray[i]));
            }
            while (partialDividend < divisor) {
                if (i < dividendArray.length - 1) {
                    partialDividend = Integer.parseInt(partialDividend +
                        String.valueOf(dividendArray[i + 1]));
                    i++;
                }
                if (partialDividend < divisor && i == dividendArray.length - 1) {
                    break;
                }
            }
            previousPosition = k;
            k = countPosition(partialDividend, divisor, previousPosition);
            if (partialDividend % divisor == 0) {
                i++;
            }
            if (partialDividend >= divisor) {
                addStep(partialDividend, divisor, position, steps);
                partialDividend = partialDividend % divisor;
            }
            if (i == dividendArray.length - 1) {
                position = k;
                addStep(partialDividend, divisor, position, steps);
                i++;
            }
        }
        return new Result(dividend, divisor, steps, divisionResult);
    }

    private int countPosition(int partialDividend, int divisor, int previousPosition){
        int k;
        int partialDividendLength = String.valueOf(partialDividend).length();
        int nextElementLength = String.valueOf(partialDividend % divisor).length();
        if(partialDividend % divisor != 0) {
            k = (partialDividendLength - nextElementLength) + previousPosition;
        }else {
            k = partialDividendLength + previousPosition;
        }
        return k;
    }

    private List<Step> addStep(int partialDividend, int divisor, int position, List<Step> steps){
        Step step = new Step(position, partialDividend,
            partialDividend - (partialDividend % divisor));
        steps.add(step);
        return steps;
    }
}

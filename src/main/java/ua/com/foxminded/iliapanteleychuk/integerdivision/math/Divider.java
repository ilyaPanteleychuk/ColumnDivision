package ua.com.foxminded.iliapanteleychuk.integerdivision.math;

import ua.com.foxminded.iliapanteleychuk.integerdivision.pattern.Result;
import ua.com.foxminded.iliapanteleychuk.integerdivision.pattern.Step;
import java.util.ArrayList;
import java.util.List;


public class Divider {

    List<Step> steps = new ArrayList<>();
    public Result divide(int dividend, int divisor) {
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
            int partialDividendLength = String.valueOf(partialDividend).length();
            int nextElementLength = String.valueOf(partialDividend % divisor).length();
            if(partialDividend % divisor != 0) {
                k = (partialDividendLength - nextElementLength) + previousPosition;
            }else {
                k = partialDividendLength + previousPosition;
            }
            if (partialDividend % divisor == 0) {
                i++;
            }
            if (partialDividend >= divisor) {
                Step step = new Step(position, partialDividend,
                    partialDividend - (partialDividend % divisor));
                steps.add(step);
                partialDividend = partialDividend % divisor;
            }
            if (i == dividendArray.length - 1) {
                position = k;
                Step step = new Step(position, partialDividend,
                    partialDividend - (partialDividend % divisor));
                steps.add(step);
                i++;
            }
        }
        return new Result(dividend, divisor, steps, divisionResult);
    }
}

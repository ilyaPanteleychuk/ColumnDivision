package ua.com.foxminded.iliapanteleychuk.integerdivision.math;

import ua.com.foxminded.iliapanteleychuk.integerdivision.pattern.Result;
import ua.com.foxminded.iliapanteleychuk.integerdivision.pattern.Step;
import java.util.ArrayList;
import java.util.List;

public class Divider {

    List<Step> steps = new ArrayList<>();

    public Result divide(int dividend, int divisor) {
        char[] dividendArray = String.valueOf(dividend).toCharArray();
        int i = 0;
        int position;
        int partialDividend = Integer.parseInt(String.valueOf(dividendArray[0]));
        int divisionResult = dividend / divisor;
        while (i < dividendArray.length - 1) {
            position = i;
            if (partialDividend == 0) {
                partialDividend = Integer.parseInt(String.valueOf(dividendArray[i]));
            }
            while (partialDividend < divisor) {
                if (i < dividendArray.length - 1) {
                    partialDividend = Integer.parseInt(partialDividend + String.valueOf(dividendArray[i + 1]));
                    i++;
                }
                if (partialDividend < divisor && i == dividendArray.length - 1) {
                    break;
                }
            }
            if (partialDividend % divisor == 0)
                i++;
            if (partialDividend >= divisor) {
                System.out.println(position);
                System.out.println(partialDividend);
                System.out.println((partialDividend - (partialDividend % divisor)));
                System.out.println();
                Step step = new Step(position, partialDividend, partialDividend - (partialDividend % divisor));
                steps.add(step);
                partialDividend = partialDividend % divisor;
            }
            partialDividend = partialDividend % divisor;
            if (i == dividendArray.length - 1) {
                System.out.println(position);
                System.out.println(partialDividend);
                System.out.println((partialDividend - (partialDividend % divisor)));
                System.out.println();
                Step step = new Step(position + 1, partialDividend, partialDividend - (partialDividend % divisor));
                steps.add(step);
            }
        }
        return new Result(dividend, divisor, steps, divisionResult);
    }
}

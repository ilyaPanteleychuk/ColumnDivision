package ua.com.foxminded.iliapanteleychuk.integerdivision.math;

import ua.com.foxminded.iliapanteleychuk.integerdivision.pattern.Result;

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
            if (partialDividend % divisor == 0) i++;

            if (partialDividend >= divisor) {
                Step step = new Step(position,partialDividend,partialDividend -(partialDividend % divisor));
                steps.add(step);
                System.out.println(1);
                partialDividend = partialDividend % divisor;
            }
            partialDividend = partialDividend % divisor;
            if (i == dividendArray.length - 1) {
                Step step = new Step(position,partialDividend, partialDividend - (partialDividend % divisor));
                steps.add(step);
            }
        }
        return new Result(dividend,divisor,steps,divisionResult);
    }

    public static class Step {

        private final int POSITION;
        private final int PARTIAL_DIVIDEND;
        private final int INTEGRAL_PARTIAL_DIVIDEND;

        public Step(int POSITION, int PARTIAL_DIVIDEND, int INTEGRAL_PARTIAL_DIVIDEND) {
            this.POSITION = POSITION;
            this.PARTIAL_DIVIDEND = PARTIAL_DIVIDEND;
            this.INTEGRAL_PARTIAL_DIVIDEND = INTEGRAL_PARTIAL_DIVIDEND;
        }

        public int getPOSITION() {
            return POSITION;
        }

        public int getPARTIAL_DIVIDEND() {
            return PARTIAL_DIVIDEND;
        }

        public int getINTEGRAL_PARTIAL_DIVIDEND() {
            return INTEGRAL_PARTIAL_DIVIDEND;
        }
    }
}

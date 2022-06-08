package ua.com.foxminded.iliapanteleychuk.integerdivision.math;

import ua.com.foxminded.iliapanteleychuk.integerdivision.model.DivisionResult;
import ua.com.foxminded.iliapanteleychuk.integerdivision.model.Step;
import java.util.ArrayList;
import java.util.List;


public class Divider {

    public DivisionResult divide(int dividend, int divisor){
        List<Step> steps = init(dividend, divisor);
        return new DivisionResult(dividend, divisor, steps, (dividend / divisor));
    }

    private List<Step> init(int dividend, int divisor){
        List<Integer> positions = countPosition(dividend,divisor);
        List<Integer> partialDividends = countPartialDividend(dividend, divisor);
        List<Integer> integralDividends = countIntegralPartialDividend(dividend, divisor);
        return addStep(positions, partialDividends, integralDividends);
    }

    private List<Step> addStep(List<Integer> positions, List<Integer> partials,
                               List<Integer> integralPartials) {
        List<Step> steps = new ArrayList<>();
        for(int i = 0; i < partials.size(); i++){
            Step step = new Step(positions.get(i), partials.get(i), integralPartials.get(i));
            steps.add(step);
        }
        return steps;
    }

    private List<Integer> countPartialDividend(int dividend, int divisor){
        List<Integer> partialDividends = new ArrayList<>();
        char[] dividendArray = String.valueOf(dividend).toCharArray();
        int partialDividend = Integer.parseInt(String.valueOf(dividendArray[0]));
        int counter = 0;
        while(counter <= dividendArray.length - 1) {
            if (partialDividend == 0) {
                partialDividend = Integer.parseInt(String.valueOf(dividendArray[counter]));
            }
            while(partialDividend < divisor) {
                if(counter < dividendArray.length - 1) {
                    partialDividend = Integer.parseInt(partialDividend +
                            String.valueOf(dividendArray[counter + 1]));
                    counter++;
                }
                if(partialDividend < divisor && counter == dividendArray.length - 1) {
                    counter++;
                    break;
                }
            }
            if (partialDividend % divisor == 0) {
                counter++;
            }
            partialDividends.add(partialDividend);
            partialDividend = partialDividend % divisor;
        }
        return partialDividends;
    }

    private List<Integer> countIntegralPartialDividend(int dividend, int divisor){
        List<Integer> integralPartialDividends = new ArrayList<>();
        List<Integer> partialDividends = countPartialDividend(dividend, divisor);
        for(Integer partialDividend : partialDividends) {
            int integralPartialDividend = partialDividend -
                        (partialDividend % divisor);
            integralPartialDividends.add(integralPartialDividend);
        }
        return integralPartialDividends;
    }

    private List<Integer> countPosition(int dividend, int divisor){
        List<Integer> positions = new ArrayList<>();
        List<Integer> partialDividends = countPartialDividend(dividend, divisor);
        int counter = 0;
        int positionCounter = 0;
        int position;
        int previousPosition;
        while(counter < partialDividends.size()){
            position = positionCounter;
            previousPosition = positionCounter;
            int partialDividendLength = String.valueOf
                                            (partialDividends.get(counter)).length();
            int nextElementLength = String.valueOf
                                    (partialDividends.get(counter) % divisor).length();
            if(partialDividends.get(counter) % divisor != 0) {
                positionCounter = (partialDividendLength - nextElementLength)
                        + previousPosition;
            }else {
                positionCounter = partialDividendLength + previousPosition;
            }
            counter++;
            positions.add(position);
        }
        return positions;
    }
}

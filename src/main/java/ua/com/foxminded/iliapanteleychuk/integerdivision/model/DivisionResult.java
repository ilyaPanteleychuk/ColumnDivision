package ua.com.foxminded.iliapanteleychuk.integerdivision.model;

import java.util.List;


public class DivisionResult {

    private final int dividend;
    private final int divisor;
    private final List<Step> stepsList;
    private final int resultOfDivision;

    public DivisionResult(int dividend, int divisor, List<Step> stepsList, int resultOfDivision) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.stepsList = stepsList;
        this.resultOfDivision = resultOfDivision;
    }

    public int getDividend() {
        return dividend;
    }

    public int getDivisor() {
        return divisor;
    }

    public List<Step> getStepsList() {
        return stepsList;
    }

    public int getResultOfDivision() {
        return resultOfDivision;
    }
}

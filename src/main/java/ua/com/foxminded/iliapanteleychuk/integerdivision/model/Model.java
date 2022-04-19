package ua.com.foxminded.iliapanteleychuk.integerdivision.model;

import java.util.List;


public class Model {

    private final int dividend;
    private final int divisor;
    private final List<Step> stepsList;
    private final int divisionResult;

    public Model(int dividend, int divisor, List<Step> stepsList, int divisionResult) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.stepsList = stepsList;
        this.divisionResult = divisionResult;
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

    public int getDivisionResult() {
        return divisionResult;
    }
}

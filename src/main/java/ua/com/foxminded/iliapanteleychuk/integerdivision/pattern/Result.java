package ua.com.foxminded.iliapanteleychuk.integerdivision.pattern;

import java.util.List;


public class Result {

    private final int DIVIDEND;
    private final int DIVISOR;
    private final List<Step> stepsList;
    private final int DIVISION_RESULT;

    public Result(int DIVIDEND, int DIVISOR, List<Step> stepsList, int DIVISION_RESULT) {
        this.DIVIDEND = DIVIDEND;
        this.DIVISOR = DIVISOR;
        this.stepsList = stepsList;
        this.DIVISION_RESULT = DIVISION_RESULT;
    }

    public int getDIVIDEND() {
        return DIVIDEND;
    }

    public int getDIVISOR() {
        return DIVISOR;
    }

    public List<Step> getStepsList() {
        return stepsList;
    }

    public int getDIVISION_RESULT() {
        return DIVISION_RESULT;
    }
}

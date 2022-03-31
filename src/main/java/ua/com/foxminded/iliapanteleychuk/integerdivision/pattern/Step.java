package ua.com.foxminded.iliapanteleychuk.integerdivision.pattern;

import java.util.Objects;


public class Step {

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

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Step step = (Step) o;
        return POSITION == step.POSITION && PARTIAL_DIVIDEND == step.PARTIAL_DIVIDEND
                        && INTEGRAL_PARTIAL_DIVIDEND == step.INTEGRAL_PARTIAL_DIVIDEND;
    }

    @Override
    public int hashCode() {
        return Objects.hash(POSITION, PARTIAL_DIVIDEND, INTEGRAL_PARTIAL_DIVIDEND);
    }
}

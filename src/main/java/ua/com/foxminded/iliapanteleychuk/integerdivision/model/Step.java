package ua.com.foxminded.iliapanteleychuk.integerdivision.model;

import java.util.Objects;


public class Step {

    private final int position;
    private final int partialDividend;
    private final int integralPartialDividend;

    public Step(int position, int partialDividend, int integralPartialDividend) {
        this.position = position;
        this.partialDividend = partialDividend ;
        this.integralPartialDividend = integralPartialDividend;
    }

    public int getPosition() {
        return position;
    }

    public int getPartialDividend() {
        return partialDividend;
    }

    public int getIntegralPartialDividend() {
        return integralPartialDividend;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Step step = (Step) o;
        return position == step.position && partialDividend == step.partialDividend
                            && integralPartialDividend == step.integralPartialDividend;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, partialDividend, integralPartialDividend);
    }
}

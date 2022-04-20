package ua.com.foxminded.iliapanteleychuk.integerdivision.format;

import ua.com.foxminded.iliapanteleychuk.integerdivision.model.DivisionResult;
import ua.com.foxminded.iliapanteleychuk.integerdivision.model.Step;
import java.util.List;
import static java.lang.System.lineSeparator;


public class ClassicFormatter implements Formatter {

    private static final String WHITE_SPACE = " ";
    private final StringBuilder output = new StringBuilder();

    @Override
    public String format(DivisionResult divisionResult) {
        List<Step> steps = divisionResult.getStepsList();
        drawHeader(divisionResult);
        steps.remove(0);
        drawStep(divisionResult);
        return output.toString();
    }

    private void drawHeader(DivisionResult model) {
        List<Step> steps = model.getStepsList();
        Step firstStep = steps.get(0);
        int dividend = model.getDividend();
        int divisor = model.getDivisor();
        int divisionResult = model.getResultOfDivision();
        int firstPartialDividend = firstStep.getPartialDividend();
        int firstIntegralPartialDividend = firstStep.getIntegralPartialDividend();
        output.append("_")
              .append(dividend)
              .append("|")
              .append(divisor)
              .append(lineSeparator());

        output.append(" ")
              .append(firstIntegralPartialDividend)
              .append(drawIndent(getIntLength(dividend) -
                     getIntLength(firstPartialDividend)))
              .append("|");
        if(getIntLength(divisor) > getIntLength(divisionResult)){
                 output.append(drawSymbol('-', getIntLength(divisor)))
                       .append(lineSeparator());
        }else{
                 output.append(drawSymbol('-', getIntLength(divisionResult)))
                       .append(lineSeparator());
        }
        output.append(" ")
              .append(drawSymbol('-',
                     getIntLength(firstIntegralPartialDividend)))
              .append(drawIndent(getIntLength(dividend) -
                     getIntLength(firstPartialDividend)))
              .append("|")
              .append(divisionResult)
              .append(lineSeparator());
        if(steps.size() == 1 && firstPartialDividend == firstIntegralPartialDividend){
            output.append(WHITE_SPACE)
                  .append("0");
        }
    }

    private void drawStep(DivisionResult divisionResult) {
        List<Step> steps = divisionResult.getStepsList();
        int divisor = divisionResult.getDivisor();
        while (!(steps.isEmpty())) {
            int partialDividend = steps.get(0).getPartialDividend();
            int integralPartialDividend = steps.get(0).getIntegralPartialDividend();
            int position = steps.get(0).getPosition();
            if (partialDividend < divisor) {
                output.append(WHITE_SPACE)
                      .append(drawIndent(position))
                      .append(partialDividend)
                      .append(lineSeparator());
                steps.remove(0);
                break;
            }
            output.append('_')
                  .append(drawIndent(position))
                  .append(partialDividend)
                  .append(lineSeparator());

            if (getIntLength(integralPartialDividend) <
                        getIntLength(partialDividend)) {
                output.append(WHITE_SPACE)
                      .append(drawIndent(position +
                          (getIntLength(partialDividend) - getIntLength(integralPartialDividend))))
                      .append(integralPartialDividend)
                      .append(lineSeparator());

                output.append(WHITE_SPACE)
                      .append(drawIndent(position +
                          (getIntLength(partialDividend) - getIntLength(integralPartialDividend))))
                      .append(drawSymbol('-',
                             getIntLength(integralPartialDividend)))
                      .append(lineSeparator());

            }else {
                output.append(WHITE_SPACE)
                       .append(drawIndent(position))
                       .append(integralPartialDividend)
                       .append(lineSeparator());

                output.append(WHITE_SPACE)
                      .append(drawIndent(position))
                      .append(drawSymbol('-',
                             getIntLength(integralPartialDividend)))
                      .append(lineSeparator());
            }
            if(steps.size() == 1 && partialDividend == integralPartialDividend){
                output.append(WHITE_SPACE)
                      .append(drawIndent(position + getIntLength(partialDividend) - 1))
                      .append("0");
            }
            steps.remove(0);
            drawStep(divisionResult);
        }
    }

    private String drawIndent(int times) {
        return WHITE_SPACE.repeat(times);
    }

    private int getIntLength(int num) {
        return String.valueOf(num).length();
    }

    private String drawSymbol(char symbol, int times) {
        return String.valueOf(symbol).repeat(times);
    }
}

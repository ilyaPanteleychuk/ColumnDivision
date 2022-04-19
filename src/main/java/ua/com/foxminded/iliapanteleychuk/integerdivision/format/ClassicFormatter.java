package ua.com.foxminded.iliapanteleychuk.integerdivision.format;

import ua.com.foxminded.iliapanteleychuk.integerdivision.dataToDraw.Result;
import ua.com.foxminded.iliapanteleychuk.integerdivision.dataToDraw.Step;
import java.util.List;
import static java.lang.System.lineSeparator;


public class ClassicFormatter implements Formatter {

    private static final String WHITE_SPACE = " ";
    private final StringBuilder output = new StringBuilder();

    @Override
    public String format(Result result) {
        List<Step> steps = result.getStepsList();
        drawHeader(result);
        steps.remove(0);
        drawStep(result);
        return output.toString();
    }

    private void drawHeader(Result result) {
        List<Step> steps = result.getStepsList();
        Step firstStep = steps.get(0);
        int dividend = result.getDividend();
        int divisor = result.getDivisor();
        int divisionResult = result.getDivisionResult();
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

    private void drawStep(Result result) {
        List<Step> steps = result.getStepsList();
        int divisor = result.getDivisor();
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
            drawStep(result);
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

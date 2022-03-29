package ua.com.foxminded.iliapanteleychuk.integerdivision.format;

import ua.com.foxminded.iliapanteleychuk.integerdivision.pattern.Result;
import ua.com.foxminded.iliapanteleychuk.integerdivision.pattern.Step;
import java.util.List;
import static java.lang.System.lineSeparator;

public class ClassicFormatter implements Formatter {

    public static final String WHITE_SPACE = " ";
    private final StringBuilder output = new StringBuilder();

    @Override
    public String format(Result result) {
        List<Step> steps = result.getStepsList();
        drawHeader(result);
        steps.remove(0);
        drawStep(result);
        return output.toString();
    }

    public void drawHeader(Result result) {
        Step firstStep = result.getStepsList().get(0);
        int dividend = result.getDIVIDEND();
        int divisor = result.getDIVISOR();
        int divisionResult = result.getDIVISION_RESULT();
        int firstPartialDividend = firstStep.getPARTIAL_DIVIDEND();
        int firstIntegralPartialDividend = firstStep.getINTEGRAL_PARTIAL_DIVIDEND();
        output.append("_")
              .append(dividend)
              .append("|").append(divisor)
              .append(lineSeparator());
        
        output.append(" ")
              .append(firstIntegralPartialDividend)
              .append(drawIndent(getIntLength(dividend) - getIntLength(firstPartialDividend)))
              .append("|")
              .append(drawSymbol('-', getIntLength(divisor)))
              .append(lineSeparator());
        
        output.append(" ")
              .append(drawSymbol('-', getIntLength(firstIntegralPartialDividend)))
              .append(drawIndent(getIntLength(dividend) - getIntLength(firstPartialDividend)))
              .append("|")
              .append(divisionResult)
              .append(lineSeparator());
    }

    private void drawStep(Result result) {
        List<Step> steps = result.getStepsList();
        int divisor = result.getDIVISOR();
        while (!(steps.isEmpty())) {
            if (steps.get(0).getPARTIAL_DIVIDEND() < divisor) {
                output.append(WHITE_SPACE)
                      .append(drawIndent(steps.get(0).getPOSITION()))
                      .append(steps.get(0).getPARTIAL_DIVIDEND())
                      .append(lineSeparator());
                steps.remove(0);
                break;
            }
            output.append('_')
                  .append(drawIndent(steps.get(0).getPOSITION() ))
                  .append(steps.get(0).getPARTIAL_DIVIDEND())
                  .append(lineSeparator());

            if (getIntLength(steps.get(0).getINTEGRAL_PARTIAL_DIVIDEND()) < getIntLength(
                    steps.get(0).getPARTIAL_DIVIDEND())) {
                output.append(WHITE_SPACE)
                      .append(drawIndent(steps.get(0).getPOSITION() + 
                              (getIntLength(steps.get(0).getPARTIAL_DIVIDEND()) - 
                                      getIntLength(steps.get(0).getINTEGRAL_PARTIAL_DIVIDEND()))))
                      .append(steps.get(0).getINTEGRAL_PARTIAL_DIVIDEND())
                      .append(lineSeparator());
                
                output.append(WHITE_SPACE)
                .append(drawIndent(steps.get(0).getPOSITION() + 
                        (getIntLength(steps.get(0).getPARTIAL_DIVIDEND()) - 
                                getIntLength(steps.get(0).getINTEGRAL_PARTIAL_DIVIDEND()))))
                .append(drawSymbol('-', getIntLength(steps.get(0).getINTEGRAL_PARTIAL_DIVIDEND())))
                .append(lineSeparator());
                
            }else {
                output.append(WHITE_SPACE)
                       .append(drawIndent(steps.get(0).getPOSITION()))
                       .append(steps.get(0).getINTEGRAL_PARTIAL_DIVIDEND())
                       .append(lineSeparator());
                
                output.append(WHITE_SPACE)
                      .append(drawIndent(steps.get(0).getPOSITION()))
                      .append(drawSymbol('-', getIntLength(steps.get(0).getINTEGRAL_PARTIAL_DIVIDEND())))
                      .append(lineSeparator());
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

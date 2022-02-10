package ua.com.foxminded.iliapanteleychuk.integerdivision.format;

import ua.com.foxminded.iliapanteleychuk.integerdivision.math.Divider;
import ua.com.foxminded.iliapanteleychuk.integerdivision.pattern.Result;

import java.util.List;

public class ClassicFormatter implements Formatter {

    private static final String LS = System.lineSeparator();
    private static final String WHITE_SPACE = " ";
    private static final String ELIMINATOR = "-";
    StringBuilder output;

    @Override
    public StringBuilder format(Result result) {
        List<Divider.Step> steps = result.getStepsList();
        output = new StringBuilder();
        headPainter(result);

        for (int i = 1; i < steps.size(); i++) {
            String line;
            if (i == steps.size() - 1) {
                line = WHITE_SPACE.repeat(steps.get(i).getPOSITION() + 1) + "_" + steps.get(i).getPARTIAL_DIVIDEND() + LS
                    + WHITE_SPACE.repeat(steps.get(i).getPOSITION() + 2)
                    + steps.get(i).getINTEGRAL_PARTIAL_DIVIDEND() + LS;
                output.append(line);
            } else if (steps.get(i).getPOSITION() != 0) {
                line = WHITE_SPACE.repeat(steps.get(i).getPOSITION()) + "_" + steps.get(i).getPARTIAL_DIVIDEND() + LS
                    + WHITE_SPACE.repeat(steps.get(i).getPOSITION() + 1)
                    + steps.get(i).getINTEGRAL_PARTIAL_DIVIDEND() + LS + WHITE_SPACE.repeat(steps.get(i).getPOSITION() + 1)
                    + ELIMINATOR.repeat(String.valueOf(steps.get(i).getPARTIAL_DIVIDEND()).length()) + LS;
                output.append(line);
            } else {
                line = "_" + steps.get(i).getPARTIAL_DIVIDEND() + LS + WHITE_SPACE
                    + steps.get(i).getINTEGRAL_PARTIAL_DIVIDEND() + LS
                    + WHITE_SPACE.repeat(steps.get(i).getPOSITION() + 1) + ELIMINATOR.repeat(String.valueOf(steps.get(i).getPARTIAL_DIVIDEND()).length()) + LS;
                output.append(line);
            }

        }

        return output;
    }

    private void headPainter(Result result) {
        List<Divider.Step> steps = result.getStepsList();
        int divisionResult = result.getDIVISION_RESULT();
        int dividend = result.getDIVIDEND();
        int divisor = result.getDIVISOR();
        int partialDividend = steps.get(0).getPARTIAL_DIVIDEND();
        int integralPatialDividend = steps.get(0).getINTEGRAL_PARTIAL_DIVIDEND();
        String firstLine = "_" + dividend + "|" + divisor + LS;
        output.append(firstLine);
        String secondLine = WHITE_SPACE + integralPatialDividend + WHITE_SPACE.repeat(String.valueOf(dividend).length() - String.valueOf(integralPatialDividend).length()) + "|"
            + ELIMINATOR.repeat(String.valueOf(divisionResult).length()) + LS;
        output.append(secondLine);
        String thirdLine = WHITE_SPACE
            + ELIMINATOR.repeat(String.valueOf(integralPatialDividend).length())
            + WHITE_SPACE.repeat(String.valueOf(dividend).length() - String.valueOf(integralPatialDividend).length()) + "|" + result.getDIVISION_RESULT() + LS;
        output.append(thirdLine);
    }

}

package ua.com.foxminded.iliapanteleychuk.integerdivision;

import ua.com.foxminded.iliapanteleychuk.integerdivision.exeption.BadArgsException;
import ua.com.foxminded.iliapanteleychuk.integerdivision.format.Formatter;
import ua.com.foxminded.iliapanteleychuk.integerdivision.math.Divider;
import ua.com.foxminded.iliapanteleychuk.integerdivision.pattern.Result;




public class Main {

    public static void main(String[] args) {

        Context context = new Context();
        try {
            context.newObject(args);
        } catch (BadArgsException e) {
            System.out.printf(e.getMessage());
            System.exit(1);
        }
        Divider divider = context.getDivider();
        Result result = divider.divide(context.getDividend(), context.getDivisor());
        Formatter formatter = context.getFormatters();
        StringBuilder outPut = formatter.format(result);
        System.out.println(outPut);
    }
}

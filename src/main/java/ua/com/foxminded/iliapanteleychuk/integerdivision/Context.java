package ua.com.foxminded.iliapanteleychuk.integerdivision;

import ua.com.foxminded.iliapanteleychuk.integerdivision.format.ClassicFormatter;
import ua.com.foxminded.iliapanteleychuk.integerdivision.format.Formatter;
import ua.com.foxminded.iliapanteleychuk.integerdivision.math.Divider;

public class Context {
    private static final int AMOUNT_OF_ARGUMENTS = 2;
    private static int dividend;
    private static int divisor;
    public Context newObject(String[] args){
    ArgumentsValidator.validate(args);
    setDividend(Integer.parseInt(args[0]));
    setDivisor(Integer.parseInt(args[1]));
    return new Context();
    }

    public static void setDividend(int dividend){
        Context.dividend = dividend;
    }

    public static void setDivisor(int divisor){
        Context.divisor = divisor;
    }

    public static int getAMOUNTOFARGUMENTS() {
        return AMOUNT_OF_ARGUMENTS;
    }

    public int getDividend() {
        return dividend;
    }

    public int getDivisor() {
        return divisor;
    }
    public Divider getDivider(){
        return new Divider();
    }
    public Formatter getFormatters(){
        return new ClassicFormatter();

    }
}

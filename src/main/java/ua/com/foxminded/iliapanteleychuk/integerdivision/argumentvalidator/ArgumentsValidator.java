package ua.com.foxminded.iliapanteleychuk.integerdivision.argumentvalidator;


import ua.com.foxminded.iliapanteleychuk.integerdivision.exception.BadArgsException;

public class ArgumentsValidator {

    public static void validate(String[] args) {
        isArgumentsEmpty(args);
        isRightAmountOfArguments(args);
        isArgumentsAreDigital(args);
        isSecondArgumentIsNotZero(args);
        isFistArgumentIsNotLessThanSecond(args);
    }

    private static void isArgumentsEmpty(String[] args) {
        if (args.length == 0) {
            throw new BadArgsException("Bad arguments. Write at least 2 ones");
        }
    }

    private static void isArgumentsAreDigital(String[] args) {
        try {
            for (int i = 0; i < args.length; i++) {
                Integer.parseInt(args[i]);
            }
        } catch (NumberFormatException exception) {
            throw new BadArgsException("Bad arguments. " +
                "Use only numeric arguments");
        }
    }

    private static void isRightAmountOfArguments(String[] args) {
        if (args.length != 2) {
            throw new BadArgsException("Bad arguments. Write only 2 of them");
        }
    }

    private static void isSecondArgumentIsNotZero(String[] args) {
        if (Integer.parseInt(args[1]) == 0) {
            throw new BadArgsException("Bad arguments. " +
                "The second argument can`t be zero");
        }
    }

    private static void isFistArgumentIsNotLessThanSecond(String[] args){
        if(Integer.parseInt(args[0]) < Integer.parseInt(args[1])){
            throw new BadArgsException("Bad arguments. " +
                "The fist argument is supposed to be greater");
        }
    }
}

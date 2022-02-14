package ua.com.foxminded.iliapanteleychuk.integerdivision;

import ua.com.foxminded.iliapanteleychuk.integerdivision.exeption.BadArgsException;

public class ArgumentsValidator {

    public static void validate(String[] args){
    isArgumetsEmpty(args);
    isRigthAmountOfAgruments(args);
    isArgumentsAreDigital(args);
    isSecondArgumentIsNotZero(args);
    }
    private static void isArgumetsEmpty(String[] args){
        if(args.length == 0){
            throw new BadArgsException("Bad arguments. Write at least 2 ones");
        }
    }
    private static void isArgumentsAreDigital(String[] args){
        try{
            for(int i = 0; i < args.length; i++){
                Integer.parseInt(args[i]);
            }
        }catch (NumberFormatException exception){
            throw new BadArgsException("Bad arguments. Use only numeric arguments");
        }
    }
    private static void isRigthAmountOfAgruments(String[] args){
        if(args.length != Context.getAMOUNTOFARGUMENTS()){
            throw new BadArgsException("Bad arguments. Write only 2 of them");
        }
    }
    private static void isSecondArgumentIsNotZero(String[] args) {
        if(Integer.parseInt(args[1]) == 0 ){
            throw new BadArgsException("Bad arguments. The second argument can`t be zero");
        }
    }

}

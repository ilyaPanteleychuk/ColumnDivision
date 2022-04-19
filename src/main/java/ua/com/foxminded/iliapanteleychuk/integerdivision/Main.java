package ua.com.foxminded.iliapanteleychuk.integerdivision;

import ua.com.foxminded.iliapanteleychuk.integerdivision.argumentvalidator.ArgumentsValidator;
import ua.com.foxminded.iliapanteleychuk.integerdivision.exception.BadArgsException;
import ua.com.foxminded.iliapanteleychuk.integerdivision.format.ClassicFormatter;
import ua.com.foxminded.iliapanteleychuk.integerdivision.format.Formatter;
import ua.com.foxminded.iliapanteleychuk.integerdivision.math.Divider;
import ua.com.foxminded.iliapanteleychuk.integerdivision.model.Model;


public class Main {

    public static void main(String[] args) {
        try{
            ArgumentsValidator.validate(args);
        }catch(BadArgsException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
        int firstArgument = Integer.parseInt(args[0]);
        int secondArgument = Integer.parseInt(args[1]);
        Divider divider = new Divider();
        Model model = divider.divide(firstArgument, secondArgument);
        Formatter formatter = new ClassicFormatter();
        String output = formatter.format(model);
        System.out.println(output);
    }
}

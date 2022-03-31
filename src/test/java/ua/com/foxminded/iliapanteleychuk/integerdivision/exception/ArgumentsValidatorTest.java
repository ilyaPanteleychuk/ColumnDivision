package ua.com.foxminded.iliapanteleychuk.integerdivision.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;


class ArgumentsValidatorTest {

    @Test
    void validate_shouldThrowBadArgumentsException_whenInputIsEmptyArgs() {
        String[] arguments = new String[2];
        arguments[0] = "";
        arguments[1] = "";
        assertThrows(BadArgsException.class, () -> {
            ArgumentsValidator.validate(arguments);
        });
    }

    @Test
    void validate_shouldThrowBadArgumentsException_whenInputHasMoreThanTwoArgs(){
        String[] arguments = new String[3];
        arguments[0] = "34";
        arguments[1] = "23";
        arguments[2] = "818";
        assertThrows(BadArgsException.class, () -> {
            ArgumentsValidator.validate(arguments);
        });
    }

    @Test
    void validate_shouldThrowBadArgumentsException_whenSecondArgumentIsZero(){
        String[] arguments = new String[2];
        arguments[0] = "34";
        arguments[1] = "0";
        assertThrows(BadArgsException.class, () -> {
            ArgumentsValidator.validate(arguments);
        });
    }

    @Test
    void validate_shouldThrowBadArgumentsException_whenSecondArgIsGreaterThanTheFirst(){
        String[] arguments = new String[2];
        arguments[0] = "34";
        arguments[1] = "72";
        assertThrows(BadArgsException.class, () -> {
            ArgumentsValidator.validate(arguments);
        });
    }

    @Test
    void validate_shouldThrowBadArgumentsException_whenArgsAreNotNumericAndCantBeCastToInt(){
        String[] arguments = new String[2];
        arguments[0] = "34#@@";
        arguments[1] = "72bfff";
        assertThrows(BadArgsException.class, () -> {
            ArgumentsValidator.validate(arguments);
        });
    }
}

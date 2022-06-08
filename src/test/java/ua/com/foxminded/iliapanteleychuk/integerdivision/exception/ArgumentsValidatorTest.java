package ua.com.foxminded.iliapanteleychuk.integerdivision.exception;

import org.junit.jupiter.api.Test;
import ua.com.foxminded.iliapanteleychuk.integerdivision.argumentvalidator.ArgumentsValidator;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
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

    @Test
    void validate_shouldNotThrowBadArgumentsException_whenInputIsNotEmpty(){
        String[] arguments = new String[2];
        arguments[0] = "10";
        arguments[1] = "5";
        assertDoesNotThrow(() -> ArgumentsValidator.validate(arguments));
    }

    @Test
    void validate_shouldNotThrowBadArgumentsException_whenInputHasTwoArgs(){
        String[] arguments = new String[2];
        arguments[0] = "34";
        arguments[1] = "23";
        assertDoesNotThrow(() -> ArgumentsValidator.validate(arguments));
    }

    @Test
    void validate_shouldNotThrowBadArgumentsException_whenSecondArgIsLessThanTheFirst(){
        String[] arguments = new String[2];
        arguments[0] = "5";
        arguments[1] = "4";
        assertDoesNotThrow(() -> ArgumentsValidator.validate(arguments));
    }

    @Test
    void validate_shouldNotThrowBadArgumentsException_whenArgsAreNumericOrCanBeCastToInt(){
        String[] arguments = new String[2];
        arguments[0] = "59";
        arguments[1] = "19";
        assertDoesNotThrow(() -> ArgumentsValidator.validate(arguments));
    }
}

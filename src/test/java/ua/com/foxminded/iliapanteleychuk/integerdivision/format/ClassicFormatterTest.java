package ua.com.foxminded.iliapanteleychuk.integerdivision.format;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.com.foxminded.iliapanteleychuk.integerdivision.math.Divider;
import ua.com.foxminded.iliapanteleychuk.integerdivision.model.Model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static java.lang.System.lineSeparator;


class ClassicFormatterTest {

    private Divider divider;
    private Formatter formatter;
    @BeforeEach
    void init(){
        divider = new Divider();
        formatter = new ClassicFormatter();
    }

    @Test
    void format_shouldDoRightOutput_WhenDividendIsShortButDivisorIsSingleDigit() {
        Model model = divider.divide(452,2);
        String expected = formatter.format(model);
        String actual = "_452|2" + lineSeparator() +
                        " 4  |---" + lineSeparator() +
                        " -  |226" + lineSeparator() +
                        "_ 5" + lineSeparator() +
                        "  4" + lineSeparator() +
                        "  -" + lineSeparator() +
                        "_ 12" + lineSeparator() +
                        "  12" + lineSeparator() +
                        "  --" + lineSeparator() +
                        "   0";
        assertEquals(expected, actual);
    }

    @Test
    void format_shouldDoRightOutput_WhenDividendIsLongButDivisorIsSingleDigit(){
        Model model = divider.divide(87534364, 7);
        String expected = formatter.format(model);
        String actual = "_87534364|7" + lineSeparator() +
                        " 7       |--------" + lineSeparator() +
                        " -       |12504909" + lineSeparator() +
                        "_17" + lineSeparator() +
                        " 14" + lineSeparator() +
                        " --" + lineSeparator() +
                        "_ 35" + lineSeparator() +
                        "  35" + lineSeparator() +
                        "  --" + lineSeparator() +
                        "_   34" + lineSeparator() +
                        "    28" + lineSeparator() +
                        "    --" + lineSeparator() +
                        "_    63" + lineSeparator() +
                        "     63" + lineSeparator() +
                        "     --" + lineSeparator() +
                        "_      64" + lineSeparator() +
                        "       63" + lineSeparator() +
                        "       --" + lineSeparator() +
                        "        1" + lineSeparator();
        assertEquals(expected, actual);
    }

    @Test
    void format_shouldDoRightOutput_WhenDividendIsShortButDivisorIsTwoDigitNumber(){
        Model model = divider.divide(534, 12);
        String expected = formatter.format(model);
        String actual = "_534|12" + lineSeparator() +
                        " 48 |--" + lineSeparator() +
                        " -- |44" + lineSeparator() +
                        "_ 54" + lineSeparator() +
                        "  48" + lineSeparator() +
                        "  --" + lineSeparator() +
                        "   6" + lineSeparator();
        assertEquals(expected, actual);
    }

    @Test
    void format_shouldDoRightOutput_whenDividendIsLongButDivisorIsTwoDigitNumber(){
        Model model = divider.divide(347343203, 21);
        String expected = formatter.format(model);
        String actual = "_347343203|21" + lineSeparator() +
                        " 21       |--------" + lineSeparator() +
                        " --       |16540152" + lineSeparator() +
                        "_137" + lineSeparator() +
                        " 126" + lineSeparator() +
                        " ---" + lineSeparator() +
                        "_ 113" + lineSeparator() +
                        "  105" + lineSeparator() +
                        "  ---" + lineSeparator() +
                        "_   84" + lineSeparator() +
                        "    84" + lineSeparator() +
                        "    --" + lineSeparator() +
                        "_     32" + lineSeparator() +
                        "      21" + lineSeparator() +
                        "      --" + lineSeparator() +
                        "_     110" + lineSeparator() +
                        "      105" + lineSeparator() +
                        "      ---" + lineSeparator() +
                        "_       53" + lineSeparator() +
                        "        42" + lineSeparator() +
                        "        --" + lineSeparator() +
                        "        11" + lineSeparator();
        assertEquals(expected, actual);
    }

    @Test
    void format_shouldDoRightOutput_whenDividendIsLongAndDivisorIsLong(){
        Model model = divider.divide( 2100421235, 1849203475);
        String expected = formatter.format(model);
        String actual = "_2100421235|1849203475" + lineSeparator() +
                        " 1849203475|----------" + lineSeparator() +
                        " ----------|1" + lineSeparator() +
                        "  251217760" + lineSeparator();
        assertEquals(expected, actual);
    }

    @Test
    void format_shouldDoRightOutput_whenDividendIsSingleAndDivisorIsSingle(){
        Model model = divider.divide(8, 2);
        String expected = formatter.format(model);
        String actual = "_8|2" + lineSeparator() +
                        " 8|-" + lineSeparator() +
                        " -|4" + lineSeparator() +
                        " 0";
        assertEquals(expected, actual);

    }
}

package ua.com.foxminded.iliapanteleychuk.integerdivision.math;

import org.junit.jupiter.api.Test;
import ua.com.foxminded.iliapanteleychuk.integerdivision.dataToDraw.Result;
import ua.com.foxminded.iliapanteleychuk.integerdivision.dataToDraw.Step;
import static org.junit.jupiter.api.Assertions.assertEquals;


class DividerTest {

    @Test
    void divide_shouldCreateRightStepList_whenInputIs2323And23() {
        Step step = new Step(0,23,23);
        Step secondStep = new Step(2,23,23);
        Divider divider = new Divider();
        Result result = divider.divide(2323, 23);
        assertEquals(result.getStepsList().get(0), step);
        assertEquals(result.getStepsList().get(1), secondStep);
    }
}

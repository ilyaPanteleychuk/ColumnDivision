package ua.com.foxminded.iliapanteleychuk.integerdivision.math;

import org.junit.jupiter.api.Test;
import ua.com.foxminded.iliapanteleychuk.integerdivision.model.DivisionResult;
import ua.com.foxminded.iliapanteleychuk.integerdivision.model.Step;
import static org.junit.jupiter.api.Assertions.assertEquals;


class DividerTest {

    @Test
    void divide_shouldCreateRightStepList_whenInputIs2323And23() {
        Step step = new Step(0,23,23);
        Step secondStep = new Step(2,23,23);
        Divider divider = new Divider();
        DivisionResult divisionResult = divider.divide(2323, 23);
        assertEquals(divisionResult.getStepsList().get(0), step);
        assertEquals(divisionResult.getStepsList().get(1), secondStep);
    }
}

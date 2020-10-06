package util;

import com.epam.array.exceptions.arrays.NullArrayException;
import com.epam.array.exceptions.arrays.OutOfBoundsException;
import com.epam.array.util.WrapperArray;
import org.junit.Assert;
import org.junit.Test;

public class WrapperArrayTest {
    private static final int[] FILLED_ARRAY = new int[]{1,3,6,-2};
    private static final int[] NULL_ARRAY = null;
    private static final int[] EMPTY_ARRAY = new int[]{};
    private static final int FIRST_ELEMENT = 1;
    private static final int NEW_ELEMENT = 2;
    private static final int OUT_INDEX = -1;

    @Test
    public void testCreateArrayShouldCreateWhenArrayIsFilled() throws NullArrayException {
        //when
        WrapperArray wrapperArray = new WrapperArray(FILLED_ARRAY);
        //then
        Assert.assertNotNull(wrapperArray);
    }

    @Test(expected = NullArrayException.class)
    public void testCreateArrayShouldNotCreateWhenArrayIsNull() throws NullArrayException {
        new WrapperArray(NULL_ARRAY);
    }

    @Test
    public void testCreateArrayShouldCreateWhenArrayIsEmpty() throws NullArrayException {
        //when
        WrapperArray wrapperArray = new WrapperArray(EMPTY_ARRAY);
        //then
        Assert.assertNotNull(wrapperArray);
    }

    @Test
    public void testGetElementShouldGetWhenArrayIsFilled() throws NullArrayException, OutOfBoundsException {
        //given
        int index = 0;
        //when
        WrapperArray wrapperArray = new WrapperArray(FILLED_ARRAY);
        int element = wrapperArray.get(index);
        //then
        Assert.assertEquals(FIRST_ELEMENT, element);
    }

    @Test(expected = OutOfBoundsException.class)
    public void testGetElementShouldNotGetWhenIndexOutOfBounds() throws NullArrayException, OutOfBoundsException {
        WrapperArray wrapperArray = new WrapperArray(FILLED_ARRAY);
        wrapperArray.get(OUT_INDEX);
    }

    @Test
    public void testSetElementShouldSetWhenArrayIsFilled() throws NullArrayException, OutOfBoundsException {
        //given
        int index = 0;
        //when
        WrapperArray wrapperArray = new WrapperArray(FILLED_ARRAY);
        wrapperArray.set(index, NEW_ELEMENT);
        //then
        Assert.assertEquals(NEW_ELEMENT, wrapperArray.get(index));
    }
}

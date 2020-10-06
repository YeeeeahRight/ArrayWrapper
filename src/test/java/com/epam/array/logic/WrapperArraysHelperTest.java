package com.epam.array.logic;

import com.epam.array.exceptions.arrays.NullArrayException;
import com.epam.array.exceptions.arrays.OutOfBoundsException;
import com.epam.array.util.WrapperArray;
import org.junit.Assert;
import org.junit.Test;

public class WrapperArraysHelperTest {
    private static final int[] SAME_ELEMENTS_ARRAY = new int[]{1,1,1,1};
    private static final int MIN_MAX_SAME_ELEMENTS_ARRAY = 1;
    private static final int[] NOT_SAME_ELEMENTS_ARRAY = new int[]{3,-4,6,2};
    private static final int MAX_NOT_SAME_ELEMENTS_ARRAY = 6;
    private static final int MIN_NOT_SAME_ELEMENTS_ARRAY = -4;
    private static final int[] SORTED_NOT_SAME_ELEMENTS_ARRAY = new int[]{-4,2,3,6};
    private ArraysHelper arraysHelper = new WrapperArraysHelper();

    @Test
    public void testFindMaxElementShouldCalculateWhenAllElementsSame() throws NullArrayException, OutOfBoundsException {
        //given
        WrapperArray array = new WrapperArray(SAME_ELEMENTS_ARRAY);
        //when
        int maxElement = arraysHelper.findMaxElement(array);
        //then
        Assert.assertEquals(MIN_MAX_SAME_ELEMENTS_ARRAY, maxElement);
    }

    @Test
    public void testFindMaxElementShouldCalculateWhenAllElementsNotSame() throws NullArrayException, OutOfBoundsException {
        //given
        WrapperArray array = new WrapperArray(NOT_SAME_ELEMENTS_ARRAY);
        //when
        int maxElement = arraysHelper.findMaxElement(array);
        //then
        Assert.assertEquals(MAX_NOT_SAME_ELEMENTS_ARRAY, maxElement);
    }

    @Test
    public void testFindMinElementShouldCalculateWhenAllElementsSame() throws NullArrayException, OutOfBoundsException {
        //given
        WrapperArray array = new WrapperArray(SAME_ELEMENTS_ARRAY);
        //when
        int minElement = arraysHelper.findMinElement(array);
        //then
        Assert.assertEquals(MIN_MAX_SAME_ELEMENTS_ARRAY, minElement);
    }

    @Test
    public void testFindMinElementShouldCalculateWhenAllElementsNotSame() throws NullArrayException, OutOfBoundsException {
        //given
        WrapperArray array = new WrapperArray(NOT_SAME_ELEMENTS_ARRAY);
        //when
        int maxElement = arraysHelper.findMinElement(array);
        //then
        Assert.assertEquals(MIN_NOT_SAME_ELEMENTS_ARRAY, maxElement);
    }

    @Test
    public void testSortArrayShouldSortWhenAllElementsSame() throws NullArrayException, OutOfBoundsException {
        //given
        WrapperArray array = new WrapperArray(SAME_ELEMENTS_ARRAY);
        //when
        arraysHelper.sortArray(array);
        boolean isEquals = (new WrapperArray(SAME_ELEMENTS_ARRAY)).equals(array);
        //then
        Assert.assertTrue(isEquals);
    }

    @Test
    public void testSortArrayShouldSortWhenAllElementsNotSame() throws NullArrayException, OutOfBoundsException {
        //given
        WrapperArray array = new WrapperArray(NOT_SAME_ELEMENTS_ARRAY);
        //when
        arraysHelper.sortArray(array);
        boolean isEquals = (new WrapperArray(SORTED_NOT_SAME_ELEMENTS_ARRAY)).equals(array);
        //then
        Assert.assertTrue(isEquals);
    }
}

package com.thearaseng.lab11.service;

import com.thearaseng.lab11.service.impl.ArrayReversorImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.mockito.Mockito;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({ArrayReversorTestCases.TestValidInput.class, ArrayReversorTestCases.TestNullInput.class})
public class ArrayReversorTestCases {

    public static class TestValidInput {

        @Test
        public void testReverseArray() {
            // Mock ArrayFlattenerService
            ArrayFlattenerService flattenerService = mock(ArrayFlattenerService.class);
            when(flattenerService.flattenArray(Mockito.any(int[][].class))).thenReturn(new int[]{1, 3, 0, 4, 5, 9});

            ArrayReversor reversor = new ArrayReversorImpl(flattenerService);
            int[][] input = {{1, 3}, {0}, {4, 5, 9}};
            int[] expectedOutput = {9, 5, 4, 0, 3, 1};
            assertArrayEquals(expectedOutput, reversor.reverseArray(input));

            // Verify that ArrayFlattenerService was indeed invoked
            verify(flattenerService).flattenArray(input);
        }
    }

    public static class TestNullInput {

        @Test
        public void testReverseArrayWithNullInput() {
            // Mock ArrayFlattenerService
            ArrayFlattenerService flattenerService = mock(ArrayFlattenerService.class);
            when(flattenerService.flattenArray(null)).thenReturn(new int[0]);

            ArrayReversor reversor = new ArrayReversorImpl(flattenerService);
            int[][] input = null;
            int[] expectedOutput = {};
            assertArrayEquals(expectedOutput, reversor.reverseArray(input));

            // Verify that ArrayFlattenerService was indeed invoked
            verify(flattenerService).flattenArray(input);
        }
    }

}

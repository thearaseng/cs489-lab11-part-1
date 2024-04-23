package com.thearaseng.lab11.service;

import static org.junit.Assert.assertArrayEquals;

import com.thearaseng.lab11.service.impl.ArrayFlattenerServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ArrayFlattenerTest.TestValidInput.class,
        ArrayFlattenerTest.TestNullInput.class
})
public class ArrayFlattenerTest {

    public static class TestValidInput {

        @Test
        public void testFlattenArray() {
            ArrayFlattenerService flattener = new ArrayFlattenerServiceImpl();
            int[][] input = {{1, 3}, {0}, {4, 5, 9}};
            int[] expectedOutput = {1, 3, 0, 4, 5, 9};
            assertArrayEquals(expectedOutput, flattener.flattenArray(input));
        }
    }

    public static class TestNullInput {

        @Test
        public void testFlattenArrayWithNullInput() {
            ArrayFlattenerService flattener = new ArrayFlattenerServiceImpl();
            int[][] input = null;
            int[] expectedOutput = {};
            assertArrayEquals(expectedOutput, flattener.flattenArray(input));
        }
    }
}


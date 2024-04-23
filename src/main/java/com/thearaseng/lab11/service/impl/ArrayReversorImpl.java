package com.thearaseng.lab11.service.impl;

import com.thearaseng.lab11.service.ArrayFlattenerService;
import com.thearaseng.lab11.service.ArrayReversor;

public class ArrayReversorImpl implements ArrayReversor {

    private ArrayFlattenerService flattenerService;

    public ArrayReversorImpl(ArrayFlattenerService flattenerService) {
        this.flattenerService = flattenerService;
    }

    @Override
    public int[] reverseArray(int[][] input) {
        int[] flattenedArray = flattenerService.flattenArray(input);
        int[] reversedArray = new int[flattenedArray.length];
        for (int i = 0; i < flattenedArray.length; i++) {
            reversedArray[i] = flattenedArray[flattenedArray.length - 1 - i];
        }
        return reversedArray;
    }
}

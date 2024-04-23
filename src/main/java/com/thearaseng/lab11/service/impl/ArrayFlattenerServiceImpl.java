package com.thearaseng.lab11.service.impl;

import com.thearaseng.lab11.service.ArrayFlattenerService;

import java.util.ArrayList;
import java.util.List;

public class ArrayFlattenerServiceImpl implements ArrayFlattenerService {

    @Override
    public int[] flattenArray(int[][] input) {
        if (input == null) {
            return new int[0];
        }

        List<Integer> flattenedList = new ArrayList<>();
        for (int[] nestedArray : input) {
            for (int num : nestedArray) {
                flattenedList.add(num);
            }
        }

        int[] flattenedArray = new int[flattenedList.size()];
        for (int i = 0; i < flattenedArray.length; i++) {
            flattenedArray[i] = flattenedList.get(i);
        }

        return flattenedArray;
    }

}

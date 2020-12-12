package com.ncepu.cloudyilaboratory.leetcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearch {

    public void searchCSVFile(int number) {
        File file = new File("/Users/huangyunyi/IdeaProjects/cloudyilaboratory/src/main/resources/binary-search.csv");
        List<Integer> numberList = new ArrayList<>();

        try(FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader =
                new BufferedReader(fileReader)) {

            String s = null;
            while ((s = bufferedReader.readLine()) != null) {
                String[] split = s.split(",");
                numberList.add(Integer.valueOf(split[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(numberList);

        int start = 0, end = numberList.size() - 1, middle = (start + end) >> 1;

        while (start < end) {
            if (number < numberList.get(middle)) {
                end = middle - 1;
            } else if (number > numberList.get(middle)) {
                start = middle + 1;
            } else {
                break;
            }
            middle = (start + end) >> 1;
        }

        if (number == numberList.get(middle)) {
            System.out.println("找到number: " + number + ", 下标为：" + middle);
        } else {
            System.out.println("没找到number: " + number);
        }
    }

    public static void main(String[] args) {
        new BinarySearch().searchCSVFile(6);
    }
}

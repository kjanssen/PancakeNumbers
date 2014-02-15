package com.dynet.kjanssen.PancakeNumbers;

import java.util.Random;

public class PancakeNumbers {

    private int[] nums;
    private int turnCount;

    public PancakeNumbers (int size) {

        nums = new int[size];
        initialize();
        turnCount = 0;
    }

    private void initialize() {

        Random random = new Random();

        for (int i = 0; i < nums.length; i++)
            nums[i] = i + 1;

        for (int i = 0; i < nums.length; i++) {
            int index = random.nextInt(nums.length - i) + i;
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
        }
    }

    public String toString () {

        String out = "\n ";

        for (int i = 0; i < nums.length; i++)
            out += (i + 1) + " ";

        out += "\n< ";

        for (int i = 0; i < nums.length; i++)
            out += nums[i] + " ";

        out += ">  Breakpoints: " + numBreakpoints();

        return out;
    }

    public void flip (int from, int to) {

        int flipSize = to - from + 1;
        int temp[] = new int[flipSize];

        for (int i = 0; i < flipSize; i++)
            temp[i] = nums[i + from - 1];

        for (int i = 0; i < flipSize; i++)
            nums[i + from - 1] = temp[flipSize - i - 1];
    }

    public Boolean done () {

        for (int i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                return false;

        return true;
    }

    public int numBreakpoints () {

        int count = 0;

        for (int i = 0; i < nums.length -1; i++)
            if (nums[i] != nums[i + 1] + 1 && nums[i] != nums[i + 1] - 1)
                count++;

        return count;
    }
}

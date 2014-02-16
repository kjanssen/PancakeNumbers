package com.dynet.kjanssen.PancakeNumbers;

import java.util.Random;

public class PancakeNumbers {

    private int[] nums;
    private int turnCount;
    private int depth;
    private int lastFrom;
    private int lastTo;

    public PancakeNumbers (int size) {

        if (size == 0)
            nums = new int[] {1, 3, 6, 4, 2, 5};
        else {
            nums = new int[size];
            initialize();
        }

        turnCount = 0;
        depth = 0;
        lastFrom = -1;
        lastTo = -1;
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

    public int getTurnCount () {
        return turnCount;
    }

    public int[] getState () {
        return nums.clone();
    }

    public String toString () {

        String out = "\n  ";

        for (int i = 0; i < nums.length; i++)
            out += (i + 1) + " ";

        out += "\n< ";

        for (int i = 0; i < nums.length; i++)
            out += nums[i] + " ";

        out += ">  h(x): " + h() + ", g(x): " + depth + ", f(x): " + (h() + depth);

        return out;
    }

    public void move (int from, int to) {
        flip(from, to);
        turnCount++;
    }

    private void flip (int from, int to) {

        if (from == lastFrom && to == lastTo)
            depth--;
        else
            depth++;

        lastFrom = from;
        lastTo = to;

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

    public int h() {
        return numBreakpoints() / 2;
    }

    public String getMoves () {
        StringBuilder stringBuilder = new StringBuilder();
        int currBreakpoints = numBreakpoints();

        for (int i = 1; i < nums.length; i++)
            for (int j = i + 1; j < nums.length + 1; j++) {
                flip(i, j);

                if (true) { //numBreakpoints() < currBreakpoints) {
                    stringBuilder.append("\n" + i + ", " + j + ": < ");
                    for (int k = 0; k < nums.length; k++)
                        stringBuilder.append(nums[k] + " ");
                    stringBuilder.append(">  h(x): " + h() + ", g(x): " + depth + ", f(x): " + (h() + depth));
                }

                flip(i, j);
            }

        return stringBuilder.toString();
    }
}


















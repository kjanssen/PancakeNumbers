// File: PancakeNumbersState.java
// Author: Kyle Janssen
// Content: Whereas the PancakeNumbers class represents a game of Pancake Numbers, this class represents a
// snapshot of the Pancake Numbers game.

package com.dynet.kjanssen.PancakeNumbers;

public class PancakeNumbersState {

    private int[] nums;
    private int h, g;

    public PancakeNumbersState (int[] nums, int h, int g) {
        this.nums = nums;
        this.h = h;
        this.g = g;
    }

    public int getH() {
        return h;
    }

    public int getG() {
        return g;
    }

    public int getF() {
        return h + g;
    }

    public String toString () {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("< ");
        for (int k = 0; k < nums.length; k++)
            stringBuilder.append(nums[k] + " ");
        stringBuilder.append(">  h(x): " + h + ", g(x): " + g + ", f(x): " + this.getF());

        return stringBuilder.toString();
    }
}

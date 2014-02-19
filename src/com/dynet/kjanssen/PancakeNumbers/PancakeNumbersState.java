// File: PancakeNumbersState.java
// Author: Kyle Janssen
// Content: Whereas the PancakeNumbers class represents a game of Pancake Numbers, this class represents a
// snapshot of the Pancake Numbers game.

package com.dynet.kjanssen.PancakeNumbers;

import java.util.Arrays;

public class PancakeNumbersState {

    private int[] nums;
    private int h, g;
    private PancakeNumbersState parent;

    public PancakeNumbersState (int[] nums, int h, int g) {
        this.nums = nums;
        this.h = h;
        this.g = g;
    }

    public void setParent (PancakeNumbersState parent) {
        this.parent = parent;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PancakeNumbersState that = (PancakeNumbersState) o;

        if (g != that.g) return false;
        if (h != that.h) return false;
        if (!Arrays.equals(nums, that.nums)) return false;
        if (parent != null ? !parent.equals(that.parent) : that.parent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nums != null ? Arrays.hashCode(nums) : 0;
        result = 31 * result + h;
        result = 31 * result + g;
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        return result;
    }
}

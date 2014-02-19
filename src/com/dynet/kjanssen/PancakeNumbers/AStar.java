package com.dynet.kjanssen.PancakeNumbers;

import java.util.HashSet;

public class AStar {

    private HashSet<PancakeNumbersState> open;
    private HashSet<PancakeNumbersState> closed;
    private PancakeNumbers pancakeNumbers;

    public AStar (int size) {
        open = new HashSet<PancakeNumbersState>();
        closed = new HashSet<PancakeNumbersState>();
        pancakeNumbers = new PancakeNumbers(size);
    }

    public void run () {
        open.add(pancakeNumbers.getState());

        while (!open.isEmpty()) {
            
        }
    }

    public static void main(String[] args) {

        AStar aStar = new AStar (0);
        aStar.run();
    }
}

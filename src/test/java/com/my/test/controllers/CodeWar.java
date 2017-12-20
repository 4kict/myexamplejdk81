package com.my.test.controllers;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by SBT-Kiladze-GS on 06.12.2017.
 */
public class CodeWar {

    /**
     * Which are in?
     * Given two arrays of strings a1 and a2 return a sorted array r in lexicographical order of the strings of a1
     * which are substrings of strings of a2.
     */

    public static String[] inArray(String[] array1, String[] array2) {

        String[] ret = Arrays.stream(array1).filter(s1 -> {
            for (String s2 : array2) {
                if (s2.contains(s1)) {
                    return true;
                }
            }
            return false;
        }).sorted().toArray(String[]::new);
        return ret;
    }


    @Test
    public void test1() {
        String a[] = new String[]{"arp", "live", "strong"};
        String b[] = new String[]{"lively", "alive", "harp", "sharp", "armstrong"};
        String r[] = new String[]{"arp", "live", "strong"};
        assertArrayEquals(r, inArray(a, b));
    }

    /**
     * Directions Reduction
     */

    enum Direction {
        NORTH {
            @Override
            boolean isOpposide(Direction side) {
                return side.equals(SOUTH);
            }
        }, SOUTH {
            @Override
            boolean isOpposide(Direction side) {
                return side.equals(NORTH);
            }
        }, EAST {
            @Override
            boolean isOpposide(Direction side) {
                return side.equals(WEST);
            }
        }, WEST {
            @Override
            boolean isOpposide(Direction side) {
                return side.equals(EAST);
            }
        };

        abstract boolean isOpposide(Direction side);
    }

    public static String[] dirReduc(String[] arr) {
        List<Direction> directions = Arrays.stream(arr).map(Direction::valueOf).collect(Collectors.toList());
//        directions.stream().forEach(direction -> );


//        Arrays.stream(arr)
//                .filter(s -> )
        //.reduce((s1, s2) -> Direction.valueOf(s1) )
        // Your code here.
        return new String[]{};
    }


    @Test
    public void testSimpleDirReduc() throws Exception {
        assertArrayEquals("\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"",
                new String[]{"WEST"},
                dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));

        assertArrayEquals("\"NORTH\", \"WEST\", \"SOUTH\", \"EAST\"",
                new String[]{"NORTH", "WEST", "SOUTH", "EAST"},
                dirReduc(new String[]{"NORTH", "WEST", "SOUTH", "EAST"}));
    }

}

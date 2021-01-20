package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int lnIndex = 0;
        int lnLeft = left.length();
        int lnRight = right.length();

        int diff = Integer.compare(lnLeft, lnRight);
        if (diff != rsl) {
            rsl = diff;
        }

        if (lnLeft >= lnRight) {
            lnIndex = lnRight;
        } else if (lnLeft < lnRight) {
            lnIndex = lnLeft;
        }

        for (int index = 0; index < lnIndex; index++) {
            int rslTmp = Character.compare(left.charAt(index), right.charAt(index));
            if (rslTmp != 0) {
                rsl = rslTmp;
                break;
            }
        }
        return rsl;
    }
}
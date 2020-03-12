package com.custom.algorithm.bubble;

import androidx.annotation.NonNull;

/**
 * 牌类
 * Created by: Ysw on 2020/3/12.
 */
public class Cards implements Comparable {
    public int pokerColors;//花色
    public int cardPoints;//点数

    public Cards(int pokerColors, int cardPoints) {
        this.pokerColors = pokerColors;
        this.cardPoints = cardPoints;
    }

    @Override
    public int compareTo(@NonNull Object object) {
        Cards c = (Cards) object;
        if (this.cardPoints > c.cardPoints) {
            return 1;
        } else if (this.cardPoints < c.cardPoints) {
            return -1;
        }
        if (this.pokerColors > c.pokerColors) {
            return 1;
        } else if (this.pokerColors < c.pokerColors) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Cards{" +
                "pokerColors=" + pokerColors +
                ", cardPoints=" + cardPoints +
                '}';
    }
}

package com.custom.algorithm.linked;

import com.custom.algorithm.bubble.Cards;

import java.util.LinkedList;

/**
 * Created by: Ysw on 2020/3/12.
 */
public class Linked {

    public static LinkedList<Cards> radixSort(LinkedList<Cards> list) {
        // 先对点数进行分组 @author Ysw created at 2020/3/12 10:44
        LinkedList[] linkedLists = new LinkedList[13];
        for (int i = 0; i < linkedLists.length; i++) {
            linkedLists[i] = new LinkedList();
        }

        //把数据一个一个放入对应的组中
        while (list.size() > 0) {
            Cards remove = list.remove();
            linkedLists[remove.cardPoints - 1].add(remove);
        }

        //把9个组合到一起
        for (int i = 0; i < linkedLists.length; i++) {
            list.addAll(linkedLists[i]);
        }

        //先花色数进行分组
        LinkedList[] suitList = new LinkedList[4];
        for (int i = 0; i < suitList.length; i++) {
            suitList[i] = new LinkedList();
        }

        //把数据一个一个的放入到对应的组中
        while (list.size() > 0) {
            Cards remove = list.remove();
            suitList[remove.pokerColors - 1].add(remove);
        }

        //把4个组合到一起
        for (int i = 0; i < suitList.length; i++) {
            list.addAll(suitList[i]);
        }
        return list;
    }
}

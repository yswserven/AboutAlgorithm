package com.custom.algorithm;

import android.content.Context;
import android.util.Log;

import com.custom.algorithm.bubble.Bubble;
import com.custom.algorithm.bubble.Cards;
import com.custom.algorithm.linked.Linked;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.LinkedList;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.custom.algorithm", appContext.getPackageName());
    }


    @Test
    public void testBubbleSort() {
        int[] array = new int[]{9, 15, 1, 58, 3, 14, 7, 6, 18, 30, 10};
        int[] bubbleSort = Bubble.bubbleSort(array);
        for (int i : bubbleSort) {
            System.out.println(i + "  ");
        }
    }

    @Test
    public void testSelectSort() {
        int[] array = new int[]{9, 15, 1, 58, 3, 14, 7, 6, 18, 30, 10};
        int[] bubbleSort = Bubble.selectSort(array);
        for (int i : bubbleSort) {
            System.out.println(i + "  ");
        }
    }

    @Test
    public void testCardsBubbleSort() {
        Cards[] array = new Cards[]{
                new Cards(3, 2),
                new Cards(2, 9),
                new Cards(1, 7),
                new Cards(3, 5),
                new Cards(4, 3)
        };
        Cards[] bubbleSort = Bubble.bubbleSort(array);
        for (Cards cards : bubbleSort) {
            System.out.println(cards.toString());
        }
    }


    /**
     * 通过链表进行二维排序
     *
     * @author Ysw created at 2020/3/12 12:40
     */
    @Test
    public void testLinkedList() {
        LinkedList<Cards> list = new LinkedList<>();
        list.add(new Cards(3, 1));
        list.add(new Cards(2, 3));
        list.add(new Cards(3, 7));
        list.add(new Cards(1, 1));
        list.add(new Cards(2, 12));
        list.add(new Cards(3, 8));
        list.add(new Cards(4, 8));
        list.add(new Cards(2, 2));
        list.add(new Cards(3, 2));
        list.add(new Cards(1, 3));
        list.add(new Cards(3, 9));
        list.add(new Cards(1, 10));
        list.add(new Cards(3, 13));
        list.add(new Cards(4, 5));
        list.add(new Cards(3, 12));
        System.out.println(list);
        LinkedList<Cards> cards = Linked.radixSort(list);
        for (int i = 0; i < cards.size(); i++) {
            Log.d("Ysw", "testLinkedList: " + cards.get(i).toString());
        }
    }


    /**
     * 测试自定义链表
     *
     * @author Ysw created at 2020/3/12 13:07
     */
    @Test
    public void testCustomLinkedList() {
        com.custom.algorithm.linked.LinkedList<Integer> list = new com.custom.algorithm.linked.LinkedList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(9);
        list.add(11);
        list.add(13);
        for (int i = 0; i < list.size(); i++) {
            Log.d("Ysw", "testCustomLinkedList: " + list.get(i));
        }
        Log.d("Ysw", "testCustomLinkedList: ==============================================");

        list.add(0, 100);
        for (int i = 0; i < list.size(); i++) {
            Log.d("Ysw", "testCustomLinkedList: " + list.get(i));
        }
        Log.d("Ysw", "testCustomLinkedList: ==============================================");

        list.add(1000);
        for (int i = 0; i < list.size(); i++) {
            Log.d("Ysw", "testCustomLinkedList: " + list.get(i));
        }
        Log.d("Ysw", "testCustomLinkedList: ==============================================");

        list.add(4, 5000);
        for (int i = 0; i < list.size(); i++) {
            Log.d("Ysw", "testCustomLinkedList: " + list.get(i));
        }
        Log.d("Ysw", "testCustomLinkedList: ==============================================");

        Integer integer = list.get(3);
        Log.d("Ysw", "testCustomLinkedList: index 6 = " + integer);
        Log.d("Ysw", "testCustomLinkedList: ==============================================");

        list.remove(3);
        for (int i = 0; i < list.size(); i++) {
            Log.d("Ysw", "testCustomLinkedList: " + list.get(i));
        }
    }
}

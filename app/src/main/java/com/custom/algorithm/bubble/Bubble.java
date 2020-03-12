package com.custom.algorithm.bubble;

/**
 * 冒泡排序法
 * <p>
 * Created by: Ysw on 2020/3/12.
 */
public class Bubble {

    /**
     * 冒泡排序法
     * 适合 3-5个数据源的排序
     *
     * @author Ysw created at 2020/3/12 10:12
     */
    public static int[] bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return array;
    }


    public static Cards[] bubbleSort(Cards[] array) {
        for(int i=array.length-1;i>0;i--) {
            boolean flag=true;
            for (int j = 0; j < i; j++) {
                if (array[j].compareTo(array[j+1])>0) {
                    Cards temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag=false;
                }
            }
            if(flag){
                break;
            }
        }
        return array;
    }


    /**
     * 选择排序法
     * 移动下标来进行排序
     *
     * @author Ysw created at 2020/3/12 10:18
     */
    public static int[] selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            if (index != i) {
                int temp = array[index];
                array[index] = array[i];
                array[i] = temp;
            }
        }
        return array;
    }
}

package com.gaurav.sorting;

import java.util.List;

public class BubbleSort {

    public BubbleSort() {
    }

    public List<Integer> sort(List<Integer> list) {
        for (int size = list.size(); size > 0; size--)
            for (int index = 0; list.size() > index + 1; index++)
                if (outOfOrder(list, index))
                    swap(list, index);

        return list;
    }

    private boolean outOfOrder(List<Integer> list, int index) {
        return list.get(index)>list.get(index+1);
    }

    private void swap(List<Integer> list, int index) {
        Integer temp = list.get(index);
        list.set(index,list.get(index+1));
        list.set(index+1,temp);
    }
}
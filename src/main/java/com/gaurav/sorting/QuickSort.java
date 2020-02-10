package com.gaurav.sorting;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    public List<Integer> sort(List<Integer> unsorted) {
        List<Integer> sorted = new ArrayList<Integer>();
        if(unsorted.size()==0){
            return sorted;
        } else {
            List<Integer> l = new ArrayList<Integer>();
            Integer m = unsorted.get(0);
            List<Integer> h = new ArrayList<Integer>();
            for(int i : unsorted.subList(1,unsorted.size())){
                if(i>m)
                    h.add(i);
                else
                    l.add(i);
            }
            sorted.addAll(sort(l));
            sorted.add(m);
            sorted.addAll(sort(h));
        }

        return sorted;
    }
}

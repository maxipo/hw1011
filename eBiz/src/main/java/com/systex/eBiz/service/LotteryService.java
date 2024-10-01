package com.systex.eBiz.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

@Service
public class LotteryService {
    //param2 : LinkedList excludes
    //String[] excludes
    public ArrayList[] getNumbers(int groups, String[] excludes) {
        Set<Integer> excludeNumbers = new TreeSet<>();
        for (String exclude : excludes) {
            excludeNumbers.add(Integer.parseInt(exclude));
        }
        ArrayList<Integer>[] lists = new ArrayList[groups];
        int random;
        for (int i = 0; i < groups; i++) {
            Set<Integer> numbers = new TreeSet<>();
            while (numbers.size() != 6) {
                random = (int) Math.ceil(Math.random() * 49);
                if (!excludeNumbers.contains(random)) {
                    numbers.add(random);
                }
            }
            lists[i] = new ArrayList<>(numbers);
            numbers.clear();
        }
        return lists;
    }
}

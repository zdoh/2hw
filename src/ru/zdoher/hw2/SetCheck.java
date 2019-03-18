package ru.zdoher.hw2;

import java.util.*;

public class SetCheck {
    private List<Set<String>> listsForTest = new ArrayList<>();
    private static int COUNT;

    public SetCheck() {
        listsForTest.add(new HashSet<>());
        listsForTest.add(new LinkedHashSet<>());
        listsForTest.add(new TreeSet<>());
        COUNT = Main.COUNT;
    }

    public void startTest() {
        for (Set<String> set : listsForTest) {
            System.out.println(set.getClass().getSimpleName() + ":");

            test(set);
        }
    }

    private void test(Set<String> set) {
        testAdd(set);
        testGet(set);
        testDel(set);
        System.out.println("-----------------------");
        
    }

    private void testAdd(Set<String> set) {
        final long start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            addToS(set, i);
        }
        final long finish = System.currentTimeMillis();
        System.out.println("Добавление значения: " + (finish - start) + " ms");

    }

    private void addToS(Set<String> set, Integer value) {
        set.add(value.toString());
    }

    private void testGet(Set<String> set) {
        final long start = System.currentTimeMillis();
        set.contains(Integer.valueOf(set.size() / 2).toString());
        final long finish = System.currentTimeMillis();
        System.out.println("Проверка на наличие значения: " + (finish - start) + " ms");
    }

    private void testDel(Set<String> set) {
        final long start = System.currentTimeMillis();
        for (Integer i = 0; i < COUNT; i++) {
            set.remove(i.toString());
        }
        final long finish = System.currentTimeMillis();
        System.out.println("Очистка через удаление значения: " + (finish - start) + " ms");
    }
}



package ru.zdoher.hw2;

import java.util.*;

public class ListCheck {
    private List<List<String>> listsForTest = new ArrayList<>();
    private static int COUNT;

    public ListCheck() {
        listsForTest.add(new ArrayList<>());
        listsForTest.add(new LinkedList<>());
        //listsForTest.add(new ArrayDeque<>());
        listsForTest.add(new Stack<>());
        listsForTest.add(new Vector<>());
        COUNT = Main.COUNT;
    }

    public void startTest() {
        for(List<String> list : listsForTest) {
            System.out.println(list.getClass().getSimpleName() + ":");

            test(list);
        }
    }

    private void test(List<String> list) {
        testAddToBegin(list);
        testGetFromBegin(list);
        testDelFromBegin(list);
        System.out.println("-----------------------");
        testAddToMiddle(list);
        testGetFromMiddle(list);
        testDelFromMiddle(list);
        System.out.println("-----------------------");
        testAddToEnd(list);
        testGetFromEnd(list);
        testDelFromend(list);
        System.out.println("-----------------------");
        System.out.println("\n");

    }

    private void testAddToBegin(List<String> list) {
        final long start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            addToBegin(list);
        }
        final long finish = System.currentTimeMillis();
        System.out.println("Добавление в начало списка: " + (finish - start) + " ms");

    }

    private void testGetFromBegin(List<String> list) {
        final long start = System.currentTimeMillis();
        String temp = list.get(0);
        final long finish = System.currentTimeMillis();
        System.out.println("Получение значения из начала списка: " + (finish - start) + " ms");
    }

    private void testDelFromBegin(List<String> list) {
        final long start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            list.remove(0);
        }
        final long finish = System.currentTimeMillis();
        System.out.println("Очистка через удаление значения из начала списка: " + (finish - start) + " ms");
    }

    private void addToBegin(List<String> list) {
        list.add(Long.toString(System.nanoTime()));
    }

    private  void testAddToMiddle(List<String> list) {
        final long start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            addToMiddle(list);
        }
        final long finish = System.currentTimeMillis();
        System.out.println("Добавление в середину списка: " + (finish - start) + " ms");

    }

    private void testDelFromMiddle(List<String> list) {
        final long start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            list.remove(list.size() / 2);
        }
        final long finish = System.currentTimeMillis();
        System.out.println("Очистка через удаление значения из из середины списка: " + (finish - start) + " ms");
    }

    private void testGetFromMiddle(List<String> list) {
        final long start = System.currentTimeMillis();
        String temp = list.get(list.size() / 2);
        final long finish = System.currentTimeMillis();
        System.out.println("Получение значения из середины списка: " + (finish - start) + " ms");
    }

    private static void addToMiddle(List<String> list) {
        list.add(list.size() / 2, Long.toString(System.nanoTime()));
    }

    private static void testAddToEnd(List<String> list) {
        final long start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            addToEnd(list);
        }
        final long finish = System.currentTimeMillis();
        System.out.println("Добавление в конец списка: " + (finish - start) + " ms");

    }

    private void testGetFromEnd(List<String> list) {
        final long start = System.currentTimeMillis();
        String temp = list.get(list.size() - 1);
        final long finish = System.currentTimeMillis();
        System.out.println("Получение значения из конца списка: " + (finish - start) + " ms");
    }

    private void testDelFromend(List<String> list) {
        final long start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            list.remove(list.size() - 1);
        }
        final long finish = System.currentTimeMillis();
        System.out.println("Очистка через удаление значения из конца списка списка: " + (finish - start) + " ms");
    }

    private static void addToEnd(List<String> list) {
        list.add(list.size(), Long.toString(System.nanoTime()));
    }
}

package ru.zdoher.hw2;

import java.util.*;

public class MapCheck {
    private List<Map<Integer, String>> mapsForTest = new ArrayList<>();
    private static int COUNT;

    public MapCheck() {
        mapsForTest.add(new HashMap<>());
        mapsForTest.add(new LinkedHashMap<>());
        mapsForTest.add(new TreeMap<>());
        mapsForTest.add(new WeakHashMap<>());
        mapsForTest.add(new IdentityHashMap<>());
        COUNT = Main.COUNT;
    }

    public void startTest() {
        for(Map<Integer, String> map : mapsForTest) {
            System.out.println(map.getClass().getSimpleName() + ":");
            test(map);
        }
    }

    private void test(Map<Integer, String> map) {
        testAdd(map);
        testGet(map);
        testDel(map);
        System.out.println("\n");
    }

    private void testAdd(Map<Integer, String> map) {
        final long start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            map.put(i, Long.toString(System.nanoTime()));
        }
        final long finish = System.currentTimeMillis();
        System.out.println("Добавление в мапу: " + (finish - start) + " ms");
    }

    private void testGet(Map<Integer, String> map) {
        final long start = System.currentTimeMillis();
        map.get(COUNT / 2);
        final long finish = System.currentTimeMillis();
        System.out.println("Поиск значения в мапе: " + (finish - start) + " ms");
    }

    private void testDel(Map<Integer, String> map) {
        final long start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            map.remove(i);
        }
        final long finish = System.currentTimeMillis();
        System.out.println("Удаление из мапы: " + (finish - start) + " ms");
    }





}

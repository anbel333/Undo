package com.anbel.Undo;

import java.util.ArrayList;
import java.util.List;

public class MyStringBuilder {
    private StringBuilder stringBuilder;
    private final List<String> snapshots;

    public MyStringBuilder() {
        stringBuilder = new StringBuilder();
        snapshots = new ArrayList<>();
        saveSnapshot();
    }

    public MyStringBuilder(String str) {
        stringBuilder = new StringBuilder(str);
        snapshots = new ArrayList<>();
        saveSnapshot();
    }

    public void append(String str) {
        stringBuilder.append(str);
        saveSnapshot();
    }

    public void undo() {
        if (snapshots.size() > 1) {
            snapshots.removeLast();
            stringBuilder = new StringBuilder(snapshots.getLast());
        }
    }

    private void saveSnapshot() {
        snapshots.add(stringBuilder.toString());
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        MyStringBuilder myStringBuilder = new MyStringBuilder("String");
        System.out.println(myStringBuilder);

        myStringBuilder.append("Builder");
        System.out.println(myStringBuilder);

        myStringBuilder.undo();
        System.out.println(myStringBuilder);
    }
}
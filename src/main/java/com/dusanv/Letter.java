package com.dusanv;

import java.util.ArrayList;
import java.util.List;

public class Letter {

    private List<String> lines = new ArrayList<>();

    public Letter(List<String> lines) {
        this.lines = lines;
    }

    public String getLine(int x) {
        return lines.get(x);
    }

    public int getHeight() {
        return lines.size();
    }
}

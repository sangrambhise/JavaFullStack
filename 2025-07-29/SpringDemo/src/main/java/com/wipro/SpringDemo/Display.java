package com.wipro.SpringDemo;
import org.springframework.stereotype.Component;

@Component
public class Display {
    private int size = 100;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Display{size=" + size + "}";
    }
}

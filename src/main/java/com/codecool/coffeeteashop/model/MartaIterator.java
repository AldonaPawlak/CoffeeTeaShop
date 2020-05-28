package com.codecool.coffeeteashop.model;

import java.util.List;

public class MartaIterator<E> implements Iterator<E> {
    List<E> elements;
    int i;

    public MartaIterator(List<E> elements) {
        this.elements = elements;
    }


    @Override
    public boolean hasNext() {
        return i < elements.size();
    }


    @Override
    public E next() {
        //i ++;
        return elements.get(i++);
    }
}

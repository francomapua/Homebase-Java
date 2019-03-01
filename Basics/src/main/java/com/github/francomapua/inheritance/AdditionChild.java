package com.github.francomapua.inheritance;

/**
 * SubtractionChild
 */
public class AdditionChild extends AbstractParent{

    public AdditionChild(int x, int y, String resultPrefix){
        super(x, y, resultPrefix);
    }

    @Override
    public String operateXFirst() {
        return resultPrefix + (x + y);
    }

    @Override
    public String operateYFirst() {
        return resultPrefix + (y + x);
    }
}
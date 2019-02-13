package com.github.francomapua.inheritance;

/**
 * AbstractParent
 */
public abstract class AbstractParent {
    protected int x;
    protected int y;
    protected String resultPrefix;

    public AbstractParent(int x, int y, String resultPrefix){
        this.x = x;
        this.y = y;
        this.resultPrefix = resultPrefix;
    }

    public abstract String operateXFirst();
    public abstract String operateYFirst();
}
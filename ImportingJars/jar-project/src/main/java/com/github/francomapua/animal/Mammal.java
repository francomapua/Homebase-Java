package com.github.francomapua.animal;

/**
 * Polygon
 */
public abstract class Mammal {
    protected boolean hasFur;
    protected boolean doesLayEggs;
    
    protected String genus;
    protected String species;
    protected String nameEnglish;

    protected String crySound;
    
    public abstract void cry();
}
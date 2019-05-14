package com.github.francomapua.inheritance;

import java.lang.reflect.Field;

/**
 * FieldsCheckParent
 */
public class FieldsCheckParent {

    public String parentOne = "parentOne";
    public String parentTwo = "parentTwo";    

    public void parentCall(){
        System.out.println("I am a parent!");
    }

    public void parentCallFields(){
        Field[] fields = this.getClass().getFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            System.out.println(fieldName);
        }
    }
}
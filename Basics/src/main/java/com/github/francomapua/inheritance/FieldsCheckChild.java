package com.github.francomapua.inheritance;

import java.lang.reflect.Field;

/**
 * FieldsCheckchild
 */
public class FieldsCheckChild extends FieldsCheckParent {

    public String childOne = "childOne";
    public String childTwo = "childTwo";

    public void childCall() {
        System.out.println("I am a child!");
    }

    public void fieldsCallChild() {
        Field[] fields = this.getClass().getFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            System.out.println(fieldName);
        }
    }

    public void callParentFields(){
        super.parentCallFields();
    }
}
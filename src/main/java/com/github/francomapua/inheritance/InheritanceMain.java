package com.github.francomapua.inheritance;

import java.util.ArrayList;

/**
 * InheritanceMain
 */
public class InheritanceMain {

    public void main(){
        int x = 10;
        int y = 5;

        ArrayList<AbstractParent> operationList = new ArrayList<AbstractParent>();

        operationList.add(new AdditionChild(x, y, "Addition Result"));

        AbstractParent subtraction = new SubtractionChild(x, y, "Subtraction Result");
        operationList.add(subtraction);

        DivisionChild division = new DivisionChild(x, y, "Division Result");
        operationList.add(division);

        // Initialize Abstract without extension
        AbstractParent modulus = new AbstractParent(1,2,"I am Modulus"){
        
            @Override
            public String operateYFirst() {
                return resultPrefix + (x % y);
            }
        
            @Override
            public String operateXFirst() {
                return resultPrefix + (y % x);
            }
        };
        operationList.add(modulus);

        for (AbstractParent operation : operationList) {
            System.out.println(operation.operateXFirst());
            System.out.println(operation.operateYFirst() + "\n");
        }
    }    
}
package com.github.francomapua;

import com.github.francomapua.inheritance.FieldsCheckChild;
import com.github.francomapua.inheritance.FieldsCheckParent;
import com.github.francomapua.inheritance.InheritanceMain;
import com.github.francomapua.testing.TestScriptGenerator;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        // IO
        // BasicIO basicIO = new BasicIO();

        // ConnectionDemo demo = new ConnectionDemo();
        // demo.main();

        // Inheritance
        String objectAlias = "sched";

        String[] fields = { 
        "id",
        "task",
        "titleId",
        "assetType",
        "releaseDateTime",
        "contentHours",
        "priority",
        "estimationDateTime",
        "created",
        "titleId"};

        TestScriptGenerator.generateMutatorTest(objectAlias, fields);


        FieldsCheckParent parent = new FieldsCheckParent();
        FieldsCheckChild child = new FieldsCheckChild();
        System.out.println("Parent Fields");
        parent.parentCallFields();
        System.out.println("\nChild Fields");
        child.fieldsCallChild();
        System.out.println("Child Calling Parent");
        child.callParentFields();
    }
}

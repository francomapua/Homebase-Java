package com.github.francomapua;

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
        String objectAlias = "profile";

        String[] fields = { "pixelHeight", "pixelWidth", "fileExtension", "minScreenDensity", "maxScreenDensity" };

        TestScriptGenerator.generateMutatorTest(objectAlias, fields);
    }
}

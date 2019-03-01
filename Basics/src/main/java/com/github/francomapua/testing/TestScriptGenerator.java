package com.github.francomapua.testing;

/**
 * TestScriptGenerator
 */
public class TestScriptGenerator {

    public static void generateMutatorTest(String objectAlias, String[] fields){
        for(String fieldName : fields){
            String upperFirstField = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            System.out.println(objectAlias + ".set" + upperFirstField + "(" + fieldName + ");\n"
            + "assertEquals(" + fieldName + ", " + objectAlias + ".get" + upperFirstField + "());\n");
        }
    }
}
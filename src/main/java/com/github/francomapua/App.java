package com.github.francomapua;

import java.io.IOException;
import java.nio.file.Path;

import javax.sound.sampled.SourceDataLine;

import com.github.francomapua.datatypes.DataTypes;
import com.github.francomapua.io.BasicIO;

/**
 * Hello world!
 *
 */
public class App {

    

    public static void main(String[] args) {
        // IO
        BasicIO basicIO = new BasicIO();
        try{
            System.out.println(basicIO.readFileAsString("src/test/inputfile.txt"));
            basicIO.copyFile("src/test/inputfile.txt", "src/test/outputfile.txt");
        }catch(IOException ex){
            ex.printStackTrace();
        }
    
    }
}

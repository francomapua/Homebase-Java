package com.github.francomapua.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BasicIO{
    
    public Path getAbsolutePath(String path){
        return Paths.get(path).toAbsolutePath();
    }

    // Delete: Works on both files and directories
    public boolean delete(String path){
        Path absPath = getAbsolutePath(path);
        File delete = new File(absPath.toString());
        return delete.delete(); // True if file exists, false if not
    }
    
    public String readFileAsString(String filePath) throws IOException{
        Path absFilePath = getAbsolutePath(filePath);
        StringBuilder sb = new StringBuilder();
        FileInputStream inStream = null;
        Reader reader = null;

        try{
            inStream = new FileInputStream(absFilePath.toString());
            reader = new InputStreamReader(inStream, "UTF-8");
            int readChar;
            while((readChar = reader.read()) >= 0){
                sb.append((char)readChar);
            }
        }finally{
            if(inStream != null){
                inStream.close();
            }
            if(reader != null){
                reader.close();
            }
        }
        return sb.toString();
    }
    
    public void copyFile(String sourceFilePath, String targetFilePath) throws IOException{
        FileInputStream inStream = null;
        FileOutputStream outStream = null;
        String absInFilePath = getAbsolutePath(sourceFilePath).toString();
        String absOutFilePath = getAbsolutePath(targetFilePath).toString();
        try{
            inStream = new FileInputStream(absInFilePath);
            outStream = new FileOutputStream(absOutFilePath);

            int data;
            while((data = inStream.read()) != -1){
                outStream.write(data);
            }
        }finally{
            if(inStream != null){
                inStream.close();
            }
            if(outStream != null){
                outStream.close(); 
            }
        }
    }

    public void ListFilesInDirectory(String dir){
    }
}
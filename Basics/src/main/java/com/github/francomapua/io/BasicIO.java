package com.github.francomapua.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;

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

    public void listFilesInADirectory(String dir){
        File directory = new File(dir);
        
        // Check if directory is valid
        if(!directory.exists() || !directory.isDirectory()){
            return;
        }

        // Iterate over files and print names
        for(File file : directory.listFiles()){
            System.out.println(file.getName());
        }
    }

    public void getXNewestFIles(String dir, int count){
        File directory = new File(dir);
        
        // Check if directory is valid
        if(!directory.exists() || !directory.isDirectory()){
            return;
        }
        File[] files = directory.listFiles();
        if(files.length == 0){
            return;
        } else if(files.length < count){
            count = files.length;
        }
        

        // Sort files in directory by creation date
        Arrays.sort(files, new Comparator<File>() {
            @Override
            public int compare(File file1, File file2) {
                long lastModified = file2.lastModified() - file1.lastModified();
                return lastModified < 0 ? -1 : 1;
            }
        });

        File[] newestFiles = Arrays.copyOfRange(files, 0, count);
        for(File file : newestFiles){
            System.out.println(file.getName() + " - " + file.lastModified());
        }
        
    }
}
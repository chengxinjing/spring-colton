package com.colton.geode.batch;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.core.partition.support.SimplePartitioner;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.cache.annotation.Cacheable;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserPartitioner implements Partitioner {
    private String file;
    private int linesize;
    private static final String partition ="PARTION";
    public UserPartitioner(String file) {
        this.file=file;
        int countLine=0;
        try (BufferedReader fileReader = new BufferedReader(new FileReader(new File(file))) ) {
            while (fileReader.readLine()!=null){
                countLine++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLinesize(countLine);
    }

    @Override
    public Map<String, ExecutionContext> partition(int gridSize) {
        int minLine=1;
        int maxLine=this.linesize;

        int targetLine=(maxLine -minLine)/gridSize +1;
        int endLine=targetLine;
        Map<String,ExecutionContext> map = new HashMap<>(gridSize);
        for (int i = 0 ; i<gridSize;i++){
            ExecutionContext context = new ExecutionContext();
            context.put("startLine",minLine);
            context.put("endLine",endLine);
            map.put(partition+i,context);
            minLine=endLine+1;
            endLine+=targetLine;
            if (endLine>=maxLine){
                endLine=maxLine;
            }

        }
        return map;
    }

    public void setLinesize(int linesize) {
        this.linesize = linesize;
    }
}

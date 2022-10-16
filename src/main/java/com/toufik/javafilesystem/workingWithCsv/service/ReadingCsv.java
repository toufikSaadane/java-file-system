package com.toufik.javafilesystem.workingWithCsv.service;

import com.toufik.javafilesystem.util.Paths;
import com.toufik.javafilesystem.workingWithCsv.domain.ResearchTopics;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ReadingCsv {

    public final static Path FILE =  Path.of(Paths.RESEARCH_CSV_DATA);
    Function<String, ResearchTopics> researchTopicsFunction = this::lineToTopic;
    Predicate<String> excludedLine = line -> !line.startsWith("#");

    @Test
    public void fromCsvToTopics(){
        try (BufferedReader reader = Files.newBufferedReader(FILE)){
            String line = reader.readLine();
            while (line != null){
                if (!line.startsWith("#")) {
                 ResearchTopics researchTopics = lineToTopic(line);
                    System.out.println(researchTopics);
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void fromCsvToTopicsUsingStream(){
        try (BufferedReader reader = Files.newBufferedReader(FILE)){
            Stream<String> lines = reader.lines();
            lines.filter(excludedLine)
                 .map(researchTopicsFunction)
                 .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public ResearchTopics lineToTopic(String line){
        String[] elements = line.split(",");
        int id = Integer.parseInt(elements[0]);
        String description = elements[1];
        return  new ResearchTopics(id, description);
    }
}

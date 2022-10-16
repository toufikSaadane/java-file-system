package com.toufik.javafilesystem.readingWritingCreatingFiles;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static com.toufik.javafilesystem.util.Paths.FILE_NAME;

@Slf4j
public class UsingBufferReader {

    @Test
    public void readTextFile(){
        Path filePath = Path.of(FILE_NAME);
        log.info("Is the file existing  : {}", Files.exists(filePath));
        try(BufferedReader bufferedReader = Files.newBufferedReader(filePath)) {
            String message = bufferedReader.readLine();
            while (message != null){
                System.out.println(message);
                message = bufferedReader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("RuntimeException while reading   " + e);
        }
    }
}

package com.toufik.javafilesystem.readingWritingCreatingFiles;

import com.google.common.io.Files;
import com.toufik.javafilesystem.util.Paths;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import static org.junit.Assert.assertTrue;

@Slf4j
public class CreateFile {
    private static boolean SUCCESS = false;
    public static Boolean createAFileUsingFileClass(String fileName){
        try {
            File newFile = new File(fileName);
            SUCCESS = newFile.createNewFile();
            log.info("Is creating file a success? : {}", SUCCESS);
        }catch (IOException exception){
            System.out.println("IOException : " + exception.getMessage());
        }
        return SUCCESS;
    }
    public static String createAFileUsingGuava(String fileName){
        try {
            Files.touch(new File(fileName));
            SUCCESS = true;
        }catch (IOException exception){
            System.out.println("IOException : " + exception.getMessage());
        }
        return fileName;
    }

    @Test
    public void givenUsingNio_whenCreatingFile_thenCorrect(){
        assertTrue(createAFileUsingFileClass(Paths.FILE_NAME));
    }

    @Test
    public void givenUsingGuava_whenCreatingFile_thenCorrect(){
    }

}

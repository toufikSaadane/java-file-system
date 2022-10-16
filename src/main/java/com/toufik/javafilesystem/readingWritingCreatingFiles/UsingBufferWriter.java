package com.toufik.javafilesystem.readingWritingCreatingFiles;

import com.toufik.javafilesystem.util.JavaFakerGenerator;
import com.toufik.javafilesystem.util.Paths;
import org.junit.Test;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class UsingBufferWriter {

    @Test
    public void whenWriteStringUsingBufferedWriter_thenCorrect(){
        String message = JavaFakerGenerator.createFakePerson();
        BufferedWriter writer = null;
        try {
            String file = CreateFile.createAFileUsingGuava(Paths.ABSOLUT_FILE_NAME
                    .concat(getClass().getName()
                            .concat(String.valueOf(LocalDate.now())))+".txt");
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(message);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

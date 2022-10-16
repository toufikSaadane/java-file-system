package com.toufik.javafilesystem.workingWithCsv.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data  @AllArgsConstructor @NoArgsConstructor
public class ResearchTopics {
    private long Id;
    private String description;

    @Override
    public String toString() {
        return "ResearchTopics : " + "Id = " + Id + " description = " + description ;
    }
}

package edu.nd.cse.ids.finalproject;

import com.opencsv.bean.*;

import java.util.List;
import java.util.HashMap;
import java.io.FileReader;

public class ExerciseReader
{
    private List<Exercise> exercises;

    public ExerciseReader()
    {
        exercises = null;
    }

    public void readExerciseFile(String filename)
    {
        try {
            this.exercises = new CsvToBeanBuilder(new FileReader(filename))
                                .withType(Exercise.class).build().parse();
        } catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    public List<Exercise> getExercises()
    {
        return this.exercises;
    }
}

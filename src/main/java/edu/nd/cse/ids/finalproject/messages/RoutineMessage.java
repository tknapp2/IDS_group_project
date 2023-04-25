package edu.nd.cse.ids.finalproject.messages;
import java.util.List;

import edu.nd.cse.ids.finalproject.Exercise;

public class RoutineMessage extends Message {
    private int time;
    private int reps;
    private int sets;

    private String name;
    
    public RoutineMessage() {}
    
    /**
    * Generate this message from the raw data.
    *
    * @param    exercise   the object providing access to the raw data
    */
    public void generate(Exercise exercise)
    {
        setTime(20);
        setName(exercise.getName());
       

    }
    public void setTime(int time)
    {
        this.time = time;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setReps(int reps)
    {
        this.reps = reps;
    }
    public void setSets(int sets)
    {
        this.sets = sets;
    }
    public int getTime()
    {
        return this.time;
    }

    public String getName()
    {
        return this.name;
    }
    public int getReps()
    {
        return this.reps;
    }
    public int getSets()
    {
        return this.sets;
    }



    
}

package edu.nd.cse.ids.finalproject.messages;
import edu.nd.cse.ids.finalproject.Exercise;

public class ExerciseDifficultyMessage extends Message {
    private String name;
    private String level;
    private String equipment;


    
    public ExerciseDifficultyMessage() {}
    
    /**
    * Generate this message from the raw data.
    *
    * @param    exercise   the object providing access to the raw data
    */
    public void generate(Exercise exercise)
    {
        setName(exercise.getName());
        /*setMuscleGroup1(exercise.getMuscleGroup1());
        setMuscleGroup2(exercise.getMuscleGroup2());
        setMuscleGroup3(exercise.getMuscleGroup3());
        setInstructions(exercise.getInstructions());
        */
        setLevel(exercise.getLevel());
        setEquipment(exercise.getEquipment());

    }
    
    public void setName(String name)
    {
        this.name = name;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    
    public String getName()
    {
        return this.name;
    }

    public String getLevel() {
        return this.level;
    }

    public String getEquipment() {
        return this.equipment;
    }
}

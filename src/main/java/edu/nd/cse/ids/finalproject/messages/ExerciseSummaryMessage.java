package edu.nd.cse.ids.finalproject.messages;
import edu.nd.cse.ids.finalproject.Exercise;

public class ExerciseSummaryMessage extends Message {
    private String name;
    private String MuscleGroup1;
    private String MuscleGroup2;
    private String MuscleGroup3;
    private String level;
    private String equipment;
    private String instructions;

    
    public ExerciseSummaryMessage() {}
    
    /**
    * Generate this message from the raw data.
    *
    * @param    exercise   the object providing access to the raw data
    */
    public void generate(Exercise exercise)
    {
        setName(exercise.getName());
        setMuscleGroup1(exercise.getMuscleGroup1());
        setMuscleGroup2(exercise.getMuscleGroup2());
        setMuscleGroup3(exercise.getMuscleGroup3());
        setInstructions(exercise.getInstructions());
        setLevel(exercise.getLevel());
        setEquipment(exercise.getEquipment());
        
    }
    
    public void setName(String name)
    {
        this.name = name;
    }

    public void setMuscleGroup1(String MuscleGroup1) {
        this.MuscleGroup1 = MuscleGroup1;
    }

    public void setMuscleGroup2(String MuscleGroup2) {
        this.MuscleGroup2 = MuscleGroup2;
    }

    public void setMuscleGroup3(String MuscleGroup3) {
        this.MuscleGroup3 = MuscleGroup3;
    }

    public void setInstructions(String instruction) {
        this.instructions = instruction;
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

    public String getMuscleGroup1() {
        return this.MuscleGroup1;
    }

    public String getMuscleGroup2() {
        return this.MuscleGroup2;
    }

    public String getMuscleGroup3() {
        return this.MuscleGroup3;
    }

    public String getInstructions() {
        return this.instructions;
    }

    public String getLevel() {
        return this.level;
    }

    public String getEquipment() {
        return this.equipment;
    }
}

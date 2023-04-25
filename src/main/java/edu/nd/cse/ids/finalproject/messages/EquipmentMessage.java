package edu.nd.cse.ids.finalproject.messages;
import edu.nd.cse.ids.finalproject.Exercise;

public class EquipmentMessage extends Message {
    private String name;
    private String equipment;
 

    
    public EquipmentMessage() {}
    
    /**
    * Generate this message from the raw data.
    *
    * @param    exercise   the object providing access to the raw data
    */
    public void generate(Exercise exercise)
    {
        setName(exercise.getName());
        /*setMuscleGroup1(excercise.getMuscleGroup1());
        setMuscleGroup2(excercise.getMuscleGroup2());
        setMuscleGroup3(excercise.getMuscleGroup3());
        setInstructions(exercise.getInstructions());
        setLevel(exercise.getLevel());*/
        setEquipment(exercise.getEquipment());
    }
    
    public void setName(String name)
    {
        this.name = name;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }
    
    public String getName()
    {
        return this.name;
    }

    public String getEquipment() {
        return this.equipment;
    }
}

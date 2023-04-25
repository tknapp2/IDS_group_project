package edu.nd.cse.ids.finalproject.messages;
import edu.nd.cse.ids.finalproject.Exercise;

public class ExerciseNameMessage extends Message {
    private String name;
    

    
    public ExerciseNameMessage() {}
    
    /**
    * Generate this message from the raw data.
    *
    * @param    exercise   the object providing access to the raw data
    */
    public void generate(Exercise exercise)
    {
        setName(exercise.getName());
        System.out.println("Exercise:" + exercise.getName());
        
        /*setMuscleGroup1(exercise.getMuscleGroup1());
        setMuscleGroup2(exercise.getMuscleGroup2());
        setMuscleGroup3(exercise.getMuscleGroup3());
        setInstructions(exercise.getInstructions());
        setLevel(exercise.getLevel());
        setEquipment(exercise.getEquipment());
        setInstructions(exercise.getInstructions());
*/
    }
    
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

}

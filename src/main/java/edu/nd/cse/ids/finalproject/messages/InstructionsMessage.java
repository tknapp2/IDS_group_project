package edu.nd.cse.ids.finalproject.messages;
import edu.nd.cse.ids.finalproject.Exercise;

public class InstructionsMessage extends Message {
    private String name;
    private String instructions;

    
    public InstructionsMessage() {}
    
    /**
    * Generate this message from the raw data.
    *
    * @param    exercise   the object providing access to the raw data
    */
    public void generate(Exercise exercise)
    {
        setName(exercise.getName());
        setInstructions(exercise.getInstructions());
   
        
    }
    
    public void setName(String name)
    {
        this.name = name;
    }

    public void setInstructions(String instruction) {
        this.instructions = instruction;
    }

    
    public String getName()
    {
        return this.name;
    }

    public String getInstructions() {
        return this.instructions;
    }

}

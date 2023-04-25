package edu.nd.cse.ids.finalproject.messages;
import edu.nd.cse.ids.finalproject.Exercise;
import java.util.Random;

public class GreetingMessage extends Message {
    private String greeting;

    
    public GreetingMessage() {}
    
    /**
    * Generate this message from the raw data.
    *
    * @param    exercise   the object providing access to the raw data
    */
    public void generate(Exercise exercise)
    {
        String[] greeting_list = {"I am happy to help", "Way to take care of yourself", "Welcome I am here to assist you"};
        int rnd = new Random().nextInt(greeting_list.length);
        setGreeting(greeting_list[rnd]);
      
    }
    
    public void setGreeting(String greeting)
    {
        this.greeting = greeting;
    }
    public String getGreeting() {
        return this.greeting;
    }
}

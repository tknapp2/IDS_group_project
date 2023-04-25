package edu.nd.cse.ids.finalproject;

import edu.nd.cse.ids.finalproject.messages.*;
import java.util.Arrays;
import gov.nih.nlm.nls.lexCheck.Lib.NounEntry;
import gov.nih.nlm.nls.lvg.Util.Word;

import org.apache.tools.ant.taskdefs.AbstractJarSignerTask;
import java.util.List;
import java.util.LinkedList;
import java.util.Hashtable;

import simplenlg.framework.*;
import simplenlg.lexicon.*;
import simplenlg.realiser.english.*;
import simplenlg.phrasespec.*;
import simplenlg.features.*;

public class MicroPlanner
{
    private Lexicon lexicon;
    private NLGFactory nlgFactory;
    
    /**
    * Constructor for MicroPlannerStyleZero.
    * Initialize the lexicon and nlgFactory for this object.  Do not recreate
    * a new lexicon/nlgFactory every time you call lexicalize().  Instead,
    * create it once here for the whole object and reuse it.
    */
    public MicroPlanner()
    {
        // your code here
        this.lexicon = Lexicon.getDefaultLexicon();
        this.nlgFactory = new NLGFactory(this.lexicon);
    }

    /**
    * Create a the text specification from the document plan.
    * Recall that a text specification is just a list of sentence
    * specifications, and that a document plan is just a list of messages.
    * This method should go through each message and call the
    * correct handleMessage() function for that message.
    *
    * @param    documentPlan    the list of messages to process
    * @return                   the text specification
    */
    public List<SPhraseSpec> lexicalize(List<Message> documentPlan)
    {
        System.out.println("lexicalizing");
        List<SPhraseSpec> phrases = new LinkedList<SPhraseSpec>();
        for (Message message : documentPlan) {
            System.out.println(message);
            // will use switch to check which type of message it is
            if (message instanceof GreetingMessage) {
                System.out.println("greeting");
                SPhraseSpec s1 = handleMessage((GreetingMessage) message);
                phrases.add(s1);
            } else if (message instanceof AlternativeExerciseMessage) {
                SPhraseSpec s2 = handleMessage((AlternativeExerciseMessage) message);
                phrases.add(s2);
            } else if (message instanceof ExerciseDifficultyMessage) {
                SPhraseSpec s5 = handleMessage((ExerciseDifficultyMessage) message);
                phrases.add(s5);
            } else if (message instanceof RoutineMessage) {
                SPhraseSpec s6 = handleMessage((RoutineMessage) message);
                phrases.add(s6);
            } else if (message instanceof EquipmentMessage) {
                SPhraseSpec s7 = handleMessage((EquipmentMessage) message);
                phrases.add(s7);
            } else if (message instanceof ExerciseNameMessage) {
                SPhraseSpec s8 = handleMessage((ExerciseNameMessage) message);
                phrases.add(s8);
            } else if (message instanceof ExerciseSummaryMessage) {
                SPhraseSpec s9 = handleMessage((ExerciseSummaryMessage) message);
                phrases.add(s9);
            } else if (message instanceof InstructionsMessage) {
                SPhraseSpec s10 = handleMessage((InstructionsMessage) message);
                phrases.add(s10);
            } else if (message instanceof MuscleInfoMessage) {
                SPhraseSpec s11 = handleMessage((MuscleInfoMessage) message);
                phrases.add(s11);
            } 
        }
        return phrases;
        
    }
    
    /**
    * Creates a single sentence specification for each message.
    * Remember that microplanner has two jobs:
    * 1. Create a sentence specification for each message, and
    * 2. Aggregate those specifications into a final list of specs to realize.
    * This method does job 1 for a particular message, in this case the
    * NumBedroomMessage.  This is where you create an SPhraseSpec simplenlg
    * object to prepare for realization later.  You set the nouns, verbs, etc.
    * that are necessary to actually render the sentence, without actually
    * calling the realizer yet.
    * <p>
    * The work for job 2 happens in lexicalize().  That is the method that
    * aggregates and forms the final list of sentence specifications to send
    * to the realizer.
    *
    * @param    message a NumBedroomMessage object to specify
    * @return           a single sentence specification for the given message
    */
    //will need to find the muscles targeted and look for something like it (works the same muscles)
    //blank is an alternative for blank when you dont have the right equipment
    //blank is an alternative if you have mobility issues
    public SPhraseSpec handleMessage(AlternativeExerciseMessage message)
    {
        
        SPhraseSpec s1 = nlgFactory.createClause();
        String name = message.getName();
        String equipment = message.getEquipment();
        String muscle = message.getMuscleGroup1();
        String muscle2 = message.getMuscleGroup2();


        WordElement we_exercise = new WordElement(name, LexicalCategory.NOUN);
        NPPhraseSpec np_exercise = nlgFactory.createNounPhrase(we_exercise);
        np_exercise.setDeterminer("a");

        WordElement we_muscle = new WordElement(muscle, LexicalCategory.NOUN);
        WordElement we_muscle2 = new WordElement(muscle2, LexicalCategory.NOUN);
        
        WordElement we_alt = new WordElement("exercise", LexicalCategory.NOUN);
        NPPhraseSpec np_alt= nlgFactory.createNounPhrase(we_alt);
        np_alt.setDeterminer("an");
        np_alt.addModifier("alternative");
       
       
        PPPhraseSpec prep= nlgFactory.createPrepositionPhrase();
        prep.setPreposition("to work");
        prep.setComplement(we_muscle);

        s1.setSubject(np_exercise);
        s1.setVerb("is");
        s1.setObject(np_alt);
        s1.addModifier(prep);
       
       /*  PPPhraseSpec prep = nlgFactory.createPrepositionPhrase();
        prep.setPreposition("to");
        prep.addComplement("you");
        s1.addModifier(prep);
        */
        return s1;
    }

    /*
    * @param    message a NumBathroomMessage object to specify
    * @return           a single sentence specification for the given message
    */
    //
    public SPhraseSpec handleMessage(ExerciseNameMessage message)
    {
        SPhraseSpec s1 = nlgFactory.createClause();
        
        String name = message.getName();

        WordElement we_exercise = new WordElement(name, LexicalCategory.NOUN);
        NPPhraseSpec np_exercise = nlgFactory.createNounPhrase(we_exercise);
        np_exercise.setDeterminer("the");


       

        s1.setSubject(np_exercise);
        return s1;
    }

    /*
    * @param    message a NumBedsMessage object to specify
    * @return           a single sentence specification for the given message
    */
    //Deadlifts target the hamstrings and the glutes. it is a beginner movement. 
    public SPhraseSpec handleMessage(ExerciseSummaryMessage message)
    {
        SPhraseSpec s1 = nlgFactory.createClause();
        SPhraseSpec s2 = nlgFactory.createClause();
        
        String name = message.getName();
        String muscle1 = message.getMuscleGroup1();
        String muscle2 = message.getMuscleGroup2();
        String equipment = message.getEquipment();
        


        WordElement we_name = new WordElement(name, LexicalCategory.NOUN);
        NPPhraseSpec np_name = nlgFactory.createNounPhrase(we_name);
        np_name.setPlural(false);

        WordElement we_work = new WordElement("work", LexicalCategory.VERB);
        WordElement we_muscle1 = new WordElement(muscle1, LexicalCategory.NOUN);
        NPPhraseSpec np_muscle1 = nlgFactory.createNounPhrase(we_muscle1);
        np_muscle1.setDeterminer("the");
        WordElement we_muscle2 = new WordElement(muscle2, LexicalCategory.NOUN);
        NPPhraseSpec np_muscle2 = nlgFactory.createNounPhrase(we_muscle2);
        np_muscle2.setDeterminer("the");
        WordElement we_equipment = new WordElement(equipment, LexicalCategory.NOUN);
        PPPhraseSpec prep= nlgFactory.createPrepositionPhrase();
        
        prep.setPreposition("requiring");
        prep.setComplement(we_equipment);
        if (muscle2.equals("N/A")){
            s1.setObject(np_muscle1);
        }
        else{
            CoordinatedPhraseElement obj = nlgFactory.createCoordinatedPhrase(np_muscle1, np_muscle2);
            s1.setObject(obj);
        }
        
            

        //NPPhraseSpec np_beds = nlgFactory.createNounPhrase(we_bed);
        //np_beds.addPreModifier(Integer.toString(numBeds));

  
        s1.setSubject(np_name);
        s1.setVerb(we_work);
        s1.addModifier(prep);
       
    
        
/*
        PPPhraseSpec prep = nlgFactory.createPrepositionPhrase();
        prep.setPreposition("for");
        prep.addComplement("you");
        s1.addModifier(prep);
*/
        return s1;
    }

    /*
    * @param    message a NumGuestMessage object to specify
    * @return           a single sentence specification for the given message
    */
    public SPhraseSpec handleMessage(ExerciseDifficultyMessage message)
    {
        SPhraseSpec s1 = nlgFactory.createClause();

        WordElement we_difficulty = new WordElement(message.getLevel(), LexicalCategory.NOUN);

        WordElement we_exercise = new WordElement("exercise", LexicalCategory.NOUN);
        NPPhraseSpec np_exercise = nlgFactory.createNounPhrase(we_exercise);
        np_exercise.setDeterminer("this");

        WordElement we_movement = new WordElement("movement", LexicalCategory.NOUN);

        NPPhraseSpec np_movement = nlgFactory.createNounPhrase(we_movement);
        np_movement.addPreModifier(we_difficulty);

        s1.setSubject(np_exercise);
        s1.setVerb("is");
        s1.setObject(np_movement);

        return s1;
    }

    /*
    * @param    message a ItemCountMessage object to specify
    * @return           a single sentence specification for the given message
    */

    public SPhraseSpec handleMessage(MuscleInfoMessage message)
    {
       
        SPhraseSpec s1 = nlgFactory.createClause();
         
        String name = message.getName();
        String m1 = message.getMuscleGroup1();
        String m2 = message.getMuscleGroup2();
        String m3 = message.getMuscleGroup3();

        WordElement we_name = new WordElement(name, LexicalCategory.NOUN);
        WordElement we_m1 = new WordElement(m1, LexicalCategory.NOUN);
        WordElement we_m2 = new WordElement(m2, LexicalCategory.NOUN);
        WordElement we_m3 = new WordElement(m3, LexicalCategory.NOUN);

        
        NPPhraseSpec np_m1 = nlgFactory.createNounPhrase(we_m1);
        NPPhraseSpec np_m2 = nlgFactory.createNounPhrase(we_m2);
        NPPhraseSpec np_m3 = nlgFactory.createNounPhrase(we_m3);
        np_m1.setDeterminer("the");

        s1.setSubject(we_name);
        s1.setVerb("target");
        s1.setObject(np_m1);
        s1.setObject(np_m2);
        s1.setObject(np_m3);

        return s1;
    }

    /*
    * @param    message a IncludesListMessage object to specify
    * @return           a single sentence specification for the given message
    */
    //here is a blank minute workout
    //blank reps of blank.
    public SPhraseSpec handleMessage(RoutineMessage message)
    {
        SPhraseSpec s1 = nlgFactory.createClause();
        SPhraseSpec s2 = nlgFactory.createClause();
        SPhraseSpec s3 = nlgFactory.createClause();
        SPhraseSpec s4 = nlgFactory.createClause();
        SPhraseSpec s5 = nlgFactory.createClause();
        SPhraseSpec s6 = nlgFactory.createClause();
        SPhraseSpec s7 = nlgFactory.createClause();
        
        
        int time = message.getTime();
        /*String exercise1 = message.getExercise1();
        String exercise2 = message.getExercise2();
        String exercise3 = message.getExercise3();
        int numReps1 = message.getReps1();
        int numSets1 = message.getSets1();
        int numReps2 = message.getReps2();
        int numSets2 = message.getSets2();
        int numReps3 = message.getReps3();
        int numSets3 = message.getSets3();
        int numReps4 = message.getReps4();
        int numSets4 = message.getSets4();
*/
        WordElement we_here = new WordElement("here", LexicalCategory.NOUN);
        NPPhraseSpec np_here = nlgFactory.createNounPhrase(we_here);

        WordElement we_workout = new WordElement("workout", LexicalCategory.NOUN);
        NPPhraseSpec np_workout = nlgFactory.createNounPhrase(we_workout);

        WordElement we_minute = new WordElement("minute", LexicalCategory.NOUN);
        NPPhraseSpec np_minute = nlgFactory.createNounPhrase(we_minute);
        np_minute.addPreModifier(Integer.toString(time));

        np_workout.addPreModifier(np_minute);
        
        s1.setSubject(np_here);
        s1.setVerb("is");
        s1.setObject(np_workout);



        WordElement we_exercise1 = new WordElement("deadlift", LexicalCategory.NOUN);
        WordElement we_exercise2 = new WordElement("lunges", LexicalCategory.NOUN);
        WordElement we_exercise3 = new WordElement("hip thrusts", LexicalCategory.NOUN);
        WordElement we_reps = new WordElement("reps", LexicalCategory.NOUN);
        WordElement we_set = new WordElement("set", LexicalCategory.NOUN);
        NPPhraseSpec np_reps1 = nlgFactory.createNounPhrase(we_reps);
        np_reps1.setDeterminer(Integer.toString(12));
        NPPhraseSpec np_reps2 = nlgFactory.createNounPhrase(we_reps);
        np_reps2.setDeterminer(Integer.toString(12));
        NPPhraseSpec np_reps3 = nlgFactory.createNounPhrase(we_reps);
        np_reps3.setDeterminer(Integer.toString(12));
        WordElement we_perform = new WordElement("perform", LexicalCategory.VERB);
        WordElement we_repeat = new WordElement("repeat", LexicalCategory.VERB);
        WordElement we_exercise = new WordElement("exercise", LexicalCategory.NOUN);
        PPPhraseSpec prepA= nlgFactory.createPrepositionPhrase();
    
        s2.setVerb(we_perform);
        s2.setObject(np_reps1);
        prepA.setPreposition("of");
        prepA.setComplement(we_exercise1);
        
        if (3 > 1){
            NPPhraseSpec np_set = nlgFactory.createNounPhrase(we_set);
            np_set.setDeterminer(Integer.toString(3));

            NPPhraseSpec np_exercise = nlgFactory.createNounPhrase(we_exercise);
            np_exercise.setDeterminer("this");
            
            PPPhraseSpec prep1= nlgFactory.createPrepositionPhrase();
            prep1.setPreposition("for");
            prep1.setComplement(np_set);
    
            s3.setVerb(we_repeat);
            s3.setObject(np_exercise);
            s3.addModifier(prep1);
           
            
        }
        PPPhraseSpec prepB= nlgFactory.createPrepositionPhrase();
    
        s4.setVerb(we_perform);
        s4.setObject(np_reps2);
        prepB.setPreposition("of");
        prepB.setComplement(we_exercise2);

        if (3 > 1){
            NPPhraseSpec np_set = nlgFactory.createNounPhrase(we_set);
            np_set.setDeterminer(Integer.toString(3));

            NPPhraseSpec np_exercise = nlgFactory.createNounPhrase(we_exercise);
            np_exercise.setDeterminer("this");
            
            PPPhraseSpec prep2= nlgFactory.createPrepositionPhrase();
            prep2.setPreposition("for");
            prep2.setComplement(np_set);
    
            s5.setVerb(we_repeat);
            s5.setObject(np_exercise);
            s5.addModifier(prep2);
           
            
        }
        PPPhraseSpec prepC= nlgFactory.createPrepositionPhrase();
    
        s6.setVerb(we_perform);
        s6.setObject(np_reps3);
        prepC.setPreposition("of");
        prepC.setComplement(we_exercise3);
        if (3 > 1){

            NPPhraseSpec np_set = nlgFactory.createNounPhrase(we_set);
            np_set.setDeterminer(Integer.toString(3));

            NPPhraseSpec np_exercise = nlgFactory.createNounPhrase(we_exercise);
            np_exercise.setDeterminer("this");
            
            PPPhraseSpec prep3= nlgFactory.createPrepositionPhrase();
            prep3.setPreposition("for");
            prep3.setComplement(np_set);
    
            s7.setVerb(we_repeat);
            s7.setObject(np_exercise);
            s7.addModifier(prep3);
           
            
        }
    CoordinatedPhraseElement c = nlgFactory.createCoordinatedPhrase();
    
    c.addCoordinate(s2);
    c.addCoordinate(s3);
    c.addCoordinate(s4);
    c.addCoordinate(s5);
    c.addCoordinate(s6);
    c.addCoordinate(s7);
    s1.setObject(c);
    return s1;
    }

    public SPhraseSpec handleMessage(InstructionsMessage message)
    {
        SPhraseSpec s1 = nlgFactory.createClause();
        SPhraseSpec s2 = nlgFactory.createClause();

        String name = message.getName();
        String instructions = message.getInstructions();

        NPPhraseSpec np_howto= nlgFactory.createNounPhrase("how to");
        WordElement we_exercise = new WordElement(name, LexicalCategory.NOUN);
        NPPhraseSpec np_name= nlgFactory.createNounPhrase(we_exercise);
        np_name.setDeterminer("a");
        NPPhraseSpec np_instructions= nlgFactory.createNounPhrase(instructions);
    
        s1.setSubject(np_howto);
        s1.setVerb("do");
        s1.setObject(np_name);
        s2.setSubject(np_instructions);
        return s1;
    }

    /*
    * @param    message a PetsAllowedMessage object to specify
    * @return           a single sentence specification for the given message
    */
    public SPhraseSpec handleMessage(EquipmentMessage message)
    { 
        SPhraseSpec s1 = nlgFactory.createClause();
        String equipment = message.getEquipment();
        WordElement we_equipment = new WordElement(equipment, LexicalCategory.NOUN);
        
        NPPhraseSpec np_equip = nlgFactory.createNounPhrase(we_equipment);
        WordElement we_you = new WordElement("you", LexicalCategory.NOUN);
            
        s1.setSubject(we_you);
        s1.setVerb("need");
        s1.setObject(np_equip);
        
        return s1;
    }

    /*
    * @param    message a GreetingMessage object to specify
    * @return           a single sentence specification for the given message
    */
    public SPhraseSpec handleMessage(GreetingMessage message)
    {
        SPhraseSpec s1 = nlgFactory.createClause();
        String greeting = message.getGreeting();

        WordElement we_greeting = new WordElement(greeting, LexicalCategory.ANY);
        
        NPPhraseSpec np_greeting = nlgFactory.createNounPhrase(we_greeting);
        s1.setObject(np_greeting);
        s1.setFeature(Feature.EXCLAMATORY, true);
        return s1;
    }
   
}

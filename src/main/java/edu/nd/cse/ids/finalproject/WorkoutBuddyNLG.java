package edu.nd.cse.ids.finalproject;

import edu.nd.cse.ids.finalproject.messages.*;

import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.Option;

import java.util.LinkedList;

import simplenlg.framework.*;
import simplenlg.lexicon.*;
import simplenlg.realiser.english.*;
import simplenlg.phrasespec.*;
import simplenlg.features.*;

public class WorkoutBuddyNLG
{
    private ExerciseReader reader;
    private DocumentPlanner docplanner;
    private MicroPlanner microplanner;
    private Realizer realizer;
    
    public WorkoutBuddyNLG(String datfile)
    {
        this.reader = new ExerciseReader();
        this.reader.readExerciseFile(datfile);

        this.docplanner = new DocumentPlanner();
        this.microplanner = new MicroPlanner();

        //this.style = style;
        /*switch(this.style) {
            case 0: this.microplanner = new MicroPlannerStyleZero();
                    break;
            case 1: this.microplanner = new MicroPlannerStyleOne();
                    break;
            case 2: this.microplanner = new MicroPlannerStyleTwo();
                    break;
        }
        */
        this.realizer = new Realizer();
    }
    public List<String> describeExercise(Exercise exercise)
    {  
        this.docplanner.createMessages(exercise);
        
        List<Message> documentPlan = this.docplanner.getMessages();
        

        List<SPhraseSpec> sentences = this.microplanner.lexicalize(documentPlan);

        
        System.out.println("created sentences");
        return(this.realizer.realize(sentences));
    }

    public List<List<String>> describeAllExercises()
    {
        List<List<String>> allSentences = new LinkedList<List<String>>();
    
        for(Exercise exercise: this.reader.getExercises())
        {
            allSentences.add(describeExercise(exercise));
        }
        System.out.println("described all exercises");
        System.out.println(allSentences);
        return(allSentences);
    }
    public List<String> describeExerciseById(int exerciseid)
    {
        //try
        //{
            Exercise exercise = this.reader.getExercises().get(exerciseid);
            return(this.describeExercise(exercise));
        /* } catch(Exception ex)
        {
            return(null);
        }*/
    }

  

    public List<String> askQuestion(String question) {
        // TODO: fill in this function!!!!!
        //HouseEntry house = this.reader.getHouses().get(houseid);
        Exercise exercise = this.reader.getExercises().get(9);

        this.docplanner.answerQuestion(exercise, question);
        
        List<Message> documentPlan = this.docplanner.getMessages();
        
        List<SPhraseSpec> sentences = this.microplanner.lexicalize(documentPlan);
        
        List<String> results = this.realizer.realize(sentences);
        for(String sentence: results)
            {
                System.out.println(sentence);
            }
        return(this.realizer.realize(sentences));
    }

    public static void main(String[] args)
    {
        // parse command line
        String question = "";
        int qindex = -1;
        for (int i = 0; i < args.length; i++) {
            if(args[i].equals("-q")) {
                qindex = i;
            }
        }

        if (qindex != -1) {
            for (int i = qindex + 1; i < args.length; i++) {
                question = question + args[i] + " ";
            }
        } else {
            question = String.join(" ", args);
        }
        question = question.trim();
        System.out.println("You Asked: " + question);
        
        String fileIn = "data/context.csv";
        int time = 20;

        WorkoutBuddyNLG workoutNlg = new WorkoutBuddyNLG(fileIn);
        List<String> description = workoutNlg.describeExerciseById(9);
        //List<List<String>> allSentences = workoutNlg.describeAllExercises();

        // code to get answer to user's question
        //List<String> answer = workoutNlg.askQuestion(question,muscle_group, time);
         
            for(String sentence: description)
            {
              System.out.println(sentence);
            }
    
    }
}

package edu.nd.cse.ids.finalproject;

import edu.nd.cse.ids.finalproject.messages.*;


import java.util.List;
import java.util.LinkedList;
import java.io.File;
import java.util.Arrays;

import org.deeplearning4j.nn.modelimport.keras.preprocessing.text.KerasTokenizer;
import org.deeplearning4j.nn.api.Layer;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.LossLayer;
import org.deeplearning4j.nn.modelimport.keras.KerasModelImport;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.lossfunctions.LossFunctions;

public class DocumentPlanner
{
    private List<Message> messages;
    private MultiLayerNetwork model;
    private KerasTokenizer tokenizer;

    public DocumentPlanner()
    {/* 
        try {
            // use the java dl4j library to pull in the model & tokenizer
            String simpleMlp = "qa_g_lstm.h5";
            model = KerasModelImport.importKerasSequentialModelAndWeights(simpleMlp);
            tokenizer = KerasTokenizer.fromJson("qa_tok.json");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        */
        messages = new LinkedList<Message>();
    }
    
    /** 
    *
    * @param    exercise   the object with access to the raw data about the house
    */
    public void createMessages(Exercise exercise)
    {
        // create each message
        GreetingMessage m1 = new GreetingMessage();
        ExerciseSummaryMessage m2 = new ExerciseSummaryMessage();
        ExerciseDifficultyMessage m3 = new ExerciseDifficultyMessage();
        
        RoutineMessage m6 = new RoutineMessage();
        AlternativeExerciseMessage m7 = new AlternativeExerciseMessage();
        MuscleInfoMessage m8 = new MuscleInfoMessage();
       
        EquipmentMessage m10 = new EquipmentMessage();
        ExerciseNameMessage m11 = new ExerciseNameMessage();
        InstructionsMessage m12 = new InstructionsMessage();
        
        
        // generate each message type and add to the messages list
        m1.generate(exercise);
        this.messages.add(m1);
        m2.generate(exercise);
        this.messages.add(m2);
        m3.generate(exercise);
        this.messages.add(m3);
        
        m6.generate(exercise);
        this.messages.add(m6);
        m7.generate(exercise);
        this.messages.add(m7);
        m8.generate(exercise);
        this.messages.add(m8);
        
        m10.generate(exercise);
        this.messages.add(m10);
        m11.generate(exercise);
        this.messages.add(m11);
        m12.generate(exercise);
        this.messages.add(m12);
    }

    /**
     * I DID NOT WRITE THIS CODE - IT WAS TAKEN FROM PROVIDED EXAMPLES
     * @param seqp      the sequence to be padded / cropped
     * @param seqlen    the length of the sequence
     */
    public static int[] padcrop(Integer[][] seqp, int seqlen)
    {
        Integer[] seq = seqp[0];
    
        int[] newseq = new int[seqlen];
        int i = 0;
        
        int diff = seq.length - seqlen;
        int itmax = seqlen + diff;
        
        if(diff < 0)
        {
            diff = 0;
            itmax = seq.length;
        }
        
        for (int j=diff; j<itmax; j++)
        {
            if(seq.length < 1)
                newseq[i] = 1;
            else
                newseq[i] = seq[j];
            
            i++;
        }
        
        return(newseq);
    }

    /** 
    *
    * @param    house   the object with access to the raw data about the house
    * @param    question the string with the question about the house
    */
    public void answerQuestion(Exercise exercise, String question) {
        // use the tokenizer to create a vectorized representation of the question
        Preprocess preproc = new Preprocess();
        String qformatted = preproc.preprocess(question);
        int seqlen = 200;

        String[] qs = new String[1];
        qs[0] = qformatted;

        Integer[][] seq = this.tokenizer.textsToSequences(qs);
        int newseq[] = padcrop(seq, seqlen);

        // use the model to produce a prediction about what class the question belongs to
        INDArray input = Nd4j.create(1, seqlen);

        for(int i = 0; i < seqlen; i++) {
            input.putScalar(new int[] {i}, newseq[i]);
        }

        INDArray output = model.output(input);

        int messageNum = output.argMax(1).getInt();

        // create message list that includes the message types necessary to answer the question
        // message order is from ['numBedroom', 'numBathroom', 'numBeds', 'numGuests', 'itemCount', 'includesList', 'viewType', 'houseLocation', 'travelDistance', 'petsAllowed', 'itemFeatures', 'greeting', 'roomType', 'detailMessage']

        String[] messageList = {"Greeting", "Summary", "Difficulty",  "ExerciseList", "Alternatives", "MuscleInfo", "Equipment", "Name", "Instructions"};

        switch(messageList[messageNum]) {
            case "Greeting": 
                GreetingMessage m1 = new GreetingMessage();
                m1.generate(exercise);
                this.messages.add(m1);
                break;
            case "Summary":
                ExerciseSummaryMessage m2 = new ExerciseSummaryMessage();
                m2.generate(exercise);
                this.messages.add(m2);
                break;
            case "Difficulty":
                ExerciseDifficultyMessage m3 = new ExerciseDifficultyMessage();
                m3.generate(exercise);
                this.messages.add(m3);
                break;
            
            case "ExerciseList":
                RoutineMessage m6 = new RoutineMessage();
                m6.generate(exercise);
                this.messages.add(m6);
                break;
            case "Alternatives":
                AlternativeExerciseMessage m7 = new AlternativeExerciseMessage();
                m7.generate(exercise);
                this.messages.add(m7);
                break;
            case "MuscleInfo":
                MuscleInfoMessage m8 = new MuscleInfoMessage();
                m8.generate(exercise);
                this.messages.add(m8);
                break;
            case "Equipment":
                EquipmentMessage m9 = new EquipmentMessage();
                m9.generate(exercise);
                this.messages.add(m9);
                break;
            case "Name":
                ExerciseNameMessage m10 = new ExerciseNameMessage();
                m10.generate(exercise);
                this.messages.add(m10);
                break;
            case "Instructions":
                InstructionsMessage m11 = new InstructionsMessage();
                m11.generate(exercise);
                this.messages.add(m11);
                break;
        }  

    }
    
    /**
    * Provide access to the list of message objects.
    * Note that the method createMessages() may be called many times for
    * different houses, or it may have been cleared.
    *
    * @return           a list of messages about the house
    */
    public List<Message> getMessages()
    {
        return messages;
    }
}

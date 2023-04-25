package edu.nd.cse.ids.finalproject;

//package edu.nd.cse.ids.finalproject;

import java.util.List;

import com.github.houbb.data.struct.core.util.list.ArrayList;

import java.util.LinkedList;

import simplenlg.framework.*;
import simplenlg.lexicon.*;
import simplenlg.realiser.english.*;
import simplenlg.phrasespec.*;
import simplenlg.features.*;

public class Realizer
{
    private Lexicon lexicon;
    private Realiser realizer;
    
    public Realizer()
    {
        lexicon = Lexicon.getDefaultLexicon();
        realizer = new Realiser(lexicon);
    }
    
    /**
    * Generate surface text for each sentence specification.
    * The input is the text specification (just a list of sentence
    * specifications).  The output is a list of the actual rendered text for
    * each sentence specification (which we call the surface text).
    * <p>
    * We're using simplenlg as our realization engine, so all this method
    * needs to do is call the realizer for every sentence specification.
    * Note that we have a realizer object already, which we created in the
    * constructor method.
    *
    * @param    sentences   the text specification
    * @return               the surface text
    */
    public List<String> realize(List<SPhraseSpec> sentences)
    {
        // your code here
        List<String> outputs = new ArrayList();
        for (SPhraseSpec sentence : sentences) {
            String output = this.realizer.realiseSentence(sentence);
            outputs.add(output);
        }
        return outputs;
    }
}

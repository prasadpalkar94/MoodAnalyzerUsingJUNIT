package com.moodanalyzer.exception;

import com.moodanalyzer.exception.MoodAnalyzerExcpetion;

import javax.swing.*;

public class MoodAnalyzer {
    private String message;
    private Object another;


    public MoodAnalyzer(){
        message="I am in Happy Mood Always";
    }

    public MoodAnalyzer(String message)
    {
        this.message = message;
    }


    public String checkMood1() throws MoodAnalyzerExcpetion {
        this.message=message;
       return checkMood();
    }


    public String checkMood() throws MoodAnalyzerExcpetion {
        try {
            if (message == " "){
                throw new MoodAnalyzerExcpetion(MoodAnalyzerExcpetion.Type.EMPTY_MESSAGE,"Enter Proper Format message for Empty Field");
            }

            if (message.contains("SAD")) {
                return "SAD";
            } else {

                return "HAPPY";
            }
        }catch (NullPointerException e){
            throw new MoodAnalyzerExcpetion(MoodAnalyzerExcpetion.Type.NULL_MESSAGE,"Enter Valid message for NULL Area");
        }
    }


    public boolean equals(Object another){
        if(this.message.equals(((MoodAnalyzer) another).message)) {
            return true;
        }
        return false;
    }

}

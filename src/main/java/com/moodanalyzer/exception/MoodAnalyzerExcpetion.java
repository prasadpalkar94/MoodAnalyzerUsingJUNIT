package com.moodanalyzer.exception;

public class MoodAnalyzerExcpetion extends Exception{
    public Type type;

    public enum Type {
        EMPTY_MESSAGE,
        NO_SUCH_CLASS,
        NO_SUCH_METHOD,
        NULL_MESSAGE;
    }

    public MoodAnalyzerExcpetion(Type type ,String message) {
        super(message);
        this.type = type;
    }
    public MoodAnalyzerExcpetion(Type type ,Throwable cause) {
        super(cause);
        this.type = type;
    }
    public MoodAnalyzerExcpetion(Type type ,String message,Throwable cause){
        super(message,cause);
        this.type = type;
    }
}

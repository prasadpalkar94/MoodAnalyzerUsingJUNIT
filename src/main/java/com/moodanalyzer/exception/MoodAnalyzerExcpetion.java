package com.moodanalyzer.exception;

public class MoodAnalyzerExcpetion extends Exception{
    public Type type;

    public enum Type {
        EMPTY_MESSAGE,
        NO_SUCH_CLASS,
        NO_SUCH_METHOD,
        NULL_MESSAGE,
        NO_SUCH_FIELD,
        FIELD_INVOCATION_ISSUE,
        ILLEGAL_ACCESS,
        INVOCATION_METHOD_EXCEPTION ;
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

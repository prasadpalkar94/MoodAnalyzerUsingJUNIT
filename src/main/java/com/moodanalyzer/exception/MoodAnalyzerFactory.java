package com.moodanalyzer.exception;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {
    public static MoodAnalyzer analyzemoodwithDefaultConstructor() throws MoodAnalyzerExcpetion{
        try {
            Class<?> mood = Class.forName("com.moodanalyzer.exception.MoodAnalyzer");
            Constructor<?> constructor = mood.getConstructor();
            Object myobject1 = constructor.newInstance();
            return (MoodAnalyzer) myobject1;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return  null;
    }



}

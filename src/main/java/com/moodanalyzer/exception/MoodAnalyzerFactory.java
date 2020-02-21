package com.moodanalyzer.exception;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {
    public static MoodAnalyzer analyzemoodwithDefaultConstructor(){
        try {
            Class<?> mood = Class.forName("com.moodanalyzer.exception.MoodAnalyzer");
            Constructor<?> constructor = mood.getConstructor();
            Object myobject1 = constructor.newInstance();
            return (MoodAnalyzer) myobject1;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public static MoodAnalyzer analyzemood(String message){
        try {
            Class<?> mood = Class.forName("com.moodanalyzer.exception.MoodAnalyzer");
            Constructor<?> constructor = mood.getConstructor(String.class);
            Object myobject1 = constructor.newInstance();
            return (MoodAnalyzer) myobject1;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return  null;
    }


}

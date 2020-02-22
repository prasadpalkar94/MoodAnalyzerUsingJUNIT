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

    public static MoodAnalyzer analyzemoodwithParameterConstructor(String message) throws MoodAnalyzerExcpetion{
        try {
            Class<?> mood = Class.forName("com.moodanalyzer.exception.MoodAnalyzer");
            Constructor<?> constructor = mood.getConstructor(String.class);
            Object myobject1 = constructor.newInstance(message);
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

    public static Constructor<?> getConstructor (String className,Class param)throws MoodAnalyzerExcpetion {
        Constructor<?> result = null;
        try {
            Class<?> moodAnalyzerClass = Class.forName(className);
            Constructor<?> constructor = moodAnalyzerClass.getConstructor(param);
            result = constructor;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyzerExcpetion(MoodAnalyzerExcpetion.Type.NO_SUCH_CLASS,e.getMessage());
        } catch (NoSuchMethodException e){
            throw new MoodAnalyzerExcpetion(MoodAnalyzerExcpetion.Type.NO_SUCH_METHOD,e.getMessage());
        }
        return result;
    }

}

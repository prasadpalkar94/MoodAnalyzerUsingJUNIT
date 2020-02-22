import com.moodanalyzer.exception.MoodAnalyzer;
import com.moodanalyzer.exception.MoodAnalyzerExcpetion;
import com.moodanalyzer.exception.MoodAnalyzerFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static com.moodanalyzer.exception.MoodAnalyzerFactory.analyzemoodwithParameterConstructor;
import static com.moodanalyzer.exception.MoodAnalyzerFactory.analyzemoodwithDefaultConstructor;

public class MoodAnalyzerTest {
   private MoodAnalyzer moodAnalyzer;

    @Before
    public void setUp() throws Exception {
        moodAnalyzer = new MoodAnalyzer("message");
    }

    @Test
    public void givenHAPPYShouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        String mood= null;
        try {
            ExpectedException exceptionRule=ExpectedException.none();
            exceptionRule.expect(MoodAnalyzerExcpetion.class);
            mood = moodAnalyzer.checkMood();
            Assert.assertEquals("HAPPY", mood);
        }catch(MoodAnalyzerExcpetion e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenSADShouldReturnSAD() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        String mood= null;
        try {
            ExpectedException exceptionRule=ExpectedException.none();
            exceptionRule.expect(MoodAnalyzerExcpetion.class);
            mood = moodAnalyzer.checkMood();
            Assert.assertEquals("SAD", mood);
        }catch (MoodAnalyzerExcpetion e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenNULLShouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        String mood= null;
        try {
            ExpectedException exceptionRule=ExpectedException.none();
            exceptionRule.expect(MoodAnalyzerExcpetion.class);
            mood = moodAnalyzer.checkMood();
            Assert.assertEquals("HAPPY", mood);
        }catch (MoodAnalyzerExcpetion e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenEmptyString() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(" ");
        String mood= " ";
        try {
            ExpectedException exceptionRule=ExpectedException.none();
            exceptionRule.expect(MoodAnalyzerExcpetion.class);
            mood = moodAnalyzer.checkMood();
            Assert.assertEquals("HAPPY", mood);
        }catch (MoodAnalyzerExcpetion e){
            e.printStackTrace();
        }
    }

    @Test
    public void checkEmptyMessageUsingEnum() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(" ");
        try {
            String mood = moodAnalyzer.checkMood();
        } catch (MoodAnalyzerExcpetion e) {
            Assert.assertEquals(MoodAnalyzerExcpetion.Type.EMPTY_MESSAGE,e.type);
        }
    }

    @Test
    public void checkNullMessageUsingEnum() {
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
            String mood = moodAnalyzer.checkMood();
        } catch (MoodAnalyzerExcpetion e) {
            Assert.assertEquals(MoodAnalyzerExcpetion.Type.NULL_MESSAGE,e.type);
        }
    }

    @Test
    public void givenMoodAnalyzer_withDefaultConstructor_when_Proper_should_Return_True(){
       try {
           MoodAnalyzer analyzemood2 = MoodAnalyzerFactory.analyzemoodwithDefaultConstructor();
           Assert.assertEquals(new MoodAnalyzer(), analyzemood2);
       }catch(MoodAnalyzerExcpetion e){
           e.printStackTrace();
       }
       }

    @Test
    public void givenMoodAnalyzer_withParameterConstructor_when_Proper_should_Return_True() {
        try {
            MoodAnalyzer analyzemood1 = MoodAnalyzerFactory.analyzemoodwithParameterConstructor("I am in Happy Mood");
            Assert.assertEquals(new MoodAnalyzer("I am in Happy Mood"), analyzemood1);
        }catch(MoodAnalyzerExcpetion e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenClassName_whenImproper_shouldReturn_Exception() {
        try {
            MoodAnalyzerFactory.getConstructor("Mood",String.class);
        }catch(MoodAnalyzerExcpetion e){
            Assert.assertEquals(MoodAnalyzerExcpetion.Type.NO_SUCH_CLASS,e.type);
        }
    }

    @Test
    public void givenConstructor_whenImproper_shouldReturn_Exception() {
        try {
            MoodAnalyzerFactory.getConstructor("MoodAnalyzer",String.class);
        }catch(MoodAnalyzerExcpetion e){
            Assert.assertEquals(MoodAnalyzerExcpetion.Type.NO_SUCH_CLASS,e.type);
        }
    }
    @Test
    public void givenHappy_whenProper_ShouldReturnHappy_byInvokingTheMethod() {
        Object moodObject = null;
        try {
            Class<?> classObj=Class.forName("MoodAnalyser");
            Constructor<?> myConstructor=classObj.getConstructor(String.class);
            Object ConstructorObject=myConstructor.newInstance("I am in happy mood");
            moodObject=MoodAnalyzerFactory.getInvokeMethod(ConstructorObject,"Happy");
            Assert.assertEquals("Happy",moodObject);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (MoodAnalyzerExcpetion moodAnalyzerExcpetion) {
            moodAnalyzerExcpetion.printStackTrace();
        }
    }

    @Test
    public void givenHappy_whenImproper_ShouldReturnException_byInvokingTheMethod() {
        try {
            Class<?> classObj=Class.forName("MoodAnalyser");
            Constructor<?> myConstructor=classObj.getConstructor(String.class);
            Object ConstructorObject=myConstructor.newInstance("I am in happy mood");
            Object moodObject=MoodAnalyzerFactory.getInvokeMethod(ConstructorObject,"saidHappy");
        } catch (MoodAnalyzerExcpetion e) {
            Assert.assertEquals(MoodAnalyzerExcpetion.Type.NO_SUCH_METHOD,e.type);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenHappy_whenProper_shouldReturnHappy_bySettingField() throws MoodAnalyzerExcpetion {
        MoodAnalyzer moodObject = MoodAnalyzerFactory.analyzemoodwithParameterConstructor();
        String mood = MoodAnalyzerFactory.setFieldValue(moodObject,"I am in happy mood","moodMessage");
        Assert.assertEquals("Happy", mood);
    }

    @Test
    public void givenField_whenNotProper_shouldReturnException() {
        try {
            MoodAnalyzer moodObject = MoodAnalyzerFactory.analyzemoodwithParameterConstructor();
            String mood = MoodAnalyzerFactory.setFieldValue(moodObject, "I am in happy mood", "moMessage");
        } catch(MoodAnalyzerExcpetion e){
            Assert.assertEquals(MoodAnalyzerExcpetion.Type.NO_SUCH_FIELD,e.type);
        }
    }

    @Test
    public void givenFieldMessage_whenNull_shouldReturnException() {
        try {
            MoodAnalyzer moodObject = MoodAnalyzerFactory.analyzemoodwithParameterConstructor();
            String mood = MoodAnalyzerFactory.setFieldValue(moodObject, null, "moodMessage");
        } catch(MoodAnalyzerExcpetion e){
            Assert.assertEquals(MoodAnalyzerExcpetion.Type.FIELD_INVOCATION_ISSUE,e.type);
        }
    }

}

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



}

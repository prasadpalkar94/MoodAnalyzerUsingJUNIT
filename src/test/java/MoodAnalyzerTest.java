import com.moodanalyzer.exception.MoodAnalyzer;
import com.moodanalyzer.exception.MoodAnalyzerExcpetion;
import com.moodanalyzer.exception.MoodAnalyzerFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static com.moodanalyzer.exception.MoodAnalyzerFactory.analyzemood;
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


}

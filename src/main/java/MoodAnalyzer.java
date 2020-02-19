import com.moodanalyzer.exception.MoodAnalyzerExcpetion;

import javax.swing.*;

public class MoodAnalyzer {
    private String message;

    public MoodAnalyzer(String message) {
        this.message = message;
    }

    public String checkMood() throws MoodAnalyzerExcpetion {


        try {
            if (message == " "){
                throw new MoodAnalyzerExcpetion("Enter Proper Format message");
            }

            if (message.contains("SAD")) {
                return "SAD";
            } else {

                return "HAPPY";
            }
        }catch (NullPointerException e){
            throw new MoodAnalyzerExcpetion("Enter Valid message");
        }
    }
}

import com.moodanalyzer.exception.MoodAnalyzerExcpetion;

public class Demo {
    public static void checkParam(){
        checkMessage();
        System.out.println("Hello World!!");
    }
    public static void checkMessage (){
        try {
            System.out.println(1 / 0);
        }catch(ArithmeticException e){
            //System.out.println(e);
            e.printStackTrace();
          //  throw new MoodAnalyzerExcpetion("check the message");
        }
    }
    public static void main(String[] args) {
        checkParam();


    }
}

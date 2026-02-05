public class gradeCalculator {
    
    public String calGrade(int percentage){

    String grade="";

    if(percentage <0){
        throw new IllegalArgumentException("Percentage can't be negative");
    }else if(percentage < 40){
        grade= "F";
    }else if(percentage < 50){
        grade= "D";
    }else if(percentage < 60){
        grade= "C";
    }else if(percentage < 70){
        grade= "B";
    }else if(percentage < 80){
        grade= "A";
    }else if(percentage < 90){
        grade= "A+";
    }else{
        grade="O";
    }

    System.out.println("You got "+grade+" grade");

return grade;
    }
}

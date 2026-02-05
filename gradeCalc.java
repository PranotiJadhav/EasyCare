public class gradeCalc {
    public String grade(int percentage) {

        if (percentage < 0) {
            throw new IllegalArgumentException("Percentage cannot be negative");
        } else if (percentage < 40) {
            return "F";
        } else if (percentage < 50) {
            return "D";
        } else if (percentage < 60) {
            return "C";
        } else if (percentage < 70) {
            return "B";
        } else if (percentage < 80) {
            return "A";
        } else if (percentage < 90) {
            return "A+";
        } else {
            return "O";
        }
    }
}

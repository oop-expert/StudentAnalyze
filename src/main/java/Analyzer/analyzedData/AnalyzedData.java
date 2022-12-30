package Analyzer.analyzedData;

import Analyzer.reportCard.ReportCard;

import java.util.ArrayList;
import java.util.List;

public class AnalyzedData {

    private String nameOfFile;
    private int avarageHwScore;
    private int avarageExcerciseScore;
    private int avarageActivityScore;

    public AnalyzedData(String nameOfFile, int avarageHwScore, int avarageExcerciseScore, int avarageActivityScore) {
        this.nameOfFile = nameOfFile;
        this.avarageHwScore = avarageHwScore;
        this.avarageExcerciseScore = avarageExcerciseScore;
        this.avarageActivityScore = avarageActivityScore;
    }
    public static List<Integer> getAverageStudentsScores(ReportCard report) {
        List<Integer> studentsScores = new ArrayList<Integer>();

        int activityScore = 0;
        int homeworkScore = 0;
        int excerciseScore = 0;
        int countPeople = 0;
        for(var student: report.getStudentsList()) {
            activityScore += Integer.parseInt(student.getActivityScore());
            homeworkScore += Integer.parseInt(student.getHomeworkScore());
            excerciseScore += Integer.parseInt(student.getExcerciseScore());
            countPeople += 1;
        }
        studentsScores.add(activityScore / countPeople);
        studentsScores.add(homeworkScore / countPeople);
        studentsScores.add(excerciseScore / countPeople);
        return studentsScores;
    }



    public String getNameOfFile() {
        return nameOfFile;
    }

    public void setNameOfFile(String nameOfFile) {
        this.nameOfFile = nameOfFile;
    }

    public int getAvarageHwScore() {
        return avarageHwScore;
    }

    public void setAvarageHwScore(int avarageHwScore) {
        this.avarageHwScore = avarageHwScore;
    }

    public int getAvarageExcerciseScore() {
        return avarageExcerciseScore;
    }

    public void setAvarageExcerciseScore(int avarageExcerciseScore) {
        this.avarageExcerciseScore = avarageExcerciseScore;
    }

    public int getAvarageActivityScore() {
        return avarageActivityScore;
    }

    public void setAvarageActivityScore(int avarageActivityScore) {
        this.avarageActivityScore = avarageActivityScore;
    }



    public String toString() {
        return String.format("Средняя по активностям: %s, Средняя по упражнениям: %s, Средняя по дз: %s \n",
                avarageActivityScore, avarageExcerciseScore, avarageHwScore);
    }
}

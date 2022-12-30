package Analyzer.visualisation.mapper;

import Analyzer.analyzedData.AnalyzedData;
import Analyzer.models.person.Person;
import Analyzer.models.person.Student;
import Analyzer.reportCard.ReportCard;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import java.util.*;
import java.util.stream.Collectors;

import static Analyzer.analyzedData.AnalyzedData.getAverageStudentsScores;


public class ChartDataMapper {
    public static PieDataset createScoreByGroupDataset(HashMap<String, AnalyzedData> statics) {


        DefaultPieDataset dataset = new DefaultPieDataset();
        for(var st : statics.keySet()) {
            dataset.setValue(st, statics.get(st).getAvarageActivityScore());
        }
//        statics.forEach(dataset::setValue);

        return dataset;
    }

    public static CategoryDataset createCategoryDataset(HashMap<String, AnalyzedData> stat) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(var st : stat.keySet()) {
            dataset.setValue(stat.get(st).getAvarageActivityScore(), "Активности", stat.get(st).getNameOfFile());
            dataset.setValue(stat.get(st).getAvarageHwScore(), "ДЗ", stat.get(st).getNameOfFile());
            dataset.setValue(stat.get(st).getAvarageExcerciseScore(), "Упражнения", stat.get(st).getNameOfFile());
        }
        return dataset;
    }
    public static CategoryDataset createCategoryDatasetForVk(HashMap<Student, Person> stat) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(var student : stat.keySet()) {
            if (stat.get(student).getGender() != null) {
                dataset.setValue(Integer.parseInt(student.getHomeworkScore()), "Название группы",student.getName() + " " + stat.get(student).getGender());
            } else {
                System.out.println("Нет гендера");
            }
        }
        return dataset;
    }
}

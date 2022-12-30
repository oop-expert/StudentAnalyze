package Analyzer;

import Analyzer.CSVParser.Parser;
import Analyzer.analyzedData.AnalyzedData;
import Analyzer.db.DBRepository;
import Analyzer.db.mapper.StudentsMapperDB;
import Analyzer.models.person.Person;
import Analyzer.models.person.Student;
import Analyzer.reportCard.ReportCard;
import Analyzer.visualisation.drawer.BarChartDrawer;
import Analyzer.visualisation.drawer.BarChartDrawerForVk;
import Analyzer.visualisation.drawer.PieChartDrawer;
import Analyzer.vkApi.VkRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static Analyzer.analyzedData.AnalyzedData.getAverageStudentsScores;


public class Main {
    public static void main(String[] args) throws Exception {
        String paths[] = new String[]{"rawData/java-rtf-1.csv", "rawData/java-rtf-2.csv", "rawData/java-rtf-3.csv", "rawData/students.csv", "rawData/java-rtf-online.csv", "rawData/java-rtf-peresdachi.csv"};
        VkRepository vk = new VkRepository();
        ReportCard report = null;
        AnalyzedData data = null;
        List<AnalyzedData> dataGroups = new ArrayList<>();
        HashMap<String, AnalyzedData> statics = new HashMap<>();
        HashMap<Student, Person> oneStudent = new HashMap<>();
        AnalyzedData[] anData = null;
        for(int i = 0; i < paths.length; i++) {
            report = Parser.getReportFromCSV(paths[i]);
            var scores = getAverageStudentsScores(report);
            data = new AnalyzedData(paths[i], scores.get(0), scores.get(1), scores.get(2));

            dataGroups.add(data);
        }
        AnalyzedData[] analyticsData = new AnalyzedData[dataGroups.size()];
        var analyzed = dataGroups.toArray(analyticsData);
        for(int i = 0; i < analyzed.length; i++) {
            statics.put(paths[i], dataGroups.get(i));
        }
        System.out.println(statics);
        var map = vk.getPersonByVk(report.getStudentsList());

        DBRepository dbRepository = new DBRepository();
        dbRepository.connect();
        dbRepository.creatTableIfNotExist();
        dbRepository.saveStudents(map, report.getStudentsList());
        dbRepository.close();

        var dbOrm = new DBRepository();
        var studentFromDB = new ArrayList<Person>();
        try {
            dbOrm.connect();
            studentFromDB = dbOrm.getStudents()
                    .stream()
                    .map(StudentsMapperDB::map)
                    .collect(Collectors.toCollection(ArrayList::new));
            dbOrm.close();
        } catch (Exception throwable) {
            throwable.printStackTrace();
        }


        new BarChartDrawer("Статистика групп", statics).setVisible(true);
        new PieChartDrawer("Статистика групп по активностям", statics).setVisible(true);
        new BarChartDrawerForVk(map).setVisible(true);
    }
}
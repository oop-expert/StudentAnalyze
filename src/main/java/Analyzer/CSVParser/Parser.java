package Analyzer.CSVParser;

import Analyzer.models.person.Student;
import Analyzer.reportCard.ReportCard;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static ReportCard getReportFromCSV(String path) throws IOException {
        List<Student> students = new CsvToBeanBuilder(new FileReader(path))
                .withType(Student.class)
                .withSkipLines(3)
                .withSeparator(';')
                .build()
                .parse();
        return new ReportCard((ArrayList<Student>) students);
    }
}

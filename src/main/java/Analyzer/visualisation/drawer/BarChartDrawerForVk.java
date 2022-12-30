package Analyzer.visualisation.drawer;

import Analyzer.models.person.Person;
import Analyzer.models.person.Student;
import Analyzer.visualisation.mapper.ChartDataMapper;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.RectangleInsets;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class BarChartDrawerForVk extends JFrame{

    public BarChartDrawerForVk(HashMap<Student, Person> statics) {
        setContentPane(createPlayersByTeamsPanel(statics));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(600, 300);
    }

    public static JPanel createPlayersByTeamsPanel(HashMap<Student, Person> statics)
    {
        JFreeChart chart = createBarChart(ChartDataMapper.createCategoryDatasetForVk(statics));
        chart.setPadding(new RectangleInsets(4, 8, 2, 2));
        return new ChartPanel(chart);
    }

    private static JFreeChart createBarChart(CategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "Студенты",
                "Студент",                   // x-axis label
                "Количество баллов за ДЗ",                // y-axis label
                dataset,
                PlotOrientation.HORIZONTAL,
                false,
                false,
                false
        );

        chart.addSubtitle(new TextTitle("Data from VK"));
        chart.setBackgroundPaint(Color.white);

        return chart;
    }
}

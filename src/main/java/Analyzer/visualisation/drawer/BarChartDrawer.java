package Analyzer.visualisation.drawer;

import Analyzer.analyzedData.AnalyzedData;
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
import java.util.ArrayList;
import java.util.HashMap;

public class BarChartDrawer extends JFrame {
    public BarChartDrawer(String title, HashMap<String, AnalyzedData> statics) {
        super(title);
        setContentPane(createPlayersByTeamsPanel(statics));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(600, 300);
    }

    public static JPanel createPlayersByTeamsPanel(HashMap<String, AnalyzedData> statics)
    {
        JFreeChart chart = createBarChart(ChartDataMapper.createCategoryDataset(statics));
        chart.setPadding(new RectangleInsets(4, 8, 2, 2));
        return new ChartPanel(chart);
    }

    private static JFreeChart createBarChart(CategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "Количество баллов по группам",
                "Группа",                   // x-axis label
                "Количество баллов",                // y-axis label
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
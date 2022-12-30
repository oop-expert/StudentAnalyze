package Analyzer.visualisation.drawer;

import Analyzer.analyzedData.AnalyzedData;
import Analyzer.models.person.Student;
import Analyzer.reportCard.ReportCard;
import Analyzer.visualisation.mapper.ChartDataMapper;
import com.vk.api.sdk.objects.messages.ChatFull;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleInsets;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PieChartDrawer extends JFrame{

    public PieChartDrawer(String title, HashMap<String, AnalyzedData> statics) {
        super(title);
        setContentPane(createStudentsByGroupsPanel(statics, title));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(600, 300);
        setVisible(true);
    }

    public static JPanel createStudentsByGroupsPanel(HashMap<String, AnalyzedData> statics, String title) {
        JFreeChart chart = createPieChart(ChartDataMapper.createScoreByGroupDataset(statics), title);
        chart.setPadding(new RectangleInsets(4, 8, 2, 2));
        return new ChartPanel(chart);
    }

    private static JFreeChart createPieChart(PieDataset dataset, String title) {
        JFreeChart chart = ChartFactory.createPieChart(
                title,
                dataset,
                false,
                true,
                false
        );

        chart.setBackgroundPaint(
                new GradientPaint(
                        new Point(0 ,0),
                        new Color(20, 20, 20),
                        new Point(400, 200),
                        Color.DARK_GRAY
                )
        );

        TextTitle t = chart.getTitle();
        t.setHorizontalAlignment(HorizontalAlignment.LEFT);
        t.setPaint(new Color(240, 240, 240));
        t.setFont(new Font("Arial", Font.BOLD, 26));
        t.setText(title);


        return chart;
    }
}

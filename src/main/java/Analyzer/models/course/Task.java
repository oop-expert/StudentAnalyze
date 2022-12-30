package Analyzer.models.course;

public class Task extends TaskType{

    String name;
    TaskType type;
    int maxScore;

    public Task(String name, TaskType type, int maxScore) {
        this.name = name;
        this.type = type;
        this.maxScore = maxScore;
    }
}

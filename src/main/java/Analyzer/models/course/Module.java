package Analyzer.models.course;

import java.util.Collection;

public class Module extends Task{

    protected String name;
    protected Collection<Task> tasks;
    protected int activitiesMaxScore;
    protected int excercisesMaxScore;
    protected int homeworksMaxScore;
    protected int seminarsMaxScore;

    public Module(String name, TaskType type, int maxScore) {
        super(name, type, maxScore);
        this.name = name;
        this.tasks = getTasks();
        this.activitiesMaxScore = getActivitiesMaxScore();
        this.excercisesMaxScore = getExcercisesMaxScore();
        this.homeworksMaxScore = getHomeworksMaxScore();
        this.seminarsMaxScore = getSeminarsMaxScore();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Collection<Task> tasks) {
        this.tasks = tasks;
    }

    public int getActivitiesMaxScore() {
        return activitiesMaxScore;
    }

    public void setActivitiesMaxScore(int activitiesMaxScore) {
        this.activitiesMaxScore = activitiesMaxScore;
    }

    public int getExcercisesMaxScore() {
        return excercisesMaxScore;
    }

    public void setExcercisesMaxScore(int excercisesMaxScore) {
        this.excercisesMaxScore = excercisesMaxScore;
    }

    public int getHomeworksMaxScore() {
        return homeworksMaxScore;
    }

    public void setHomeworksMaxScore(int homeworksMaxScore) {
        this.homeworksMaxScore = homeworksMaxScore;
    }

    public int getSeminarsMaxScore() {
        return seminarsMaxScore;
    }

    public void setSeminarsMaxScore(int seminarsMaxScore) {
        this.seminarsMaxScore = seminarsMaxScore;
    }
}

package Analyzer.models.course;

import java.util.Collection;

public class Course extends Module{

    protected String name;
    protected int activitiesMaxScore;
    protected int excercisesMaxScore;
    protected int homeworksMaxScore;
    protected int seminarsMaxScore;
    protected Collection<Module> modules;

    public Course(String name, TaskType type, int maxScore) {
        super(name, type, maxScore);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getActivitiesMaxScore() {
        return activitiesMaxScore;
    }

    @Override
    public void setActivitiesMaxScore(int activitiesMaxScore) {
        this.activitiesMaxScore = activitiesMaxScore;
    }

    @Override
    public int getExcercisesMaxScore() {
        return excercisesMaxScore;
    }

    @Override
    public void setExcercisesMaxScore(int excercisesMaxScore) {
        this.excercisesMaxScore = excercisesMaxScore;
    }

    @Override
    public int getHomeworksMaxScore() {
        return homeworksMaxScore;
    }

    @Override
    public void setHomeworksMaxScore(int homeworksMaxScore) {
        this.homeworksMaxScore = homeworksMaxScore;
    }

    @Override
    public int getSeminarsMaxScore() {
        return seminarsMaxScore;
    }

    @Override
    public void setSeminarsMaxScore(int seminarsMaxScore) {
        this.seminarsMaxScore = seminarsMaxScore;
    }

    public Collection<Module> getModules() {
        return modules;
    }

    public void setModules(Collection<Module> modules) {
        this.modules = modules;
    }
}

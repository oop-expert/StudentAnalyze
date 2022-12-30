package Analyzer.models.scores;

import java.util.Collection;

public class ModuleScores extends TaskScores{

    protected Collection<TaskScores> taskScores;
    protected int activitiesScore;
    protected int excerciseScore;
    protected int homeworkScores;
    protected int seminarScores;

    public ModuleScores(Collection<TaskScores> taskScores, int activitiesScore, int excerciseScore, int homeworkScores, int seminarScores) {
        super();
        this.setTaskScores(taskScores);
        this.setActivitiesScore(activitiesScore);
        this.setExcerciseScore(excerciseScore);
        this.setHomeworkScores(homeworkScores);
        this.setSeminarScores(seminarScores);
    }

    public Collection<TaskScores> getTaskScores() {
        return taskScores;
    }

    public void setTaskScores(Collection<TaskScores> taskScores) {
        this.taskScores = taskScores;
    }

    public int getActivitiesScore() {
        return activitiesScore;
    }

    public void setActivitiesScore(int activitiesScore) {
        this.activitiesScore = activitiesScore;
    }

    public int getExcerciseScore() {
        return excerciseScore;
    }

    public void setExcerciseScore(int excerciseScore) {
        this.excerciseScore = excerciseScore;
    }

    public int getHomeworkScores() {
        return homeworkScores;
    }

    public void setHomeworkScores(int homeworkScores) {
        this.homeworkScores = homeworkScores;
    }

    public int getSeminarScores() {
        return seminarScores;
    }

    public void setSeminarScores(int seminarScores) {
        this.seminarScores = seminarScores;
    }
}

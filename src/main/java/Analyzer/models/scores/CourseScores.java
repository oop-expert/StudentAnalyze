package Analyzer.models.scores;

import java.util.Collection;

public class CourseScores  extends ModuleScores{

    protected Collection<ModuleScores> moduleScores;
    protected int activitiesScore;
    protected int excercisesScore;
    protected int homeworksScore;
    protected int seminarsScore;

    public CourseScores(Collection<TaskScores> taskScores, int activitiesScore, int excerciseScore, int homeworkScores, int seminarScores) {
        super(taskScores, activitiesScore, excerciseScore, homeworkScores, seminarScores);
    }

    public Collection<ModuleScores> getModuleScores() {
        return moduleScores;
    }

    public void setModuleScores(Collection<ModuleScores> moduleScores) {
        this.moduleScores = moduleScores;
    }

    @Override
    public int getActivitiesScore() {
        return activitiesScore;
    }

    @Override
    public void setActivitiesScore(int activitiesScore) {
        this.activitiesScore = activitiesScore;
    }

    public int getExcercisesScore() {
        return excercisesScore;
    }

    public void setExcercisesScore(int excercisesScore) {
        this.excercisesScore = excercisesScore;
    }

    public int getHomeworksScore() {
        return homeworksScore;
    }

    public void setHomeworksScore(int homeworksScore) {
        this.homeworksScore = homeworksScore;
    }

    public int getSeminarsScore() {
        return seminarsScore;
    }

    public void setSeminarsScore(int seminarsScore) {
        this.seminarsScore = seminarsScore;
    }
}

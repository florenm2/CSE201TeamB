import java.util.ArrayList;
import java.util.HashMap;

public class Account {

    public static int stage;
    public String major;
    public ArrayList<String> classesChosen;
    public ArrayList<String> coursesPrevTaken;

    public Account() {
        major = "";
        classesChosen = new ArrayList<String>();
        coursesPrevTaken = new ArrayList<String>();
        stage = 0;
    }

    private void setMajor(String m) {
        major = m;
    }

    private String getMajor() {
        return major;
    }

    private void setClassesChosen(ArrayList<String> CC) {
        classesChosen = CC;
    }

    private ArrayList<String> getClassesChosen() {
        return classesChosen;
    }

    private void setCoursesPrevTaken(ArrayList<String> CPT) {
        coursesPrevTaken = CPT;
    }

    private ArrayList<String> getCoursesPrevTaken() {
        return coursesPrevTaken;
    }

    public void setStage(int newStage) {
        stage = newStage;
    }

    public int getStage() {
        return stage;
    }

    public static void main(String[] args) {
        Account user = new Account();

        chooseMajor m = new chooseMajor();
        chooseClasses cc = new chooseClasses();
        choosePrereqs cp = new choosePrereqs();


//        user.setClassesChosen(cc.classesChosen);
//        user.setCoursesPrevTaken(cp.prereqsComplete);

                m.setVisible(true);

                if (m.jToggleButton1.getModel().isPressed()) {
                    user.setMajor(m.major);
                    m.setVisible(false);
                    cc.setVisible(true);
                    cp.setVisible(true);
                }


        }
    }




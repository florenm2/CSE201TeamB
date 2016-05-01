import java.util.ArrayList;

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

		System.out.println("checkpoint");

		chooseMajor m = new chooseMajor();
		chooseClasses cc = new chooseClasses();
		choosePrereqs cp = new choosePrereqs();
		
		user.setMajor(m.major);
		user.setClassesChosen(cc.classesChosen);
		user.setCoursesPrevTaken(cp.prereqsComplete);

		boolean cycleContinues = true;

		while (cycleContinues) {
			switch (user.stage) {
			case 0:
				m.setVisible(true);
				cc.setVisible(false);
				cp.setVisible(false);
				user.setStage(m.getStage());
				break;
			case 1:
				m.setVisible(false);
				cc.setVisible(true);
				cp.setVisible(false);
				user.setStage(cc.getStage());
				break;
			case 2:
				m.setVisible(false);
				cc.setVisible(false);
				cp.setVisible(true);
				user.setStage(cp.getStage());
				break;
			case 3:
				m.setVisible(false);
				cc.setVisible(false);
				cp.setVisible(false);
				cycleContinues = false;
				break;
			default:
				m.setVisible(true);
				cc.setVisible(false);
				cp.setVisible(false);
				break;
			}

		}

		// System.out.println(Controller.coursesonce.size());

	}

}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Controls the main calculations and logic of the program. 
 */
public class Controller {

	ArrayList<Course> prereqs = new ArrayList<Course>();
	static String errorMessage = "Error";
	static String reqMessage = "N/A";

	public static String getReqMessage() {
		return reqMessage;
	}

	public ArrayList<Course> getPrereqs() {
		return prereqs;
	}

	public void setPrereqs(ArrayList<Course> prereqs) {
		this.prereqs = prereqs;
	}

	/*
	 * Filters through all courses offered in the .csv file and displays each
	 * course only once (removes multiple sections)
	 */
	public static ArrayList<Course> displayCoursesOnce(
			ArrayList<Course> allClasses) {
		ArrayList<Course> coursesOnce = new ArrayList<Course>();
		String prev = "";
		for (Course all : allClasses) {
			if (!all.getCourseNum().equals(prev)) {
				coursesOnce.add(all);
				prev = all.getCourseNum();
			}
		}
		return coursesOnce;
	}

	/*
	 * Returns each possible prerequisite in an ArrayList of Course objects
	 */
	public static ArrayList<Course> displayPrereqOptions() throws IOException {

		Course p1 = new Course();
		p1.setTitle("Fundmntls-Progrming&Prob Solvg");
		p1.setCourseNum("174");
		Course p2 = new Course();
		p2.setTitle("Intro to Software Engineering");
		p2.setCourseNum("201");
		Course p3 = new Course();
		p3.setTitle("Object-Oriented Programming");
		p3.setCourseNum("271");
		Course p4 = new Course();
		p4.setTitle("Data Abstractions & Structures");
		p4.setCourseNum("274");
		Course p5 = new Course();
		p5.setTitle("Computer Architecture");
		p5.setCourseNum("278");
		Course p6 = new Course();
		p6.setTitle("Data Communications & Network");
		p6.setCourseNum("283");
		Course p7 = new Course();
		p7.setTitle("Client/Server Programming");
		p7.setCourseNum("383");
		Course p8 = new Course();
		p8.setTitle("Database Systems");
		p8.setCourseNum("385");
		Course p9 = new Course();
		p9.setTitle("Intro To Computer Graphics");
		p9.setCourseNum("386");
		Course p10 = new Course();
		p10.setTitle("Senior Design Project");
		p10.setCourseNum("448");

		ArrayList<Course> courses = new ArrayList<Course>();

		courses.add(p1);
		courses.add(p2);
		courses.add(p3);
		courses.add(p4);
		courses.add(p5);
		courses.add(p6);
		courses.add(p7);
		courses.add(p8);
		courses.add(p9);
		courses.add(p10);

		return courses;

	}

	/*
	 * CS requirements
	 * http://bulletin.miamioh.edu/engineering-computing/computer-science-bs/
	 * 
	 * SE requirements
	 * http://bulletin.miamioh.edu/engineering-computing/software-bs/
	 */
	public static boolean checkPrereqs(Course c,
			ArrayList<Course> coursesPrevTaken) throws IOException {

		String fileName = "prereqs.txt";
		BufferedReader br = null;
		String cur = "";
		br = new BufferedReader(new FileReader(fileName));
		boolean reqsMet = true;

		while ((cur = br.readLine()) != null) {
			String[] prereqs = cur.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
			// if current line, first course listed is the course
			if (prereqs[0].equals(c.getCourseNum())) {
				// loop through checking all requirements
				for (int i = 1; i < prereqs.length; i++) {
					int reqMet = 0;
					// check courses taken to see if it matches requirement
					for (Course taken : coursesPrevTaken) {
						if (taken.getCourseNum().equals(prereqs[i]))
							reqMet = 1;
					}
					// if never set to one, requirement not satisfied
					if (reqMet == 0) {
						errorMessage = "Prequisite for CSE" + c.getCourseNum()
								+ " not met. Requirement: CSE " + prereqs[i]
								+ " not satisfied";
						reqsMet = false;
					}
				}
			}
		}
		br.close();

		return reqsMet;
	}

	public static String getErrorMessage() {
		return errorMessage;
	}

	/*
	 * Determines if the selected Course has already been selected
	 */
	public static boolean isSameCourse(Course c,
			ArrayList<Course> coursesScheduled) {
		boolean conflict = false;

		for (Course scheduled : coursesScheduled) {
			if (c.getCourseNum().equals(scheduled.getCourseNum())
					&& c.getCrn() != scheduled.getCrn()) {
				conflict = true;
				errorMessage = "Same Course";
			}
		}

		return conflict;
	}

	public static boolean checkCourseTime(Course c,
			ArrayList<Course> coursesScheduled) {
		boolean conflict = false;
		boolean sameDay = false;
		for (Course scheduled : coursesScheduled) {
			// 1. check days
			for (int i = 1; i < c.getDays().length(); i++) {
				for (int j = 1; j < scheduled.getDays().length(); j++) {
					if (c.getDays().substring(i, i)
							.equals(scheduled.getDays().substring(j, j))) {
						sameDay = true;
					}
				}
			}

			// 2. check times
			if (sameDay) {

				// if selected course end or start time is the same as the
				// respective start or end time of other course
				if ((c.getStartTime() == scheduled.getEndTime())
						|| (c.getEndTime() == scheduled.getStartTime())) {
					conflict = true;
				}

				// if selected course start time is between the start time and
				// end time of another course
				/*
				 * cccccccccc aaaaaaaaa
				 */
				else if ((c.getStartTime() >= scheduled.getStartTime())
						&& (c.getStartTime() <= scheduled.getEndTime())) {
					conflict = true;
				}
				// if selected course end time is between the start and end time
				// of another course
				/*
				 * cccccccccc aaaaaaaaaa
				 */
				else if ((c.getEndTime() >= scheduled.getStartTime())
						&& (c.getEndTime() <= scheduled.getEndTime())) {
					conflict = true;
				}
				/*
				 * cccccccccccc aaaaaa
				 */
				else if ((c.getStartTime() <= scheduled.getStartTime())
						&& (c.getEndTime() >= scheduled.getEndTime())) {
					conflict = true;
				}
				/*
				 * ccccc aaaaaaaaaa
				 */
				else if ((c.getStartTime() >= scheduled.getStartTime())
						&& (c.getEndTime() <= scheduled.getEndTime())) {
					conflict = true;
				}
				if (conflict)
					errorMessage = "Time conflict between CSE"
							+ c.getCourseNum() + " and CSE"
							+ scheduled.getCourseNum();
			}
		}
		return conflict;
	}

	// CS requirements
	public static boolean coreSE(Course c) throws IOException {
		boolean isCoreSE = false;

		String fileName = "coreSE.txt";
		BufferedReader br = null;
		String cur = "";
		br = new BufferedReader(new FileReader(fileName));
		boolean reqsMet = true;

		while ((cur = br.readLine()) != null) {
			String[] prereqs = cur.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
			for (int i = 0; i < prereqs.length; i++) {
				if (c.getCourseNum().equals(prereqs[i])) {
					isCoreSE = true;

					reqMessage = c.getCourseNum() + " is a core SE requirement";
				}
			}
		}
		br.close();

		return isCoreSE;
	}

	// SE requirements
	public static boolean coreCS(Course c) throws IOException {
		boolean isCoreCS = false;
		String fileName = "coreCS.txt";
		BufferedReader br = null;
		String cur = "";
		br = new BufferedReader(new FileReader(fileName));
		boolean reqsMet = true;

		while ((cur = br.readLine()) != null) {
			String[] prereqs = cur.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
			for (int i = 0; i < prereqs.length; i++) {
				if (c.getCourseNum().equals(prereqs[i])) {
					isCoreCS = true;
					reqMessage = c.getCourseNum() + " is a core CS requirement";
				}
			}
		}
		br.close();

		return isCoreCS;
	}

	// Determines if Course is a usable CS elective
	public static boolean electiveCS(Course c) throws IOException {
		boolean isElectiveCS = false;
		String fileName = "electiveCS.txt";
		BufferedReader br = null;
		String cur = "";
		br = new BufferedReader(new FileReader(fileName));
		boolean reqsMet = true;

		int electiveIndex = 0;
		while ((cur = br.readLine()) != null) {
			String[] prereqs = cur.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
			for (int i = 0; i < prereqs.length; i++) {
				if (c.getCourseNum().equals(prereqs[i])) {
					isElectiveCS = true;
					if (electiveIndex == 0) {
						reqMessage = c.getCourseNum()
								+ " is a CS core elective. You need 9 credit hours of core electives.";
					} else if (electiveIndex == 1) {
						reqMessage = c.getCourseNum()
								+ " is a CS affiliate elective. You need 6 credit hours of affiliate electives.";
					}
				}
			}
			electiveIndex++;
		}
		br.close();

		return isElectiveCS;
	}

	// Determines if Course applies to the Software Engineering Areas of
	// Specialization
	public static boolean areaOfSpecializationSE(Course c) throws IOException {
		boolean meetsRequirement = false;

		String fileName = "areaOfSpecialization.txt";
		BufferedReader br = null;
		String cur = "";
		br = new BufferedReader(new FileReader(fileName));
		boolean reqsMet = true;

		while ((cur = br.readLine()) != null) {
			String[] prereqs = cur.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
			for (int i = 0; i < prereqs.length; i++) {
				if (c.getCourseNum().equals(prereqs[i])) {
					reqMessage = c.getCourseNum()
							+ " meets Area of Specialization requirement for: "
							+ prereqs[0];
					meetsRequirement = true;
				}
			}

		}
		br.close();

		return meetsRequirement;
	}

	/*
	 * Calls all other methods that check CS requirements.
	 */
	public static boolean checkCSRequirements(Course c) throws IOException {
		boolean meetsRequirements = false;

		if (coreCS(c)) {
			meetsRequirements = true;
		} else if (electiveCS(c)) {
			meetsRequirements = true;
		}

		if (!meetsRequirements)
			reqMessage = c.getCourseNum() + " meets no CS requirements";

		return meetsRequirements;
	}

	public static boolean checkSERequirements(Course c) throws IOException {
		boolean meetsRequirements = false;

		if (coreSE(c)) {
			meetsRequirements = true;
		} else if (areaOfSpecializationSE(c)) {
			meetsRequirements = true;
		}

		if (!meetsRequirements)
			reqMessage = c.getCourseNum() + " meets no SE requirements";

		return meetsRequirements;
	}

	/*
	 * Saves the final course schedule, in the form of an ArrayList of Courses,
	 * to a .csv file
	 */
	public static void saveToCSV(ArrayList<Course> scheduledCourses)
			throws IOException {
		FileWriter scheduleWriter = new FileWriter("createdSchedule.csv");
		scheduleWriter.append("CRN,Department,Course Number,Title,Section,Instructor,Start Time, End Time \n");

		for (Course scheduled : scheduledCourses) {
			scheduleWriter.append(scheduled.displayCourseCSVFormat());
			scheduleWriter.append('\n');
		}

		scheduleWriter.close();
	}

	public static void main(String[] args) {

		//begin the process, open a chooseMajor window
		chooseMajor cm = new chooseMajor();

	}

}

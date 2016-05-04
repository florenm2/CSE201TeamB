import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {

	// Marks: "C:\\Users\\Owner\\Documents\\github\\CSE201TeamB\\"
	// Adams: "C:\\Users\\AdamBenjamin\\Documents\\CSE 201\\CSE201TeamB\\"
	// Mary's: "/Users/maryfloren/Documents/workspace/CSE201TeamB/"
	// String fileName = "/Users/nehulyadav/Documents/workspace/CSE201TeamB/";
	static String path = "C:\\Users\\AdamBenjamin\\Documents\\CSE 201\\CSE201TeamB\\";

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
				// System.out.println("CSE" + all.getCourseNum() + " "
				// + all.getTitle());
				prev = all.getCourseNum();
			}
		}
		return coursesOnce;
	}
	/*
	public static ArrayList<Course> displayPrereqOptions() throws IOException {

		ArrayList<Course> courses = ImportCSV.csvFileIN();
		String fileName = path + "prereqsOnce.txt";
		BufferedReader br = null;
		String cur = "";
		br = new BufferedReader(new FileReader(fileName));

		ArrayList<Course> prereqList = new ArrayList<Course>();

		while ((cur = br.readLine()) != null) {
			String[] prereqs = cur.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
			for (Course c : courses) {
				for (int i = 0; i < 11; i++){
					if (prereqs[i].equals(c.getCourseNum())) {
						prereqList.add(c);
					}
				}
			}

		}
		br.close();

		ArrayList<Course> prereqOnceList = displayCoursesOnce(prereqList);
		System.out.println(prereqOnceList);
		return prereqOnceList;
	}
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

	// working
	public static boolean checkPrereqs(Course c,
		ArrayList<Course> coursesPrevTaken) throws IOException {

		String fileName = path + "prereqs.txt";
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
						/*
						 * System.out.println("Prequisite for CSE" +
						 * c.getCourseNum() + " not met. Requirement: CSE " +
						 * prereqs[i] + " not satisfied");
						 */
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
	 * public static ArrayList<String> listIncompletePrereqs(Course c,
	 * ArrayList<Course> coursesPrevTaken ) throws IOException{
	 * 
	 * ArrayList<String> prereqsUnfinished = new ArrayList<String>(); String
	 * fileName = path + "prereqs.txt"; BufferedReader br = null; String cur =
	 * ""; br = new BufferedReader(new FileReader(fileName));
	 * 
	 * while ((cur = br.readLine()) != null){ String[] prereqs =
	 * cur.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); //if current line, first
	 * course listed is the course if(prereqs[0].equals(c.getCourseNum())){
	 * prereqsUnfinished = prereqs; //loop through checking all requirements
	 * for(int i = 1; i<prereqs.length;i++){ boolean notFoundYet = true; //check
	 * courses taken to see if it matches requirement for(int j = 0;
	 * j<coursesPrevTaken.size();j++){
	 * if((prereqs[i]).equals(coursesPrevTaken.get(j).getCourseNum()))
	 * prereqsToTake.remove(prereqs[i])
	 * 
	 * 
	 * prereqsUnfinished.add("CSE " + prereqs[i]); } } for(int i = 1;
	 * i<prereqs.length;i++){ int reqMet = 0; //check courses taken to see if it
	 * matches requirement for(Course taken: coursesPrevTaken){
	 * if(taken.getCourseNum().equals(prereqs[i])) reqMet = 1; } //if never set
	 * to one, requirement not satisfied if(reqMet == 0){
	 * System.out.println("Prequisite for CSE" + c.getCourseNum() +
	 * " not met. Requirement: CSE "+prereqs[i]+" not satisfied"); reqsMet =
	 * false; } }
	 * 
	 * 
	 * 
	 * } } br.close();
	 * 
	 * return prereqsUnfinished; }
	 */

	public static boolean isSameCourse(Course c,
			ArrayList<Course> coursesScheduled) {
		boolean conflict = false;

		for (Course scheduled : coursesScheduled) {
			if (c.getCourseNum().equals(scheduled.getCourseNum()) && c.getCrn() != scheduled.getCrn()) {
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
						//System.out.println("Same day between: " + c.displayCourse() + " and " + scheduled.displayCourse());
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

	// works
	public static boolean coreSE(Course c) throws IOException {
		boolean isCoreSE = false;

		String fileName = path + "coreSE.txt";
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
					System.out.println(c.getCourseNum()
							+ " is a core SE requirement");
				}
			}
		}
		br.close();

		return isCoreSE;
	}

	// works
	public static boolean coreCS(Course c) throws IOException {
		boolean isCoreCS = false;
		String fileName = path + "coreCS.txt";
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
					System.out.println(c.getCourseNum()
							+ " is a core CS requirement");
				}
			}
		}
		br.close();

		return isCoreCS;
	}

	public static boolean electiveCS(Course c) throws IOException {
		boolean isElectiveCS = false;
		String fileName = path + "electiveCS.txt";
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
						System.out
								.println(c.getCourseNum()
										+ " is a CS elective. You need a total of 9 credit hours from the following courses: ...");
						reqMessage = c.getCourseNum()
								+ " is a CS elective. You need a total of 9 credit hours from the following courses: ...";
					} else if (electiveIndex == 1) {
						System.out
								.println(c.getCourseNum()
										+ " is a CS affiliate elective. You need a total of 6 credit hours from the following courses: ...");
						reqMessage = c.getCourseNum()
								+ " is a CS affiliate elective. You need a total of 6 credit hours from the following courses: ...";
					}
				}
			}
			electiveIndex++;
		}
		br.close();

		return isElectiveCS;
	}

	public static boolean areaOfSpecializationSE(Course c) throws IOException {
		boolean meetsRequirement = false;

		String fileName = path + "areaOfSpecialization.txt";
		BufferedReader br = null;
		String cur = "";
		br = new BufferedReader(new FileReader(fileName));
		boolean reqsMet = true;

		while ((cur = br.readLine()) != null) {
			String[] prereqs = cur.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
			for (int i = 0; i < prereqs.length; i++) {
				if (c.getCourseNum().equals(prereqs[i])) {
					System.out.println(c.getCourseNum()
							+ " meets Area of Specialization requirement for: "
							+ prereqs[0]);
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
		System.out.println(c.getCourseNum() + " meets no CS requirements");

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
		System.out.println(c.getCourseNum() + " meets no SE requirements");

		return meetsRequirements;
	}

	public static void saveToCSV(ArrayList<Course> scheduledCourses) // ArrayList<Course>
																		// cOnce)
			throws IOException {
		FileWriter scheduleWriter = new FileWriter(path + "createdSchedule.csv");

		// FileWriter scheduleOnceWriter = new FileWriter(path +
		// "coursesOnceSchedule.csv");

		for (Course scheduled : scheduledCourses) {
			scheduleWriter.append(scheduled.displayCourseCSVFormat());
			scheduleWriter.append('\n');
		}
		/*
		 * for (Course c : cOnce) {
		 * scheduleOnceWriter.append(c.displayCourseCSVFormat());
		 * scheduleOnceWriter.append('\n'); }
		 */

		scheduleWriter.close();
		// scheduleOnceWriter.close();
	}

	public static void main(String[] args) {

		ArrayList<Course> allCourses = new ArrayList<Course>();
		ArrayList<Course> coursesOnce = new ArrayList<Course>();// notice
																// unused, never
																// returned
		ArrayList<Course> coursesPrevTaken = new ArrayList<Course>();
		ArrayList<Course> coursesScheduled = new ArrayList<Course>();
		ArrayList<Course> prereqs = new ArrayList<Course>();

		try {
			allCourses = ImportCSV.csvFileIN();
			prereqs = displayPrereqOptions();
		} catch (IOException e) {
			e.printStackTrace();
		}

		coursesOnce = displayCoursesOnce(allCourses);
		for (Course c : prereqs)
			System.out.println(c.getCourseNum());

		/*
		 * // Step 0: Testing Course c274 = new Course();
		 * c274.setCourseNum("274"); c274.setSubject("CSE");
		 * 
		 * Course c289 = new Course(); c289.setCourseNum("289");
		 * c289.setSubject("CSE");
		 * 
		 * Course c381 = new Course(); c381.setCourseNum("381");
		 * c381.setSubject("CSE"); c381.setDays("MW"); c381.setStartTime(10000);
		 * c381.setEndTime(11000);
		 * 
		 * Course c464 = new Course(); c464.setCourseNum("464");
		 * c464.setSubject("CSE"); c464.setDays("WF"); c464.setStartTime(10050);
		 * c464.setEndTime(12050);
		 * 
		 * Course c174 = new Course(); c174.setCourseNum("174");
		 * c174.setSubject("CSE");
		 * 
		 * Course c211 = new Course(); c211.setCourseNum("211");
		 * c211.setSubject("CSE");
		 * 
		 * Course c386 = new Course(); c386.setCourseNum("386");
		 * c386.setSubject("CSE");
		 * 
		 * Course c600 = new Course(); c600.setCourseNum("600");
		 * c600.setSubject("CSE");
		 * 
		 * coursesPrevTaken.add(c274); coursesPrevTaken.add(c289);
		 * 
		 * coursesScheduled.add(c381); coursesScheduled.add(c464);
		 * 
		 * 
		 * try { checkPrereqs(c381, coursesPrevTaken); checkPrereqs(c464,
		 * coursesPrevTaken); checkPrereqs(c174, coursesPrevTaken); //
		 * coreSE(c174); // coreSE(c464); // coreCS(c174); // coreCS(c464);
		 * 
		 * isSameCourse(c464, coursesScheduled);
		 * 
		 * // electiveCS(c211); // electiveCS(c386);
		 * System.out.println("\nCS Checks"); checkCSRequirements(c600);
		 * checkCSRequirements(c211); checkCSRequirements(c386);
		 * checkCSRequirements(c174); checkCSRequirements(c386);
		 * checkCSRequirements(c464);
		 * 
		 * System.out.println("\nSE Checks"); checkSERequirements(c600);
		 * checkSERequirements(c211); checkSERequirements(c386);
		 * checkSERequirements(c174); checkSERequirements(c386);
		 * checkSERequirements(c464);
		 * 
		 * /* System.out.println("ONE"); ArrayList<String> prereqsNeeded = new
		 * ArrayList<String>(); prereqsNeeded = listIncompletePrereqs(c381,
		 * coursesPrevTaken); for (String s : prereqsNeeded)
		 * System.out.println(s); System.out.println("TWO");
		 */

		// areaOfSpecializationSE(c386);
		// areaOfSpecializationSE(c464);

		// saveToCSV(coursesScheduled, coursesOnce);
		/*
		 * } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * if (checkCourseTime(c464, coursesScheduled)) {
		 * System.out.println("Time conflict"); } else {
		 * System.out.println("No time conflict"); }
		 */

		// Step 1: Display all course names for student to select the courses
		// that he/she has previously taken
		// coursesOnce = displayCoursesOnce(allCourses);

		// Step 2: Let student select courses and store in coursesPrevTaken

		// Step 3: Display all courses offered in a given semester
		for (Course c : allCourses) {
			// System.out.println(c.displayCourse());
		}

		// Step 4: Let student select all courses he/she wants to schedule and
		// store in coursesScheduled

		// Step 5: Check requirements
		// 5a: Check prereqs, will call check prereqs here

		// 5b: Check

		chooseMajor cm = new chooseMajor();

	}

}

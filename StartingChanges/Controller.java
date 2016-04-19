import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Controller {

	public static void main(String[] args) {
		
		ArrayList<Course> allCourses = new ArrayList<Course>();
		ArrayList<Course> coursesOnce = new ArrayList<Course>();//notice unused, never returned
		ArrayList<Course> coursesPrevTaken = new ArrayList<Course>();
		ArrayList<Course> coursesScheduled = new ArrayList<Course>();
		
		try {
			allCourses = ImportCSV.csvFileIN();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Step 0: Testing
		Course c274 = new Course();
		c274.setCourseNum("274");
		c274.setSubject("CSE");
		
		Course c289 = new Course();
		c289.setCourseNum("289");
		c289.setSubject("CSE");
		
		Course c381 = new Course();
		c381.setCourseNum("381");
		c381.setSubject("CSE");
		
		Course c487 = new Course();
		c487.setCourseNum("487");
		c487.setSubject("CSE");
		
		Course c174 = new Course();
		c174.setCourseNum("174");
		c174.setSubject("CSE");
		
		coursesPrevTaken.add(c274);
		coursesPrevTaken.add(c289);
		
		coursesScheduled.add(c381);
		
		try {
			checkPrereqs(c381, coursesPrevTaken);
			checkPrereqs(c487, coursesPrevTaken);
			checkPrereqs(c174, coursesPrevTaken);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Step 1: Display all course names for student to select the courses that he/she has previously taken
		//coursesOnce = displayCoursesOnce(allCourses);
		
		//Step 2: Let student select courses and store in coursesPrevTaken
		
		//Step 3: Display all courses offered in a given semester
		for(Course c : allCourses){
			//System.out.println(c.displayCourse());
		}
		
		//Step 4: Let student select all courses he/she wants to schedule and store in coursesScheduled
		
		//Step 5: Check requirements
		//5a: Check prereqs, will call check prereqs here
		
		//5b: Check 
		
		
		
		
	}
	
	/*
	 * Filters through all courses offered in the .csv file and displays each course only once (removes multiple sections)
	 */
	public static ArrayList<Course> displayCoursesOnce(ArrayList<Course> allClasses){
		ArrayList<Course> coursesOnce = new ArrayList<Course>();
		String prev = "";
		for(Course all : allClasses){
			if(!all.getCourseNum().equals(prev)){
				coursesOnce.add(all);
				System.out.println("CSE"+all.getCourseNum() + " " + all.getTitle());
				prev = all.getCourseNum();
			}
		}		
		return coursesOnce;
	}
	
	/*
	 * CS requirements
	 * http://bulletin.miamioh.edu/engineering-computing/computer-science-bs/
	 * 
	 * SE requirements
	 * http://bulletin.miamioh.edu/engineering-computing/software-bs/
	 */
	
	//working
	public static void checkPrereqs(Course c, ArrayList<Course> coursesPrevTaken ) throws IOException{
		//Mark's location: "C:\\Users\\Owner\\Documents\\github\\CSE201TeamB\\prereqs.txt"
		//Adam: "C:\\Users\\AdamBenjamin\\Documents\\CSE 201\\CSE201TeamB\\prereqs.txt"
		String fileName = "C:\\Users\\AdamBenjamin\\Documents\\CSE 201\\CSE201TeamB\\prereqs.txt";
		BufferedReader br = null;
		String cur = "";
		br = new BufferedReader(new FileReader(fileName));
		
		while ((cur = br.readLine()) != null){
			String[] prereqs = cur.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
			//if current line, first course listed is the course
			if(prereqs[0].equals(c.getCourseNum())){
				//loop through checking all requirements
				for(int i = 1; i<prereqs.length;i++){
					int reqMet = 0;
					//check courses taken to see if it matches requirement
					for(Course taken: coursesPrevTaken){
						if(taken.getCourseNum().equals(prereqs[i]))
							reqMet = 1;	
					}
					//if never set to one, requirement not satisfied
					if(reqMet == 0)
						System.out.println("Prequisite for CSE" + c.getCourseNum() + " not met. Requirement: CSE "+prereqs[i]+" not satisfied");
				}
			}
		}
		br.close();
	}
	
	
}

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Controller {

	public static void main(String[] args) {
		
		ArrayList<Course> allCourses = new ArrayList<Course>();
		ArrayList<Course> coursesOnce = new ArrayList<Course>();
		ArrayList<Course> coursesPrevTaken = new ArrayList<Course>();
		ArrayList<Course> coursesScheduled = new ArrayList<Course>();
		
		try {
			allCourses = ImportCSV.csvFileIN();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Step 1: Display all course names for student to select the courses that he/she has previously taken
		coursesOnce = displayCoursesOnce(allCourses);
		
		//Step 2: Let student select courses and store in coursesPrevTaken
		
		//Step 3: Display all courses offered in a given semester
		for(Course c : allCourses){
			System.out.println(c.displayCourse());
		}
		
		//Step 4: Let student select all courses he/she wants to schedule and store in coursesScheduled
		
		//Step 5: Check requirements
		//5a: Check prereqs
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
	
	public static void checkPrereqs(Course c){
		
		
	}
	
	
}

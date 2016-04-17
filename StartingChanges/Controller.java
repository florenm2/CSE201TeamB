import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Controller {

	public static void main(String[] args) {
		
		ArrayList<Course> allCourses = new ArrayList<Course>();
		ArrayList<Course> coursesOnce = new ArrayList<Course>();
		ArrayList<Course> coursesTaken = new ArrayList<Course>();
		
		try {
			allCourses = ImportCSV.csvFileIN();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		for(Course c : allCourses){
			System.out.println(c.displayCourse());
		}
		*/
		coursesOnce = displayCoursesOnce(allCourses);
		
		
		
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
	
	
	
}

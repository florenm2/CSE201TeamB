import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Controller {

	public static void main(String[] args) {
		
		ArrayList<Course> allCourses = new ArrayList<Course>();
		try {
			allCourses = ImportCSV.csvFileIN();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Course c : allCourses){
			System.out.println(c.displayCourse());
		}
	}
	
	public ArrayList<Course> displayCoursesOnce(){
		ArrayList<Course> coursesOnce = new ArrayList<Course>();
		
		
		
		return coursesOnce;
	}
	
}

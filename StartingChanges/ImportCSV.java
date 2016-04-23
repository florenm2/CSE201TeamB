import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is where all of the data from the CSV file are read in and course objects are created.
 * @author lauren
 *
 */
public class ImportCSV {

	/**
	 * parses the csv file and creates the course objects
	 * @param fileName
	 * @throws IOException
	 */
	@SuppressWarnings("null")
	public static ArrayList<Course> csvFileIN() throws IOException {

		//Marks: "C:\\Users\\Owner\\Documents\\github\\CSE201TeamB\\classes.csv"
		//Adams: "C:\\Users\\AdamBenjamin\\Documents\\CSE 201\\CSE201_dev\\src\\classes.csv"
		//Mary's: "/Users/maryfloren/CSE201TeamB/classes.csv"
//		String fileName = "/Users/maryfloren/CSE201TeamB/classes.csv";
//		String fileName = "C:\\Users\\AdamBenjamin\\Documents\\CSE 201\\CSE201_dev\\src\\classes.csv";
		
		// creatBufferedReader
		BufferedReader br = null;

		// current line
		String cur = "";

		// this stores all of the parts seperated by commas in the current line
		ArrayList<Course> courseList = new ArrayList<Course>();

		// read the file imported by the filereader
		br = new BufferedReader(new FileReader(fileName));

		//string of titles
		String courses = br.readLine();

		// read line/create object
		while ((cur = br.readLine()) != null) {

			// split on the comma
			String[] course = cur.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

			// course object created
			Course obj = new Course();

			if (course[0] != null) {
				obj.setCrn(Integer.parseInt(course[0].toString()));
			} else {
				obj.setCrn((Integer) null);
			}

			if (course[1] != null) {
				obj.setSubject(course[1]);
			} else {
				obj.setSubject(null);
			}

			if (course[2] != null) {
				obj.setCourseNum(course[2]);
			} else {
				obj.setCourseNum(null);
			}

			if (course[3] != null) {
				obj.setSection(course[3]);
			} else {
				obj.setSection(null);
			}

			// included title
			if (course[4] != null) {
				obj.setTitle(course[4]);
			} else {
				obj.setTitle(null);
			}
			// skip hours 5
			// skip En 6
			// skip max_enroll 7

			try {
				obj.setStartTime(Integer.parseInt(course[8].toString()));
			} catch (NumberFormatException ex) {
				obj.setStartTime(0);
				// System.err.println("Ilegal input: Start time");
			}

			try {
				obj.setEndTime(Integer.parseInt(course[9].toString()));
			} catch (NumberFormatException ex) {
				obj.setEndTime(0);
				// System.err.println("Ilegal input: End time");
			}

			if (course[10] != null) {
				obj.setDays(course[10]);
			} else {
				obj.setDays(null);
			}

			// skip building 11
			// skip room 12

			if (course[13] != null) {
				String s = course[13];
				s.replaceAll("^\"|\"$", "");
				obj.setInstructorName(s);
			} else {
				obj.setInstructorName(null);
			}

			// add to array of courses
			courseList.add(obj);

			// display to console for testing
			//System.out.println(obj.displayCourse());

		}
		
		
		// scan.close();
		br.close();
		
		return courseList;
	}
	
	
}



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * This class is where all of the data from the CSV file are read in and course
 * objects are created.
 * 
 * @author lauren
 * Edited by Mary Floren, Adam Benjamin, Mark Sullivan, and Nehul Yadav
 * 
 */

public class ImportCSV {

	/**
	 * parses the csv file and creates the course objects
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	@SuppressWarnings("null")
	public static ArrayList<Course> csvFileIN() throws IOException {

		String fileName = "CSECourseScheduleSpring2016.csv";

		// creatBufferedReader
		BufferedReader br = null;

		// current line
		String cur = "";

		// this stores all of the parts seperated by commas in the current line
		ArrayList<Course> courseList = new ArrayList<Course>();

		// read the file imported by the filereader
		br = new BufferedReader(new FileReader(fileName));

		// string of titles
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
			}

			try {
				obj.setEndTime(Integer.parseInt(course[9].toString()));
			} catch (NumberFormatException ex) {
				obj.setEndTime(0);
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

		}

		br.close();

		/*
		 * Sorts the ArrayList of classes
		 */
		Collections.sort(courseList, new Comparator<Course>() {
			public int compare(Course c1, Course c2) {
				int intc1 = Integer.parseInt(c1.getCourseNum().substring(0, 3));
				int intc2 = Integer.parseInt(c2.getCourseNum().substring(0, 3));
				return intc1 - intc2;
			}

		});

		return courseList;
	}

}

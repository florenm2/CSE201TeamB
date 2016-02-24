import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * This Class constructs the GUI and creates the strings that will be printed to the GUI.
 * @author lauren
 *
 */
public class FirstGUI2 {
	private Container pane;
	final boolean fill = true;
	final boolean weightX = true;
	final boolean RIGHT_TO_LEFT = false;
	public String mon = "";
	public String tues = "";
	public String wed = "";
	public String thu = "";
	public String fri = "";
	private JTextArea textAreaMon = new JTextArea(mon);
	private JTextArea textAreaTue = new JTextArea(tues);
	private JTextArea textAreaWed = new JTextArea(wed);
	private JTextArea textAreaThu = new JTextArea(thu);
	private JTextArea textAreaFri = new JTextArea(fri);
	private JTextArea description;
	private JScrollPane scroll = new JScrollPane();

	/**
	 * add components to the GUI
	 */
	public void addComponents(Container pane) {
		if (RIGHT_TO_LEFT)
			pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		// JScrollPane scroll = new JScrollPane(pane);

		JButton button;
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.fill = GridBagConstraints.HORIZONTAL;

		button = new JButton("Open File");
		c.gridx = 1;
		c.gridy = 1;
		pane.add(button, c);

		textAreaMon = new JTextArea(mon);
		textAreaMon.setLineWrap(true);
		textAreaMon.setEditable(false);
		c.gridx = 1;
		c.gridy = 2;
		pane.add(textAreaMon, c);

		textAreaTue = new JTextArea(tues);
		textAreaTue.setLineWrap(true);
		textAreaTue.setEditable(false);
		c.gridx = 1;
		c.gridy = 3;
		pane.add(textAreaTue, c);

		textAreaWed = new JTextArea(wed);
		textAreaWed.setLineWrap(true);
		textAreaWed.setEditable(false);
		c.gridx = 1;
		c.gridy = 4;
		pane.add(textAreaWed, c);

		textAreaThu = new JTextArea(thu);
		textAreaThu.setLineWrap(true);
		textAreaThu.setEditable(false);
		c.gridx = 1;
		c.gridy = 5;
		pane.add(textAreaThu, c);

		textAreaFri = new JTextArea(fri);
		textAreaFri.setLineWrap(true);
		textAreaFri.setEditable(false);
		c.gridx = 1;
		c.gridy = 6;
		pane.add(textAreaFri, c);

		description = new JTextArea("\n Click the open button in order to select and im"
				+ "port your .csv file. Your schedule and times will be displayed in the schedule below.\n");
		description.setEditable(false);
		c.gridx = 1;
		c.gridy = 0;

		pane.add(description, c);

		// attaching the file opener to the open file button
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				new InterfacePanel();
				// textAreaMon.setText(mon);
				makeGUI();
			}
		});
	}

	/**
	 * creates the frame and showing the GUI to the user
	 */
	public static void makeGUI() {
		JFrame frame = new JFrame("Final Exam Scheduler");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// FirstGUI2 add = new FirstGUI2();
		JPanel panel = new JPanel();
		FirstGUI2 add = new FirstGUI2();
		add.addComponents(panel);

		JScrollPane pane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		frame.getContentPane().add(pane);

		add.printToGUI();
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Finds out if there are any overlapping times for time1
	 */
	public boolean findOverlapForTime1(ArrayList<Course> courses) {
		int endTime1;
		boolean boo = false;
		int startTime2;
		String prof1 = "";
		String prof2 = "";
		String courseNum1 = "";
		String courseNum2 = "";
		String section1 = "";
		String section2 = "";
		
		if(courses.size() == 1){
			return boo;
		}

		for (int i = 0; i < courses.size(); i++) {
			for (int j = 0; j < courses.size(); j++) {

				Course course1 = courses.get(i);
				Course course2 = courses.get(j);
				
				endTime1 = course1.getEndTime();
				startTime2 = course2.getStartTime();	
				prof1 = course1.getInstructorName();
				prof2 = course2.getInstructorName();
				courseNum1 = course1.getCourseNum();
				courseNum2 = course2.getCourseNum();
				section1 = course1.getSection();
				section2 = course2.getSection();
				
				//System.out.println(courses.get(i) + "compared to " + courses.get(j));
				//System.out.println(endTime1 + " compared to " + startTime2);
				//System.out.println(prof1 + " compared to " + prof2);
				
					if (endTime1 <= startTime2 || prof1.equals(prof2) && (!courseNum1.equals(courseNum2) || !section1.equals(section2))) {
						boo = true;
						System.out.println("boo = true");
					}
				
			}
		}
		return boo;
	}

	/**
	 * Finds out if there are any overlapping times for times 4 and 9
	 */
	public boolean findOverlapForTime4And9(ArrayList<Course> courses) {
		int endTime1;
		int startTime2;
		boolean boo = false;
		String prof1 = "";
		String prof2 = "";
		String courseNum1 = "";
		String courseNum2 = "";
		String section1 = "";
		String section2 = "";
		
		if(courses.size() == 1){
			return boo;
		}

		for (int i = 0; i < courses.size(); i++) {
			for (int j = 0; j < courses.size(); j++) {

				Course course1 = courses.get(i);
				Course course2 = courses.get(j);
				
				endTime1 = course1.getEndTime();
				startTime2 = course2.getStartTime();
				prof1 = course1.getInstructorName();
				prof2 = course2.getInstructorName();
				courseNum1 = course1.getCourseNum();
				courseNum2 = course2.getCourseNum();
				section1 = course1.getSection();
				section2 = course2.getSection();

				//System.out.println(courses.get(i) + "compared to " + courses.get(j));
				//System.out.println(endTime1 + " compared to " + startTime2);
				
				if (endTime1 <= startTime2 || prof1.equals(prof2) && (!courseNum1.equals(courseNum2) || !section1.equals(section2))) {
					boo = true;
					System.out.println("boo = true");
				}
			}
		}
		return boo;
	}

	/**
	 * finds out if there are overlapping times for any time starting after 5:30
	 */
	public boolean findOverlapForTimesAfter1730(ArrayList<Course> courses) {
		int startTime;
		int endTime;
		boolean boo = false;
		String prof1 = "";
		String prof2 = "";
		String courseNum1 = "";
		String courseNum2 = "";
		String section1 = "";
		String section2 = "";

		if(courses.size() == 1){
			return boo;
		}
		
		
		for (int i = 0; i < courses.size(); i++) {
			for (int j = 0; j < courses.size(); j++) {

				Course course1 = courses.get(i);
				Course course2 = courses.get(j);
				
				endTime = course1.getEndTime();
				startTime = course2.getStartTime();
				prof1 = course1.getInstructorName();
				prof2 = course2.getInstructorName();
				courseNum1 = course1.getCourseNum();
				courseNum2 = course2.getCourseNum();
				section1 = course1.getSection();
				section2 = course2.getSection();

				//System.out.println(courses.get(i) + "compared to " + courses.get(j));
				System.out.println(endTime + " compared to " + startTime);
				System.out.println(prof1 + " compared to " + prof2);

				if (startTime >= endTime || prof1.equals(prof2) && (!courseNum1.equals(courseNum2) || !section1.equals(section2))) {
					boo = true;
					System.out.println("boo = true");
				}
			}
		}
		return boo;
	}

	/**
	 * creates the strings that will print to the GUI
	 */
	public void printToGUI() {
		// JText Fields
		mon = "Monday: \n \n 8:00 - 10:00:\t Group Exam 1 \n 10:15-12:15:\t Group Exam 2 \n 12:45 - 2:45:\t";

		// check for possible overlap
		if (findOverlapForTime1(ArrayListsForClasses.time1)) {
			mon += "ERROR POSSIBLE OVERLAPPING CLASSES";
			mon += "\n\t";
		}

		for (int i = 0; i < ArrayListsForClasses.time1.size(); i++) {
			mon += ArrayListsForClasses.time1.get(i).displayCourse();
			//System.out.println("Added to string for GUI: " + ArrayListsForClasses.time1.get(i).displayCourse());
			mon += " \n\t";
		}

		mon += "\n 3:00 - 5:00:\t";
		for (int i = 0; i < ArrayListsForClasses.time2.size(); i++) {
			mon += ArrayListsForClasses.time2.get(i).displayCourse();
			//System.out.println("Added to string for GUI: " + ArrayListsForClasses.time2.get(i).displayCourse());
			mon += " \n\t";
		}

		mon += "\n 5:30 - 7:30:\t Group Exam 3 \n 7:45 - 9:45:\t";
		if (findOverlapForTimesAfter1730(ArrayListsForClasses.time3)) {
			tues += "ERROR POSSIBLE OVERLAPPING CLASSES";
			tues += "\n\t";
		}

		for (int i = 0; i < ArrayListsForClasses.time3.size(); i++) {
			mon += ArrayListsForClasses.time3.get(i).displayCourse();
			//System.out.println("Added to string for GUI: " + ArrayListsForClasses.time3.get(i).displayCourse());
			mon += " \n\t";
		}
		// }
		mon += "\n \n";
		textAreaMon.setText(mon);

		// textAreaTues
		tues = "Tuesday: \n \n 8:00 - 10:00: \t";

		if (findOverlapForTime4And9(ArrayListsForClasses.time4)) {
			tues += "ERROR POSSIBLE OVERLAPPING CLASSES";
			tues += "\n\t";
		}

		for (int i = 0; i < ArrayListsForClasses.time4.size(); i++) {
			tues += ArrayListsForClasses.time4.get(i).displayCourse();
			//System.out.println("Added to string for GUI: " + ArrayListsForClasses.time4.get(i).displayCourse());
			tues += " \n\t";
		}

		tues += "\n 10:15 - 12:15: Group Exam 4 \n 12:45 - 2:45:\t ";

		for (int i = 0; i < ArrayListsForClasses.time5.size(); i++) {
			tues += ArrayListsForClasses.time5.get(i).displayCourse();
			//System.out.println("Added to string for GUI: " + ArrayListsForClasses.time5.get(i).displayCourse());
			tues += " \n\t";
		}

		tues += "\n 3:00 - 5:00:\t ";

		for (int i = 0; i < ArrayListsForClasses.time6.size(); i++) {
			tues += ArrayListsForClasses.time6.get(i).displayCourse();
			//System.out.println("Added to string for GUI: " + ArrayListsForClasses.time6.get(i).displayCourse());
			tues += " \n\t";
		}

		tues += "\n 5:30 - 7:30:\t ";

		if (findOverlapForTimesAfter1730(ArrayListsForClasses.time7)) {
			tues += "ERROR POSSIBLE OVERLAPPING CLASSES";
			tues += "\n\t";
		}
		for (int i = 0; i < ArrayListsForClasses.time7.size(); i++) {
			tues += ArrayListsForClasses.time7.get(i).displayCourse();
			//System.out.println("Added to string for GUI: " + ArrayListsForClasses.time7.get(i).displayCourse());
			tues += " \n\t";
		}

		tues += "\n 7:45 - 9:45:\t ";

		if (findOverlapForTimesAfter1730(ArrayListsForClasses.time8)) {
			tues += "ERROR POSSIBLE OVERLAPPING CLASSES";
			tues += "\n\t";
		}

		for (int i = 0; i < ArrayListsForClasses.time8.size(); i++) {
			tues += ArrayListsForClasses.time8.get(i).displayCourse();
			//System.out.println("Added to string for GUI: " + ArrayListsForClasses.time8.get(i).displayCourse());
			tues += " \n\t";
		}

		tues += "\n \n";
		textAreaTue.setText(tues);

		// TextAreaWed
		wed = "Wednesday \n \n 8:00 - 10:00:\t";

		if (findOverlapForTime4And9(ArrayListsForClasses.time9)) {
			tues += "ERROR POSSIBLE OVERLAPPING CLASSES";
			tues += "\n\t";
		}

		if (findOverlapForTimesAfter1730(ArrayListsForClasses.time9)) {
			wed += "ERROR POSSIBLE OVERLAPPING CLASSES";
			wed += "\n\t";
		}

		for (int i = 0; i < ArrayListsForClasses.time9.size(); i++) {
			wed += ArrayListsForClasses.time9.get(i).displayCourse();
			//System.out.println("Added to string for GUI: " + ArrayListsForClasses.time9.get(i).displayCourse());
			wed += " \n\t";
		}

		wed += "\n 10:15-12:15:\t";

		for (int i = 0; i < ArrayListsForClasses.time10.size(); i++) {
			wed += ArrayListsForClasses.time10.get(i).displayCourse();
			//System.out.println("Added to string for GUI: " + ArrayListsForClasses.time10.get(i).displayCourse());
			wed += " \n\t";
		}

		wed += "\n 12:45 - 2:45 :\t Group Exam 5 \n 3:00 - 5:00:\t";

		for (int i = 0; i < ArrayListsForClasses.time11.size(); i++) {
			wed += ArrayListsForClasses.time11.get(i).displayCourse();
			System.out.println("Added to string for GUI: " + ArrayListsForClasses.time11.get(i).displayCourse());
			wed += " \n\t";
		}

		wed += "\n 5:30 - 7:30:\t";

		System.out.println("START HERE!!!!!!!!!!!!!!!!!!!");
		if (findOverlapForTimesAfter1730(ArrayListsForClasses.time12)) {
			wed += "ERROR POSSIBLE OVERLAPPING CLASSES";
			wed += "\n\t";
		}

		for (int i = 0; i < ArrayListsForClasses.time12.size(); i++) {
			wed += ArrayListsForClasses.time12.get(i).displayCourse();
			//System.out.println("Added to string for GUI: " + ArrayListsForClasses.time12.get(i).displayCourse());
			wed += " \n\t";
		}
		System.out.println("END HERE!!!!!!!!!!!!!!!!!!!");

		wed += "\n 7:45 - 9:45:\t";

		if (findOverlapForTimesAfter1730(ArrayListsForClasses.time13)) {
			wed += "ERROR POSSIBLE OVERLAPPING CLASSES";
			wed += "\n\t";
		}

		for (int i = 0; i < ArrayListsForClasses.time13.size(); i++) {
			wed += ArrayListsForClasses.time13.get(i).displayCourse();
			//System.out.println("Added to string for GUI: " + ArrayListsForClasses.time13.get(i).displayCourse());
			wed += " \n\t";
		}

		wed += "\n \n";
		textAreaWed.setText(wed);

		// TextAreaThurs
		thu = "Thursday \n \n 8:00 - 10:00:\t";

		for (int i = 0; i < ArrayListsForClasses.time14.size(); i++) {
			thu += ArrayListsForClasses.time14.get(i).displayCourse();
			//System.out.println("Added to string for GUI: " + ArrayListsForClasses.time14.get(i).displayCourse());
			thu += " \n\t";
		}

		thu += "\n 10:15-12:15 :\t Group Exam 6 \n 12:45 - 2:45:\t";

		for (int i = 0; i < ArrayListsForClasses.time15.size() - 1; i++) {
			thu += ArrayListsForClasses.time15.get(i).displayCourse();
			//System.out.println("Added to string for GUI: " + ArrayListsForClasses.time15.get(i).displayCourse());
			thu += " \n\t";
		}

		thu += "\n 3:00 - 5:00:\t";

		for (int i = 0; i < ArrayListsForClasses.time16.size(); i++) {
			thu += ArrayListsForClasses.time16.get(i).displayCourse();
			//System.out.println("Added to string for GUI: " + ArrayListsForClasses.time16.get(i).displayCourse());
			thu += " \n\t";
		}

		thu += "\n 5:30 - 7:30:\t Group Exam 7 \n 7:45 - 9:45:\t";

		if (findOverlapForTimesAfter1730(ArrayListsForClasses.time17)) {
			thu += "ERROR POSSIBLE OVERLAPPING CLASSES";
			thu += "\n\t";
		}

		for (int i = 0; i < ArrayListsForClasses.time17.size(); i++) {
			thu += ArrayListsForClasses.time17.get(i).displayCourse();
			//System.out.println("Added to string for GUI: " + ArrayListsForClasses.time17.get(i).displayCourse());
			thu += " \n\t";
		}

		thu += "\n \n";
		textAreaThu.setText(thu);

		// TextAreaFri
		fri = "Friday \n \n 8:00 - 10:00:\t Group Exam 8 \n 10:15-12:15:\t";

		for (int i = 0; i < ArrayListsForClasses.time18.size(); i++) {
			fri += ArrayListsForClasses.time18.get(i).displayCourse();
			//System.out.println("Added to string for GUI: " + ArrayListsForClasses.time18.get(i).displayCourse());
			fri += " \n\t";
		}

		fri += "\n 12:45 - 2:45:\t Group Exam 9";
		fri += "\n \n";
		textAreaFri.setText(fri);
	}

	/**
	 * main method
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				makeGUI();
			}
		});

	}

}
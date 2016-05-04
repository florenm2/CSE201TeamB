/*
 * Creates a JFrame using javax.swing that displays a user's final exam times based on the classes that
 * the user selected in chooseCourses.java
 * 
 * by: Adam Benjamin, Mark Sullivan, Mary Floren, Nehul Yadav
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class displayFinalExams extends JFrame implements ActionListener {

	private int numDays = 6;
	private ArrayList<Course> scheduledCourses;
	private JButton buttonsave, buttonback;
	ArrayList<Course> coursesScheduled1;
	displayWeeklySchedule dws;
	
	/*
	 * Constructor that calls all other methods. Takes in displayWeeklySchedule object that contains all the 
	 * data necessary to create and display schedule. 
	 */
	public displayFinalExams(displayWeeklySchedule dws) throws IOException {
		this.dws = dws;
		scheduledCourses = dws.coursesScheduled1;
		frameSetup(dws.coursesScheduled1);
		
		coursesScheduled1 = dws.coursesScheduled1;
		setVisible(true);
	}

	//Sets up layout of entire frame
	private void frameSetup(ArrayList<Course> coursesScheduled) throws IOException {
		setLayout(new BorderLayout());
		setBounds(0, 0, 900, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setLocationRelativeTo(null);
		finalExamSetup(coursesScheduled);
		buttonPanelSetup(coursesScheduled);
		heading();
		
		//
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height-100);
		//
		
		setVisible(true);

	}

	//Sets up JPanel grid for each day of the week's final exams
	private void finalExamSetup(ArrayList<Course> coursesScheduled) {

		JPanel days = new JPanel(new GridLayout(0, numDays));

		days.add(times());
		days.add(monday(coursesScheduled));
		days.add(tuesday(coursesScheduled));
		days.add(wednesday(coursesScheduled));
		days.add(thursday(coursesScheduled));
		days.add(friday(coursesScheduled));

		add(days, BorderLayout.CENTER);
	}

	//Sets up two buttons at bottom of the frame to go back and save schedule
	private void buttonPanelSetup(ArrayList<Course>scheduledCourses) throws IOException {
		JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
		buttonback = new JButton("<<View Weekly Schedule");
		buttonsave = new JButton("Save Schedule to .csv");

		buttonsave.addActionListener(new CSVListener(scheduledCourses));
		
		buttonPanel.add(buttonback);
		buttonback.addActionListener(this);
		buttonPanel.add(buttonsave);

		add(buttonPanel, BorderLayout.SOUTH);
	}

	/*
	 * Implementation of ActionListener that calls the saveToCSV(ArrayList<Course>) method from Controller to create
	 * csv file of courses scheduled
	 */
	private class CSVListener implements ActionListener {

		public CSVListener(ArrayList<Course> scheduledCourses) throws IOException {
			//Controller.saveToCSV(scheduledCourses);
		}

		public void actionPerformed(ActionEvent e) {
			try {
				Controller.saveToCSV(scheduledCourses );
				JOptionPane.showMessageDialog(null, "CSV created! See file: createdSchedule.csv to view your schedule!");
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}
	}
	
	//Creates JPanel of header of JFrame
	private void heading() {
		JPanel heading = new JPanel();
		JLabel header = new JLabel("Final Exam Schedule");
		header.setFont(header.getFont().deriveFont(Font.BOLD, 18f));
		heading.add(header);

		add(heading, BorderLayout.NORTH);
	}

	//Creates JPanel that display exam times
	private JPanel times() {
		JPanel time = new JPanel(new GridLayout(13, 0));
		// sets border
		Border blackline = BorderFactory.createLineBorder(Color.BLACK, 1);
		time.setBorder(blackline);

		// sets heading
		JLabel heading = new JLabel("Exam Times");
		time.add(heading);
		Font font = heading.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		heading.setFont(font.deriveFont(attributes));
		// heading.setFont(heading.getFont().deriveFont(Font.BOLD,14f));

		JLabel time1 = new JLabel("8:00-10:00am");
		Font font1 = time1.getFont();
		// time1.setFont(font.deriveFont(attributes));
		JLabel course1 = new JLabel("");
		JLabel time2 = new JLabel("10:15am-12:15pm");
		// time2.setFont(font.deriveFont(attributes));
		JLabel course2 = new JLabel("");
		JLabel time3 = new JLabel("12:45-2:45pm");
		// time3.setFont(font.deriveFont(attributes));
		JLabel course3 = new JLabel("");
		JLabel time4 = new JLabel("3:00-5:00pm");
		// time4.setFont(font.deriveFont(attributes));
		JLabel course4 = new JLabel("");
		JLabel time5 = new JLabel("5:30-7:30pm");
		// time5.setFont(font.deriveFont(attributes));
		JLabel course5 = new JLabel("");
		JLabel time6 = new JLabel("7:45-9:45pm");
		// time6.setFont(font.deriveFont(attributes));
		JLabel course6 = new JLabel("");
		time.add(time1);
		time.add(course1);
		time.add(time2);
		time.add(course2);
		time.add(time3);
		time.add(course3);
		time.add(time4);
		time.add(course4);
		time.add(time5);
		time.add(course5);
		time.add(time6);
		time.add(course6);

		return time;
	}

	/*
	 * Creates JPanel for Monday exams. This method also includes all logic for Monday exams and places
	 * them in the correct slot
	 */
	private JPanel monday(ArrayList<Course> coursesScheduled) {
		JPanel mon = new JPanel(new GridLayout(13, 0));

		// sets border
		Border blackline = BorderFactory.createLineBorder(Color.BLACK, 1);
		mon.setBorder(blackline);

		// sets heading
		JLabel heading = new JLabel("Monday");
		mon.add(heading);
		Font font = heading.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		heading.setFont(font.deriveFont(attributes));
		heading.setFont(heading.getFont().deriveFont(Font.BOLD, 14f));

		// 8-10
		JLabel time1 = new JLabel("");
		JLabel time11 = new JLabel("");
		// 10:15-12:15
		JLabel time2 = new JLabel("");
		JLabel time22 = new JLabel("");
		// 12:45-2:45
		JLabel time3 = new JLabel("");
		JLabel time33 = new JLabel("");
		// 3-5
		JLabel time4 = new JLabel("");
		JLabel time44 = new JLabel("");
		// 5:30-7:30
		JLabel time5 = new JLabel("");
		JLabel time55 = new JLabel("");
		// 7:45-9:45
		JLabel time6 = new JLabel("");
		JLabel time66 = new JLabel("");

		boolean conflict1 = false;
		boolean conflict2 = false;
		for (Course scheduled : coursesScheduled) {
			//if start time = 1pm and is on MW, MWF, or WF, exam time is 12:45pm
			if (scheduled.getStartTime() == 1300
					&& (scheduled.getDays().equals("MW")
							|| scheduled.getDays().equals("MWF") || scheduled
							.getDays().equals("WF")) && !conflict1) {
				//System.out.println("1300Success: " + scheduled.getCourseNum());
				time3.setText(scheduled.getSubject() + scheduled.getCourseNum()
						+ ": " + scheduled.getTitle());
				conflict1 = true;
			} else if (scheduled.getStartTime() == 1300
					&& (scheduled.getDays().equals("MW")
							|| scheduled.getDays().equals("MWF") || scheduled
							.getDays().equals("WF")) && conflict1) {
				//System.out.println("1300Conflict: " + scheduled.getCourseNum());
				time33.setText(scheduled.getSubject()
						+ scheduled.getCourseNum() + ": "
						+ scheduled.getTitle());
				time33.setBackground(Color.RED);
				time33.setOpaque(true);
				time3.setBackground(Color.RED);
				time3.setOpaque(true);
			}
			//if start time = 2:30pm and is on MW, MWF, or WF, exam time is 12:45pm
			if (scheduled.getStartTime() == 1430
					&& (scheduled.getDays().equals("MW")
							|| scheduled.getDays().equals("MWF") || scheduled
							.getDays().equals("WF")) && !conflict2) {
				//System.out.println("1430Success: " + scheduled.getCourseNum());
				time4.setText(scheduled.getSubject() + scheduled.getCourseNum()
						+ ": " + scheduled.getTitle());
				conflict2 = true;
			} else if (scheduled.getStartTime() == 1430
					&& (scheduled.getDays().equals("MW")
							|| scheduled.getDays().equals("MWF") || scheduled
							.getDays().equals("WF")) && conflict2) {
				//System.out.println("1430Conflict: " + scheduled.getCourseNum());
				time44.setText(scheduled.getSubject()
						+ scheduled.getCourseNum() + ": "
						+ scheduled.getTitle());
				time44.setBackground(Color.RED);
				time44.setOpaque(true);
				time4.setBackground(Color.RED);
				time4.setOpaque(true);

			}
			//if start time is 5:30pm or later and on Monday's only, exam is 7:45pm
			if (scheduled.getStartTime() >= 1730
					&& scheduled.getDays().equals("M")) {
				time6.setText(scheduled.getSubject() + scheduled.getCourseNum()
						+ ": " + scheduled.getTitle());
			}
		}

		mon.add(time1);
		mon.add(time11);
		mon.add(time2);
		mon.add(time22);
		mon.add(time3);
		mon.add(time33);
		mon.add(time4);
		mon.add(time44);
		mon.add(time5);
		mon.add(time55);
		mon.add(time6);
		mon.add(time66);

		return mon;
	}

	/*
	 * Creates JPanel for Tuesday exams. This method also includes all logic for Tuesday exams and places
	 * them in the correct slot
	 */
	private Component tuesday(ArrayList<Course> coursesScheduled) {
		JPanel tues = new JPanel(new GridLayout(13, 0));

		// set border
		Border blackline = BorderFactory.createLineBorder(Color.BLACK, 1);
		tues.setBorder(blackline);

		// set heading
		JLabel heading = new JLabel("Tuesday");
		Font font = heading.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		heading.setFont(font.deriveFont(attributes));
		heading.setFont(heading.getFont().deriveFont(Font.BOLD, 14f));
		tues.add(heading);

		// 8-10
		JLabel time1 = new JLabel("");
		JLabel time11 = new JLabel("");
		// 10:15-12:15
		JLabel time2 = new JLabel("");
		JLabel time22 = new JLabel("");
		// 12:45-2:45
		JLabel time3 = new JLabel("");
		JLabel time33 = new JLabel("");
		// 3-5
		JLabel time4 = new JLabel("");
		JLabel time44 = new JLabel("");
		// 5:30-7:30
		JLabel time5 = new JLabel("");
		JLabel time55 = new JLabel("");
		// 7:45-9:45
		JLabel time6 = new JLabel("");
		JLabel time66 = new JLabel("");

		boolean conflict1 = false;
		boolean conflict2 = false;
		boolean conflict3 = false;
		boolean conflict4 = false;

		for (Course scheduled : coursesScheduled) {
			//System.out.println(scheduled.getCourseNum());
			// If course starts at 10am and is on either T, R, or TR
			if (scheduled.getStartTime() == 1000
					&& (scheduled.getDays().equals("T")
							|| scheduled.getDays().equals("R") || scheduled
							.getDays().equals("TR")) && !conflict1) {
				//System.out.println("T1000Success: " + scheduled.getCourseNum());
				time2.setText(scheduled.getSubject() + scheduled.getCourseNum()
						+ ": " + scheduled.getTitle());
				conflict1 = true;
			} else if (scheduled.getStartTime() == 1000
					&& (scheduled.getDays().equals("T")
							|| scheduled.getDays().equals("R") || scheduled
							.getDays().equals("TR")) && conflict1) {
				//System.out.println("T1000Conflict: " + scheduled.getCourseNum());
				time22.setText(scheduled.getSubject()
						+ scheduled.getCourseNum() + ": "
						+ scheduled.getTitle());
				time22.setBackground(Color.RED);
				time22.setOpaque(true);
				time2.setBackground(Color.RED);
				time2.setOpaque(true);

			}
			// If course starts at 1pm and is on either T, R, or TR
			if (scheduled.getStartTime() == 1300
					&& (scheduled.getDays().equals("T")
							|| scheduled.getDays().equals("R") || scheduled
							.getDays().equals("TR")) && !conflict2) {
				//System.out.println("T1300Success: " + scheduled.getCourseNum());
				time3.setText(scheduled.getSubject() + scheduled.getCourseNum()
						+ ": " + scheduled.getTitle());
				conflict2 = true;
			} else if (scheduled.getStartTime() == 1300
					&& (scheduled.getDays().equals("T")
							|| scheduled.getDays().equals("R") || scheduled
							.getDays().equals("TR")) && conflict2) {
				//System.out.println("T1300Conflict: " + scheduled.getCourseNum());
				time33.setText(scheduled.getSubject()
						+ scheduled.getCourseNum() + ": "
						+ scheduled.getTitle());
				time33.setBackground(Color.RED);
				time33.setOpaque(true);
				time3.setBackground(Color.RED);
				time3.setOpaque(true);

			}
			// If course starts at 4pm and is on either T, R, or TR
			if (scheduled.getStartTime() == 1600
					&& (scheduled.getDays().equals("T")
							|| scheduled.getDays().equals("R") || scheduled
							.getDays().equals("TR")) && !conflict3) {
				//System.out.println("T1600Success: " + scheduled.getCourseNum());
				time4.setText(scheduled.getSubject() + scheduled.getCourseNum()
						+ ": " + scheduled.getTitle());
				conflict3 = true;
			} else if (scheduled.getStartTime() == 1600
					&& (scheduled.getDays().equals("T")
							|| scheduled.getDays().equals("R") || scheduled
							.getDays().equals("TR")) && conflict3) {
				//System.out.println("T1600Conflict: " + scheduled.getCourseNum());
				time44.setText(scheduled.getSubject()
						+ scheduled.getCourseNum() + ": "
						+ scheduled.getTitle());
				time44.setBackground(Color.RED);
				time44.setOpaque(true);
				time4.setBackground(Color.RED);
				time4.setOpaque(true);

			}
			// if a course starts at 5:30pm or later and is on TR
			if (scheduled.getStartTime() >= 1730
					&& scheduled.getDays().equals("TR")) {
				time5.setText(scheduled.getSubject() + scheduled.getCourseNum()
						+ ": " + scheduled.getTitle());
			}
			// if a course starts at 5:30pm or later and is on T
			if (scheduled.getStartTime() >= 1730
					&& scheduled.getDays().equals("T")) {
				time6.setText(scheduled.getSubject() + scheduled.getCourseNum()
						+ ": " + scheduled.getTitle());
			}
		}

		tues.add(time1);
		tues.add(time11);
		tues.add(time2);
		tues.add(time22);
		tues.add(time3);
		tues.add(time33);
		tues.add(time4);
		tues.add(time44);
		tues.add(time5);
		tues.add(time55);
		tues.add(time6);
		tues.add(time66);

		return tues;
	}

	/*
	 * Creates JPanel for Wednesday exams. This method also includes all logic for Monday exams and places
	 * them in the correct slot
	 */
	private Component wednesday(ArrayList<Course> coursesScheduled) {
		JPanel wed = new JPanel(new GridLayout(13, 0));

		// set border
		Border blackline = BorderFactory.createLineBorder(Color.BLACK, 1);
		wed.setBorder(blackline);

		// set heading
		JLabel heading = new JLabel("Wednesday");
		Font font = heading.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		heading.setFont(font.deriveFont(attributes));
		heading.setFont(heading.getFont().deriveFont(Font.BOLD, 14f));
		wed.add(heading);

		// 8-10
		JLabel time1 = new JLabel("");
		JLabel time11 = new JLabel("");
		// 10:15-12:15
		JLabel time2 = new JLabel("");
		JLabel time22 = new JLabel("");
		// 12:45-2:45
		JLabel time3 = new JLabel("");
		JLabel time33 = new JLabel("");
		// 3-5
		JLabel time4 = new JLabel("");
		JLabel time44 = new JLabel("");
		// 5:30-7:30
		JLabel time5 = new JLabel("");
		JLabel time55 = new JLabel("");
		// 7:45-9:45
		JLabel time6 = new JLabel("");
		JLabel time66 = new JLabel("");

		boolean conflict1 = false;
		boolean conflict2 = false;
		boolean conflict3 = false;
		boolean conflict4 = false;

		for (Course scheduled : coursesScheduled) {
			//System.out.println(scheduled.getCourseNum());
			// If course starts at 10am and is on either MW, WF, or MWF: exam is
			// at 10:15am
			if (scheduled.getStartTime() == 1000
					&& (scheduled.getDays().equals("MW")
							|| scheduled.getDays().equals("WF") || scheduled
							.getDays().equals("MWF")) && !conflict1) {
				//System.out.println("W1000Success: " + scheduled.getCourseNum());
				time2.setText(scheduled.getSubject() + scheduled.getCourseNum()
						+ ": " + scheduled.getTitle());
				conflict1 = true;
			} else if (scheduled.getStartTime() == 1000
					&& (scheduled.getDays().equals("MW")
							|| scheduled.getDays().equals("WF") || scheduled
							.getDays().equals("MWF")) && conflict1) {
				//System.out.println("W1000Conflict: " + scheduled.getCourseNum());
				time22.setText(scheduled.getSubject()
						+ scheduled.getCourseNum() + ": "
						+ scheduled.getTitle());
				time22.setBackground(Color.RED);
				time22.setOpaque(true);
				time2.setBackground(Color.RED);
				time2.setOpaque(true);

			}
			// If course starts at 11:30am and is on either MW, WF, MWF: exam is
			// at 12:45pm
			if (scheduled.getStartTime() == 1130
					&& (scheduled.getDays().equals("MW")
							|| scheduled.getDays().equals("WF") || scheduled
							.getDays().equals("MWF")) && !conflict2) {
				//System.out.println("W1300Success: " + scheduled.getCourseNum());
				time3.setText(scheduled.getSubject() + scheduled.getCourseNum()
						+ ": " + scheduled.getTitle());
				conflict2 = true;
			} else if (scheduled.getStartTime() == 1300
					&& (scheduled.getDays().equals("MW")
							|| scheduled.getDays().equals("WF") || scheduled
							.getDays().equals("MWF")) && conflict2) {
				//System.out.println("W1300Conflict: " + scheduled.getCourseNum());
				time33.setText(scheduled.getSubject()
						+ scheduled.getCourseNum() + ": "
						+ scheduled.getTitle());
				time33.setBackground(Color.RED);
				time33.setOpaque(true);
				time3.setBackground(Color.RED);
				time3.setOpaque(true);

			}
			// If course starts at 4pm and is on either MW, WF, MWF. Exam is 5:30
			if (scheduled.getStartTime() == 1600
					&& (scheduled.getDays().equals("MW")
							|| scheduled.getDays().equals("WF") || scheduled
							.getDays().equals("MWF")) && !conflict3) {
				//System.out.println("W1600Success: " + scheduled.getCourseNum());
				time4.setText(scheduled.getSubject() + scheduled.getCourseNum()
						+ ": " + scheduled.getTitle());
				conflict3 = true;
			} else if (scheduled.getStartTime() == 1600
					&& (scheduled.getDays().equals("MW")
							|| scheduled.getDays().equals("WF") || scheduled
							.getDays().equals("MWF")) && conflict3) {
				//System.out.println("T1600Conflict: " + scheduled.getCourseNum());
				time55.setText(scheduled.getSubject()
						+ scheduled.getCourseNum() + ": "
						+ scheduled.getTitle());
				time44.setBackground(Color.RED);
				time44.setOpaque(true);
				time4.setBackground(Color.RED);
				time4.setOpaque(true);

			}
			// if a course starts at 5:30pm or later and is on MW
			if (scheduled.getStartTime() >= 1730
					&& scheduled.getDays().equals("MW")) {
				time5.setText(scheduled.getSubject() + scheduled.getCourseNum()
						+ ": " + scheduled.getTitle());
			}
			// if a course starts at 5:30pm or later and is on W
			if (scheduled.getStartTime() >= 1730
					&& scheduled.getDays().equals("W")) {
				time6.setText(scheduled.getSubject() + scheduled.getCourseNum()
						+ ": " + scheduled.getTitle());
			}
		}

		wed.add(time1);
		wed.add(time11);
		wed.add(time2);
		wed.add(time22);
		wed.add(time3);
		wed.add(time33);
		wed.add(time4);
		wed.add(time44);
		wed.add(time5);
		wed.add(time55);
		wed.add(time6);
		wed.add(time66);

		return wed;
	}

	/*
	 * Creates JPanel for Thursday exams. This method also includes all logic for Thursday exams and places
	 * them in the correct slot
	 */
	private Component thursday(ArrayList<Course> coursesScheduled) {
		JPanel thur = new JPanel(new GridLayout(13, 0));

		// set border
		Border blackline = BorderFactory.createLineBorder(Color.BLACK, 1);
		thur.setBorder(blackline);

		// set heading
		JLabel heading = new JLabel("Thursday");
		Font font = heading.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		heading.setFont(font.deriveFont(attributes));
		heading.setFont(heading.getFont().deriveFont(Font.BOLD, 14f));
		thur.add(heading);

		// 8-10
		JLabel time1 = new JLabel("");
		JLabel time11 = new JLabel("");
		// 10:15-12:15
		JLabel time2 = new JLabel("");
		JLabel time22 = new JLabel("");
		// 12:45-2:45
		JLabel time3 = new JLabel("");
		JLabel time33 = new JLabel("");
		// 3-5
		JLabel time4 = new JLabel("");
		JLabel time44 = new JLabel("");
		// 5:30-7:30
		JLabel time5 = new JLabel("");
		JLabel time55 = new JLabel("");
		// 7:45-9:45
		JLabel time6 = new JLabel("");
		JLabel time66 = new JLabel("");

		boolean conflict1 = false;
		boolean conflict2 = false;
		boolean conflict3 = false;
		boolean conflict4 = false;

		for (Course scheduled : coursesScheduled) {
			//System.out.println(scheduled.getCourseNum());
			// If course starts at 8 or 8:30am and is on either T, R, or TR:
			// exam is at 8:00am
			if ((scheduled.getStartTime() == 800 || scheduled.getStartTime() == 830)
					&& (scheduled.getDays().equals("T")
							|| scheduled.getDays().equals("R") || scheduled
							.getDays().equals("TR")) && !conflict1) {
				//System.out.println("R800Success: " + scheduled.getCourseNum());
				time1.setText(scheduled.getSubject() + scheduled.getCourseNum()
						+ ": " + scheduled.getTitle());
				conflict1 = true;
			} else if ((scheduled.getStartTime() == 800 || scheduled
					.getStartTime() == 830)
					&& (scheduled.getDays().equals("T")
							|| scheduled.getDays().equals("R") || scheduled
							.getDays().equals("TR")) && conflict1) {
				//System.out.println("R800Conflict: " + scheduled.getCourseNum());
				time11.setText(scheduled.getSubject()
						+ scheduled.getCourseNum() + ": "
						+ scheduled.getTitle());
				time11.setBackground(Color.RED);
				time11.setOpaque(true);
				time1.setBackground(Color.RED);
				time1.setOpaque(true);

			}
			// If course starts at 11:30am and is on either T, R, TR: exam is at
			// 12:45pm
			if (scheduled.getStartTime() == 1130
					&& (scheduled.getDays().equals("T")
							|| scheduled.getDays().equals("R") || scheduled
							.getDays().equals("TR")) && !conflict2) {
				//System.out.println("R1300Success: " + scheduled.getCourseNum());
				time3.setText(scheduled.getSubject() + scheduled.getCourseNum()
						+ ": " + scheduled.getTitle());
				conflict2 = true;
			} else if (scheduled.getStartTime() == 1300
					&& (scheduled.getDays().equals("T")
							|| scheduled.getDays().equals("R") || scheduled
							.getDays().equals("TR")) && conflict2) {
				//System.out.println("R1300Conflict: " + scheduled.getCourseNum());
				time33.setText(scheduled.getSubject()
						+ scheduled.getCourseNum() + ": "
						+ scheduled.getTitle());
				time33.setBackground(Color.RED);
				time33.setOpaque(true);
				time3.setBackground(Color.RED);
				time3.setOpaque(true);

			}
			// If course starts at 2:30pm and is on either T, R, or TR: exam is
			// at 3pm
			if (scheduled.getStartTime() == 1430
					&& (scheduled.getDays().equals("T")
							|| scheduled.getDays().equals("R") || scheduled
							.getDays().equals("TR")) && !conflict3) {
				//System.out.println("T1600Success: " + scheduled.getCourseNum());
				time4.setText(scheduled.getSubject() + scheduled.getCourseNum()
						+ ": " + scheduled.getTitle());
				conflict3 = true;
			} else if (scheduled.getStartTime() == 1430
					&& (scheduled.getDays().equals("T")
							|| scheduled.getDays().equals("R") || scheduled
							.getDays().equals("TR")) && conflict3) {
				//System.out.println("T1600Conflict: " + scheduled.getCourseNum());
				time44.setText(scheduled.getSubject()
						+ scheduled.getCourseNum() + ": "
						+ scheduled.getTitle());
				time44.setBackground(Color.RED);
				time44.setOpaque(true);
				time4.setBackground(Color.RED);
				time4.setOpaque(true);

			}
			// if a course starts at 5:30pm or later and is on R
			if (scheduled.getStartTime() >= 1730
					&& scheduled.getDays().equals("R")) {
				time6.setText(scheduled.getSubject() + scheduled.getCourseNum()
						+ ": " + scheduled.getTitle());
			}
		}

		thur.add(time1);
		thur.add(time11);
		thur.add(time2);
		thur.add(time22);
		thur.add(time3);
		thur.add(time33);
		thur.add(time4);
		thur.add(time44);
		thur.add(time5);
		thur.add(time55);
		thur.add(time6);
		thur.add(time66);

		return thur;
	}

	/*
	 * Creates JPanel for Friday exams. This method also includes all logic for Friday exams and places
	 * them in the correct slot
	 */
	private Component friday(ArrayList<Course> coursesScheduled) {
		JPanel fri = new JPanel(new GridLayout(13, 0));

		// set border
		Border blackline = BorderFactory.createLineBorder(Color.BLACK, 1);
		fri.setBorder(blackline);

		// set heading
		JLabel heading = new JLabel("Friday");
		Font font = heading.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		heading.setFont(font.deriveFont(attributes));
		heading.setFont(heading.getFont().deriveFont(Font.BOLD, 14f));
		fri.add(heading);

		// 8-10
		JLabel time1 = new JLabel("");
		JLabel time11 = new JLabel("");
		// 10:15-12:15
		JLabel time2 = new JLabel("");
		JLabel time22 = new JLabel("");
		// 12:45-2:45
		JLabel time3 = new JLabel("");
		JLabel time33 = new JLabel("");
		// 3-5
		JLabel time4 = new JLabel("");
		JLabel time44 = new JLabel("");
		// 5:30-7:30
		JLabel time5 = new JLabel("");
		JLabel time55 = new JLabel("");
		// 7:45-9:45
		JLabel time6 = new JLabel("");
		JLabel time66 = new JLabel("");

		boolean conflict1 = false;
		boolean conflict2 = false;
		boolean conflict3 = false;
		boolean conflict4 = false;

		for (Course scheduled : coursesScheduled) {
			//System.out.println(scheduled.getCourseNum());
			// If course starts at 8 or 8:30am and is on either MW, WF, or MWF:
			// exam is at 8:00am
			if ((scheduled.getStartTime() == 800 || scheduled.getStartTime() == 830)
					&& (scheduled.getDays().equals("MW")
							|| scheduled.getDays().equals("WF") || scheduled
							.getDays().equals("MWF")) && !conflict1) {
				//System.out.println("F800Success: " + scheduled.getCourseNum());
				time1.setText(scheduled.getSubject() + scheduled.getCourseNum()
						+ ": " + scheduled.getTitle());
				conflict1 = true;
			} else if ((scheduled.getStartTime() == 800 || scheduled
					.getStartTime() == 830)
					&& (scheduled.getDays().equals("MW")
							|| scheduled.getDays().equals("WF") || scheduled
							.getDays().equals("MWF")) && conflict1) {
				//System.out.println("F800Conflict: " + scheduled.getCourseNum());
				time11.setText(scheduled.getSubject()
						+ scheduled.getCourseNum() + ": "
						+ scheduled.getTitle());
				time11.setBackground(Color.RED);
				time11.setOpaque(true);
				time1.setBackground(Color.RED);
				time1.setOpaque(true);

			}

			// if it is CSE 174
			if (scheduled.getCourseNum().equals("174")) {
				time3.setText(scheduled.getSubject() + scheduled.getCourseNum()
						+ ": " + scheduled.getTitle());
			}
		}

		fri.add(time1);
		fri.add(time11);
		fri.add(time2);
		fri.add(time22);
		fri.add(time3);
		fri.add(time33);
		fri.add(time4);
		fri.add(time44);
		fri.add(time5);
		fri.add(time55);
		fri.add(time6);
		fri.add(time66);

		return fri;
	}

	//ActionListener called when back button is pressed. Creates object of displayWeeklySchedule with necessary information
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonback) {
			this.dispose();
			displayWeeklySchedule dws1 = new displayWeeklySchedule(dws.cc);
			
		}
		
	}

}

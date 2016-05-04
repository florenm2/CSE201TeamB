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
import java.util.Iterator;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class displayWeeklySchedule extends JFrame implements ActionListener {

	private int numDays = 5;
	JButton buttonback, buttonsave;
	public ArrayList<Course> coursesScheduled1;
	chooseCourses cc;

	public displayWeeklySchedule(chooseCourses cc) {
		this.cc=cc;
		frameSetup(cc.coursesScheduled);
		coursesScheduled1 = cc.coursesScheduled;
		setVisible(true);
	}

	private void frameSetup(ArrayList<Course> coursesScheduled) {
		setLayout(new BorderLayout());
		setBounds(0, 0, 900, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setLocationRelativeTo(null);
		finalExamSetup(coursesScheduled);
		buttonPanelSetup();
		heading();
		
		//
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height-100);
		//
		setVisible(true);

	}

	private void finalExamSetup(ArrayList<Course> coursesScheduled) {

		JPanel days = new JPanel(new GridLayout(0, numDays));

		days.add(monday(coursesScheduled));
		days.add(tuesday(coursesScheduled));
		days.add(wednesday(coursesScheduled));
		days.add(thursday(coursesScheduled));
		days.add(friday(coursesScheduled));

		add(days, BorderLayout.CENTER);
	}

	private void buttonPanelSetup() {
		JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
		buttonback = new JButton("<<Select Courses");
		buttonsave = new JButton("View Final Exam Schedule>>");

		buttonback.addActionListener(this);
		buttonPanel.add(buttonback);
		
		buttonsave.addActionListener(this);
		buttonPanel.add(buttonsave);
		

		add(buttonPanel, BorderLayout.SOUTH);
	}

	private void heading() {
		JPanel heading = new JPanel();
		JLabel header = new JLabel("Weekly Course Schedule");
		header.setFont(header.getFont().deriveFont(Font.BOLD, 18f));
		heading.add(header);

		add(heading, BorderLayout.NORTH);
	}

	private JPanel monday(ArrayList<Course> coursesScheduled) {
		JPanel mon = new JPanel(new GridLayout(13, 0));
		ArrayList<Course>mondayCourses = new ArrayList<Course>();
		
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

		for(Course scheduled: coursesScheduled){
			if(scheduled.getDays().contains("M")){
				mondayCourses.add(scheduled);
				if(scheduled.getStartTime() <= 830){
					time1.setText(scheduled.displayCourse());
				}
				else if(scheduled.getStartTime() <= 1000){
					time2.setText(scheduled.displayCourse());
				}
				else if(scheduled.getStartTime() <= 1130){
					time3.setText(scheduled.displayCourse());
				}
				else if(scheduled.getStartTime() <= 1300){
					time4.setText(scheduled.displayCourse());
				}
				else if(scheduled.getStartTime() <= 1430){
					time5.setText(scheduled.displayCourse());
				}
				else if(scheduled.getStartTime() <= 1600){
					time6.setText(scheduled.displayCourse());
				}
				else if(scheduled.getStartTime() > 1600){
					time66.setText(scheduled.displayCourse());
				}
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

		for(Course scheduled: coursesScheduled){
			if(scheduled.getDays().contains("T")){
				if(scheduled.getStartTime() <= 830){
					time1.setText(scheduled.displayCourse());
				}
				else if(scheduled.getStartTime() <= 1000){
					time2.setText(scheduled.displayCourse());
				}
				else if(scheduled.getStartTime() <= 1130){
					time3.setText(scheduled.displayCourse());
				}
				else if(scheduled.getStartTime() <= 1300){
					time4.setText(scheduled.displayCourse());
				}
				else if(scheduled.getStartTime() <= 1430){
					time5.setText(scheduled.displayCourse());
				}
				else if(scheduled.getStartTime() <= 1600){
					time6.setText(scheduled.displayCourse());
				}
				else if(scheduled.getStartTime() > 1600){
					time66.setText(scheduled.displayCourse());
				}
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

		for(Course scheduled: coursesScheduled){
			if(scheduled.getDays().contains("W")){
				if(scheduled.getStartTime() <= 830){
					time1.setText(scheduled.displayCourse());
				}
				else if(scheduled.getStartTime() <= 1000){
					time2.setText(scheduled.displayCourse());
				}
				else if(scheduled.getStartTime() <= 1130){
					time3.setText(scheduled.displayCourse());
				}
				else if(scheduled.getStartTime() <= 1300){
					time4.setText(scheduled.displayCourse());
				}
				else if(scheduled.getStartTime() <= 1430){
					time5.setText(scheduled.displayCourse());
				}
				else if(scheduled.getStartTime() <= 1600){
					time6.setText(scheduled.displayCourse());
				}
				else if(scheduled.getStartTime() > 1600){
					time66.setText(scheduled.displayCourse());
				}
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

		for(Course scheduled: coursesScheduled){
			if(scheduled.getDays().contains("R")){
				if(scheduled.getStartTime() <= 830){
					time1.setText(scheduled.displayCourse());
				}
				else if(scheduled.getStartTime() <= 1000){
					time2.setText(scheduled.displayCourse());
				}
				else if(scheduled.getStartTime() <= 1130){
					time3.setText(scheduled.displayCourse());
				}
				else if(scheduled.getStartTime() <= 1300){
					time4.setText(scheduled.displayCourse());
				}
				else if(scheduled.getStartTime() <= 1430){
					time5.setText(scheduled.displayCourse());
				}
				else if(scheduled.getStartTime() <= 1600){
					time6.setText(scheduled.displayCourse());
				}
				else if(scheduled.getStartTime() > 1600){
					time66.setText(scheduled.displayCourse());
				}
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

		for(Course scheduled: coursesScheduled){
			if(scheduled.getDays().contains("F")){
				if(scheduled.getStartTime() <= 830){
					time1.setText(scheduled.displayCourse());
				}
				else if(scheduled.getStartTime() <= 1000){
					time2.setText(scheduled.displayCourse());
				}
				else if(scheduled.getStartTime() <= 1130){
					time3.setText(scheduled.displayCourse());
				}
				else if(scheduled.getStartTime() <= 1300){
					time4.setText(scheduled.displayCourse());
				}
				else if(scheduled.getStartTime() <= 1430){
					time5.setText(scheduled.displayCourse());
				}
				else if(scheduled.getStartTime() <= 1600){
					time6.setText(scheduled.displayCourse());
				}
				else if(scheduled.getStartTime() > 1600){
					time66.setText(scheduled.displayCourse());
				}
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

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonsave) {
				try {
					this.dispose();
					displayFinalExams dFinal = new displayFinalExams(this);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			
		}
		
		else if (e.getSource() == buttonback) {
			this.dispose();
			cc.displayChooseClasses();
		}
		
	}
	
	public static void main(String[] args) {
		
		
		
		/*
		Course c381 = new Course();
		c381.setTitle("Operating Systems");
		c381.setCourseNum("381");
		c381.setSubject("CSE");
		c381.setDays("MW");
		c381.setStartTime(1300);
		c381.setEndTime(1400);
		c381.setSection("B");

		Course c464 = new Course();
		c464.setTitle("Algorithms");
		c464.setCourseNum("464");
		c464.setSubject("CSE");
		c464.setDays("TR");
		c464.setStartTime(1300);
		c464.setEndTime(1350);
		c464.setSection("A");

		Course c271 = new Course();
		c271.setTitle("Object Oriented");
		c271.setCourseNum("271");
		c271.setSubject("CSE");
		c271.setDays("WF");
		c271.setStartTime(1430);
		c271.setEndTime(1500);
		c271.setSection("B");

		Course c174 = new Course();
		c174.setTitle("Into");
		c174.setCourseNum("174");
		c174.setSubject("CSE");
		c174.setDays("MWF");
		c174.setStartTime(830);
		c174.setEndTime(950);
		c174.setSection("A");

		ArrayList<Course> coursesScheduled = new ArrayList<Course>();
		coursesScheduled.add(c381);
		coursesScheduled.add(c464);
		coursesScheduled.add(c271);
		coursesScheduled.add(c174);
		
		new displayWeeklySchedule(coursesScheduled);
		*/
	}

	

}

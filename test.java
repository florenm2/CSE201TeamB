import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class test implements ActionListener {

	JList courseList, courses;
	JButton buttonin, buttonout, buttonnext, buttonback;
	JLabel dispMessage;
	ArrayList<Course> coursesScheduled = new ArrayList<Course>();
	ArrayList<Course> allCourses = new ArrayList<Course>();
	ArrayList<Course> prereqsTaken = new ArrayList<Course>();
	JFrame frame;
	choosePrereqs cp;

	// using DefaultListModel to keep track of the two lists
	DefaultListModel coursesDisplayed, coursesChosen;

	public test(choosePrereqs cp) {
		this.cp = cp;
		this.prereqsTaken = cp.prereqsTaken;
		
		frame = new JFrame("Choose your classes:");
		try {
			frame.setContentPane(this.createContentPane());
		} catch (IOException e) {
			e.printStackTrace();
		}

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// all panes are same size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width, screenSize.height - 100);

		frame.setVisible(true);

	}
	public void displayChooseClasses(){
		frame = new JFrame("Choose your classes:");
		try {
			frame.setContentPane(this.createContentPane());
		} catch (IOException e) {
			e.printStackTrace();
		}

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// all panes are same size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width, screenSize.height - 100);

		frame.setVisible(true);
	}

	public JPanel createContentPane() throws IOException {

		// the complete panel
		JPanel overallGUI = new JPanel();

		// Instantiate the List Models.
		coursesDisplayed = new DefaultListModel();
		coursesChosen = new DefaultListModel();

		// Things to be in the list.
		allCourses = ImportCSV.csvFileIN();
		// coursesScheduled = allCourses;

		// add every Course into the coursesDisplayed list
		for (Course c : allCourses) {
			coursesDisplayed.addElement(c.displayCourse());
		}

		// create list
		courseList = new JList(coursesDisplayed);
		courseList.setVisibleRowCount(30);
		courseList
				.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		// add to a JScrollPane
		JScrollPane list1 = new JScrollPane(courseList);

		courses = new JList(coursesChosen);
		courses.setVisibleRowCount(25);
		courses.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		// second list to JScrollPane
		JScrollPane list2 = new JScrollPane(courses);

		JPanel buttonPanel1 = new JPanel();
		JPanel buttonPanel2 = new JPanel();
		JPanel textPanel1 = new JPanel();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int verticalSpacing = screenSize.height/3;
		JPanel buttons = new JPanel(new GridLayout(3, 2, 0, verticalSpacing));

		buttonin = new JButton("Add >>");
		buttonin.addActionListener(this);
		buttonPanel1.add(buttonin);

		buttonout = new JButton("<< Remove");
		buttonout.addActionListener(this);
		buttonPanel1.add(buttonout);
		
		dispMessage = new JLabel("Error");
		dispMessage.setForeground(Color.red);
		dispMessage.setVisible(false);
		textPanel1.add(dispMessage);

		buttonback = new JButton("Back");
		buttonback.addActionListener(this);
		buttonPanel2.add(buttonback);
		
		buttonnext = new JButton("Next");
		buttonnext.addActionListener(this);
		buttonPanel2.add(buttonnext);

		buttons.add(buttonPanel1);
		buttons.add(textPanel1);
		buttons.add(buttonPanel2);

		// put everything together
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));

		bottomPanel.add(Box.createRigidArea(new Dimension(15, 0)));
		bottomPanel.add(list1);
		bottomPanel.add(Box.createRigidArea(new Dimension(3, 0)));
		bottomPanel.add(buttons);
		bottomPanel.add(Box.createRigidArea(new Dimension(15, 0)));
		bottomPanel.add(list2);
		bottomPanel.add(Box.createRigidArea(new Dimension(15, 0)));

		overallGUI.add(bottomPanel);
		overallGUI.setOpaque(true);
		return overallGUI;
	}

	private JPanel createSquareJPanel(Color color, int size) {
		JPanel tempPanel = new JPanel();
		tempPanel.setBackground(color);
		tempPanel.setMinimumSize(new Dimension(size, size));
		// tempPanel.setMaximumSize(new Dimension(size, size));
		tempPanel.setPreferredSize(new Dimension(size, size));
		return tempPanel;
	}

	// valueChanged is the method that deals with a ListSelectionEvent.
	// This simply changes the boxes that are selected to true.

	public void actionPerformed(ActionEvent e) {
		int i = 0;
		dispMessage.setVisible(false);
		// When the 'in' button is pressed,
		// we take the indices and values of the selected coursesChosen
		// and output them to an array.

		if (e.getSource() == buttonin) {
			
			int counter = 0;
			
			int[] fromindex = courseList.getSelectedIndices();

			Object[] from = courseList.getSelectedValues();

			for (int j = 0; j < from.length; j++) {
				for (Course c : allCourses) {
					if (c.displayCourse().equals(from[j].toString())) {//c.displayCourse().substring(1, 5).equals(from[j].toString().substring(1, 5))
						counter++;
						
						try {
							if ((!Controller.isSameCourse(c, coursesScheduled)
									&& !Controller.checkCourseTime(c, coursesScheduled)
									&& Controller.checkPrereqs(c,prereqsTaken)
							 )) {
								coursesScheduled.add(c);
								
								//
								for (i = 0; i < from.length; i++) {
									coursesChosen.addElement(from[i]);
									
								}

								// remove the courses chosen from the first list.
								// remove from the bottom
								for (i = (fromindex.length - 1); i >= 0; i--) {
									coursesDisplayed.remove(fromindex[i]);
								}
								//
								
								
								try {
									if (cp.cm.isCS) {
										Controller.checkCSRequirements(c);
										//
										dispMessage.setText(Controller.getReqMessage());
										dispMessage.setForeground(Color.black);
										dispMessage.setVisible(true);
										//
									} else {
										Controller.checkSERequirements(c);
										//
										dispMessage.setText(Controller.getReqMessage());
										dispMessage.setForeground(Color.black);
										dispMessage.setVisible(true);
										//
									}
								} catch (IOException e1) {
									e1.printStackTrace();
								}

								
							}else if(!Controller.checkPrereqs(c,prereqsTaken)){
								dispMessage.setText(Controller.getErrorMessage());
								dispMessage.setForeground(Color.red);
								dispMessage.setVisible(true);
							}else if(Controller.isSameCourse(c, coursesScheduled)){
								dispMessage.setText(Controller.getErrorMessage());
								dispMessage.setForeground(Color.red);
								dispMessage.setVisible(true);
							}else if(Controller.checkCourseTime(c, coursesScheduled)){
								dispMessage.setText(Controller.getErrorMessage());
								dispMessage.setForeground(Color.red);
								dispMessage.setVisible(true);
							}
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
					
				}
				
			}

			
		}

		// If out button is pressed, take the indices and values of
		// the selected courses and output them to an array
		else if (e.getSource() == buttonout) {
			Object[] to = courses.getSelectedValues();
			int[] toindex = courses.getSelectedIndices();

			for (int j = 0; j < to.length; j++) {
				for (Iterator<Course> iterator = coursesScheduled.iterator(); iterator
						.hasNext();) {
					Course c = iterator.next();
					if (c.displayCourse().substring(1, 5).equals(to[j].toString().substring(1,5))) {
						iterator.remove();
						
						

					}
				}
				for (i = 0; i < to.length; i++) {
					coursesDisplayed.addElement(to[i]);
				}

				for (i = (toindex.length - 1); i >= 0; i--) {
					coursesChosen.remove(toindex[i]);
				}
			}

			
		} else if (e.getSource() == buttonnext) {
			displayWeeklySchedule dWeekly = new displayWeeklySchedule(this);
			frame.dispose();

		} else if (e.getSource() == buttonback) {
			//choosePrereqs cp = new choosePrereqs(isCSMajor);
			cp.displayChoosePrereqs();
			frame.dispose();
			
		}
	}

	public static void main(String[] args) {
		//test t = new test();
	}
}
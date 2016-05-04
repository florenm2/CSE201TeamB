import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/*
 * Displays a window that allows user to choose from a list of 
 * prerequisites and populate a list of prerequisites he/she
 * has completed. Chosen prerequisites are stores in an
 * ArrayList for future use.
 */
public class choosePrereqs implements ActionListener {

	JList itemList, courses;
	JButton buttonin, buttonout, nextButton, prevButton;
	ArrayList<Course> coursesScheduled = new ArrayList<Course>();
	ArrayList<Course> allPrereqs = new ArrayList<Course>();
	ArrayList<Course> prereqsTaken = new ArrayList<Course>();
	JFrame frame;
	chooseMajor cm;

	/*
	 * Constructor of the class Parameter: chooseMajor object
	 */
	public choosePrereqs(chooseMajor cm) {
		frame = new JFrame("Choose prerequisites");
		this.cm = cm;

		try {
			frame.setContentPane(this.createContentPane());
		} catch (IOException e) {
			e.printStackTrace();
		}

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width, screenSize.height - 100);

		frame.setVisible(true);

	}

	public void displayChoosePrereqs() {
		frame = new JFrame("Choose prerequisites");

		try {
			frame.setContentPane(this.createContentPane());
		} catch (IOException e) {
			e.printStackTrace();
		}

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width, screenSize.height - 100);

		frame.setVisible(true);

		// re-populating the list box
		for (int i = 0; i < prereqList.getSize(); i++) {
			for (Course c : prereqsTaken) {
				try {
					if (c.displayCoursePrereq().equals(
							prereqList.getElementAt(i).toString())) {
						prereqsChosen.addElement(prereqList.getElementAt(i));
						prereqList.removeElementAt(i);
					}
				} catch (Exception e) {
				}
			}
		}

	}

	/*
	 *  Using DefaultListModel to keep track of the two lists
	 *  prereqList is populated with all possible prerequisites
	 *  prereqList is shown in the box on the left
	 *  prereqsChosen is populated with the prereqs chosen by the user
	 *  prereqsChosen is shown in the box on the right
	 *  
	 *  When a class is added to prereqsChosen it is removed from prereqsList
	 */
	DefaultListModel prereqList, prereqsChosen;

	public JPanel createContentPane() throws IOException {

		// Create the final Panel
		JPanel totalGUI = new JPanel();

		// Instantiate the List Models
		prereqList = new DefaultListModel();
		prereqsChosen = new DefaultListModel();

		// populating the list of all prerequisites
		allPrereqs = Controller.displayPrereqOptions();

		// add every item in the String array into the ListModel
		for (Course c : allPrereqs) {
			prereqList.addElement(c.displayCoursePrereq());
		}

		// Creating the list
		itemList = new JList(prereqList);
		itemList.setVisibleRowCount(25);
		itemList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		// Add them to a JScrollPane so when we remove prereqsChosen from the JList
		// it will not get smaller in size
		JScrollPane list1 = new JScrollPane(itemList);

		courses = new JList(prereqsChosen);
		courses.setVisibleRowCount(25);
		courses.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		JScrollPane list2 = new JScrollPane(courses);

		// Creation of buttons
		JPanel buttonPanel = new JPanel();
		JPanel navButtons = new JPanel();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		//vertical spacing between the top two buttons and the bottom two buttons
		int verticalSpacing = screenSize.height - 500;
		JPanel buttons = new JPanel(new GridLayout(2, 2, 0, verticalSpacing));

		buttonin = new JButton("Add >>");
		buttonin.addActionListener(this);
		buttonPanel.add(buttonin);

		buttonout = new JButton("<< Remove");
		buttonout.addActionListener(this);
		buttonPanel.add(buttonout);

		prevButton = new JButton("Prev");
		prevButton.addActionListener(this);
		navButtons.add(prevButton);

		nextButton = new JButton("Next");
		nextButton.addActionListener(this);
		navButtons.add(nextButton);

		buttons.add(buttonPanel);
		buttons.add(navButtons);

		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));

		bottomPanel.add(Box.createRigidArea(new Dimension(15, 0)));
		bottomPanel.add(list1);
		bottomPanel.add(Box.createRigidArea(new Dimension(3, 0)));
		bottomPanel.add(buttons);
		bottomPanel.add(Box.createRigidArea(new Dimension(15, 0)));
		bottomPanel.add(list2);
		bottomPanel.add(Box.createRigidArea(new Dimension(15, 0)));

		totalGUI.add(bottomPanel);
		totalGUI.setOpaque(true);
		return totalGUI;
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
	// This changes the boxes that are selected to true.
	public void actionPerformed(ActionEvent e) {
		int i = 0;

		/*
		 * If buttonin is pressed, output the selected prereqsChosen to an array
		 */
		if (e.getSource() == buttonin) {
			int[] fromindex = itemList.getSelectedIndices();

			Object[] from = itemList.getSelectedValues();
			for (int j = 0; j < from.length; j++) {
				for (Course c : allPrereqs) {
					if (c.displayCoursePrereq().equals(from[j].toString())) {
						prereqsTaken.add(c);

						for (i = 0; i < from.length; i++) {
							prereqsChosen.addElement(from[i]);
						}

						// Remove the prereqsChosen from the first list.
						// Remove from the bottom so we don't remove the wrong objects
						for (i = (fromindex.length - 1); i >= 0; i--) {
							prereqList.remove(fromindex[i]);
						}
					}

				}
			}
		}

		// add each element in the array to the second list

		// If buttonout is pressed, output the selected prereqsChosen to an array
		else if (e.getSource() == buttonout) {
			Object[] to = courses.getSelectedValues();
			int[] toindex = courses.getSelectedIndices();

			for (int j = 0; j < to.length; j++) {
				for (Iterator<Course> iterator = prereqsTaken.iterator(); iterator
						.hasNext();) {
					Course c = iterator.next();
					if (c.displayCoursePrereq().equals(to[j].toString())) {
						iterator.remove();

					}
				}
			}

			// add each element in the array to the first list
			for (i = 0; i < to.length; i++) {
				prereqList.addElement(to[i]);
			}

			// Remove the prereqsChosen from the second list
			// Remove from the bottom so we don't remove the wrong objects
			for (i = (toindex.length - 1); i >= 0; i--) {
				prereqsChosen.remove(toindex[i]);
			}
		}
		// clicks next button
		else if (e.getSource() == nextButton) {
			chooseCourses cc = new chooseCourses(this);
			frame.dispose();

		// clicks prev button
		} else if (e.getSource() == prevButton) {
			cm.displayChooseMajor();
			frame.dispose();
		}
	}

	public static void main(String[] args) {

	}
}
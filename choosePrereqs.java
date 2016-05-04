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
		
		//re-populating the list box
		//
		
		for(int i =0; i<prereqList.getSize(); i++){
			System.out.println(prereqList.getElementAt(i));
			for(Course c: prereqsTaken){
				if(c.displayCoursePrereq().equals(prereqList.getElementAt(i).toString())){
					items.addElement(prereqList.getElementAt(i));
					prereqList.removeElementAt(i);
				}
			}
		}
		
	}

	// The ListModels we will be using in the example.
	DefaultListModel prereqList, items;

	public JPanel createContentPane() throws IOException {

		// Create the final Panel.
		JPanel totalGUI = new JPanel();

		// Instantiate the List Models.
		prereqList = new DefaultListModel();
		items = new DefaultListModel();

		// Things to be in the list.

		allPrereqs = Controller.displayPrereqOptions();

		// Using a for loop, we add every item in the String array
		// into the ListModel.

		for (Course c : allPrereqs) {
			prereqList.addElement(c.displayCoursePrereq());
		}

		// Creation of the list.
		// We set the cells in the list to be 20px x 140px.

		itemList = new JList(prereqList);
		itemList.setVisibleRowCount(25);
		// itemList.setFixedCellHeight(20);
		// itemList.setFixedCellWidth(140);
		itemList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		// We then add them to a JScrollPane.
		// This means when we remove items from the JList
		// it will not shrink in size.
		JScrollPane list1 = new JScrollPane(itemList);

		courses = new JList(items);
		courses.setVisibleRowCount(25);
		// courses.setFixedCellHeight(20);
		// courses.setFixedCellWidth(140);
		courses.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		// We add this list to a JScrollPane too.
		// This is so the list is displayed even though there are
		// currently no items in the list.
		// Without the scrollpane, the list would not show.
		JScrollPane list2 = new JScrollPane(courses);

		// We create the buttons to be placed between the lists.
		JPanel buttonPanel = new JPanel();
		JPanel navButtons = new JPanel();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
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

		// This final bit of code uses a BoxLayout to space out the widgets
		// in the GUI.

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

	// In this method, we create a square JPanel of a colour and set size
	// specified by the arguments.

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

		// When the 'in' button is pressed,
		// we take the indices and values of the selected items
		// and output them to an array.

		if (e.getSource() == buttonin) {
			// System.out.println("test");
			int[] fromindex = itemList.getSelectedIndices();

			Object[] from = itemList.getSelectedValues();
			// System.out.println(from[0].toString());
			for (int j = 0; j < from.length; j++) {
				for (Course c : allPrereqs) {
					if (c.displayCoursePrereq().equals(from[j].toString())) {
						System.out.println("true");
						prereqsTaken.add(c);

						for (i = 0; i < from.length; i++) {
							items.addElement(from[i]);
						}

						// Finally, we remove the items from the first list.
						// We must remove from the bottom, otherwise we try to
						// remove the wrong objects.
						for (i = (fromindex.length - 1); i >= 0; i--) {
							prereqList.remove(fromindex[i]);
						}
					}

				}
			}
		}

		// Then, for each item in the array, we add them to
		// the other list.

		// If the out button is pressed, we take the indices and values of
		// the selected items and output them to an array.
		else if (e.getSource() == buttonout) {
			Object[] to = courses.getSelectedValues();
			int[] toindex = courses.getSelectedIndices();

			for (int j = 0; j < to.length; j++) {
				for (Iterator<Course> iterator = prereqsTaken.iterator(); iterator
						.hasNext();) {
					Course c = iterator.next();
					if (c.displayCoursePrereq().equals(to[j].toString())) {
						System.out.println("remove");
						iterator.remove();

					}
				}
			}
			for (Course c : prereqsTaken) {
				System.out.println(c.displayCourse());
			}

			// Then, for each item in the array, we add them to
			// the other list.
			for (i = 0; i < to.length; i++) {
				prereqList.addElement(to[i]);
			}

			// Finally, we remove the items from the first list.
			// We must remove from the bottom, otherwise we try to
			// remove the wrong objects.
			for (i = (toindex.length - 1); i >= 0; i--) {
				items.remove(toindex[i]);
			}
		}
		// Clicks next button
		else if (e.getSource() == nextButton) {
			test cc = new test(this);
			frame.dispose();

		} else if (e.getSource() == prevButton) {// clicks prev button
			cm.displayChooseMajor();
			frame.dispose();
		}
	}

	public static void main(String[] args) {

	}
}
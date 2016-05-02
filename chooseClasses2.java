import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

public class chooseClasses2 implements ActionListener {

	JList CourseList, selectedList;
	JButton buttonin, buttonout, buttonnext, buttonback;

	// The ListModels we will be using in the example.
	DefaultListModel courseList, courseOptions;

	public chooseClasses2() {

		JFrame frame = new JFrame("Please choose your classes:");
		try {
			frame.setContentPane(this.createContentPane());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width, screenSize.height - 100);
		frame.setVisible(true);

	}

	public JPanel createContentPane() throws IOException {

		// Create the final Panel.
		JPanel totalGUI = new JPanel();

		totalGUI.setBorder(BorderFactory.createEtchedBorder());
		totalGUI.setLayout(new GridBagLayout());

		// Instantiate the List Models.
		courseList = new DefaultListModel();
		courseOptions = new DefaultListModel();

		ArrayList<Course> allCourses = ImportCSV.csvFileIN();

		for (Course c : allCourses) {
			courseList.addElement(c.displayCourse());
		}

		// Creation of the list.
		// We set the cells in the list to be 20px x 140px.

		CourseList = new JList(courseList);
		CourseList.setVisibleRowCount(45);
		// CourseList.setFixedCellHeight(20);
		// CourseList.setFixedCellWidth(140);
		CourseList
				.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		// We then add them to a JScrollPane.
		// This means when we remove courseOptions from the JList
		// it will not shrink in size.
		JScrollPane list1 = new JScrollPane(CourseList);

		selectedList = new JList(courseOptions);
		// selectedList.setVisibleRowCount(10);
		// selectedList.setFixedCellHeight(20);
		// selectedList.setFixedCellWidth(140);
		selectedList
				.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		// We add this list to a JScrollPane too.
		// This is so the list is displayed even though there are
		// currently no courseOptions in the list.
		// Without the scrollpane, the list would not show.
		JScrollPane list2 = new JScrollPane(selectedList);

		Insets EMPTY_INSETS = new Insets(0, 0, 0, 0);
		JLabel sourceLabel = new JLabel("Available Classes");

		totalGUI.add(sourceLabel, new GridBagConstraints(0, 0, 1, 1, 0, 0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE,
				EMPTY_INSETS, 0, 0));
		totalGUI.add(list2, new GridBagConstraints(0, 1, 1, 5, .5, 1,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				EMPTY_INSETS, 0, 0));

		buttonin = new JButton("Add >>");
		totalGUI.add(buttonin, new GridBagConstraints(1, 2, 1, 2, 0, .25,
				GridBagConstraints.CENTER, GridBagConstraints.NONE,
				EMPTY_INSETS, 0, 0));
		buttonin.addActionListener(this);
		buttonout = new JButton("<< Remove");
		totalGUI.add(buttonout, new GridBagConstraints(1, 4, 1, 2, 0, .25,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						0, 5, 0, 5), 0, 0));
		buttonout.addActionListener(this);
		buttonnext = new JButton("Done");
		totalGUI.add(buttonnext, new GridBagConstraints(1, 4, 1, 2, 0, .25,
				GridBagConstraints.PAGE_END, GridBagConstraints.NONE,
				new Insets(0, 5, 0, 5), 0, 0));
		// buttonnext.addActionListener(this);
		buttonback = new JButton("Done");
		totalGUI.add(buttonback, new GridBagConstraints(1, 4, 1, 2, 0, .25,
				GridBagConstraints.PAGE_END, GridBagConstraints.NONE,
				new Insets(0, 5, 0, 5), 0, 0));
		// buttonback.addActionListener(this);

		JLabel destLabel = new JLabel("Classes completed:");

		totalGUI.add(destLabel, new GridBagConstraints(2, 0, 1, 1, 0, 0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE,
				EMPTY_INSETS, 0, 0));
		totalGUI.add(list2, new GridBagConstraints(2, 1, 1, 5, .5, 1.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				EMPTY_INSETS, 0, 0));
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
		// we take the indices and values of the selected courseOptions
		// and output them to an array.

		if (e.getSource() == buttonin) {
			int[] fromindex = CourseList.getSelectedIndices();
			Object[] from = CourseList.getSelectedValues();

			// Then, for each item in the array, we add them to
			// the other list.
			for (i = 0; i < from.length; i++) {
				courseOptions.addElement(from[i]);
			}

			// Finally, we remove the courseOptions from the first list.
			// We must remove from the bottom, otherwise we try to
			// remove the wrong objects.
			for (i = (fromindex.length - 1); i >= 0; i--) {
				courseList.remove(fromindex[i]);
			}
		}

		// If the out button is pressed, we take the indices and values of
		// the selected courseOptions and output them to an array.
		else if (e.getSource() == buttonout) {
			Object[] to = selectedList.getSelectedValues();
			int[] toindex = selectedList.getSelectedIndices();

			// Then, for each item in the array, we add them to
			// the other list.
			for (i = 0; i < to.length; i++) {
				courseList.addElement(to[i]);
			}

			// Finally, we remove the courseOptions from the first list.
			// We must remove from the bottom, otherwise we try to
			// remove the wrong objects.
			for (i = (toindex.length - 1); i >= 0; i--) {
				courseOptions.remove(toindex[i]);
			}
		}
	}

	public static void main(String[] args) {

		chooseClasses2 demo = new chooseClasses2();

	}
}
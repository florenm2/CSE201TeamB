import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class displayCourses extends JFrame {
	@SuppressWarnings("unchecked")
	public ArrayList<Course> classesChosen = new ArrayList<Course>();
	public ArrayList<Course> courseList = new ArrayList<Course>();
	public ArrayList<Course> allCourses;
	public int stage;

	private JLabel message;
	private JPanel coursePanel, buttonPanel;
	private JButton status;
	private int rows, columns;

	/**
	 * Creates a list of Courses that can be selected
	 */
	public displayCourses() {

		try {
			allCourses = ImportCSV.csvFileIN();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Course[] courseArray = allCourses
				.toArray(new Course[allCourses.size()]);

		rows = allCourses.size() - 1;
		columns = 2;
		frameSetup();
		courseListSetup();
		buttonPanelSetup();
		// statusSetup();
		this.setVisible(true);
	}

	/**
	 * Sets up the details for the frame.
	 */
	private void frameSetup() {
		setLayout(new BorderLayout());
		setBounds(0, 0, 500, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		courseListSetup();
		buttonPanelSetup();
		statusSetup();
	}

	/**
	 * Sets up the details for the square panel itself.
	 */
	private void courseListSetup() {
		// The layout is based on the number of rows
		coursePanel = new JPanel(new GridLayout(rows, 0));

		try {
			allCourses = ImportCSV.csvFileIN();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Course[] courseArray = allCourses
				.toArray(new Course[allCourses.size()]);

		// Each option is a Course object
		for (int row = 0; row < courseArray.length; row++) {
			
		
			JCheckBox cells = new JCheckBox("" + courseArray[row].getTitle()
					+ ", " + "CSE " + courseArray[row].getCourseNum() + ", "
					+ courseArray[row].getStartTime() + "-"
					+ courseArray[row].getStartTime());
			coursePanel.add(cells);
			cells.addActionListener(new QueenListener());
		}

		JScrollPane myScrollPane = new JScrollPane(coursePanel);
		add(myScrollPane, BorderLayout.CENTER);
	}

	/**
	 * Sets up the labels at the top of the board
	 */
	private void buttonPanelSetup() {
		buttonPanel = new JPanel(new GridLayout(1, 2));
		message = new JLabel("Please select your classes:");
		message.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonPanel.add(message);
		add(buttonPanel, BorderLayout.NORTH);

	}

	/**
	 * Sets up button at bottom of board that allows user to check solution.
	 */
	private void statusSetup() {
		status = new JButton("Check Solution");
		// status.addActionListener(new solutionListener());
		add(status, BorderLayout.SOUTH);
	}

	/**
	 * Updates a specified square by adding a queen if the space is unoccupied
	 * or removing it if the space is occupied
	 * 
	 * @param row
	 *            the row of the square
	 * @param col
	 *            the column of the square
	 * 
	 *            public void updateSquare(int row, int col) throws IOException
	 *            {
	 * 
	 *            BufferedImage queen = ImageIO.read(new File(
	 *            "C:/Users/AdamBenjamin/271Workspace/Project 2/queen.jpg"));
	 *            JLabel queenIm = new JLabel(new ImageIcon(queen)); if
	 *            (numQueens < 8) { if (squaresFilled[row][col] == 0) {
	 *            squaresFilled[row][col] = 1;
	 * 
	 *            squares[row][col].add(queenIm); numQueens++;
	 *            System.out.println(squaresFilled[row][col]);
	 *            squares[row][col].revalidate(); squares[row][col].repaint();
	 *            }// end if else { squares[row][col].removeAll(); JButton q =
	 *            new JButton("[" + row + "][" + col + "]");
	 *            q.addActionListener(new QueenListener());
	 *            squares[row][col].add(q);
	 * 
	 *            squares[row][col].revalidate(); squares[row][col].repaint();
	 *            squaresFilled[row][col] = 0; numQueens--;
	 *            System.out.println(squaresFilled[row][col]);
	 * 
	 *            }// end else numOfQueens.setText(numQueens +
	 *            " Queen(s) added"); }// end if else {
	 *            message.setText("No more queens may be placed!"); validate();
	 *            }// end else }// end updateSquare
	 */

	/**
	 * Listener for checking boxes
	 * 
	 */
	public class QueenListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			try {
				allCourses = ImportCSV.csvFileIN();
			} catch (IOException t) {
				t.printStackTrace();
			}
			Course[] courseArray = allCourses.toArray(new Course[allCourses
					.size()]);

			for (int row = 0; row < courseArray.length; row++) {
				AbstractButton ab = (AbstractButton) e.getSource();
				boolean selected = ab.getModel().isSelected();
				if (selected) {
					classesChosen.add(courseArray[row]);
				}

			}

		}
	}

	/**
	 * Listener to check if solution works
	 * 
	 * 
	 * public class solutionListener implements ActionListener { public void
	 * actionPerformed(ActionEvent e) { solutionChecker();
	 * 
	 * }// end actionperformed }// end solutionListener
	 */
	/*
	 * Checks to see if there are any conflicts among queens placed on board
	 * 
	 * private void solutionChecker() { int count = 0;
	 * 
	 * for (int row = 0; row < ROWS; row++) { for (int cell = 0; cell < COLUMNS;
	 * cell++) { if (squaresFilled[row][cell] == 1) {
	 * 
	 * queens[count] = new Queen(row, cell); count++;
	 * 
	 * }// end if
	 * 
	 * }// end for }// end for for (int i = 0; i < (count - 1); i++) {
	 * System.out.println(i + ": " + queens[i].toString());
	 * 
	 * if (queens[i].attacks(queens[i + 1]) == false) {
	 * JOptionPane.showMessageDialog(null, "Not a Solution! Error at: " +
	 * queens[i].toString()); }// end if else if (i == (count - 2)) {
	 * JOptionPane.showMessageDialog(null, "Partial Solution Works!"); }// end
	 * if }// end for }
	 */
	public static void main(String[] args) {
		new displayCourses();
	}

}

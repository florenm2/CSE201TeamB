import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

public class test implements  ActionListener{

    JList itemList, courses;
    JButton buttonin, buttonout;
    ArrayList<Course> allCoursesLogic = new ArrayList<Course>();
    ArrayList<Course> allCourses = new ArrayList<Course>();
    
    // The ListModels we will be using in the example.
    DefaultListModel shopping, items;

    public JPanel createContentPane () throws IOException{

        // Create the final Panel.
        JPanel totalGUI = new JPanel();
        
        // Instantiate the List Models.
        shopping = new DefaultListModel();
        items = new DefaultListModel();

        // Things to be in the list.
        allCourses = ImportCSV.csvFileIN();
        //allCoursesLogic = allCourses;

        // Using a for loop, we add every item in the String array
        // into the ListModel.

        for(Course c: allCourses){
        	shopping.addElement(c.displayCourse());
        }

        // Creation of the list.
        // We set the cells in the list to be 20px x 140px.
        
        itemList = new JList(shopping);
        itemList.setVisibleRowCount(25);
        //itemList.setFixedCellHeight(20);
       // itemList.setFixedCellWidth(140);
        itemList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        // We then add them to a JScrollPane.
        // This means when we remove items from the JList
        // it will not shrink in size.
        JScrollPane list1 = new JScrollPane(itemList);
        
        courses = new JList(items);
       courses.setVisibleRowCount(25);
       // courses.setFixedCellHeight(20);
        //courses.setFixedCellWidth(140);
        courses.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        // We add this list to a JScrollPane too.
        // This is so the list is displayed even though there are 
        // currently no items in the list.
        // Without the scrollpane, the list would not show.
        JScrollPane list2 = new JScrollPane(courses);

        // We create the buttons to be placed between the lists.
        JPanel buttonPanel = new JPanel();

        buttonin = new JButton(">>");
        buttonin.addActionListener(this);
        buttonPanel.add(buttonin);

        buttonout = new JButton("<<");
        buttonout.addActionListener(this);
        buttonPanel.add(buttonout);

        // This final bit of code uses a BoxLayout to space out the widgets
        // in the GUI.

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));

        bottomPanel.add(Box.createRigidArea(new Dimension(15,0)));
        bottomPanel.add(list1);
        bottomPanel.add(Box.createRigidArea(new Dimension(15,0)));
        bottomPanel.add(buttonPanel);
        bottomPanel.add(Box.createRigidArea(new Dimension(15,0)));
        bottomPanel.add(list2);
        bottomPanel.add(Box.createRigidArea(new Dimension(15,0)));

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

    public void actionPerformed(ActionEvent e) 
    {
        int i = 0;
        
        // When the 'in' button is pressed,
        // we take the indices and values of the selected items
        // and output them to an array.

        if(e.getSource() == buttonin)
        {
        	System.out.println("test");
            int[] fromindex = itemList.getSelectedIndices();
            Object[] from = itemList.getSelectedValues();
            System.out.println(from.toString());
            for(Course c: allCourses){
            	if(c.displayCourse().equals(from)){
            		System.out.println("true");
            		allCoursesLogic.add(c);
            	}
            }
            for(Course c:allCoursesLogic){
            	System.out.println(c.displayCourse());
            }
            // Then, for each item in the array, we add them to
            // the other list.
            for(i = 0; i < from.length; i++)
            {
                items.addElement(from[i]);
            }
            
            // Finally, we remove the items from the first list.
            // We must remove from the bottom, otherwise we try to 
            // remove the wrong objects.
            for(i = (fromindex.length-1); i >=0; i--)
            {
                shopping.remove(fromindex[i]);
            }
        }
        
        // If the out button is pressed, we take the indices and values of
        // the selected items and output them to an array.
        else if(e.getSource() == buttonout)
        {
            Object[] to = courses.getSelectedValues();
            int[] toindex = courses.getSelectedIndices();
            
            // Then, for each item in the array, we add them to
            // the other list.
            for(i = 0; i < to.length; i++)
            {
                shopping.addElement(to[i]);
            }
            
            // Finally, we remove the items from the first list.
            // We must remove from the bottom, otherwise we try to
            // remove the wrong objects.
            for(i = (toindex.length-1); i >=0; i--)
            {
                items.remove(toindex[i]);
            }
        }
    }

    private static void createAndShowGUI() throws IOException {

        //JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("[=] JListExample - Adding and Removing [=]");
   
        test demo = new test();
        frame.setContentPane(demo.createContentPane());
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width, screenSize.height-100);
		//
        
        //frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
					createAndShowGUI();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            } 
        });
    }
}
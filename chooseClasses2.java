import javax.swing.*;
import javax.swing.event.*;

import choosePrereqs.AddListener;
import choosePrereqs.NextListener;
import choosePrereqs.RemoveListener;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

public class chooseClasses2 implements  ActionListener{

    JList CourseList, selectedList;
    JButton buttonin, buttonout, buttonnext, buttonback;
    
    // The ListModels we will be using in the example.
    DefaultListModel courseList, courseOptions;

    public chooseClasses2(){
    	
    	
    	
        JFrame frame = new JFrame("Please choose your classes:");
        try {
			frame.setContentPane(this.createContentPane());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width, screenSize.height-100);
        frame.setVisible(true);
        
    }
    public JPanel createContentPane() throws IOException{

        // Create the final Panel.
        JPanel totalGUI = new JPanel();
        
        
        // Instantiate the List Models.
        courseList = new DefaultListModel();
        courseOptions = new DefaultListModel();

        
        ArrayList<Course> allCourses = ImportCSV.csvFileIN();


        for(Course c: allCourses){
        	courseList.addElement(c.displayCourse());
        }

        // Creation of the list.
        // We set the cells in the list to be 20px x 140px.
        
        CourseList = new JList(courseList);
        CourseList.setVisibleRowCount(45);
        //CourseList.setFixedCellHeight(20);
       // CourseList.setFixedCellWidth(140);
        CourseList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        // We then add them to a JScrollPane.
        // This means when we remove courseOptions from the JList
        // it will not shrink in size.
        JScrollPane list1 = new JScrollPane(CourseList);
        
        selectedList = new JList(courseOptions);
       // selectedList.setVisibleRowCount(10);
       // selectedList.setFixedCellHeight(20);
        //selectedList.setFixedCellWidth(140);
        selectedList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        // We add this list to a JScrollPane too.
        // This is so the list is displayed even though there are 
        // currently no courseOptions in the list.
        // Without the scrollpane, the list would not show.
        JScrollPane list2 = new JScrollPane(selectedList);

        JPanel topbuttonPanel = new JPanel(new GridLayout(2, 1));
        buttonin = new JButton("Add >>");
        buttonin.addActionListener(this);
        buttonin.setSize(new Dimension(40, 40));
        topbuttonPanel.add(buttonin);

        buttonout = new JButton("<< Remove");
        buttonout.addActionListener(this);
        buttonout.setSize(new Dimension(40, 40));
        topbuttonPanel.add(buttonout);
        
        JPanel bottombuttonPanel = new JPanel(new GridLayout(1,2));
        buttonnext = new JButton("Next");
        //buttonnext.addActionListener(this);
        buttonnext.setSize(new Dimension(40, 40));
        bottombuttonPanel.add(buttonnext);

        buttonback = new JButton("Back");
        //buttonback.addActionListener(this);
        buttonback.setSize(new Dimension(40, 40));
        bottombuttonPanel.add(buttonback);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,1));
        buttonPanel.add(topbuttonPanel);
        buttonPanel.add(bottombuttonPanel);
        
        // This final bit of code uses a BoxLayout to space out the widgets
        // in the GUI.

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));

        bottomPanel.add(Box.createRigidArea(new Dimension(10,0)));
        bottomPanel.add(list1);
        bottomPanel.add(Box.createRigidArea(new Dimension(5,0)));
        bottomPanel.add(buttonPanel);
        bottomPanel.add(Box.createRigidArea(new Dimension(5,0)));
        bottomPanel.add(list2);
        bottomPanel.add(Box.createRigidArea(new Dimension(10,0)));

        totalGUI.add(bottomPanel);
        totalGUI.setOpaque(true);
        return totalGUI;
        
        
        
        setBorder(BorderFactory.createEtchedBorder());
        setLayout(new GridBagLayout());
        sourceLabel = new JLabel("Available Classes");
        sourceListModel = new SortedListModel();
        sourceList = new JList(sourceListModel);
        add(sourceLabel, new GridBagConstraints(0, 0, 1, 1, 0, 0,
            GridBagConstraints.CENTER, GridBagConstraints.NONE,
            EMPTY_INSETS, 0, 0));
        add(new JScrollPane(sourceList), new GridBagConstraints(0, 1, 1, 5, .5,
            1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            EMPTY_INSETS, 0, 0));

        addButton = new JButton("Add >>");
        add(addButton, new GridBagConstraints(1, 2, 1, 2, 0, .25,
            GridBagConstraints.CENTER, GridBagConstraints.NONE,
            EMPTY_INSETS, 0, 0));
        addButton.addActionListener(new AddListener());
        removeButton = new JButton("<< Remove");
        add(removeButton, new GridBagConstraints(1, 4, 1, 2, 0, .25,
            GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
                0, 5, 0, 5), 0, 0));
        removeButton.addActionListener(new RemoveListener());
        nextButton = new JButton("Done");
        add(nextButton, new GridBagConstraints(1, 4, 1, 2, 0, .25,
            GridBagConstraints.PAGE_END, GridBagConstraints.NONE,
            new Insets(0, 5, 0, 5), 0, 0));
        nextButton.addActionListener(new NextListener());
        
        destLabel = new JLabel("Classes completed:");
        destListModel = new SortedListModel();
        destList = new JList(destListModel);
        add(destLabel, new GridBagConstraints(2, 0, 1, 1, 0, 0,
            GridBagConstraints.CENTER, GridBagConstraints.NONE,
            EMPTY_INSETS, 0, 0));
        add(new JScrollPane(destList), new GridBagConstraints(2, 1, 1, 5, .5,
            1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            EMPTY_INSETS, 0, 0));
        
        
        
        
        
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
        // we take the indices and values of the selected courseOptions
        // and output them to an array.

        if(e.getSource() == buttonin)
        {
            int[] fromindex = CourseList.getSelectedIndices();
            Object[] from = CourseList.getSelectedValues();

            // Then, for each item in the array, we add them to
            // the other list.
            for(i = 0; i < from.length; i++)
            {
                courseOptions.addElement(from[i]);
            }
            
            // Finally, we remove the courseOptions from the first list.
            // We must remove from the bottom, otherwise we try to 
            // remove the wrong objects.
            for(i = (fromindex.length-1); i >=0; i--)
            {
                courseList.remove(fromindex[i]);
            }
        }
        
        // If the out button is pressed, we take the indices and values of
        // the selected courseOptions and output them to an array.
        else if(e.getSource() == buttonout)
        {
            Object[] to = selectedList.getSelectedValues();
            int[] toindex = selectedList.getSelectedIndices();
            
            // Then, for each item in the array, we add them to
            // the other list.
            for(i = 0; i < to.length; i++)
            {
                courseList.addElement(to[i]);
            }
            
            // Finally, we remove the courseOptions from the first list.
            // We must remove from the bottom, otherwise we try to
            // remove the wrong objects.
            for(i = (toindex.length-1); i >=0; i--)
            {
                courseOptions.remove(toindex[i]);
            }
        }
    }


    public static void main(String[] args) {
            
			
			chooseClasses2 demo = new chooseClasses2();
       
    }
}
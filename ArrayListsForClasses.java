import java.util.ArrayList;

public class ArrayListsForClasses {

	// 18 Different Exam Time Slots
	public static ArrayList<Course> time1 = new ArrayList<Course>();
	public static ArrayList<Course> time2 = new ArrayList<Course>();
	public static ArrayList<Course> time3 = new ArrayList<Course>();
	public static ArrayList<Course> time4 = new ArrayList<Course>();
	public static ArrayList<Course> time5 = new ArrayList<Course>();
	public static ArrayList<Course> time6 = new ArrayList<Course>();
	public static ArrayList<Course> time7 = new ArrayList<Course>();
	public static ArrayList<Course> time8 = new ArrayList<Course>();
	public static ArrayList<Course> time9 = new ArrayList<Course>();
	public static ArrayList<Course> time10 = new ArrayList<Course>();
	public static ArrayList<Course> time11 = new ArrayList<Course>();
	public static ArrayList<Course> time12 = new ArrayList<Course>();
	public static ArrayList<Course> time13 = new ArrayList<Course>();
	public static ArrayList<Course> time14 = new ArrayList<Course>();
	public static ArrayList<Course> time15 = new ArrayList<Course>();
	public static ArrayList<Course> time16 = new ArrayList<Course>();
	public static ArrayList<Course> time17 = new ArrayList<Course>();
	public static ArrayList<Course> time18 = new ArrayList<Course>();

	// Strings for Meeting Times
	public static String MW = "MW";
	public static String WF = "WF";
	public static String MWF = "MWF";
	public static String MTWR = "MTWR";
	public static String MTWRF = "MTWRF";
	public static String M = "M";
	public static String T = "T";
	public static String R = "R";
	public static String TR = "TR";
	public static String W = "W";
	public static String F = "W";


	/**
	 * Method to Sort Courses in to ArrayLists
	 * @param courseList
	 */
	public static void sortArrays(ArrayList<Course> courseList) {

		for (int i = 0; i < courseList.size(); i++) {
			Course cor = courseList.get(i);
			// Time 1
			if ((cor.getStartTime() == 1300 || cor.getStartTime() == 1325)
					&& (MW.equals(cor.getDays()) || WF.equals(cor.getDays()) || MWF.equals(cor.getDays())
							|| MTWRF.equals(cor.getDays()) || MTWR.equals(cor.getDays()))) {
				time1.add(cor);

				// Test
				//System.out.println("Adding " + cor.displayCourse() + " to Time 1");

				// Time 2
			} else if ((cor.getStartTime() == 1600) && (MW.equals(cor.getDays()) || WF.equals(cor.getDays())
					|| MWF.equals(cor.getDays()) || MTWRF.equals(cor.getDays()) || MTWR.equals(cor.getDays()))) {
				time2.add(cor);

				// Test
				//System.out.println("Adding " + cor.displayCourse() + " to Time 2");

				// Time 3
			} else if ((cor.getStartTime() >= 1730) && (M.equals(cor.getDays()))) {
				time3.add(cor);

				
				// Time 4
			} else if ((cor.getStartTime() == 800 || cor.getStartTime() == 830)
					&& (T.equals(cor.getDays()) || R.equals(cor.getDays()) || TR.equals(cor.getDays()))) {
				time4.add(cor);

				// Test
				//System.out.println("Adding " + cor.displayCourse() + " to Time 4");

				// Time 5
			} else if ((cor.getStartTime() == 1130)
					&& (T.equals(cor.getDays()) || R.equals(cor.getDays()) || TR.equals(cor.getDays()))) {
				time5.add(cor);

				// Test
				//System.out.println("Adding " + cor.displayCourse() + " to Time 5");

				// Time 6
			} else if ((cor.getStartTime() == 1430)
					&& (T.equals(cor.getDays()) || R.equals(cor.getDays()) || TR.equals(cor.getDays()))) {
				time6.add(cor);

				// Test
				//System.out.println("Adding " + cor.displayCourse() + " to Time 6");

				// Time 7
			} else if ((cor.getStartTime() >= 1730) && (TR.equals(cor.getDays()))) {
				time7.add(cor);

				// Test
				//System.out.println("Adding " + cor.displayCourse() + " to Time 7");

				// Time 8
			} else if ((cor.getStartTime() >= 1730) && (T.equals(cor.getDays()))) {
				time8.add(cor);

				// Test
			//	System.out.println("Adding " + cor.displayCourse() + " to Time 8");

				// Time 9
			} else if ((cor.getStartTime() == 800 || cor.getStartTime() == 830)
					&& (MW.equals(cor.getDays()) || WF.equals(cor.getDays()) || MWF.equals(cor.getDays())
							|| MTWRF.equals(cor.getDays()) || MTWR.equals(cor.getDays()) || M.equals(cor.getDays())
							|| W.equals(cor.getDays()) || F.equals(cor.getDays()))) {
				time9.add(cor);

				// Test
				//System.out.println("Adding " + cor.displayCourse() + " to Time 9");

				// Time 10
			} else if ((cor.getStartTime() == 1130) && (MW.equals(cor.getDays()) || WF.equals(cor.getDays())
					|| MWF.equals(cor.getDays()) || MTWRF.equals(cor.getDays()) || MTWR.equals(cor.getDays())
					|| M.equals(cor.getDays()) || W.equals(cor.getDays()) || F.equals(cor.getDays()))) {
				time10.add(cor);

				// Test
				//System.out.println("Adding " + cor.displayCourse() + " to Time 10");

				// Time 11
			} else if ((cor.getStartTime() == 1430) && (MW.equals(cor.getDays()) || WF.equals(cor.getDays())
					|| MWF.equals(cor.getDays()) || MTWRF.equals(cor.getDays()) || MTWR.equals(cor.getDays())
					|| M.equals(cor.getDays()) || W.equals(cor.getDays()) || F.equals(cor.getDays()))) {
				time11.add(cor);

				// Test
				//System.out.println("Adding " + cor.displayCourse() + " to Time 11");

				// Time 12
			} else if ((cor.getStartTime() >= 1730) && (MW.equals(cor.getDays()))) {
				time12.add(cor);

				// Test
				//System.out.println("Adding " + cor.displayCourse() + " to Time 12");

				// Time 13
			} else if ((cor.getStartTime() >= 1730) && (W.equals(cor.getDays()))) {
				time13.add(cor);

				// Test
				//System.out.println("Adding " + cor.displayCourse() + " to Time 13");

				// Time 14
			} else if ((cor.getStartTime() == 1000)
					&& (T.equals(cor.getDays()) || R.equals(cor.getDays()) || TR.equals(cor.getDays()))) {
				time14.add(cor);

				// Test
				//System.out.println("Adding " + cor.displayCourse() + " to Time 14");

				// Time 15
			} else if ((cor.getStartTime() == 1300)
					&& (T.equals(cor.getDays()) || R.equals(cor.getDays()) || TR.equals(cor.getDays()))) {
				time15.add(cor);

				// Test
				//System.out.println("Adding " + cor.displayCourse() + " to Time 15");

				// Time 16
			} else if ((cor.getStartTime() == 1600)
					&& (T.equals(cor.getDays()) || R.equals(cor.getDays()) || TR.equals(cor.getDays()))) {
				time16.add(cor);

				// Test
				//System.out.println("Adding " + cor.displayCourse() + " to Time 16");

				// Time 17
			} else if ((cor.getStartTime() >= 1730) && (R.equals(cor.getDays()))) {
				time17.add(cor);

				// Test
				//System.out.println("Adding " + cor.displayCourse() + " to Time 17");

				// Time 18
			} else if ((cor.getStartTime() == 1000) && (MW.equals(cor.getDays()) || WF.equals(cor.getDays())
					|| MWF.equals(cor.getDays()) || MTWRF.equals(cor.getDays()) || MTWR.equals(cor.getDays())
					|| M.equals(cor.getDays()) || W.equals(cor.getDays()) || F.equals(cor.getDays()))) {
				time18.add(cor);

				// Test
				//System.out.println("Adding " + cor.displayCourse() + " to Time 18");

			}

		}
	}
}
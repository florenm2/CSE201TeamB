public class Course {

	public int crn;
	public String subject;
	public String courseNum;
	public String section;
	public int startTime;
	public int endTime;
	public String days;
	public String instructorName;
	
	public String title;

	

	/**
	 *  Will store value to print course information to the GUI
	 */
	public String course;

	/**
	 * super constructor
	 */
	public Course() {
		super();
	}

	/**
	 * course constructor
	 * @param crn
	 * @param subject
	 * @param courseNum
	 * @param section
	 * @param startTime
	 * @param endTime
	 * @param days
	 * @param instructorName
	 */
	public Course(int crn, String subject, String courseNum, String title, String section, int startTime, int endTime, String days,
			String instructorName) {
		super();
		this.crn = crn;
		this.subject = subject;
		this.courseNum = courseNum;
		this.section = section;
		this.startTime = startTime;
		this.endTime = endTime;
		this.days = days;
		this.instructorName = instructorName;
		
		this.title = title;
	}

	/**
	 * Set course value to display to GUI
	 * @return
	 */
	public String displayCourse() {
		course = getSubject() + getCourseNum() + " " + getTitle() + "(" + getSection() + ") " + getInstructorName() + " Start Time: " + getStartTime() + " End Time: " + getEndTime();
		return course;
	}

	/**
	 * main
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 * Things I added
	 */
	
	
	
	
	
	/**
	 * retrieves the crn
	 * @return
	 */
	public int getCrn() {
		return crn;
	}

	/**
	 * sets the crn
	 * @param crn
	 */
	public void setCrn(int crn) {
		this.crn = crn;
	}

	/**
	 * gets the subject
	 * @return
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * sets the subject
	 * @param subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * gets the course number
	 * @return
	 */
	public String getCourseNum() {
		return courseNum;
	}

	/**
	 * sets the course number
	 * @param course2
	 */
	public void setCourseNum(String course2) {
		this.courseNum = course2;
	}

	/**
	 * gets the section
	 * @return
	 */
	public String getSection() {
		return section;
	}

	/**
	 * set the section
	 * @param section
	 */
	public void setSection(String section) {
		this.section = section;
	}

	/**
	 * get the start time
	 * @return
	 */
	public int getStartTime() {
		return startTime;
	}

	/**
	 * set the start time
	 * @param startTime
	 */
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	/**
	 * get the end time
	 * @return
	 */
	public int getEndTime() {
		return endTime;
	}

	/**
	 * set the end time
	 * @param endTime
	 */
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	/**
	 * get days
	 * @return
	 */
	public String getDays() {
		return days;
	}

	/**
	 * set days
	 * @param days
	 */
	public void setDays(String days) {
		this.days = days;
	}

	/**
	 * get instructor name
	 * @return
	 */
	public String getInstructorName() {
		return instructorName;
	}

	/**
	 * set instructor name
	 * @param instructorName
	 */
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}

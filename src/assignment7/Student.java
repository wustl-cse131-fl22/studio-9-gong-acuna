package assignment7;

public class Student {
	private String firstName;
	private String lastName;
	private int studID;
	private double attemptedCredits;
	private double passingCredits;
	private double totalGradeQualityPoints;
	private double bearBucksBalance;
	
	public Student(String a, String b , int c ) {
		firstName = a;
		lastName = b;
		studID = c;
		attemptedCredits = 0;
		passingCredits = 0;
		totalGradeQualityPoints = 0;
		bearBucksBalance = 0;
	}
	public String getFullName() {
		return (firstName + " " + lastName);
	}
	public int getId() {
		return studID;
	}
	
	public void submitGrade(double grade, int credits) {
	double GradeQualityPoints = grade * credits;	
	totalGradeQualityPoints += GradeQualityPoints;
	attemptedCredits += credits;
	if (grade >= 1.7) {
		passingCredits += credits;
	}
	}
	
	public int getTotalAttemptedCredits() {
		return (int) attemptedCredits;
	}
	
	public int getTotalPassingCredits() {
		return (int) passingCredits;
	}
	
	public double calculateGradePointAverage() {
		return totalGradeQualityPoints/attemptedCredits;
	}
	
	public String getClassStanding() {
	if(this.getTotalPassingCredits() < 30) {
		return "First Year";
	}
	else if (30 <= this.getTotalPassingCredits() && this.getTotalPassingCredits() < 60) {
		return "Sophomore";
	}
	else if (60 <= this.getTotalPassingCredits() && this.getTotalPassingCredits() < 90) {
		return "Junior";
	}
	else 
		return "Senior";
	}
	
	public boolean isEligibleForPhiBetaKappa() {
	if (this.getTotalPassingCredits() >= 98 && this.calculateGradePointAverage() >= 3.60) {
		return true;
	}
	else if(this.getTotalPassingCredits() >= 75 && this.calculateGradePointAverage() >= 3.80) {
		return true;
	}
	else {
		return false;
	}
	}
	
	public void depositBearBucks(double amount) {
		bearBucksBalance += amount;
	}
	
	public void deductBearBucks(double amount) {
		bearBucksBalance -= amount;
	}
	
	public double getBearBucksBalance() {
		return bearBucksBalance;
	}
	
	public double cashOutBearBucks() {
		double recieved = 0;
		if (bearBucksBalance <= 10){
			recieved = 0;
		}
		else {
			recieved = bearBucksBalance - 10;
		}
		bearBucksBalance = 0;
		return recieved;
	}
	
	
	public Student createLegacy(String firstName, Student other, boolean isHyphenated, int id) {
		String childLastName;
		if (isHyphenated) {
			childLastName = (this.lastName + "-" + other.lastName);
		}
		else {
			childLastName = this.lastName;
		}
		
		Student child = new Student(firstName,childLastName, id);
		child.depositBearBucks(this.cashOutBearBucks() + other.cashOutBearBucks());
		return child;
	}
	
	public String toString() {
		return (firstName + " " + lastName + " " + studID);
	}
	
}

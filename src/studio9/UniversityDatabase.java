package studio9;

import java.util.HashMap;
import java.util.Map;

import assignment7.Student;

public class UniversityDatabase {
	//TODO: Complete this class according to the studio instructions
	
	
	private Map<String, Student> Database;
	
	public UniversityDatabase() {
		this.Database = new HashMap<String, Student>();
	}
	
	public void addStudent(String accountName, Student student) {
		// TODO
		this.Database.put(accountName, student);
	}

	public int getStudentCount() {
		// TODO
		return this.Database.size();
	}

	public String lookupFullName(String accountName) {
		// TODO: Complete according to studio instructions
		if (this.Database.get(accountName)== null) {
			return null;
		}
		else {
			return this.Database.get(accountName).getFullName();	
		}	
	}

	public double getTotalBearBucks() {
		// TODO
		double bearBucks = 0;
		for (String i : this.Database.keySet()) {
			Student a = this.Database.get(i);
			bearBucks += a.getBearBucksBalance();
		}
		return bearBucks;
	}
}

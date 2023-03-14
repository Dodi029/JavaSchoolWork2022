package org.tukorea.club;

public class ProgClubMember {
	private String name;
	private String studentId;
	private String department;
	private String langauge;
	private String gender;
	public String toString() {
		return "ProgClubMember [name=" + name + ", studentId=" + studentId + ", department=" + department + ", langauge=" + langauge + ", gender=" + gender +"]";
	};
	public ProgClubMember(String name, String studentId, String department, String language, String gender) {
		this.name = name;
		this.studentId = studentId;
		this.department = department;
		this.langauge = language;
		this.gender = gender;
	}
}

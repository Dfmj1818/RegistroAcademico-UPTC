package Model;

public class Student {

	private long studentCode;
	private String universityName;

	public Student() {

	}

	public void setStudentCode(long studentCode) {
		this.studentCode=studentCode;
	}

	public long getStudentCode() {
		return studentCode;
	}

	public void setUniversityName(String universityName) {
		this.universityName=universityName;
	}

	public String getUniversityName() {
		return universityName;
	}

	@Override
	public String toString() {
		StringBuilder studentInformation=new StringBuilder();
		studentInformation.append("Codigo Estudiantil:")
		.append(getStudentCode()).append("\n")
		.append("Nombre Asignado Por la Universidad: ")
		.append(getUniversityName());

		return studentInformation.toString();
	}


}

package Model;

public class Student {

	private long studentCode;
	private String universityName;
    private int id;
    private boolean isAttended;
    
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
	
	public void setId(int id) {
		this.id=id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setIsAttended(boolean isAttended) {
		this.isAttended=isAttended;
	}
	
	public boolean getIsAttended() {
		return isAttended;
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

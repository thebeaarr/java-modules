class enrollement 
{
	private String studentid ; 
	private String course ;

	public enrollement(String studentid , String course)
	{
		this.studentid = studentid ;
		this.course = course ;
	}

	public setCourse(String course)
	{
		this.course = course ;
	}
	public setStudentid(String studentid)
	{
		this.studentid = studentid ;
	}
}



public class PersonnelAdministartif extends Person
{
	private String poste ; // position 
	private int bureau ; // office number
	private ArrayList<enrollement> enrols ; 
	public PersonnelAdministartif(String poste , int bureau)
	{
		this.poste = poste ;
		this.bureau = bureau;
		this.enrols = new ArrayList<>();
	}



	public void gererInscriptions(String studentid , String course)
	{
		enrols.add(new enrollement(studentid , course));
	}


	@Override 
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()).append("\nposte : ").append(this.poste).append("\nbureau").append(this.bureau).append("\n");
		return sb.toString();
	}
	@Override
	public void afficherInfo()
	{
		System.out.println(this);
	}
}

import java.util.ArrayList;

class Course {
	private String course;
	private float note;

	public Course(String course,float note) {
		this.course = course;
		this.note = note;
	}

	// Getters
	public String getCourse() { return course;}
	public float getNote() { return note; }
	public void setNote(float note){this.note = note ;}

	@Override
	public String toString()
	{
		return course + " - : " + note;
	}
}

public class Student extends  Person
{
	private String  numeroEtudiant;
	private String filier ;
	private String niveau;
	private ArrayList<Course> courses ;

	public Student(String nom , String prenom ,String cin , int age  , String filier , String numerEtudiant, String niveau  )
	{
		super(nom , prenom ,cin  , age) ;
		this.filier = filier ;
		this.niveau = niveau;
		this.numeroEtudiant = numerEtudiant ;
		this.courses = new ArrayList<>() ;
	}

	public void sinscrire(String course)
	{
		this.courses.add(new Course(course , 0.0f));
	}
	public void passerExamen(String course ,  float note)
	{
		for(Course c : this.courses)
		{
			if(c.getCourse().equals(course) )
			{
				c.setNote(note);
				return ;
			}
		}
		System.out.println("Course not found: " + course);
	}
	@Override 
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()).append("\nnumeroEtudiant : ").append(this.numeroEtudiant).append("\nFillier : ").append(this.filiere).append("\nNiveau : ").append(this.niveau).append("\n");
		for(Course c : this.courses)
		{
			sb.append("  -  ").append(c.getCourse()).append("\nNote :").append(c.getNote()).append("\n");
		}
		return sb.toString();
	}

	@Override
	public void afficherInfo()
	{
		System.out.println(this);
	}
}
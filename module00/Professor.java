
import java.util.ArrayList;

class Exam
{
	private  String course ;
	private String studentid ;
	private float note ;


	public Exam(String course , String studentid , float note )
	{
		this.course  = course;
		this.studentid = studentid;
		this.note = note;
	}

	public void setstudentid(String studentid){this.studentid = studentid ;}
	public void setCourse(String course ) { this.course = course ;}
	public void setNote(float note ){this.note = note ;}
}

public class Professor extends Person 
{
	private String specialite ;
	private String departement ;
	private float salaire ;
	private ArrayList<Exam> results;
	private ArrayList<String> courses ;
	
	public Professor(String nom , String prenom , String cin , int age , String specialite , String departement , float salaire)
	{
		super(nom , prenom , cin , age);
		this.salaire= salaire;
		this.departement = departement;
		this.specialite = specialite;
		this.courses  = new ArrayList<>();
		this.results = new ArrayList<>();
	}
	public void setSalaire(float salaire) { this.salaire = salaire;}
	public void enseignerCours(String course )
	{
		this.courses.add(course);
	}
	public void corrigerExamen(String course , String studentid , float note)
	{
		this.results.add(new Exam(course , studentid , note));
	}
	@Override 
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()).append("\nSpecialite : ").append(specialite).append("\nDepartement : ").append(this.departement).append("\nSalaire").append(this.salaire).append("\n");
		return sb.toString();
		}
	@Override
	public void afficherInfo()
	{
		System.out.println(this);
	}
}
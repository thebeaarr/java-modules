

public class Person
{
	protected  String nom ;
	protected  String prenom ;
	protected  int age ;
	protected  String cin ;
	// public void setNom(String nom) { this.nom = nom ;}
	// public void setPreNom(String prenom ) { this.prenom = prenom;}
	// public void setCin(String cin) { this.cin = cin  ;}
	// public void setAge(int age) { this.age= age ;}
	public String getNom() {return this.nom;}
	public String getPreNom() {return this.prenom;}
	public String getcin() {return this.cin;}
	public int getAge(){return this.age;}


	public Person(String nom , String prenom , String cin , int age) {
		this.age = age;
		this.nom = nom ;
		this.prenom = prenom ;
		this.cin = cin ;
	}


	@Override
	public String toString()
	{
		return "[nom : " + this.nom + " prenom : " + this.prenom + " age : "  + this.age + " CIN : " +  this.cin  + "]";
	}

	public void afficherInfo()
	{
		System.out.println(this);
	}
}
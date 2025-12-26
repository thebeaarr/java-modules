public class Main
{
	public static void main(String[] args)
	{
		Person p1 = new Person("Alami", "Ahmed", "AB123456" , 50);
Person p2 = new Student("Bennani", "Sara", "CD789012" , 20 , "Info", "2023001","S5");
Person p3 = new Professor("Aatila", "Mustapha",  "EF345678", 45, "POO", "Informatique", 15000);
p1.afficherInfo();
p2.afficherInfo();
p3.afficherInfo();
	}
}
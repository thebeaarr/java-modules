public class Main
{
	public static void main(String[] args)
	{
	System.out.println("---------------- Test1 -----------------");

		Person p1 = new Person("Alami", "Ahmed", "AB123456" , 50);
Person p2 = new Student("Bennani", "Sara", "CD789012" , 20 , "Info", "2023001","S5");
Person p3 = new Professor("Aatila", "Mustapha",  "EF345678", 45, "POO", "Informatique", 15000);
p1.afficherInfo();
p2.afficherInfo();
p3.afficherInfo();


	System.out.println("---------------- Test2 -----------------");

	Person[] uni = new Person[4];
	uni[0] = new Person ("mohamed" , "lakhdar" , "EA1111" , 18 );
	uni[1] = new Professor("mohamed" , "lakhdar" , "EA1111" , 18 , "Cyber" , "Informatique" , 10000 );
	uni[2] = new Student("mohamed" , "lakhdar" , "EA1111" , 18 , "Cybersecurity" , "G148024918" , "S5");
	uni[3] = new PersonnelAdministartif("mohamed" , "lakhdar" , "EA1111" , 18  , "staff technique" , 10 );
	for(int i = 0 ; i < 4 ; i++)
		uni[i].afficherInfo();
	}
}
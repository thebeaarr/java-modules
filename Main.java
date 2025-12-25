public class Main
{
	public static void main(String[] args)
	{
		Inventory inventory = new Inventory();
		Weapon weapon = new Weapon("Sword" , 30 , "samurai" , 100);
		Fruit fruit = new Fruit("Fuji" , "Apple" , 20);
		inventory.addItem("Sword" , 30 , "samurai" , 100);
		inventory.addItem(fruit);
		inventory.addItem(weapon);
		inventory.displayInventory();
	}
}
public  abstract class Item implements Itemstuff
{
	protected  String name;
	protected  int quantity;

	@Override
	public String toString()
	{
		return "name : " + this.name + " quantity : " + this.quantity ;
	}

	public Item(String name , int quantity)
	{
		this.name  = name ;
		this.quantity = quantity;
	}
	@Override
	public String getName()
	{
		return this.name ;
	}
	@Override
	public int getQuantity()
	{
		return this.quantity;
	}


	public abstract void DisplayInfo(); // this is a fucntion that's an abstract no need to implement it tells the direvied class that they must implement it by there way 
}
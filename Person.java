

public class Person
{
	int id;
	String fName;
	String lName;
	int age;
	
	public Person()
	{
		//
	}
	
	public Person(int id, String fName, String lName, int age)
	{
		this.id    = id;
		this.fName = fName;
		this.lName = lName;
		this.age   = age;
	}

	@Override
	public String toString()
	{
		return "Person [id=" + id + ", fName=" + fName + ", lName=" + lName + ", age=" + age + "]";
	}	

}

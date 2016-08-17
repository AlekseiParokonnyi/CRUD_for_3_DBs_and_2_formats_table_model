import java.util.ArrayList;

public class PersonDAO_Mock implements PersonDAO
{
	ArrayList<Person> pp = new ArrayList<Person>();
	
	public PersonDAO_Mock()
	{
		pp.add( new Person(10, "Vasia", "Pupkin", 23) );
		pp.add( new Person(11, "Gasia", "Lupkin", 26) );
		pp.add( new Person(17, "Fasia", "Gupkin", 33) );
		pp.add( new Person(24, "Lasia", "Fupkin", 11) );
		pp.add( new Person(56, "Pasia", "Hupkin", 99) );
	}

	@Override
	public void create(Person p)
	{
		pp.add(p);		
	}

	@Override
	public ArrayList<Person> read()
	{
		return pp;
	}

	@Override
	public void update(Person p)
	{
		for(Person i : pp)
		{
			if(i.id == p.id)
			{
				i.fName = p.fName;
				i.lName = p.lName;
				i.age = p.age;
				break;
			}
		}
	}

	@Override
	public void delete(Person p)
	{
		int del = 0;
		
		for(Person i : pp)
		{
			if(i.id == p.id)
			{
				break;
			}
			del++;
		}
		
		pp.remove(del);
	}
}



import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class PersonDAO_nXML implements PersonDAO
{
	String file = "C:/java/PersonsNN.xml";

	@Override
	public ArrayList<Person> read() 
	{
		ArrayList<Person> ret = new ArrayList<Person>(0);

		try
		{
			File ff = new File(file);
			if( ff.length() > 0)
			{
				XMLDecoder	de = new XMLDecoder(new FileInputStream(file));
				ret = (ArrayList<Person>) de.readObject();
			}
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}

		return ret;
	}

	@Override
	public void create(Person p) 
	{
		ArrayList<Person> ret = read();
		ret.add(p);
		write(ret);
	}

	@Override
	public void update(Person p) 
	{
		ArrayList<Person> ret = read();

		//ret.add(p);

		write(ret);
	}

	@Override
	public void delete(Person p) 
	{
		ArrayList<Person> ret = read();

		//ret.add(p);

		write(ret);
	}	
	private void write(ArrayList<Person> pp)
	{
		try 
		{
			XMLEncoder en = new XMLEncoder(new FileOutputStream(file));
			en.writeObject(pp);
			en.flush();
			en.close();
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}		
	}
}

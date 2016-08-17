import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class PersonDAO_nJSON implements PersonDAO
{
	String file = "C:/Java/PersonsNN.json";

	@Override
	public ArrayList<Person> read() 
	{
		ArrayList<Person> pp = new ArrayList<Person>();

		try 
		{
			File ff = new File(file);
			if( ff.length() > 0)
			{
				DataInputStream in = new DataInputStream(new FileInputStream(file));
				String str = in.readUTF();
				Gson gs = new Gson();
				pp = gs.fromJson(str, new TypeToken<ArrayList<Person>>(){}.getType());
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		return pp;
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
			Gson gs = new Gson();
			String str = gs.toJson(pp);
			DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
			out.writeUTF(str);
			out.flush();
			out.close();
		}
		catch ( IOException e) 
		{
			e.printStackTrace();
		}		
	}
	
}

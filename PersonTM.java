import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class PersonTM extends AbstractTableModel
{
	private static final long serialVersionUID = 1L;
	
	PersonDAO pd = null;
	ArrayList<Person> pp = null;
	
	public PersonTM() 
	{
		//pd = new PersonDAO_Mock();
		//pd = new PersonDAO_H2();
		//pd = new PersonDAO_MySQL();
		//pd = new PersonDAO_SQLite();
		//pd = new PersonDAO_XML();
		//pd = new PersonDAO_JSON();
		//pd = new PersonDAO_CSV();
		//pd = new PersonDAO_YAML();
		pd = new PersonDAO_nXML();
		pp = read();
	}
	
	public ArrayList<Person> read()
	{
		ArrayList<Person> pp = pd.read();
		
		return pp;
	}
	
	public void create(Person p)
	{
		pd.create( p );
	}
	
	public void update(Person p)
	{
		pd.update( p );
	}
	
	public void delete(Person p)
	{
		pd.delete( p );
	}
	
	@Override
	public int getColumnCount()
	{	
		return 4;
	}

	@Override
	public String getColumnName(int col) 
	{
		String[] str = {"ID", "FName", "LName", "Age"};
		return str[col];
	}

	@Override
	public int getRowCount() 
	{
		return pp.size();
	}

	@Override
	public Object getValueAt(int row, int col) 
	{
		Person p = pp.get(row);
		
		Object ret = null;
		switch (col)
		{
			case 0: ret = p.id;    break;
			case 1: ret = p.fName; break;
			case 2: ret = p.lName; break;
			case 3: ret = p.age;   break;
		}
		
		return ret;
	}

}

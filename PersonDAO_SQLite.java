import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonDAO_SQLite implements PersonDAO
{

	@Override
	public void create(Person p)
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:D://Alex/learning/JavaHillel/Database/Bases/SQLite/PersonDB.sqlite");
			String sql = "INSERT INTO PERSON (id, fname, lname, age) VALUES (?,?,?,?)";
			PreparedStatement st = conn.prepareStatement( sql );
			st.setInt(1, p.id);
			st.setString(2, p.fName);
			st.setString(3, p.lName);
			st.setInt(4, p.age);
			st.executeUpdate();
			conn.close();
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Person> read()
	{
		ArrayList<Person> pp = new ArrayList<Person>();
		
		try
		{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:D://Alex/learning/JavaHillel/Database/Bases/SQLite/PersonDB.sqlite");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM PERSON");
			while(rs.next())
			{
				pp.add( new Person (rs.getInt(1), rs.getString("fname"), rs.getString(3), rs.getInt(4)) );
			}
			conn.close();
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
		return pp;
	}

	@Override
	public void update(Person p)
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:D://Alex/learning/JavaHillel/Database/Bases/SQLite/PersonDB.sqlite");
			Statement st = conn.createStatement();
			String sql = "UPDATE PERSON SET FNAME='" + p.fName + "', LNAME='" + p.lName + "', AGE=" + p.age + " WHERE ID=" + p.id;
			st.executeUpdate(sql);
			conn.close();
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Person p)
	{
		try 
		{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:D://Alex/learning/JavaHillel/Database/Bases/SQLite/PersonDB.sqlite");
			Statement st = conn.createStatement();
			String sql = "delete from Person where id =" + p.id;
			st.executeUpdate(sql);
			conn.close();
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}

}

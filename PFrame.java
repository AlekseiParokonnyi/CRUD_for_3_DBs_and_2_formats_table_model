import javax.swing.JFrame;

public class PFrame extends JFrame
{
	private static final long serialVersionUID = 1L;

	public PFrame()
	{
		setTitle("Person");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200, 200, 500, 500);
		
		add( new PPanel() );
		
		setVisible(true);
	}
}

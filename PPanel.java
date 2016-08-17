
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PPanel extends JPanel
{

	private static final long serialVersionUID = 1L;
	PersonTM dm = null;
	JTable tbl = null;
	
	public PPanel()
	{
		setLayout(null);
		
		dm = new PersonTM();
		tbl = new JTable(dm);
		JScrollPane scr = new JScrollPane(tbl);
		scr.setBounds(10, 10, 300, 300);
		add(scr);
		
		JTextField txtId = new JTextField();
		txtId.setBounds(10, 350, 100, 20);
		add(txtId);
		
		JTextField txtFName = new JTextField();
		txtFName.setBounds(120, 350, 100, 20);
		add(txtFName);
		
		JTextField txtLName = new JTextField();
		txtLName.setBounds(230, 350, 100, 20);
		add(txtLName);
		
		JTextField txtAge = new JTextField();
		txtAge.setBounds(340, 350, 100, 20);
		add(txtAge);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(10, 380, 100, 20);
		add(btnCreate);
		btnCreate.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				dm.create(new Person(Integer.parseInt(txtId.getText()), txtFName.getText(), txtLName.getText(),  Integer.parseInt(txtAge.getText()) ) );
				dm.pp = dm.read();
				tbl.revalidate();
			}
		});

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(230, 380, 100, 20);
		add(btnUpdate);
		btnUpdate.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				dm.update(new Person(Integer.parseInt(txtId.getText()), txtFName.getText(), txtLName.getText(),  Integer.parseInt(txtAge.getText()) ) );
				dm.pp = dm.read();
				tbl.repaint();
			}
		});


		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(340, 380, 100, 20);
		add(btnDelete);
		btnDelete.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				dm.delete(new Person(Integer.parseInt(txtId.getText()), " ", " ",  0 ) );
				dm.pp = dm.read();
				tbl.revalidate();
			}
		});
	}
	
	
	
	
}

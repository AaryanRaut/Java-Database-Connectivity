import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


	class MyFrame extends JFrame
	{
		JLabel l1, l2, l3, l4, l5, l6, l7;
		JTextField t1, t2, t3;
		JTextArea ta1;
		JComboBox cb1;
		JRadioButton rb1, rb2, rb3, rb4, rb5;
		JButton b1, b2, b3, b4, b5;
		ButtonGroup bg, bg2;
	
		public MyFrame()
		{
			super("STUDENT PORTAL");
			setSize(600,800);
			setLocation(650,100);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setResizable(false);
			setLayout(null);

			l1 = new JLabel("Student ID :");
			l1.setFont(new Font("Serif", Font.BOLD, 26));
			l1.setBounds(30,40,140,30);
			add(l1);

			t1 = new JTextField();
			t1.setFont(new Font("Serif", Font.BOLD, 26));
			t1.setBounds(230,40,100,30);
			add(t1);

			l2 = new JLabel("Student Name :");
			l2.setFont(new Font("Serif", Font.BOLD, 26));
			l2.setBounds(30,90,180,30);
			add(l2);

			t2 = new JTextField();
			t2.setFont(new Font("Serif", Font.BOLD, 26));
			t2.setBounds(230,90,150,30);
			add(t2);

			l3 = new JLabel("Mobile No. :");
			l3.setFont(new Font("Serif", Font.BOLD, 26));
			l3.setBounds(30,140,150,30);
			add(l3);

			t3 = new JTextField();
			t3.setFont(new Font("Serif", Font.BOLD, 26));
			t3.setBounds(230,140,150,30);
			add(t3);

			l4 = new JLabel("Gender :");
			l4.setFont(new Font("Serif", Font.BOLD, 26));
			l4.setBounds(30,190,100,30);
			add(l4);

			rb1 = new JRadioButton("Male");
			rb1.setFont(new Font("Serif", Font.BOLD, 26));
			rb1.setBounds(230,190,100,30);
			add(rb1);

			rb2 = new JRadioButton("Female");
			rb2.setFont(new Font("Serif", Font.BOLD, 26));
			rb2.setBounds(350,190,130,30);
			add(rb2);

			bg = new ButtonGroup();
			bg.add(rb1);
			bg.add(rb2);

			l5 = new JLabel("State :");
			l5.setFont(new Font("Serif", Font.BOLD, 26));
			l5.setBounds(30,240,120,30);
			add(l5);

			Object str [] = {"SELECT", "Maharashtra", "Delhi", "Gujarat", "Punjab", "Goa"};

			cb1 = new JComboBox(str);
			cb1.setFont(new Font("Serif", Font.BOLD, 26));
			cb1.setBounds(230,240,250,30);
			add(cb1);

			l6 = new JLabel("Address :");
			l6.setFont(new Font("Serif", Font.BOLD, 26));
			l6.setBounds(30,290,130,30);
			add(l6);

			ta1 = new JTextArea();
			ta1.setFont(new Font("Serif", Font.PLAIN, 20));
			ta1.setLineWrap(true);
			ta1.setBounds(230,295,350,130);
			add(ta1);
			  
			l7 = new JLabel("Coding Lang. :");
			l7.setFont(new Font("Serif", Font.BOLD, 26));
			l7.setBounds(30,450,180,31);
			add(l7);

			rb3 = new JRadioButton("C++");
			rb3.setFont(new Font("Serif", Font.BOLD, 26));
			rb3.setBounds(230,455,100,30);
			add(rb3);

			rb4 = new JRadioButton("JAVA");
			rb4.setFont(new Font("Serif", Font.BOLD, 26));
			rb4.setBounds(330,455,100,30);
			add(rb4);
			
			rb5 = new JRadioButton("PYTHON");
			rb5.setFont(new Font("Serif", Font.BOLD, 26));
			rb5.setBounds(450,455,150,30);
			add(rb5);

			bg2 = new ButtonGroup();
			bg2.add(rb3);
			bg2.add(rb4);
			bg2.add(rb4);

			b1 = new JButton("Select");
			b1.setFont(new Font("Serif", Font.BOLD, 26));
			b1.setBounds(130,520,140,30);
			b1.setToolTipText("Display Information");
			add(b1);

			b2 = new JButton("Insert");
			b2.setFont(new Font("Serif", Font.BOLD, 26));
			b2.setBounds(310,520,140,30);
			b2.setToolTipText("Insert Record");
			add(b2);

			b3 = new JButton("Update");
			b3.setFont(new Font("Serif", Font.BOLD, 26));
			b3.setBounds(130,580,140,30);
			b3.setToolTipText("Update Record");
			add(b3);

			b4 = new JButton("Delete");
			b4.setFont(new Font("Serif", Font.BOLD, 26));
			b4.setBounds(310,580,140,30);
			b4.setToolTipText("Delete Record");
			add(b4);

			b5 = new JButton("Clear All");
			b5.setFont(new Font("Serif", Font.BOLD, 26));
			b5.setBounds(220,640,140,30);
			add(b5);

			
			b1.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
					if(t1.getText().equals(""))
					{
						JOptionPane.showMessageDialog(MyFrame.this, "Enter Student ID", "Warning", JOptionPane.WARNING_MESSAGE);
						return;
					}	

					else
					{
					try
					{
						Class.forName("com.mysql.jdbc.Driver");

						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/sample", "root", "mysql");
			
						Statement stm = con.createStatement();

						ResultSet rs = stm.executeQuery("Select * from student where Id = "+t1.getText());

						if(rs.next())
						{
							t1.setText(rs.getInt(1)+"");
							t2.setText(rs.getString(2)+"");
							t3.setText(rs.getString(3)+"");
							
							String Gender = rs.getString(4);

							if(Gender.equalsIgnoreCase("Male"))
							{
								rb1.setSelected(true);
							}
							else if(Gender.equalsIgnoreCase("Female"))
							{
								rb2.setSelected(true);
							}

							String state = rs.getString(5);
							cb1.setSelectedItem(state);

							ta1.setText(rs.getString(6)+"");

							String prog_lang = rs.getString(7);

							if(prog_lang.equalsIgnoreCase("C++"))
							{
								rb3.setSelected(true);
							}

							else if(prog_lang.equalsIgnoreCase("JAVA"))
							{
								rb4.setSelected(true);
							}

							else if(prog_lang.equalsIgnoreCase("PYHTON"))
							{
								rb5.setSelected(true);
							}
						}
						else
						{
							JOptionPane.showMessageDialog(MyFrame.this, "Record Not Found", "Warning", JOptionPane.WARNING_MESSAGE);
			
							con.close();
						}
					}
					catch(Exception a)
					{
						System.out.print(a);
					}
					}
				}
			});

			
			b2.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
				if(t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("") || !rb1.isSelected() || !rb2.isSelected() || cb1.getSelectedItem()==0 || ta1.getText().equals("") || !rb3.isSelected() || !rb4.isSelected() || !rb5.isSelected())
				{
					JOptionPane.showMessageDialog(MyFrame.this, "Enter Student ID", "Warning", JOptionPane.WARNING_MESSAGE);
						return;
				}

				try
				{
					Class.forName("com.mysql.jdbc.Driver");

					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/sample", "root", "mysql");

					PreparedStatement stm = con.prepareStatement("insert into student values(?,?,?,?,?,?,?)");

					stm.setInt(1, Integer.parseInt(t1.getText()));
					stm.setString(2, t2.getText());
					stm.setString(3, t3.getText());
					
					String Gender = "";
					if(rb1.isSelected())
					{
						Gender = "Male";
					}
					else if(rb1.isSelected())
					{
						Gender = "Female";
					}
					stm.setString(4, Gender);
					
					String State = (String) cb1.getSelectedItem();
					stm.setString(5, State);
			
					stm.setString(6, ta1.getText());

					String prog_lang = "";
					if(rb3.isSelected())
					{
						prog_lang="C++";
					}
					else if(rb4.isSelected())
					{
						prog_lang = "JAVA";
					}
					else if(rb5.isSelected())
					{
						prog_lang = "PYTHON";
					}
					stm.setString(7, prog_lang);
			

					int i = stm.executeUpdate();

					JOptionPane.showMessageDialog(MyFrame.this, "Information Stored Sucessfully", "Success", JOptionPane.PLAIN_MESSAGE);

					con.close();
				}
				catch(Exception a)
				{
					JOptionPane.showMessageDialog(MyFrame.this, "Not Recorded", "Error", JOptionPane.ERROR_MESSAGE);
				}

				}
			});

			b3.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
					if(t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("") || (!rb1.isSelected() && !rb2.isSelected()) || cb1.getSelectedItem()==null || ta1.getText().equals("") || (!rb3.isSelected() && !rb4.isSelected() && !rb5.isSelected()))
					{
						JOptionPane.showMessageDialog(MyFrame.this, "Enter Details", "Warning", JOptionPane.WARNING_MESSAGE);
							return;
					}
					else
					{
					try
					{
						Class.forName("com.mysql.jdbc.Driver");

						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/sample", "root", "mysql");

						String gender = rb1.isSelected() ? "Male" : "Female";
            					String state = (String) cb1.getSelectedItem();
            					String progLang = rb3.isSelected() ? "C++" : rb4.isSelected() ? "JAVA" : "PYTHON";

						String query = "Update student set Name = ?, Mobile_no = ?, Gender = ?, State = ?, Address = ?, prog_lang = ? where Id = ?";
						
						PreparedStatement stm = con.prepareStatement(query);

						 stm.setString(1, t2.getText()); 
            					 stm.setString(2, t3.getText()); 
            					 stm.setString(3, gender);              
            					 stm.setString(4, state);               
            					 stm.setString(5, ta1.getText());
            					 stm.setString(6, progLang);            
             					 stm.setInt(7, Integer.parseInt(t1.getText()));

						int i = stm.executeUpdate();

						con.close();

						if(i>0)
						{
							JOptionPane.showMessageDialog(MyFrame.this, "Record Update Successfully", "Success", JOptionPane.PLAIN_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(MyFrame.this, "Record Not Update", "Error", JOptionPane.ERROR_MESSAGE);
						}

                           			con.close();       
					}
					catch(Exception a)
					{
						//System.out.print(a);
						JOptionPane.showMessageDialog(MyFrame.this, "Not Recorded", "Error", JOptionPane.ERROR_MESSAGE);                        
					}
					}
				}
			});


			b4.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
		                     if(t1.getText().equals(""))
                		     {
					JOptionPane.showMessageDialog(MyFrame.this, "ENTER STUDENT ID", "WARNING", JOptionPane.WARNING_MESSAGE);
                                	return;
		                     }                  
                		     else
                     		     {
                         		try
                          		{
                              			Class.forName("com.mysql.jdbc.Driver");

						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/sample", "root", "mysql");

                         			Statement stmt = con.createStatement();                      

   						int i = stmt.executeUpdate("Delete from student where Id = "+Integer.parseInt(t1.getText()));

              					if(i == 0)
              					{
							JOptionPane.showMessageDialog(MyFrame.this, "RECORD NOT FOUND ", "MESSAGE", JOptionPane.PLAIN_MESSAGE);                                   
              					}
              					else
              					{ 
							JOptionPane.showMessageDialog(MyFrame.this, "RECORD DELETED SUCCESSFULLY!", "MESSAGE", JOptionPane.PLAIN_MESSAGE);         
             					} 
                          				 con.close();       
                        		}
                        		catch(Exception ex)
                        		{
 						JOptionPane.showMessageDialog(MyFrame.this, "RECORD NOT FOUND ", "MESSAGE", JOptionPane.PLAIN_MESSAGE);                                   
                        		}	
				    }
				}
			});

			b5.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
					t1.setText("");
					t2.setText("");
					t3.setText("");
					
					ta1.setText("");
					
					bg.clearSelection();
					bg2.clearSelection();

					cb1.setSelectedIndex(0);
				}
			});

			setVisible(true);
		}
	}

public class StudentLoginDemo
{
	public static void main(String [] args)
	{
		new MyFrame();	
	}
}

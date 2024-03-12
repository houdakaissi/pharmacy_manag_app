package tp_releve;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class client extends JFrame {
	Statement st;
	Conneccion con=new Conneccion();
	ResultSet rst;
	JLabel lbtitre,lbnum,lbnom,lbprenom,lbmath,lbpc,lbsvt,lbang,lbfran;
	JTextField tfnum,tfnom,tfprenom,tfmath,tfpc,tfsvt,tfang,tfran;
	JButton btenrg,btsupp,btenrg1;
	JTable jt;
	JScrollPane js;
	
	public client(){
		this.setTitle("chcode_appli");
		this.setSize(700,700);
		this.setLocationRelativeTo(null);
		JPanel pn=new JPanel();
		   pn.setLayout(null);
		   pn.setBackground(new Color(250,200,150));
		   add(pn);
			
			lbtitre=new JLabel("gestion des clients");
			lbtitre.setBounds(70,10,300,30);
			lbtitre.setFont(new Font("Arial",Font.BOLD,18));
			lbtitre.setForeground(new Color(100,120,100));
			pn.add(lbtitre);
			//numero
			lbnum=new JLabel("ID_CLIENT:");
			lbnum.setBounds(20,50,150,30);
			lbnum.setFont(new Font("Arial",Font.BOLD,14));
			lbnum.setForeground(new Color(100,120,100));
			pn.add(lbnum);
			
			tfnum=new JTextField();
			tfnum.setBounds(150,50,150,25);
			pn.add(tfnum);
			//nom
			lbnom=new JLabel("Nom :");
			lbnom.setBounds(20,80,100,30);
			lbnom.setFont(new Font("Arial",Font.BOLD,14));
			lbnom.setForeground(new Color(100,120,100));
			pn.add(lbnom);
			
			tfnom=new JTextField();
			tfnom.setBounds(150,80,150,25);
			pn.add(tfnom);
			//prenom
			lbprenom=new JLabel("EMAIL :");
			lbprenom.setBounds(20,110,100,30);
			lbprenom.setFont(new Font("Arial",Font.BOLD,14));
			lbprenom.setForeground(new Color(100,120,100));
			pn.add(lbprenom);
			

			tfprenom=new JTextField();
			tfprenom.setBounds(150,110,150,25);
			pn.add(tfprenom);
			//math
			lbmath=new JLabel("GENRE :");
			lbmath.setBounds(20,140,100,30);
			lbmath.setFont(new Font("Arial",Font.BOLD,14));
			lbmath.setForeground(new Color(100,120,100));
			pn.add(lbmath);
			
			tfmath=new JTextField();
			tfmath.setBounds(90,140,100,25);
			pn.add(tfmath);
			 //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
			//bouton enregistrement enseignant
			btenrg1=new JButton("MODIFIER");
			btenrg1.setBounds(280,200,120,25);
			
			//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
			DefaultTableModel df=new DefaultTableModel();
			 
				jt=new JTable();
				js=new JScrollPane();
				js.setViewportView(jt);
				js.setBounds(180,250,400,400);
			 
			df.addColumn("id_client");
			df.addColumn("nom");
			df.addColumn("email");
			df.addColumn("genre");
			
			jt.setModel(df);
			pn.add(js);
			
			String qr="select * from client";
			
			try{
				st=con.laConnection().createStatement();
				rst=st.executeQuery(qr);
				while(rst.next()){
					df.addRow(new Object[]{rst.getString("id_client"),rst.getString("nom"),rst.getString("email"),rst.getString("genre")});
				}
				
			}
			catch(SQLException ex){
				JOptionPane.showMessageDialog(this,"Erreur,supression impossible!",null,JOptionPane.ERROR_MESSAGE);
			}
			
		
		 
	//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
			
			
			
btenrg1.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ev){
		String ID_CLIENT,NOM,EMAIL,GENRE ;
		ID_CLIENT=tfnum.getText();
		NOM=tfnom.getText();
		EMAIL=tfprenom.getText();
		GENRE=tfmath.getText();
	 

		String rq1="update client set     nom='"+NOM+"',email='"+EMAIL+"',genre='"+GENRE+"' where id_client='"+ID_CLIENT+"'";
		try{
			st=con.laConnection().createStatement();
			if( !ID_CLIENT.equals("")&& !NOM.equals("")&&!EMAIL.equals("")&&!GENRE.equals("")){
			st.executeUpdate(rq1);
    		JOptionPane.showMessageDialog(null,"Insertion reussie!",null,JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				JOptionPane.showMessageDialog(null,"Remplissez tous les champs!",null,JOptionPane.ERROR_MESSAGE);
			}
			
		}
		catch(SQLException ex){
	    	JOptionPane.showMessageDialog(null,"Erreur!",null,JOptionPane.ERROR_MESSAGE);	
	    }
		dispose();
		client er=new client();
		er.setVisible(true);
	}
	
});
			pn.add(btenrg1);
			
			
			
			
			
			 
			//bouton enregistrement enseignant
			btenrg=new JButton("ENREGISTRER");
			btenrg.setBounds(10,200,120,25);
btenrg.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ev){
		String ID_CLIENT,NOM,EMAIL,GENRE ;
		ID_CLIENT=tfnum.getText();
		NOM=tfnom.getText();
		EMAIL=tfprenom.getText();
		GENRE=tfmath.getText();
	 

		String rq1="insert into client(id_client,nom,email,genre ) values('"+ID_CLIENT+"','"+NOM+"','"+EMAIL+"','"+GENRE+"' )";
		try{
			st=con.laConnection().createStatement();
			if(!ID_CLIENT.equals("")&&!NOM.equals("")&&!EMAIL.equals("")&&!GENRE.equals("")){
			st.executeUpdate(rq1);
    		JOptionPane.showMessageDialog(null,"Insertion reussie!",null,JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				JOptionPane.showMessageDialog(null,"Remplissez tous les champs!",null,JOptionPane.ERROR_MESSAGE);
			}
			
		}
		catch(SQLException ex){
	    	JOptionPane.showMessageDialog(null,"Erreur!",null,JOptionPane.ERROR_MESSAGE);	
	    }
		dispose();
		client er=new client();
		er.setVisible(true);
	}
	
});
			pn.add(btenrg);
			//bouton supprimer
			btsupp=new JButton("SUPPRIMER");
			btsupp.setBounds(150,200,120,25);
btsupp.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ev){
		String ID_CLIENT,NOM,EMAIL,GENRE ;
		ID_CLIENT=tfnum.getText();
		

		String rq1="delete from client where id_client='"+ID_CLIENT+"'";
		try{
			st=con.laConnection().createStatement();
			if(!ID_CLIENT.equals("")){
			st.executeUpdate(rq1);
    		JOptionPane.showMessageDialog(null,"Suppr�ssion reussie!",null,JOptionPane.INFORMATION_MESSAGE);
			}
			
			
		}
		catch(SQLException ex){
	    	JOptionPane.showMessageDialog(null,"Erreur!",null,JOptionPane.ERROR_MESSAGE);	
	    }
		dispose();
		client er=new client();
		er.setVisible(true);
	}
	
});
			pn.add(btsupp);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  client en=new client();
  en.setVisible(true);
	}

}
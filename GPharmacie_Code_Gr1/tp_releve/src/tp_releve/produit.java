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


public class produit extends JFrame {
	Statement st;
	Conneccion con=new Conneccion();
	ResultSet rst;
	JLabel lbtitre,lbnum,lbnom,lbprenom,lbmath,lbpc,lbsvt,lbang,lbfran;
	JTextField tfnum,tfnom,tfprenom,tfmath,tfpc,tfsvt,tfang,tfran;
	JButton btenrg,btsupp,btenrg1;
	JTable jt;
	JScrollPane js;
	public produit(){
		this.setTitle("chcode_appli");
		this.setSize(700,700);
		this.setLocationRelativeTo(null);
		JPanel pn=new JPanel();
		   pn.setLayout(null);
		   pn.setBackground(new Color(36, 36, 36));
		   add(pn);
			
			lbtitre=new JLabel("gestion des Produits");
			lbtitre.setBounds(200,10,300,30);
			lbtitre.setFont(new Font("Arial",Font.BOLD,18));
			lbtitre.setForeground(new Color(0,0,255));
			pn.add(lbtitre);
			//numero
			lbnum=new JLabel("ID_PRODUIT:");
			lbnum.setBounds(20,50,150,30);
			lbnum.setFont(new Font("Arial",Font.BOLD,14));
			lbnum.setForeground(new Color(255, 255, 255));
			pn.add(lbnum);
			
			tfnum=new JTextField();
			tfnum.setBounds(300,50,150,25);
			pn.add(tfnum);
			//nom
			lbnom=new JLabel("TYPE:");
			lbnom.setBounds(20,80,100,30);
			lbnom.setFont(new Font("Arial",Font.BOLD,14));
			lbnom.setForeground(new Color(255, 255, 255));
			pn.add(lbnom);
			
			tfnom=new JTextField();
			tfnom.setBounds(300,80,150,25);
			pn.add(tfnom);
			//prenom
			lbprenom=new JLabel("LIBELLE :");
			lbprenom.setBounds(20,110,100,30);
			lbprenom.setFont(new Font("Arial",Font.BOLD,14));
			lbprenom.setForeground(new Color(255, 255, 255));
			pn.add(lbprenom);
			

			tfprenom=new JTextField();
			tfprenom.setBounds(300,110,150,25);
			pn.add(tfprenom);
			//math
			lbmath=new JLabel("ID_RAYON:");
			lbmath.setBounds(20,140,100,30);
			lbmath.setFont(new Font("Arial",Font.BOLD,14));
			lbmath.setForeground(new Color(255, 255, 255));
			pn.add(lbmath);
			
			tfmath=new JTextField();
			tfmath.setBounds(300,140,100,25);
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
			 
			df.addColumn("id_produi");
			df.addColumn("type");
			df.addColumn("libelle");
			df.addColumn("id_rayon");
			
			jt.setModel(df);
			pn.add(js);
			
			String qr="select * from Produit";
			
			try{
				st=con.laConnection().createStatement();
				rst=st.executeQuery(qr);
				while(rst.next()){
					df.addRow(new Object[]{rst.getString("id_produit"),rst.getString("type"),rst.getString("libelle"),rst.getString("id_rayon")});
				}
				
			}
			catch(SQLException ex){
				JOptionPane.showMessageDialog(this,"Erreur,supression impossible!",null,JOptionPane.ERROR_MESSAGE);
			}
			
		
		 
	//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
	
	
			
			
btenrg1.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ev){
		String ID_PRODUIT,TYPE,LIBELLE,ID_RAYON;
		ID_PRODUIT=tfnum.getText();
		TYPE=tfnom.getText();
		LIBELLE=tfprenom.getText();
		ID_RAYON=tfmath.getText();
	 

		String rq1="update Produit set     id_rayon='"+ID_RAYON+"',type='"+TYPE+"',libelle='"+LIBELLE+"' where id_produit='"+ID_PRODUIT+"'";
		try{
			st=con.laConnection().createStatement();
			if( !ID_PRODUIT.equals("")&& !LIBELLE.equals("")&&!TYPE.equals("")&&!ID_RAYON.equals("")){
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
		produit er=new produit();
		er.setVisible(true);
	}
	
});
			pn.add(btenrg1);
			
			
			
			
			
			 
			//bouton enregistrement enseignant
			btenrg=new JButton("ENREGISTRER");
			btenrg.setBounds(10,200,120,25);
btenrg.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ev){
		String ID_PRODUIT,TYPE,LIBELLE,ID_RAYON;
		ID_PRODUIT=tfnum.getText();
		TYPE=tfnom.getText();
		LIBELLE=tfprenom.getText();
		ID_RAYON=tfmath.getText();

		String rq1="insert into Produit(id_produit,type,libelle,id_rayon ) values('"+ID_PRODUIT+"','"+TYPE+"','"+LIBELLE+"','"+ID_RAYON+"' )";
		try{
			st=con.laConnection().createStatement();
			if(!ID_PRODUIT.equals("")&&!TYPE.equals("")&&!LIBELLE.equals("")&&!ID_RAYON.equals("")){
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
		rayon er=new rayon();
		er.setVisible(true);
	}
	
});
			pn.add(btenrg);
			//bouton supprimer
			btsupp=new JButton("SUPPRIMER");
			btsupp.setBounds(150,200,120,25);
btsupp.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ev){
		String ID_PRODUIT,TYPE,LIBELLE,ID_RAYON;
		ID_PRODUIT=tfnum.getText();
	 
		

		String rq1="delete from Produit where id_produit='"+ID_PRODUIT+"'";
		try{
			st=con.laConnection().createStatement();
			if(!ID_PRODUIT.equals("")){
			st.executeUpdate(rq1);
    		JOptionPane.showMessageDialog(null,"Suppr�ssion reussie!",null,JOptionPane.INFORMATION_MESSAGE);
			}
			
			
		}
		catch(SQLException ex){
	    	JOptionPane.showMessageDialog(null,"Erreur!",null,JOptionPane.ERROR_MESSAGE);	
	    }
		dispose();
		produit er=new produit();
		er.setVisible(true);
	}
	
});
			pn.add(btsupp);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  produit en=new produit();
  en.setVisible(true);
	}

}

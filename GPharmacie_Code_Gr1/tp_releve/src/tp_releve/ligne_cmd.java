 package tp_releve;

 import tp_releve.Conneccion;
 import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

import java.sql.*;


 

public class ligne_cmd extends JFrame   {
	Statement st;
	Conneccion con=new Conneccion();
	ResultSet rst;
	JLabel lbtitre,lbnum,lbnom,lbprenom,lbmath,lbpc,lbsvt,lbang,lbfran;
	JTextField tfnum,tfnom,tfprenom,tfmath,tfpc,tfsvt,tfang,tfran;
	JButton btenrg,btsupp,btenrg1;
	JTable jt;
	JScrollPane js;
	
	public ligne_cmd(){
		this.setTitle("GESTION DES LIGNES DES COMMANDES");
		this.setSize(700,700);
		this.setLocationRelativeTo(null);
		JPanel pn=new JPanel();
		   pn.setLayout(null);
		   pn.setBackground(new Color(  0, 255, 255  ));
		   add(pn);
			
			lbtitre=new JLabel("gestion des lignes des commandes");
			lbtitre.setBounds(200,10,400,30);
			lbtitre.setFont(new Font("Arial",Font.BOLD,18));
			lbtitre.setForeground(new Color( 139, 69, 19));
			pn.add(lbtitre);
			//numero
			lbnum=new JLabel("QUANTITÉ:");
			lbnum.setBounds(70,50,150,30);
			lbnum.setFont(new Font("Arial",Font.BOLD,14));
			lbnum.setForeground(new Color( 139, 69, 19));
			pn.add(lbnum);
			
			tfnum=new JTextField();
			tfnum.setBounds(250,50,150,25);
			pn.add(tfnum);
			//nom
			lbnom=new JLabel("ID_COMMANDE:");
			lbnom.setBounds(70,80,150,30);
			lbnom.setFont(new Font("Arial",Font.BOLD,14));
			lbnom.setForeground(new Color( 139, 69, 19));
			pn.add(lbnom);
			
			tfnom=new JTextField();
			tfnom.setBounds(250,80,150,25);
			pn.add(tfnom);
			//prenom
			lbprenom=new JLabel("ID_PRODUIT :");
			lbprenom.setBounds(70, 110,150, 30);
			lbprenom.setFont(new Font("Arial",Font.BOLD,14));
			lbprenom.setForeground(new Color( 139, 69, 19));
			pn.add(lbprenom);
			

			tfprenom=new JTextField();
			tfprenom.setBounds(250,110,150,25);
			pn.add(tfprenom);
			//math
			 
			//bouton enregistrement enseignant
			btenrg1=new JButton("MODIFIER");
			btenrg1.setBounds(400,170,120,25);
 
		//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
				DefaultTableModel df=new DefaultTableModel();
				 
					jt=new JTable();
					js=new JScrollPane();
					js.setViewportView(jt);
					js.setBounds(180,250,400,400);
				 
				df.addColumn("quantité");
				df.addColumn("id_commande");
				df.addColumn("id_produit");
				
				jt.setModel(df);
				pn.add(js);
				
				String qr="select * from ligne_cmd";
				
				try{
					st=con.laConnection().createStatement();
					rst=st.executeQuery(qr);
					while(rst.next()){
						df.addRow(new Object[]{rst.getString("quantité"),rst.getString("id_commande"),rst.getString("id_produit")});
					}
					
				}
				catch(SQLException ex){
					JOptionPane.showMessageDialog(this,"Erreur,supression impossible!",null,JOptionPane.ERROR_MESSAGE);
				}
				
			
			 
		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
		
		 
			btenrg1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ev){
					String QUANTITÉ,ID_COMMANDE,ID_PRODUIT ;
					QUANTITÉ=tfnum.getText();
					ID_COMMANDE=tfnom.getText();
					ID_PRODUIT=tfprenom.getText();
				    
	 

		String rq1="update ligne_cmd  set     quantité='"+QUANTITÉ+"', id_produit='"+ID_PRODUIT+"'  where id_commande='"+ID_COMMANDE+"'";
		try{
			st=con.laConnection().createStatement();
			if( !ID_PRODUIT.equals("")&& !QUANTITÉ.equals("")&&!ID_COMMANDE.equals("") ){
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
		ligne_cmd er=new ligne_cmd();
		er.setVisible(true);
	}
	
});
			pn.add(btenrg1);
			
			
			
			
			
			 
			//bouton enregistrement enseignant
			btenrg=new JButton("ENREGISTRER");
			btenrg.setBounds(100,170,120,25);
btenrg.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ev){
		String QUANTITÉ,ID_COMMANDE,ID_PRODUIT ;
		QUANTITÉ=tfnum.getText();
		ID_COMMANDE=tfnom.getText();
		ID_PRODUIT=tfprenom.getText();
		 

		String rq1="insert into ligne_cmd(quantité,id_commande,id_produit ) values('"+QUANTITÉ+"','"+ID_COMMANDE+"','"+ID_PRODUIT+"'  )";
		try{
			st=con.laConnection().createStatement();
			if(!ID_COMMANDE.equals("")&&!ID_PRODUIT.equals("")&&!QUANTITÉ.equals("") ){
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
		ligne_cmd er=new ligne_cmd();
		er.setVisible(true);
	}
	
});
			pn.add(btenrg);
			//bouton supprimer
			btsupp=new JButton("SUPPRIMER");
			btsupp.setBounds(240,200,120,25);
btsupp.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ev){
		String  ID_COMMANDE,ID_PRODUIT;
		ID_COMMANDE=tfnom.getText();
		ID_PRODUIT=tfprenom.getText();
	 
		

		String rq1="delete from ligne_cmd where id_commande='"+ID_COMMANDE+"' and  id_produit='"+ID_PRODUIT+"'"  ;
		try{
			st=con.laConnection().createStatement();
			if(!ID_COMMANDE.equals("")){
			st.executeUpdate(rq1);
    		JOptionPane.showMessageDialog(null,"Suppr�ssion reussie!",null,JOptionPane.INFORMATION_MESSAGE);
			}
			
			
		}
		catch(SQLException ex){
	    	JOptionPane.showMessageDialog(null,"Erreur!",null,JOptionPane.ERROR_MESSAGE);	
	    }
		dispose();
		ligne_cmd er=new ligne_cmd();
		er.setVisible(true);
	}
	
});
			pn.add(btsupp);
	}

public static void main(String[] args) {
	// TODO Auto-generated method stub
ligne_cmd en=new ligne_cmd();
en.setVisible(true);
}

}
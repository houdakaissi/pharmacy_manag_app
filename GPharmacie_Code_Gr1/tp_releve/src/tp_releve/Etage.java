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


public class Etage extends JFrame {
	Statement st;
	Conneccion con=new Conneccion();
	ResultSet rst;
	JLabel lbtitre,lbnum,lbnom,lbprenom,lbmath,lbpc,lbsvt,lbang,lbfran;
	JTextField tfnum,tfnom,tfprenom,tfmath,tfpc,tfsvt,tfang,tfran;
	JButton btenrg,btsupp,btenrg1;
	JTable jt;
	JScrollPane js;
	
	public Etage(){
		this.setTitle("GESTION DES ETAGES");
		this.setSize(700,700);
		this.setLocationRelativeTo(null);
		JPanel pn=new JPanel();
		   pn.setLayout(null);
		   pn.setBackground(new Color(20, 140, 70));
		   add(pn);
			
			lbtitre=new JLabel("gestion des etages");
			lbtitre.setBounds(200,10,300,30);
			lbtitre.setFont(new Font("Arial",Font.BOLD,18));
			lbtitre.setForeground(new Color( 0,0,0));
			pn.add(lbtitre);
			//numero
			lbnum=new JLabel("NUMERO_DETAGE:");
			lbnum.setBounds(50,50,150,30);
			lbnum.setFont(new Font("Arial",Font.BOLD,14));
			lbnum.setForeground(new Color( 0,0,0));
			pn.add(lbnum);
			
			tfnum=new JTextField();
			tfnum.setBounds(250,50,250,25);
			pn.add(tfnum);
			//nom
			 

		 
			 
			 //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
			//bouton enregistrement enseignant
			btenrg1=new JButton("MODIFIER");
			btenrg1.setBounds(370,170,150,25);
			//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
			DefaultTableModel df=new DefaultTableModel();
			 
				jt=new JTable();
				js=new JScrollPane();
				js.setViewportView(jt);
				js.setBounds(180,250,400,400);
			 
			df.addColumn("numero-detage");
			 
			
			jt.setModel(df);
			pn.add(js);
			
			String qr="select * from Etage";
			
			try{
				st=con.laConnection().createStatement();
				rst=st.executeQuery(qr);
				while(rst.next()){
					df.addRow(new Object[]{rst.getString("numero_detage") });
				}
				
			}
			catch(SQLException ex){
				JOptionPane.showMessageDialog(this,"Erreur,supression impossible!",null,JOptionPane.ERROR_MESSAGE);
			}
			
		
		 
	//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
			
			
			
btenrg1.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ev){
		String NUMERO_DETAGE ;
		NUMERO_DETAGE=tfnum.getText();
		 
	 
	 

		String rq1="update ligne_cmd  set     numero_detage='"+NUMERO_DETAGE+"'"  ;
		try{
			st=con.laConnection().createStatement();
			if( !NUMERO_DETAGE.equals("") ){
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
			btenrg.setBounds(70,170,170,25);
btenrg.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ev){
		String NUMERO_DETAGE ;
		NUMERO_DETAGE=tfnum.getText();
		 
		 

		String rq1="insert into Etage(numero_detage ) values('"+NUMERO_DETAGE+"'   )";
		try{
			st=con.laConnection().createStatement();
			if(!NUMERO_DETAGE.equals("") ){
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
		Etage er=new Etage();
		er.setVisible(true);
	}
	
});
			pn.add(btenrg);
			//bouton supprimer
			btsupp=new JButton("SUPPRIMER");
			btsupp.setBounds(210,200,170,25);
btsupp.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ev){
		String  NUMERO_DETAGE;
		NUMERO_DETAGE=tfnum.getText();
	 
		

		String rq1="delete from Etage where numero_detage='"+NUMERO_DETAGE+"'";
		try{
			st=con.laConnection().createStatement();
			if(!NUMERO_DETAGE.equals("")){
			st.executeUpdate(rq1);
    		JOptionPane.showMessageDialog(null,"Suppr�ssion reussie!",null,JOptionPane.INFORMATION_MESSAGE);
			}
			
			
		}
		catch(SQLException ex){
	    	JOptionPane.showMessageDialog(null,"Erreur!",null,JOptionPane.ERROR_MESSAGE);	
	    }
		dispose();
		Etage er=new Etage();
		er.setVisible(true);
	}
	
});
			pn.add(btsupp);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 Etage en=new Etage();
  en.setVisible(true);
	}

}
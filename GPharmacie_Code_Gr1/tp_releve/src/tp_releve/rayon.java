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


public class rayon extends JFrame {
	Statement st;
	Conneccion con=new Conneccion();
	ResultSet rst;
	JLabel lbtitre,lbnum,lbnom,lbprenom,lbmath,lbpc,lbsvt,lbang,lbfran;
	JTextField tfnum,tfnom,tfprenom,tfmath,tfpc,tfsvt,tfang,tfran;
	JButton btenrg,btsupp,btenrg1;
	JTable jt;
	JScrollPane js;
	public rayon(){
		this.setTitle("chcode_appli");
		this.setSize(700,700);
		this.setLocationRelativeTo(null);
		JPanel pn=new JPanel();
		   pn.setLayout(null);
		   pn.setBackground(new Color(128,0,128));
		   add(pn);
			
			lbtitre=new JLabel("gestion des rayons");
			lbtitre.setBounds(220,10,300,30);
			lbtitre.setFont(new Font("Arial",Font.BOLD,18));
			lbtitre.setForeground(new Color(255,255,255));
			pn.add(lbtitre);
			//numero
			lbnum=new JLabel("ID_RAYON:");
			lbnum.setBounds(80,50,150,30);
			lbnum.setFont(new Font("Arial",Font.BOLD,14));
			lbnum.setForeground(new Color(255, 255, 255));
			pn.add(lbnum);
			
			tfnum=new JTextField();
			tfnum.setBounds(260,50,250,25);
			pn.add(tfnum);
			//nom
			lbnom=new JLabel("NBR_ETAGE:");
			lbnom.setBounds(80,80,100,30);
			lbnom.setFont(new Font("Arial",Font.BOLD,14));
			lbnom.setForeground(new Color(255, 255, 255));
			pn.add(lbnom);
			
			tfnom=new JTextField();
			tfnom.setBounds(260,80,150,25);
			pn.add(tfnom);
			//prenom
			lbprenom=new JLabel("TYPE :");
			lbprenom.setBounds(80,110,100,30);
			lbprenom.setFont(new Font("Arial",Font.BOLD,14));
			lbprenom.setForeground(new Color(255, 255, 255));
			pn.add(lbprenom);
			

			tfprenom=new JTextField();
			tfprenom.setBounds(260,110,250,25);
			pn.add(tfprenom);
			//math
			 
			 //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
			//bouton enregistrement enseignant
			btenrg1=new JButton("MODIFIER");
			btenrg1.setBounds(320,170,120,25);
			

			//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
					DefaultTableModel df=new DefaultTableModel();
					 
						jt=new JTable();
						js=new JScrollPane();
						js.setViewportView(jt);
						js.setBounds(180,250,400,400);
					 
					df.addColumn("id_rayon");
					df.addColumn("type");
					df.addColumn("nbr_etage");
					
					jt.setModel(df);
					pn.add(js);
					
					String qr="select * from Rayon";
					
					try{
						st=con.laConnection().createStatement();
						rst=st.executeQuery(qr);
						while(rst.next()){
							df.addRow(new Object[]{rst.getString("id_rayon"),rst.getString("type"),rst.getString("nbr_etage")});
						}
						
					}
					catch(SQLException ex){
						JOptionPane.showMessageDialog(this,"Erreur,supression impossible!",null,JOptionPane.ERROR_MESSAGE);
					}
					
				
				 
			//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
			
			
			
btenrg1.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ev){
		String ID_RAYON,NBR_ETAGE,TYPE ;
		ID_RAYON=tfnum.getText();
		TYPE=tfnom.getText();
		NBR_ETAGE=tfprenom.getText();
	 
	 

		String rq1="update Rayon  set     nbr_etage='"+NBR_ETAGE+"', type='"+TYPE+"'  where id_rayon='"+ID_RAYON+"'";
		try{
			st=con.laConnection().createStatement();
			if( !ID_RAYON.equals("")&& !TYPE.equals("")&&!NBR_ETAGE.equals("") ){
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
			btenrg.setBounds(70,170,120,25);
btenrg.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ev){
		String ID_RAYON,TYPE,NBR_ETAGE ;
		ID_RAYON=tfnum.getText();
		TYPE=tfnom.getText();
		NBR_ETAGE=tfprenom.getText();
		 

		String rq1="insert into Rayon(id_rayon,nbr_etage,type ) values('"+ID_RAYON+"','"+NBR_ETAGE+"','"+TYPE+"'  )";
		try{
			st=con.laConnection().createStatement();
			if(!ID_RAYON.equals("")&&!TYPE.equals("")&&!NBR_ETAGE.equals("") ){
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
			btsupp.setBounds(190,200,120,25);
btsupp.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ev){
		String  ID_RAYON;
		ID_RAYON=tfnum.getText();
	 
		

		String rq1="delete from Rayon where id_rayon='"+ID_RAYON+"'";
		try{
			st=con.laConnection().createStatement();
			if(!ID_RAYON.equals("")){
			st.executeUpdate(rq1);
    		JOptionPane.showMessageDialog(null,"Suppr�ssion reussie!",null,JOptionPane.INFORMATION_MESSAGE);
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
			pn.add(btsupp);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  rayon en=new rayon();
  en.setVisible(true);
	}

}

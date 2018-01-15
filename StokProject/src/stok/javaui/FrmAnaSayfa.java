package stok.javaui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;







import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import stok.bll.UrunBll;
import stok.dalmysql.UrunDal;
import stok.entities.Urun;


public class FrmAnaSayfa extends JFrame {

	/**
	 * Launch the application.
	 */
	
	//swing projesi
	UrunBll urunBll=new UrunBll(new UrunDal());
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAnaSayfa frame = new FrmAnaSayfa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmAnaSayfa() {
		setTitle("Anasayfa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 345);
		getContentPane().setLayout(null);
		
		JList list_1 = new JList();
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_1.setBounds(10, 11, 208, 257);
		getContentPane().add(list_1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
			/*	DefaultListModel liste=new DefaultListModel();
				liste.addElement(1234);
				liste.addElement("ahmet");
				liste.addElement(true);
				liste.add(2,"melise");//kacýncý sýraya yukleme yapacaksan
				list_1.setModel(liste);*/
			}
		});
		btnNewButton.setBounds(260, 36, 89, 23);
		getContentPane().add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Object eleman=comboBox.getSelectedItem();
				int index= comboBox.getSelectedIndex();
				Object[] aa=comboBox.getSelectedObjects();
				
				JOptionPane.showMessageDialog(null, eleman);
				JOptionPane.showMessageDialog(null, index);
			}
		});
		comboBox.setToolTipText("\u0130li Seciniz");
		comboBox.setBounds(260, 248, 163, 20);
		getContentPane().add(comboBox);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				DefaultComboBoxModel liste=new DefaultComboBoxModel();
				ArrayList<Urun> list=new ArrayList<Urun>();
				list=urunBll.Listele();
				
				//yontem1-dongu
				
				for (Urun urun : list)
				{
					liste.addElement(urun.getUrunAdi());
				}
				comboBox.setModel(liste);
				//Yontem2.1
				DefaultComboBoxModel liste2=new DefaultComboBoxModel
						(
						new UrunBll(new UrunDal()).Listele().toArray()
						);
				comboBox.setModel(liste2);
				//Yontem2.2
				comboBox.setModel(new DefaultComboBoxModel(new UrunBll(new UrunDal()).Listele().toArray()));
				
				
			}
		});
		btnNewButton_2.setBounds(260, 207, 89, 23);
		getContentPane().add(btnNewButton_2);
	}
}

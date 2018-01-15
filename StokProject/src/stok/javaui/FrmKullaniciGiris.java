package stok.javaui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import stok.bll.KullaniciBll;
import stok.entities.Kullanici;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmKullaniciGiris extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtTCKimlikNo;
	private JPasswordField password;
	
	KullaniciBll kullaniciBll=new KullaniciBll();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmKullaniciGiris dialog = new FrmKullaniciGiris();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmKullaniciGiris() {
		setBounds(100, 100, 454, 379);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblIcon = new JLabel("");
			lblIcon.setIcon(new ImageIcon(this.getClass().getResource("/Security2.png")));
			lblIcon.setBounds(51, 35, 128, 128);
			contentPanel.add(lblIcon);
		}
		{
			JLabel lblNewLabel = new JLabel("TC Kimlik No");
			lblNewLabel.setBounds(189, 67, 96, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Parola");
			lblNewLabel_1.setBounds(189, 124, 46, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtTCKimlikNo = new JTextField();
			txtTCKimlikNo.setBounds(266, 64, 86, 20);
			contentPanel.add(txtTCKimlikNo);
			txtTCKimlikNo.setColumns(10);
		}
		{
			password = new JPasswordField();
			password.setBounds(266, 121, 86, 20);
			contentPanel.add(password);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnGiris = new JButton("Giri\u015F");
				btnGiris.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0)
					{
						try 
						{
							if(txtTCKimlikNo.getText().trim().equals(""))
							{
								JOptionPane.showMessageDialog(null, "TC kimlik no giriniz.");
								txtTCKimlikNo.requestFocus();
								return;
							}
							if(String.valueOf(password.getPassword()).equals(""))
							{
								JOptionPane.showMessageDialog(null, "Parolayý giriniz");
								password.requestFocus();
								return;
							}
							boolean donen=new KullaniciBll().KullaniciKontrol(txtTCKimlikNo.getText().trim(),String.valueOf(password.getPassword()));
						    if(donen)
						    {
						    	StokIslemleri frm=new StokIslemleri();
						    	frm.setExtendedState(6);//MAXIMIZED_BOTH-ekraný kaplar
						    	frm.setVisible(true);
						    	setVisible(false);
						    }
						    else
						    {
						    	JOptionPane.showMessageDialog(null, "TC Kimlik No veya Parola yanlýþ!");
						    	txtTCKimlikNo.requestFocus();
						    }
						    
						   
						}							
					
						    catch (Exception e)
						{
							JOptionPane.showMessageDialog(null, "hata:"+e.getMessage());
						}
					}
				});
				btnGiris.setActionCommand("OK");
				btnGiris.setIcon(new ImageIcon( this.getClass().getResource("/Giris.png")));
				buttonPane.add(btnGiris);
				getRootPane().setDefaultButton(btnGiris);
			}
			{
				JButton btnCikis = new JButton("\u00C7\u0131k\u0131\u015F");
				btnCikis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) 
					{
						setVisible(false);
						
					}
				});
				btnCikis.setIcon(new ImageIcon( this.getClass().getResource("/delete.png")));
				btnCikis.setActionCommand("Cancel");
				buttonPane.add(btnCikis);
			}
		}
	}

}


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class SignUP extends JFrame {

	private JPanel contentPane;
	private JTextField fullName;
	private JTextField cnic;
	private JPasswordField password;
	private JPasswordField confirmPassword;
	static ArrayList<Passengers> PassengerList=new ArrayList<Passengers>();
	static JTextField username;
	private JTextField passport;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUP frame = new SignUP();
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
	public SignUP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 436);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(37, 150, 190));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Havayolu Bilgi Yönetim Sistemine Hoşgeldiniz");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(152, 11, 389, 29);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ad Soyad");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(37, 68, 86, 14);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CNIC");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(37, 130, 99, 14);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Şifre");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setBounds(37, 203, 99, 14);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Şifreyi Onayla");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(37, 247, 132, 17);
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel_4);
		
		fullName = new JTextField();
		fullName.setBounds(214, 65, 150, 20);
		contentPane.add(fullName);
		fullName.setColumns(10);
		
		username = new JTextField();
		username.setBounds(214, 96, 150, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		cnic = new JTextField();
		cnic.setBounds(214, 127, 150, 20);
		contentPane.add(cnic);
		cnic.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(214, 200, 150, 20);
		contentPane.add(password);
		
		confirmPassword = new JPasswordField();
		confirmPassword.setBounds(214, 244, 150, 20);
		contentPane.add(confirmPassword);
		
		JButton btnNewButton = new JButton("Kayıt Ol");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
								int chk=0;
				for (int i=0 ; i<password.getText().length() ; i++)
				{
					char check=password.getText().charAt(i);
					
					if (Character.isUpperCase(check)==true)
					{
						chk+=1;
						break;
					}
				}
				
				if(username.getText().equals("") || password.getText().equals("") || cnic.getText().equals("") || fullName.getText().equals("") ||
						confirmPassword.getText().equals("") || passport.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurun.");
				}
				else
				{
					for (Passengers x: PassengerList)
					{
						if (x.getUsername().equals(username.getText()) || x.cnic.equals(cnic.getText()))
						{
							if(x.getUsername().equals(username.getText()))
							{
								JOptionPane.showMessageDialog(null, "Bu kullanıcı adı zaten kayıtlı lütfen başka bir tane seçiniz");
							}
							else if (x.cnic.equals(cnic.getText()))
							{
								JOptionPane.showMessageDialog(null, "Bu CNIC zaten kayıtlı lütfen başka bir tane seçiniz");
							}
						}
					}
				}
				
				if(password.getText().equals(confirmPassword.getText())==false)
				{
					JOptionPane.showMessageDialog(null, "Şifreler eşleşmedi.");
				}
				else
				{
				Passengers obj=new Passengers(fullName.getText(),cnic.getText(),username.getText(),password.getText(),passport.getText());
				PassengerList.add(obj);
			
				Login obj1=new Login();
				obj1.setVisible(true);
				dispose();
				}
			}
		});
		
		btnNewButton.setBounds(387, 348, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
		JLabel lblNewLabel_5 = new JLabel("Kullanıcı Adı");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(37, 99, 96, 14);
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton("Geri");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login obj=new Login();
				
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(503, 348, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("Pasaport");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setForeground(new Color(0, 0, 0));
		lblNewLabel_6.setBounds(37, 155, 99, 29);
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel_6);
		
		passport = new JTextField();
		passport.setBounds(214, 163, 150, 20);
		contentPane.add(passport);
		passport.setColumns(10);
	}
}

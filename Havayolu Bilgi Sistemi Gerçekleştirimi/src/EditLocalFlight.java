
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class EditLocalFlight extends JFrame {

	private JPanel contentPane;
	private JTextField flightID;
	private JTextField flightTime;
	private JTextField flightDate;
	private JTextField departCity;
	private JTextField landCity;
	private JTextField economySeats;
	private JTextField businessSeats;
	private JTextField distance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditLocalFlight frame = new EditLocalFlight();
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
	public EditLocalFlight() {
		setBackground(new Color(37, 150, 190));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 382);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(37, 150, 190));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Uçuşu Düzenle");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 20);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Uçuş ID");
		lblNewLabel_1.setBounds(10, 36, 113, 14);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Saat");
		lblNewLabel_2.setBounds(10, 61, 113, 14);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tarih");
		lblNewLabel_3.setBounds(10, 86, 113, 14);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Kalkış Şehri");
		lblNewLabel_4.setBounds(10, 111, 113, 14);
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Varış Şehri");
		lblNewLabel_5.setBounds(10, 136, 113, 14);
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Economy Koltuk");
		lblNewLabel_6.setBounds(10, 161, 113, 14);
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Business Koltuk");
		lblNewLabel_7.setBounds(10, 186, 113, 14);
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel_7);
		
		flightID = new JTextField();
		flightID.setBounds(133, 33, 86, 20);
		contentPane.add(flightID);
		flightID.setColumns(10);
		
		flightTime = new JTextField();
		flightTime.setBounds(133, 58, 86, 20);
		contentPane.add(flightTime);
		flightTime.setColumns(10);
		
		flightDate = new JTextField();
		flightDate.setBounds(133, 83, 86, 20);
		contentPane.add(flightDate);
		flightDate.setColumns(10);
		
		departCity = new JTextField();
		departCity.setBounds(133, 108, 86, 20);
		contentPane.add(departCity);
		departCity.setColumns(10);
		
		landCity = new JTextField();
		landCity.setBounds(133, 133, 86, 20);
		contentPane.add(landCity);
		landCity.setColumns(10);
		
		economySeats = new JTextField();
		economySeats.setBounds(133, 158, 86, 20);
		contentPane.add(economySeats);
		economySeats.setColumns(10);
		
		businessSeats = new JTextField();
		businessSeats.setBounds(133, 183, 86, 20);
		contentPane.add(businessSeats);
		businessSeats.setColumns(10);
		
		JButton btnNewButton = new JButton("Tamamla");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (flightID.getText().equals("") || flightTime.getText().equals("") || flightDate.getText().equals("") || departCity.getText().equals("") || 
						landCity.getText().equals("") || economySeats.getText().equals("") || businessSeats.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Alanlar boş bırakılamaz");
				}
				else if(economySeats.getText().matches("^\\d+(\\.\\d+)?")==false)
				{
					JOptionPane.showMessageDialog(null, "Lütfen Economy koltuk sayısı için tam sayı değeri giriniz.");
				}
				else if(businessSeats.getText().matches("^\\d+(\\.\\d+)?")==false)
				{
					JOptionPane.showMessageDialog(null, "Lütfen Business koltuk sayısı için tam sayı değeri giriniz.");
				}
				else if(distance.getText().matches("^\\d+(\\.\\d+)?")==false)
				{
					JOptionPane.showMessageDialog(null, "Lütfen uçuş süresi için tam sayı değeri giriniz.");
				}
				else if (Integer.parseInt(economySeats.getText())>50)
				{
					JOptionPane.showMessageDialog(null, "Economy koltuk sayısı 50'den büyük olamaz");
				}
				else if (Integer.parseInt(businessSeats.getText())>10)
				{
					JOptionPane.showMessageDialog(null, "Business koltuk sayısı 10'dan büyük olamaz");
				}
				else
				{
					int row=LocalFlightSchedule.table.getSelectedRow();
					System.out.println(row);
					LocalFlightSchedule.table.setValueAt(flightID.getText(), row, 0);
					LocalFlightSchedule.table.setValueAt(flightTime.getText(), row, 1);
					LocalFlightSchedule.table.setValueAt(flightDate.getText(), row , 2);
					LocalFlightSchedule.table.setValueAt(departCity.getText(), row , 3);
					LocalFlightSchedule.table.setValueAt(landCity.getText(), row , 4);
					LocalFlightSchedule.table.setValueAt(economySeats.getText(), row , 5);
					LocalFlightSchedule.table.setValueAt(businessSeats.getText(),row , 6);
					LocalFlightSchedule.table.setValueAt(distance.getText(), row , 7);
	      	 		
	      	 		Flight objnew=new Flight(flightID.getText() , flightTime.getText() , flightDate.getText() , departCity.getText() , landCity.getText() , economySeats.getText()
	      	 				, businessSeats.getText() , distance.getText());
	      	 		LocalFlightSchedule.flightList.set((row), objnew);
	      	 		JOptionPane.showMessageDialog(null, "Uçuş Başarıyla Güncellendi");
					
	      	 		LocalFlightSchedule obj=new LocalFlightSchedule();
					obj.setVisible(true);
					dispose();
				}
				
				
			}
		});
		btnNewButton.setBounds(255, 207, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_8 = new JLabel("Uçuş Süresi");
		lblNewLabel_8.setBounds(10, 211, 113, 14);
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel_8);
		
		distance = new JTextField();
		distance.setBounds(133, 208, 86, 20);
		contentPane.add(distance);
		distance.setColumns(10);
		
		
	}

}

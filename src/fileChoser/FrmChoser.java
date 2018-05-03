package fileChoser;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FileChooserUI;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmChoser extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmChoser frame = new FrmChoser();
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
	public FrmChoser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtPath = new JTextArea();
		txtPath.setFont(new Font("Monospaced", Font.BOLD, 40));
		txtPath.setBounds(10, 11, 389, 196);
		contentPane.add(txtPath);
		
		JButton btnChosefile = new JButton("ChoseFile");
		btnChosefile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("ImageFiles", "jpg");
				fc.setFileFilter(filter);
				fc.showDialog(btnChosefile, "ChoseFile");
				String path =txtPath.getText() +"/n"+fc.getSelectedFile().toString();
				txtPath.setText(path);
			}
		});
		btnChosefile.setBounds(151, 218, 89, 23);
		contentPane.add(btnChosefile);
	}
}

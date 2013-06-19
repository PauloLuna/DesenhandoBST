import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import java.awt.SystemColor;


public class MenuFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4802543776519360897L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuFrame frame = new MenuFrame();
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
	public MenuFrame() {
		setTitle("Floresta (by: jpsl2)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 177);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnBst = new JButton("BST");
		btnBst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				(new BSTFrame()).setVisible(true);
			}
		});
		
		JEditorPane dtrpnBemVindoA = new JEditorPane();
		dtrpnBemVindoA.setBackground(SystemColor.menu);
		dtrpnBemVindoA.setEditable(false);
		dtrpnBemVindoA.setContentType("text/html");
		dtrpnBemVindoA.setFont(new Font("Arial", Font.PLAIN, 18));
		dtrpnBemVindoA.setText("<div style=\"width: 220px;text-align:center; font-family:arial; font-size:18px;\">Bem vindo a floresta! \r\nEscolha seu tipo de \u00C1rvore.</div>");
		contentPane.add(dtrpnBemVindoA);
		btnBst.setFont(new Font("Arial Black", Font.PLAIN, 18));
		contentPane.add(btnBst);
		
		JButton btnAvl = new JButton("AVL");
		btnAvl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				(new AVLFrame()).setVisible(true);
			}
		});
		btnAvl.setFont(new Font("Arial Black", Font.PLAIN, 18));
		contentPane.add(btnAvl);
	}

}

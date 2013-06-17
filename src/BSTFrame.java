import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JEditorPane;
import javax.swing.DropMode;
import java.awt.SystemColor;
import javax.swing.JScrollPane;


public class BSTFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2770656510919669272L;
	public Head head;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BSTFrame frame = new BSTFrame();
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
	public BSTFrame() {
		setTitle("Desenhando sua BST (by: jpsl2)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 450);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JLabel lblAdcioneSeusValores = new JLabel("Adicione seus valores (ou remova):");
		panel.add(lblAdcioneSeusValores);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAddAction();
			}			
		});
		panel.add(btnAdd);
		
		JButton btnDel = new JButton("Del");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnDelAction();
			}
		});
		panel.add(btnDel);
		
		head = new Head();
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane);
		
		JEditorPane dtrpnTesteeee = new JEditorPane();
		dtrpnTesteeee.setBackground(SystemColor.menu);
		dtrpnTesteeee.setEditable(false);
		dtrpnTesteeee.setText("Testeeee");
		scrollPane.setViewportView(dtrpnTesteeee);
		
		JLabel lblNewLabel = new JLabel("Inser\u00E7\u00E3o:                               ");
		panel_2.add(lblNewLabel, BorderLayout.NORTH);
		JPanel panel_1 = new PanelBST(head);
		getContentPane().add(panel_1, BorderLayout.CENTER);
	}

	private void btnAddAction() {
		// TODO Auto-generated method stub
		//Checa se a árvore já tem uma raiz se não tiver cria, se tiver insere em uma folha
		if(head.bst==null){
			head.bst = new BST(Integer.parseInt(textField.getText()));
			
		} else{
			head.bst.inserir(Integer.parseInt(textField.getText()));
		}
		repaint();
	}
	
	private void btnDelAction() {
		// TODO Auto-generated method stub
		if(head.bst!=null){
			head.bst = head.bst.remover(Integer.parseInt(textField.getText()));
		}
		repaint();
	}
	
}



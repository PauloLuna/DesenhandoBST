import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class BSTFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2770656510919669272L;
	public Head head;
	private JTextField textField;

	
	/**
	 * Create the frame.
	 */
	public BSTFrame() {
		setTitle("Desenhando sua BST (by: jpsl2)");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		JPanel panel_1 = new PanelBST(head);
		getContentPane().add(panel_1, BorderLayout.CENTER);
	}

	private void btnAddAction() {
		// TODO Auto-generated method stub
		//Checa se a árvore já tem uma raiz se não tiver cria, se tiver insere em uma folha
		if(head.arvore==null){
			head.arvore = new BST(Integer.parseInt(textField.getText()));
			
		} else{
			((BST) head.arvore).inserir(Integer.parseInt(textField.getText()));
		}
		repaint();
	}
	
	private void btnDelAction() {
		// TODO Auto-generated method stub
		if(head.arvore!=null){
			head.arvore = ((BST) head.arvore).remover(Integer.parseInt(textField.getText()));
		}
		repaint();
	}
	
}



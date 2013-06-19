import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class AVLFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6223682862336473201L;
	private Head head;
	private JTextField textField;

	
	/**
	 * Create the frame.
	 */
	public AVLFrame() {
		setTitle("Desenhando sua AVL (by: jpsl2)");
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
		
		JButton btnBal = new JButton("Bal");
		btnBal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnBalAction();
			}			
		});
		panel.add(btnBal);
		
		head = new Head();
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane);
		
		JEditorPane dtrpnA = new JEditorPane();
		dtrpnA.setContentType("text/html");
		dtrpnA.setBackground(SystemColor.menu);
		dtrpnA.setText("<div style=\"width :90px\">Aqui voc\u00EA pode visualizar sua pr\u00F3pria AVL.<br/>-Os n\u00F3s <span style=\"background-color:green\">verdes</span> tem fator de bala\u00E7o zero;<br/>-Os <span style=\"background-color:yellow\">amarelos</span> 1 ou -1;<br/>-E os <span style=\"background-color:red\">vermelhos</span> est\u00E3o desbalanceados.<br/>Se um n\u00F3 estiver desbalanceado voc\u00EA ter\u00E1 que rebalancear a \u00E1rvore.<br/>Mas n\u00E3o se preocupe isso \u00E9 f\u00E1cil(sqn), \u00E9 s\u00F3 clicar no bot\u00E3o [Bal] logo abaixo.</div>");
		dtrpnA.setEditable(false);
		scrollPane.setViewportView(dtrpnA);
		
		JLabel lblNewLabel = new JLabel("Instru\u00E7\u00F5es:");
		panel_2.add(lblNewLabel, BorderLayout.NORTH);
		JPanel panel_1 = new PanelBST(head);
		getContentPane().add(panel_1, BorderLayout.CENTER);
	}

	private void btnAddAction() {
		// TODO Auto-generated method stub
		//Checa se a árvore já tem uma raiz se não tiver cria, se tiver insere em uma folha
		if(head.arvore==null){
			head.arvore = new AVL(Integer.parseInt(textField.getText()));
			
		} else{
			if(((AVL) head.arvore).isBalanced())
				((AVL) head.arvore).inserir(Integer.parseInt(textField.getText()));
		}
		repaint();
	}
	
	private void btnDelAction() {
		// TODO Auto-generated method stub
		if(head.arvore!=null){
			if(((AVL) head.arvore).isBalanced())
				head.arvore = ((AVL) head.arvore).remover(Integer.parseInt(textField.getText()));
		}
		repaint();
	}
	
	private void btnBalAction() {
		
		if(head.arvore!=null){
			head.arvore = ((AVL) head.arvore).balanciamento();
		}
		repaint();
	}
	
}



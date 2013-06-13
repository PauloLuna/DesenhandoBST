import java.awt.Graphics;
import javax.swing.JPanel;


public class PanelBST extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7007979979472887556L;

	public static int y = 40;
	
	public Head head;
	/**
	 * Create the panel.
	 */
	public PanelBST(Head head) {
		this.head = head;
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		//Se a árvore já existir manda ela imprimir suas partes
		super.paint(g);
		if(head.bst!=null)
		head.bst.paint(g, this.getWidth()/2, y);//manda o centro da tela no eixo x e um valor padrão no eixo y
												//como posição inicial para pintar o root
		
	}

}

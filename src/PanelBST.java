import java.awt.Color;
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
		if(head.arvore!=null){
			int i = 1, apoio  = 0;
			apoio= this.getWidth()/40;
			if(head.arvore instanceof AVL){
				if(!((AVL)head.arvore).isBalanced()){
					g.setColor(Color.RED);
					g.drawString("Xiii! tá tudo bagunçado. Dá uma balanciada nisso!", 20, 20);
				}
			}
			while(i*2<apoio)i*=2;
			((Imprimivel) head.arvore).paint(g, this.getWidth()/2, y, i/2);//manda o centro da tela no eixo x e um valor padrão no eixo y
																	//como posição inicial para pintar o root
		}
												
		
	}

}

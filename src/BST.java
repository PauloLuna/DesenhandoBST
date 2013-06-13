import java.awt.Graphics;

//Essa � uma BST bem simples s� tem o m�todo inserir e um paint 
//pra desenhar seus n�s na mesma forma que est�o estruturados
public class BST {

	public BST left;
	public BST right;
	public int value;
	
	public BST(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	public void inserir(int value){
		if(value<this.value){
			if(left == null){
				BST no = new BST(value);
				left = no;
			} else {
				this.left.inserir(value);
			}
		} else {
			if(right == null){
				BST no = new BST(value);
				right = no;
			} else {
				this.right.inserir(value);
			}
		}
	}
	
	public void paint(Graphics g, int x, int y){
		/*
		 * Esse � o m�todo que desenha tudo,
		 * ele � pequeno porque � recursivo,
		 * cada n� desenha a si pr�prio e faz as
		 * retas para as duas sub-�rvores se existirem
		 */
		

		g.drawRect(x, y, 20, 20);//cada ret�ngulo tem 20x20
		g.drawString(""+value, x+3, y+15);//coloca o texto no centro do ret�ngulo do n�
										//funciona bem para valores de at� 2 digitos
		if(this.left != null){
			/*
			 * se tiver sub-�rvore a esquerda desenha uma linha para ela
			 * e manda o pr�ximo n� continuar a impress�o
			 * passando as novas coordenadas para ele
			 */
			g.drawLine(x, y+20, x-20, y+40);
			left.paint(g, x-40, y+40);
		}
		if(this.right != null){
			/*
			 * faz o mesmo que o if acima por�m com a sub-�rvore a direita
			 */
			g.drawLine(x+20, y+20, x+40, y+40);
			right.paint(g, x+40, y+40);
		}
	}
}

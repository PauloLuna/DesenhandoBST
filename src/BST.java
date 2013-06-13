import java.awt.Graphics;

//Essa é uma BST bem simples só tem o método inserir e um paint 
//pra desenhar seus nós na mesma forma que estão estruturados
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
		 * Esse é o método que desenha tudo,
		 * ele é pequeno porque é recursivo,
		 * cada nó desenha a si próprio e faz as
		 * retas para as duas sub-árvores se existirem
		 */
		

		g.drawRect(x, y, 20, 20);//cada retângulo tem 20x20
		g.drawString(""+value, x+3, y+15);//coloca o texto no centro do retângulo do nó
										//funciona bem para valores de até 2 digitos
		if(this.left != null){
			/*
			 * se tiver sub-árvore a esquerda desenha uma linha para ela
			 * e manda o próximo nó continuar a impressão
			 * passando as novas coordenadas para ele
			 */
			g.drawLine(x, y+20, x-20, y+40);
			left.paint(g, x-40, y+40);
		}
		if(this.right != null){
			/*
			 * faz o mesmo que o if acima porém com a sub-árvore a direita
			 */
			g.drawLine(x+20, y+20, x+40, y+40);
			right.paint(g, x+40, y+40);
		}
	}
}

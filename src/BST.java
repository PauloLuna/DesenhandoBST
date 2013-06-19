import java.awt.Graphics;


//Essa é uma BST bem simples só tem o método inserir e um paint 
//pra desenhar seus nós na mesma forma que estão estruturados
public class BST implements Imprimivel{
	
	public BST left;
	public BST right;
	public int value;
	
	public BST(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	public BST inserir(int value){
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
		return this;
	}
	
	public BST remover(int value){//essa é uma adaptação do alg visto em sala a lógica é a mesma
		if(this.value>value){
			if(this.left!=null){
				this.left = this.left.remover(value);
			} else {
				this.left = null;
			}
			return this;
		} else if(this.value<value){
			if(this.right!=null){
				this.right = this.right.remover(value);
			} else {
				this.right = null;
			}
			return this;
		} else {//this.value == value
			BST r = null;
			if(this.left == null){
				r = this.right;
			} else if(this.right == null){
				r = this.left;
			} else {
				RetDeleteMin ret = this.right.deleteMin();//Essa classe foi criada no fim desse arquivo
				this.right = ret.bst;
				this.value = ret.val;
				r = this;
			}
			return r;
		}
	}
	
	private RetDeleteMin deleteMin(){//O método que substitui o nó pelo menor da direita
		RetDeleteMin  r= null;
		
		if(this.left == null){
			r = new RetDeleteMin(this.right, this.value);
		} else {
			r = this.left.deleteMin();
			this.left = r.bst;
			r.bst = this;
		}
		
		return r;
	}
	
	public void paint(Graphics g, int x, int y, int lineSize){
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
			g.drawLine(x, y+20, x-lineSize*20 +20, y+60);
			left.paint(g, x-lineSize*20, y+60, lineSize/2);
		}
		if(this.right != null){
			/*
			 * faz o mesmo que o if acima porém com a sub-árvore a direita
			 */
			g.drawLine(x+20, y+20, x+lineSize*20, y+60);
			right.paint(g, x+lineSize*20, y+60, lineSize/2);
		}
	}
	
}

class RetDeleteMin{
	/*
	 * Classe criada pra poder retornar os dois valores
	 * exigidos pelo método deleteMin()
	 */
	public BST bst;
	public int val;
	public RetDeleteMin(BST bst, int val){
		this.bst = bst;
		this.val = val;
	}
}

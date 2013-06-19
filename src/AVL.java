import java.awt.Color;
import java.awt.Graphics;


public class AVL implements Imprimivel{
	public AVL left, right;
	public int value;

	public AVL(int value) {
		this.value = value;
		this.left = null;
		this.right = null;		
	}

	public void inserir(int value) {
		if(value<this.value){
			if(left == null){
				AVL no = new AVL(value);
				left = no;
			} else {
				this.left.inserir(value);
			}
		} else if(value>this.value){
			if(right == null){
				AVL no = new AVL(value);
				right = no;
			} else {
				this.right.inserir(value);
			}
		}
	}

	public AVL remover(int value){//essa é uma adaptação do alg visto em sala para BST a lógica é a mesma
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
			AVL r = null;
			if(this.left == null){
				r = this.right;
			} else if(this.right == null){
				r = this.left;
			} else {
				RetDeleteMin2 ret = this.right.deleteMin();//Essa classe foi criada no fim desse arquivo
				this.right = ret.avl;
				this.value = ret.val;
				r = this;
			}
			return r;
		}
	}

	private RetDeleteMin2 deleteMin(){//O método que substitui o nó pelo menor da direita
		RetDeleteMin2  r= null;

		if(this.left == null){
			r = new RetDeleteMin2(this.right, this.value);
		} else {
			r = this.left.deleteMin();
			this.left = r.avl;
			r.avl = this;
		}

		return r;
	}

	public AVL rotateSimplesDireita(){
		AVL lr, l;
		lr = this.left.right;
		l = this.left;
		l.right = this;
		this.left = lr;
		return l;
	}

	public AVL rotateSimplesEsquerda(){
		AVL rl, r;
		rl = this.right.left;
		r = this.right;
		r.left = this;
		this.right = rl;
		return r;
	}

	public AVL rotateDuplaDireita(){
		this.left = this.left.rotateSimplesEsquerda();
		return this.rotateSimplesDireita();
	}

	public AVL rotateDuplaEsquerda(){
		this.right = this.right.rotateSimplesDireita();
		return this.rotateSimplesEsquerda();
	}
	
	public boolean isBalanced(){
		int bf = this.bf();
		if(bf == 2 || bf==-2){
			return false;
		} else if(this.right == null && this.left == null){
			return true;
		} else if(this.right == null){
			return this.left.isBalanced();
		} else if(this.left == null){
			return this.right.isBalanced();
		} else {
			return this.right.isBalanced()&&this.left.isBalanced();
		}
	}

	public AVL balanciamento(){
		if(this.left != null){
			this.left = this.left.balanciamento();
		}
		if(this.right != null){
			this.right = this.right.balanciamento();
		}
		int bf = this.bf();
		if(bf == 2){
			int rbf = this.right.bf();
			if(rbf==-1){
				return this.rotateDuplaEsquerda();
			} else {
				return this.rotateSimplesEsquerda();
			}
		} else if(bf == -2){
			int lbf = this.left.bf();
			if(lbf == 1){
				return this.rotateDuplaDireita();
			} else {
				return this.rotateSimplesDireita();
			}
		}
		return this;
	}

	public int altura(){
		int esquerda = 0, direita = 0;
		if(this.left != null){
			esquerda = this.left.altura();
		}
		if(this.right != null){
			direita = this.right.altura();
		}
		if(esquerda>direita){
			return 1 + esquerda;
		} else {
			return 1 + direita;
		}
	}

	public int bf(){
		if((this.right == null)&&(this.left == null)){
			return 0;
		} else if(this.right == null){
			return - this.left.altura();
		} else if(this.left == null){
			return this.right.altura();
		} else {
			return this.right.altura() - this.left.altura();
		}
	}

	public void paint(Graphics g, int x, int y, int lineSize){
		/*
		 * Esse é o método que desenha tudo,
		 * ele é pequeno porque é recursivo,
		 * cada nó desenha a si próprio e faz as
		 * retas para as duas sub-árvores se existirem
		 */

		int a = this.bf();
		switch(a){
		case 0:
			g.setColor(Color.GREEN);
			g.fillRect(x, y, 20, 20);
			break;
		case 1:
		case -1:
			g.setColor(Color.YELLOW);
			g.fillRect(x, y, 20, 20);
			break;
		case 2:
		case -2:
			g.setColor(Color.RED);
			g.fillRect(x, y, 20, 20);
			g.drawArc(x-10, y-13, 40, 40,0, 70);
			if(a==2){
				int[]a1 = {x+20,x+15,x+20};
				int[]b = {y-15, y-10, y-3};
				g.fillPolygon(a1, b,3);
			} else {
				int[]a1 = {x+26,x+31,x+36};
				int[]b = {y+7, y+12, y+7};
				g.fillPolygon(a1, b,3);
			}
			
		}
		g.setColor(Color.BLACK);
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

class RetDeleteMin2{
	/*
	 * Classe criada pra poder retornar os dois valores
	 * exigidos pelo método deleteMin()
	 */
	public AVL avl;
	public int val;
	public RetDeleteMin2(AVL avl, int val){
		this.avl = avl;
		this.val = val;
	}
}

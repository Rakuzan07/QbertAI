package logic;

public class Position {
		
		public String toString() {
			return "Position [x=" + x + ", y=" + y + "]";
		}

		private int x , y;
		
		public Position (int x ,  int y){
			this.x=x;
			this.y=y;
		}
		
		public Position (Position p){
			this.x=p.x;
			this.y=p.y;
		}
		
		public void add(int x, int y){
			this.x=this.x+x;
			this.y=this.y-y;
		}
		
		public void divide(int div) {
			x=x/div;
			y=y/div;
		}
		
		public void mul(int mul) {
			this.x=x*mul;
			this.y=y*mul;
		}
		
		public void setX(int x){
			this.x=x;
		}
		
		public void setY(int y){
			this.y=y;
		}
		
		public int getX(){
			return x;
		}
		
		public int getY(){
			return y;
		}

		
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		public boolean equals(Object obj) {
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Position other = (Position) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		
		public double shift(Position position) {  //DISTANZA DA UN PUNTO AD UN ALTRO
			return Math.sqrt(Math.pow(x-position.x,2)+Math.pow(y-position.y,2));
		}

	}



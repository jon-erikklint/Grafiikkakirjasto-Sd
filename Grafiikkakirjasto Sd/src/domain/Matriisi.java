package domain;

public class Matriisi {
	
	double[][] matriisi;
	
	public Matriisi(int riveja, int sarakkeita){
		matriisi = new double[riveja][sarakkeita];
	}
	
	public Matriisi(double[][] matriisi){
		this.matriisi = matriisi;
	}
	
	public void summaa(Matriisi other){
		if(other.x() == this.x() &&
		   other.y() == this.y()){
			for(int i=0; i < this.y(); i++){
				for(int j=0; j < this.x(); i++){
					this.matriisi[i][j] += other.matriisi[i][j];
					}
				}
			}
	}
	
	public Matriisi summa(Matriisi other){
		if(other.x() == this.x() &&
			other.y() == this.y()){
			Matriisi palautettava = new Matriisi(this.y(), this.x());
			for(int i=0; i < this.y(); i++){
				for(int j=0; j < this.x(); i++){
					palautettava.matriisi[i][j] =  + matriisi[i][j];
				}
			}
			return palautettava;
		}
		return null;
	}
	
	public Matriisi tulo(Matriisi other){
		if(other.x() == this.y()){
			Matriisi palautettava = new Matriisi(this.y(), this.x());
			for(int i=0; i < other.y(); i++){
				for(int j=0; j < this.x(); i++){
					
				}
			}
		}
		return null;
	}
	
	public int y(){
		return this.matriisi.length;
	}
	
	public int x(){
		return this.matriisi[0].length;
	}

}

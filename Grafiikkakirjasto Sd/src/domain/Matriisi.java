package domain;
//Tämä on math-riisi
public class Matriisi {
	
	int[][] matriisi;
	
	public Matriisi(int y, int x){
		matriisi = new int[y][x];
	}
	
	public Matriisi(int[][] matriisi){
		this.matriisi = matriisi;
	}
	
	public void apply(int poo){
		matriisi[0][0] += poo;
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
	
	public Matriisi tulo(Matriisi other){ //KESKENNENENENENNERNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN!
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

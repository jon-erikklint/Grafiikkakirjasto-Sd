package domain;

public class Vektori {
    
    private double X;
    private double Y;
    
    public Vektori(double x, double y){
        X=x;
        Y=y;
    }
    
    public Vektori(){
        this(0,0);
    }
    
    public void summaa(Vektori vektori){
        this.X += vektori.X;
        this.Y += vektori.Y;
    }
    
    public Vektori summa(Vektori vektori){
        return new Vektori(this.X + vektori.X, this.Y + vektori.Y);
    }
    
    public void vahenna(Vektori vektori){
        this.X -= vektori.X;
        this.Y -= vektori.Y;
    }
    
    public Vektori erotus(Vektori vektori){
        return new Vektori(this.X - vektori.X, this.Y - vektori.Y);
    }
    
    public void skaalaa(Vektori vektori){
        this.X = this.X * vektori.X;
        this.Y = this.Y * vektori.Y;
    }
    
    public Vektori skaalaus(Vektori vektori){
        return new Vektori(this.X * vektori.X, this.Y * vektori.Y);
    }
    
    public double pistetulo(Vektori vektori){
        return this.X * vektori.X + this.Y * vektori.Y;
    }
    
    public double etaisyys(Vektori vektori){
        return Math.sqrt((this.X-vektori.X)*(this.X-vektori.X)+(this.Y-vektori.Y)*(this.Y-vektori.Y));
    }
    
    public Vektori yksikkovektori(){
        double x = X / this.etaisyys(new Vektori());
        double y = Y / this.etaisyys(new Vektori());
        return new Vektori(x, y);
    }
    
    public void skalaarikerro(double kerroin){
        this.X *= kerroin;
        this.Y *= kerroin;
    }
    
    public Vektori skalaaritulo(double kerroin){
        return new Vektori( this.X * kerroin, this.Y * kerroin);
    }
    
    public Vektori kloonaa(){
        return new Vektori(X, Y);
    }
    
    public double pituus(){
        return etaisyys(new Vektori());
    }
    
    public void kierra(double kulma){
        Vektori kierto = this.kierto(kulma);
        this.X = kierto.X;
        this.Y = kierto.Y;
    }
    
    public Vektori kierto(double kulma){
        double cos = Math.cos(kulma);
        double sin = Math.sin(kulma);
        
        return new Vektori( X*cos - Y*sin, X*sin + Y*cos );
    }

    public double getX() {
        return X;
    }

    public void setX(float X) {
        this.X = X;
    }

    public double getY() {
        return Y;
    }

    public void setY(float Y) {
        this.Y = Y;
    }
    
    
    
}

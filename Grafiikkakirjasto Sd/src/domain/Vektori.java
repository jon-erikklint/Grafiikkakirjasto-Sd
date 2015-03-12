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
    
    /**
     * Skaalaa vektorin X- ja Y-komponentit annetun vektorin vastaavilla komponenetilla.
     * @param vektori 
     */
    public void skaalaa(Vektori vektori){
        this.X = this.X * vektori.X;
        this.Y = this.Y * vektori.Y;
    }
    
    /**
     * Palauttaa vektorin skaalattuna annetulla vektorilla.
     * @param vektori
     * @return 
     */
    public Vektori skaalaus(Vektori vektori){
        return new Vektori(this.X * vektori.X, this.Y * vektori.Y);
    }
    
    /**
     * Skaalaa vektorin annetun kertoimella.
     * @param kerroin 
     */
    public void skaalaa(double kerroin){
        X = kerroin*X;
        Y = kerroin*Y;
    }
    
    /**
     * Palauttaa vektorin skaalattuna annetulla kertoimella.
     * @param kerroin
     * @return 
     */
    public Vektori skaalaus(double kerroin){
        return new Vektori(kerroin*this.X, kerroin*this.Y);
    }
    
    /**
     * Palauttaa vektorin pistetulon annetun vektorin kanssa.
     * @param vektori
     * @return 
     */
    public double pistetulo(Vektori vektori){
        return this.X * vektori.X + this.Y * vektori.Y;
    }
    
    /**
     * Palauttaa vektorin etäisyyden annetusta vektorista.
     * @param vektori
     * @return 
     */
    public double etaisyys(Vektori vektori){
        return this.erotus(vektori).pituus();
    }
    
    /**
     * Palauttaa vektorin suuntaisen yksikkövektorin.
     * @return 
     */
    public Vektori yksikkovektori(){
        double x = X / this.pituus();
        double y = Y / this.pituus();
        return new Vektori(x, y);
    }
    
    public void skalaarikerro(double kerroin){
        this.X *= kerroin;
        this.Y *= kerroin;
    }
    
    public Vektori skalaaritulo(double kerroin){
        return new Vektori( this.X * kerroin, this.Y * kerroin);
    }
    
    /**
     * Palauttaa itsestä kloonin.
     * @return this
     */
    public Vektori klooni(){
        return new Vektori(X, Y);
    }
    
    /**
     * Kloonaa itsensä annetuksi vektoriksi.
     * @param vektori 
     */
    public void kloonaa(Vektori vektori){
        this.X = vektori.X;
        this.Y = vektori.Y;
    }
    
    /**
     * Kiertää vektoria annetulla kulmalla.
     * @param kulma 
     */
    public void kierra(double kulma){
        Vektori kierto = this.kierto(kulma);
        this.kloonaa(kierto);
    }
    
    /**
     * Palauttaa vektorin kierrettynä annetulla kulmalla.
     * @param kulma
     * @return Kierretty vektori
     */
    public Vektori kierto(double kulma){
        double cos = Math.cos(kulma);
        double sin = Math.sin(kulma);
        
        return new Vektori( X*cos - Y*sin, X*sin + Y*cos );
    }
    
    /**
     * Kiertää vektoria annetulla kulmalla annetun pisteen suhteen.
     * @param piste
     * @param kulma 
     */
    public void kierra(Vektori piste, double kulma){
        this.kloonaa(this.kierto(piste, kulma));
    }
    
    /**
     * Palauttaa vektorin kierrettynä annetulla kulmalla annetun pisteen suhteen.
     * @param piste
     * @param kulma
     * @return Kierretty vektori
     */
    public Vektori kierto(Vektori piste, double kulma){
        Vektori erotus = this.getSijainti(piste);
        erotus.kierra(kulma);
        erotus.summaa(piste);
        return erotus;
    }

    public double pituus() {
        return Math.sqrt(X*X + Y*Y);
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
    
    /**
     * Palauttaa vektorin sijainnin annetun vektorin suhteen.
     * @param piste
     * @return 
     */
    public Vektori getSijainti(Vektori piste){
        return piste.erotus(this);
    }
    
}

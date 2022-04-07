package sistemapagos.apiPagos.models;

public class Operacion {
    public final int valor;
    public final float importeTotal;
    public final String marca;
    private float tasa;

    public Operacion(int valor, String marca, float tasa,float importeTotal) {
        this.valor = valor;
        this.marca = marca;
        this.tasa = tasa;
        this.importeTotal = importeTotal;
    }


    public float getTasa() {
        return this.tasa;
    }

    public void setTasa(float tasa) {
        this.tasa = tasa;
    }

    

    public int getValor() {
        return this.valor;
    }

    

    public String getMarca() {
        return this.marca;
    }

    
}


package projeto1;


public class Estoque {
    
    private int trigo;
    private int sal;
    private int acucar;
    private int paoProduzido;
    private int paoVendido;

    public Estoque(int trigo, int sal, int acucar, int paoProduzido, int paoVendido) {
        this.trigo = trigo;
        this.sal = sal;
        this.acucar = acucar;
        this.paoProduzido = paoProduzido;
        this.paoVendido = paoVendido;
    }

    public int getPaoVendido() {
        return paoVendido;
    }

    public void setPaoVendido(int paoVendido) {
        this.paoVendido = paoVendido;
    }
    
    
    public int getTrigo() {
        return trigo;
    }

    public void setTrigo(int trigo) {
        this.trigo = trigo;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public int getAcucar() {
        return acucar;
    }

    public void setAcucar(int acucar) {
        this.acucar = acucar;
    }

    public int getPaoProduzido() {
        return paoProduzido;
    }

    public void setPaoProduzido(int paoProduzido) {
        this.paoProduzido = paoProduzido;
    }
    
    
     @Override
    public String toString() {
        int acucar1 = this.getAcucar();
        int trigo2 = this.getTrigo();
        int sal2 = this.getSal();                    
        int kilos1 = acucar1 / 1000;
        int gramas1 = acucar1 % 1000;
        int kilos2 = trigo2 / 1000;
        int gramas2 = trigo2 % 1000;
        int kilos3 = sal2 / 1000;
        int gramas3 = sal2 % 1000;
        
        return ("Trigo: " + kilos2 + "," + gramas2 + " Kgs\n" + 
                            "Açúcar: " + kilos1 + "," + gramas1 + " Kgs\n" +
                             "Sal: " + kilos3 + "," + gramas3 + " Kgs\n");
    }

}
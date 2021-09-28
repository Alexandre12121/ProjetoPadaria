package projeto1;


public class Funcionario extends Padeiro{
    
    private int valor;

    public Funcionario(int valor, String login, String senha) {
        super(login, senha);
        this.valor = valor;
    }

    
    

    public Funcionario(String login, String senha) {
        super(login, senha);
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        int valor = this.getValor();
        int kilos2 = valor / 100;
        int gramas2 = valor % 100;    
        
        return ("Valor total vendido: " + "R$"+ kilos2 + "," + gramas2);
    }

   
    
    
    
}

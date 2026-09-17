package pcmania.casca;

public class Cliente {

    private String nome;
    private String cpf;
    private Computador[] computadores;
    private int quantidade;
    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.computadores = new Computador[10];
        this.quantidade = 0;
    }
    public void adicionarComputador(Computador pc) {
        if (quantidade < 10) {
            computadores[quantidade] = pc;
            quantidade++;
        }
    }
    public float calculaTotalCompra() {
        float total = 0.0f;
        for (int i = 0; i < quantidade; i++) {
            total += computadores[i].getPreco();
        }
        return total;
    }
    public Computador[] getComputadores() {
        return computadores;
    }
    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public int getQuantidade() {
        return quantidade;
    }
}

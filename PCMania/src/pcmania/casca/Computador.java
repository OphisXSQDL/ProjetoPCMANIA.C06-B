package pcmania.casca;

public class Computador {

    private String marca;
    private float preco;
    private HardwareBasico[] hardwares;
    private SistemaOperacional sistemaOperacional;
    private MemoriaUSB memoriaUSB;

    public Computador(String marca, float preco, SistemaOperacional sistemaOperacional, HardwareBasico[] hardwares) {
        this.marca = marca;
        this.preco = preco;
        this.sistemaOperacional = sistemaOperacional;
        this.hardwares = hardwares;
    }

    public void addMemoriaUSB(MemoriaUSB musb) {
        this.memoriaUSB = musb;
    }

    public void mostraPCConfigs() {
        System.out.println("Marca: " + marca);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Sistema Operacional: " + sistemaOperacional.getNome() + " (" + sistemaOperacional.getTipo() + " bits)");
        System.out.println("Hardware Básico:");
        for (int i = 0; i < hardwares.length; i++) {
            if (hardwares[i] != null) {
                System.out.println(" - " + hardwares[i].getNome() + ": " + hardwares[i].getCapacidade());
            }
        }
        if (memoriaUSB != null) {
            System.out.println("Acompanha: " + memoriaUSB.getNome() + " de " + memoriaUSB.getCapacidade() + "Gb/Tb");
        }
        System.out.println("Não acompanha Memória USB.");
    }

    public float getPreco() {
        return preco;
    }
}

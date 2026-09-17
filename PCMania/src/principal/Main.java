package principal;

public class Main {

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Promoção 1
        pcmania.casca.HardwareBasico[] h1 = new pcmania.casca.HardwareBasico[3];
        h1[0] = new pcmania.casca.HardwareBasico("Pentium Core i5", 2200);
        h1[1] = new pcmania.casca.HardwareBasico("Memoria RAM", 8);
        h1[2] = new pcmania.casca.HardwareBasico("HD", 500);
        pcmania.casca.SistemaOperacional so1 = new pcmania.casca.SistemaOperacional("macOS Sequoia", 64);
        pcmania.casca.MemoriaUSB usb1 = new pcmania.casca.MemoriaUSB("Pendrive", 16);

        // Promoção 2
        pcmania.casca.HardwareBasico[] h2 = new pcmania.casca.HardwareBasico[3];
        h2[0] = new pcmania.casca.HardwareBasico("Pentium Core i7", 3370);
        h2[1] = new pcmania.casca.HardwareBasico("Memoria RAM", 16);
        h2[2] = new pcmania.casca.HardwareBasico("HD", 1000);
        pcmania.casca.SistemaOperacional so2 = new pcmania.casca.SistemaOperacional("Windows 8", 64);
        pcmania.casca.MemoriaUSB usb2 = new pcmania.casca.MemoriaUSB("Pen-drive", 32);

        // Promoção 3
        pcmania.casca.HardwareBasico[] h3 = new pcmania.casca.HardwareBasico[3];
        h3[0] = new pcmania.casca.HardwareBasico("Pentium Core i7", 4500);
        h3[1] = new pcmania.casca.HardwareBasico("Memoria RAM", 32);
        h3[2] = new pcmania.casca.HardwareBasico("HD", 2000);
        pcmania.casca.SistemaOperacional so3 = new pcmania.casca.SistemaOperacional("Windows 10", 64);
        pcmania.casca.MemoriaUSB usb3 = new pcmania.casca.MemoriaUSB("HD Externo", 1000);

        System.out.print("Informe o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Informe o CPF do cliente: ");
        String cpf = scanner.nextLine();

        pcmania.casca.Cliente cliente = new pcmania.casca.Cliente(nome, cpf);

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- MENU DE PROMOÇÕES ---");
            System.out.println("1 - Promoção 1 (Apple)");
            System.out.println("2 - Promoção 2 (Samsung)");
            System.out.println("3 - Promoção 3 (Dell)");
            System.out.println("0 - Sair / Finalizar Compra");
            System.out.print("Digite sua opção: ");
            opcao = scanner.nextInt();

            if (opcao == 1) {
                pcmania.casca.Computador pc1 = new pcmania.casca.Computador("Apple", 2191.00f, so1, h1);
                pc1.addMemoriaUSB(usb1);
                cliente.adicionarComputador(pc1);
                System.out.println("PC da Promoção 1 adicionado ao carrinho!");
            } else if (opcao == 2) {
                pcmania.casca.Computador pc2 = new pcmania.casca.Computador("Samsung", 2192.00f, so2, h2);
                pc2.addMemoriaUSB(usb2);
                cliente.adicionarComputador(pc2);
                System.out.println("PC da Promoção 2 adicionado ao carrinho!");
            } else if (opcao == 3) {
                pcmania.casca.Computador pc3 = new pcmania.casca.Computador("Dell", 2193.00f, so3, h3);
                pc3.addMemoriaUSB(usb3);
                cliente.adicionarComputador(pc3);
                System.out.println("PC da Promoção 3 adicionado ao carrinho!");
            } else if (opcao != 0) {
                System.out.println("Opção inválida! Tente novamente.");
            }
        }

        System.out.println("\n==================================");
        System.out.println("RESUMO DA COMPRA");
        System.out.println("==================================");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println("----------------------------------");
        System.out.println("COMPUTADORES ADQUIRIDOS:\n");

        pcmania.casca.Computador[] pcsComprados = cliente.getComputadores();
        for (int i = 0; i < pcsComprados.length; i++) {
            if (pcsComprados[i] != null) {
                pcsComprados[i].mostraPCConfigs();
            }
        }

        System.out.println("TOTAL DA COMPRA: R$ " + cliente.calculaTotalCompra());

        // Chamada do método estático sem import
        atendimento.ProcessarPedido.processar(cliente.getComputadores());

        scanner.close();
    }
}

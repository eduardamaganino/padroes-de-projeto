package Facade;

// Classe do subsistema Cozinha 
class Cozinha {
    public void prepararComida() {
        System.out.println("Cozinha: Preparando a comida...");
    }
}

// Classe do subsistema Entrega
class Entrega { 
    public void realizarEntrega() {
        System.out.println("Entrega: Iniciando a entrega...");
    }
}

// Classe do subsistema Pagamento
class Pagamento {
    public void processarPagamento() {
        System.out.println("Pagamento: Processando o pagamento...");
    }
}

// Classe Facade
class SistemaDePedidoFacade {
    private Cozinha cozinha;
    private Entrega entrega;
    private Pagamento pagamento;

    // Fornece uma interface simplificada para o cliente, ocultando a complexidade de interagir com os subsistemas individualmente.
    public SistemaDePedidoFacade() {
        cozinha = new Cozinha();
        entrega = new Entrega();
        pagamento = new Pagamento();
    }

    // Método para fazer um pedido
    public void fazerPedido() {
        cozinha.prepararComida();
        pagamento.processarPagamento();
        entrega.realizarEntrega();
    }
}

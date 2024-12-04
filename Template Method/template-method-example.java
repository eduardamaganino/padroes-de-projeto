// Classe abstrata que define o método template
public abstract class Bebida {
    // Método template final que define o esqueleto do algoritmo
    public final void prepararBebida() {
        ferverAgua();          // Passo comum para todas as bebidas
        adicionarIngredientes(); // Passo específico definido pelas subclasses
        mexer();               // Passo comum para todas as bebidas
        servir();              // Passo comum para todas as bebidas
    }

    // Método comum para ferver água
    private void ferverAgua() {
        System.out.println("Fervendo água...");
    }

    // Método abstrato que será implementado pelas subclasses
    protected abstract void adicionarIngredientes();

    // Método comum para mexer a bebida
    private void mexer() {
        System.out.println("Mexendo a bebida...");
    }

    // Método comum para servir a bebida
    private void servir() {
        System.out.println("Servindo a bebida.");
    }
}

// Subclasse concreta para preparar chá
public class Cha extends Bebida {
    @Override
    protected void adicionarIngredientes() {
        System.out.println("Adicionando saquinho de chá...");
    }
}

// Subclasse concreta para preparar café
public class Cafe extends Bebida {
    @Override
    protected void adicionarIngredientes() {
        System.out.println("Adicionando pó de café...");
    }
}

// Classe cliente que utiliza as implementações do padrão Template Method
public class Cliente {
    public static void main(String[] args) {
        // Preparar chá
        Bebida cha = new Cha();
        cha.prepararBebida();

        System.out.println(); // Apenas para separar a saída no console

        // Preparar café
        Bebida cafe = new Cafe();
        cafe.prepararBebida();
    }
}


# Padrão Template Method

## Conceito

O padrão Template Method define o esqueleto de um algoritmo em uma operação, deixando alguns passos a serem implementados pelas subclasses. Ele permite que subclasses redefinam certos passos de um algoritmo sem mudar a estrutura do algoritmo.

## Problema

É útil quando você tem um algoritmo com passos que podem ser variáveis ou específicos para subclasses, mas o esqueleto do algoritmo deve permanecer o mesmo.

## Quando Usar

- Quando várias classes diferem apenas na implementação de alguns passos de um algoritmo.
- Para evitar duplicação de código, encapsulando a estrutura invariável do algoritmo em uma classe base.

## Diagrama UML

![Template Method UML Diagram](template-method-uml.png)

## Exemplo de código-fonte:

//Classe abstrata que define o método template

public abstract class Template {

//Método template final que define o esqueleto do algoritmo

    public final void templateMethod() {
        baseOperation();      // Operação base comum a todas as subclasses
        requiredOperation1(); // Operação específica 1, a ser implementada pelas subclasses
        requiredOperation2(); // Operação específica 2, a ser implementada pelas subclasses
        hook();               // Operação gancho, pode ser opcionalmente sobrescrita
    }

    // Método para a operação base
    private void baseOperation() {
        System.out.println("Base operation performed");
    }

    // Métodos abstratos para operações específicas, que devem ser implementados pelas subclasses
    protected abstract void requiredOperation1();
    protected abstract void requiredOperation2();

    // Método gancho, que pode ser sobrescrito pelas subclasses
    protected void hook() {
        // Hook operation
    }
}

// Subclasse concreta que implementa os métodos abstratos definidos na classe Template

public class ConcreteClass extends Template {

    // Implementação do método abstrato para a operação específica 1
    @Override
    protected void requiredOperation1() {
        System.out.println("ConcreteClass: Operation1 performed");
    }

    // Implementação do método abstrato para a operação específica 2
    @Override
    protected void requiredOperation2() {
        System.out.println("ConcreteClass: Operation2 performed");
    }

    // Sobrescrita do método gancho (opcional)
    @Override
    protected void hook() {
        System.out.println("ConcreteClass: Hook operation performed");
    }
}

// Classe cliente que utiliza as implementações do padrão Template Method

public class Client {

    public static void main(String[] args) {
        // Criando instância de ConcreteClass
        Template template = new ConcreteClass();
        // Chamando o método template
        template.templateMethod();
    }
}


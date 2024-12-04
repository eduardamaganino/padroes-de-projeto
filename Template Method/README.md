# Padrão Template Method

## Conceito

O padrão Template Method define o esqueleto de um algoritmo em uma operação, deixando alguns passos a serem implementados pelas subclasses. Ele permite que subclasses redefinam certos passos de um algoritmo sem mudar a estrutura do algoritmo.

## Problema

É útil quando você tem um algoritmo com passos que podem ser variáveis ou específicos para subclasses, mas o esqueleto do algoritmo deve permanecer o mesmo.

## Quando Usar

- Quando várias classes diferem apenas na implementação de alguns passos de um algoritmo.
- Para evitar duplicação de código, encapsulando a estrutura invariável do algoritmo em uma classe base.

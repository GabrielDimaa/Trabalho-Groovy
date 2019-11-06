/*
Um programa para gerenciar uma agenda de contatos. Cada contato será armazenado um nome e sobrenome,
telefone, e a data do aniversário (dia e mês).
O programa permite inserir um contato, remover, pesquisar pelo nome, listar todos os contatos e apresentar os contatos que fazem
aniversário em um determinado mês.
O programa contém uma lista encadeada com descritor tendo um elo em cada elemento, conectando um elemento ao outro.
Assim teremos uma aplicação orientado a objetos.
*/

static void main(String[] args) {
    Scanner tc = new Scanner(System.in)
    Agenda.mixin(Metodos)

    def metodos = new Agenda()
    def lista = new Lista()
    lista.quantidade = 0
    int escolha = 0

     while (escolha != 6) {
        println("Menu:")
        println("1 - Adicionar novo contato")
        println("2 - Remover contato")
        println("3 - Pesquisar")
        println("4 - Lista de contatos")
        println("5 - Aniversariantes de um mês")
        println("6 - Sair")
        escolha = tc.nextInt()

        switch (escolha) {

            case 1:
                metodos.addContato(lista)
                break

            case 2:
                metodos.remover(lista)
                break

            case 3:
                metodos.pesquisar(lista)
                break

            case 4:
                metodos.listar(lista)
                break

            case 5:
                metodos.aniver(lista)
                break

            default:
                println("Programa encerrado!")
                break

        }

     }

}
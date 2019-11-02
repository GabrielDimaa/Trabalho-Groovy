class Metodos {

    //As classes não precisam ter o mesmo nome base que suas definições de arquivo de origem

    static Scanner tc = new Scanner(System.in)


     Agenda pegarDados() {
        Agenda.mixin(Utils)

        def dados = new Agenda()

        println("Nome: ")
        dados.nome = tc.next()
        println("Sobrenome: ")
        dados.sobrenome = tc.next()
        dados.telefone = dados.lerTelefone()
        dados.dataAniver = dados.lerData()
        print("Contato salvo")

        return (dados)

    }

    void addContato(Lista lista) {

        def novoContato = new Agenda()
        def aux = new Agenda()
        char resp = 'S'

        while (resp == 'S') {

            if (lista.quantidade == 0) {
                novoContato = pegarDados()

                novoContato.elo = null

                lista.primeiro = novoContato
                lista.ultimo = novoContato
                lista.quantidade++

            } else {
                aux = lista.primeiro

                while (aux.elo != null) {
                    aux = aux.elo
                }
                novoContato = pegarDados()
                novoContato.elo = null

                aux.elo = novoContato
                lista.ultimo = novoContato
                lista.quantidade++
            }

            println("Deseja continuar adicionando? (S / N) ")
            resp = tc.next().charAt(0).toUpperCase()

        }

    }

    void remover(Lista lista) {

        String nome, sobrenome

        println("Remover contato!")
        println("Digite o nome do contato: ")
        nome = tc.next()
        println("Sobrenome: ")
        sobrenome = tc.next()

        Agenda contato = lista.primeiro;

        if (nome.equals(contato.nome) && sobrenome.equals(contato.sobrenome) ) {
            lista.primeiro = contato.elo
            println("Contato removido!")
        }

        else {

            while (contato != null) {
                def x = new Agenda()
                x = contato.elo
                String nomeElo = x.nome
                String sobrenomeElo = x.sobrenome

                if (nome.equals(nomeElo) && sobrenome.equals(sobrenomeElo)) {
                    Agenda aux = contato.elo
                    contato.elo = aux.elo
                    println("Contato removido!")
                    break
                } else {
                    contato = contato.elo
                }

            }

        }

    }

    void pesquisar(Lista lista) {

        String nome
        String sobrenome

        println("Pesquisar contato!")
        println("Digite o nome do contato: ")
        nome = tc.next().toUpperCase()
        println("Sobrenome: ")
        sobrenome = tc.next().toUpperCase()

        Agenda contato = lista.primeiro
        while (contato != null) {
            String n = contato.nome
            String s = contato.sobrenome

            if (nome.equals(n.toUpperCase()) && sobrenome.equals(s.toUpperCase())) {

                println("-------------------------------------------")
                println("Nome: ${contato.nome} ${contato.sobrenome}")
                println("Telefone: ${contato.telefone}")
                println("Data de aniversário: ${contato.dataAniver}")
                break

            }
            else {

                contato = contato.elo
                if (contato.elo == null) {
                    println("Contato não encontrado!")
                    break
                }

            }

        }

    }

    void listar(Lista lista) {

        Agenda listagem = lista.primeiro
        while (listagem != null) {

            println("-------------------------------------------")
            println("Nome: ${listagem.nome} ${listagem.sobrenome}")
            println("Telefone: ${listagem.telefone}")
            println("Data de aniversário: ${listagem.dataAniver}")
            println("-------------------------------------------")

            listagem = listagem.elo

        }

    }

    void aniver(Lista lista) {

        Agenda.mixin(Utils)
        def meses = [1:"Janeiro", 2:"Fevereiro", 3:"Março", 4:"Abril", 5:"Maio", 6:"Junho",
                     7:"Julho", 8:"Agosto", 9:"Setembro", 10:"Outubro", 11:"Novembro", 12:"Dezembro"]

        int mesAniver, mes
        String frase = "Mês: "
        boolean valida = false

        while (valida == false) {

            println("Aniversariantes de um mês!")
            mes = validaNumero(frase)

            if (mes <= 12 && mes > 0) {
                println "${meses.get(mes)}"

                Agenda contato = lista.primeiro
                while (contato != null) {

                    mesAniver = Integer.parseInt(contato.dataAniver.substring(3))
                    if (mesAniver == mes) {

                        println("Nome: ${contato.nome} ${contato.sobrenome}")
                        println("Telefone: ${contato.telefone}")
                        println("Data de aniversário: ${contato.dataAniver}")
                        println("-------------------------------------------")

                    }
                    if (contato.elo == null) {
                        valida = true
                    }
                    contato = contato.elo

                }

            }

            else {
                println("Mês inválido")
                valida = false
            }

        }

    }

}
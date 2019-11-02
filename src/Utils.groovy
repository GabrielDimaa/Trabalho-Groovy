class Utils {

    int validaNumero(String frase) {
        Scanner tc = new Scanner(System.in)
        boolean valida = false
        int numero
        while (valida != true) {
            println(frase)
            try {
                numero = Integer.parseInt(tc.nextLine())
                return (numero)
            } catch (NumberFormatException e) {
               println("Por favor, digite apenas números!")
                valida = false
            }
        }
        return (numero)
    }

     String lerTelefone() {
        String telefone
        String frase = "Telefone: "
        boolean valida = false
        int valor
        while (valida == false) {
            valor = validaNumero(frase)
            telefone = Integer.toString(valor)
            valida = telefone.matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d")
            if (valida == true) {
                return (telefone)
            }
            else {
                valida = false
            }
        }
        return null
    }

     String lerData() {
        Scanner tc = new Scanner(System.in)

        String data
        int dia, mes
        boolean valida = false
        while (valida == false) {
            println("Data de aniversário: (dd/mm)")
            data = tc.nextLine()
            valida = data.matches("\\d\\d/\\d\\d")
            if (valida == true) {
                dia = Integer.parseInt(data.substring(0,2))
                mes = Integer.parseInt(data.substring(3))
                if (dia <= 31 && dia > 0 && mes <= 12 && mes > 0) {
                    return data
                }
                else {
                    valida = false
                }
            }
            else {
                valida = false
            }
        }
        return null
    }

}

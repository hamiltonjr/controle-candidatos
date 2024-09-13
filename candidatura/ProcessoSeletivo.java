package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.List;
import java.util.ArrayList;

public class ProcessoSeletivo
{
    // salário usado como base para contratação de candidatos
    private static final double SALARIO_BASE = 2000.00;

    // total de candidatos selecionados
    private static final int TOTAL_CANDIDATOS = 5;

    // lista de candidatos
    private static final String[] CANDIDATOS = {
            "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO",
            "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"
    };

    private static List<String> selecionados;

    public static void main(String[] args) {
        System.out.println("Processo seletivo");
        // testes do case 1 comentados
        //analisarCandidato(1900.00);
        //analisarCandidato(2200.00);
        //analisarCandidato(2000.00);

        // teste do case 2
        selecionarCandidatos();

        // teste do case 3
        imprimirSelecionados();

        // teste do case 4
        for (String candidato : selecionados)
        {
            entrarEmContato(candidato);
        }

    }

    /**
     * Analisa candidatos com base em suas propostas salariais.
     * @param salarioPretendido
     */
    public static void analisarCandidato(double salarioPretendido)
    {
        if (SALARIO_BASE > salarioPretendido)
        {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (SALARIO_BASE == salarioPretendido)
        {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTAR-PROPOSTA");
        } else
        {
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }

    /**
     * Seleciona certa quantidade de candidatos com base em propostas
     * salariais dos mesmos. Os nomes são guardados em uma lista para
     * posterior exibição.
     */
    public static void selecionarCandidatos()
    {
        selecionados = new ArrayList<>();
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;

        while (candidatosSelecionados < TOTAL_CANDIDATOS &&
            candidatoAtual < CANDIDATOS.length)
        {
            String candidato = CANDIDATOS[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato +
                    " solicitou este valor de salário: " +
                    String.format("%1.2f", salarioPretendido));
            if (SALARIO_BASE >= salarioPretendido)
            {
                System.out.println("O candidato " + candidato +
                        " foi selecionado para a vaga.");
                selecionados.add(candidato);
                candidatosSelecionados++;
            }
            System.out.println();
            candidatoAtual++;
        }
    }

    /**
     * Imprime a lista de candidatos selecionados gerada em
     * selecionarCandidatos().
     */
    public static void imprimirSelecionados()
    {
        System.out.print("Lista de selecionados: ");
        System.out.print(selecionados.get(0));
        for (int i=1; i<selecionados.size(); i++)
        {
            System.out.print(", " + selecionados.get(i));
        }
        System.out.println();
    }

    /**
     * Simula o RH entrando em contato com os candidatos selecionados
     * usando um método randômico.
     * @param candidato
     */
    public static void entrarEmContato(String candidato)
    {
        int tentativas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do
        {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando)
            {
                tentativas++;
            } else
            {
                System.out.println("\nCONTATO REALIZADO COM SUCESSO");
            }
        } while (continuarTentando && tentativas < 3);

        if (atendeu)
        {
            System.out.println("Conseguimos contato com " +
                    candidato + " com " + tentativas + " tentativas");
        } else
        {
            System.out.println("\nNão conseguimos contato com " + candidato);
        }
    }

    /**
     * Simula a proposição de salário dos candidatos.
     * @return proposição aleatória de salário
     */
    private static double valorPretendido()
    {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    /**
     * Simula o atendimento de até 3 ligações do RH para o
     * candidato.
     * @return se o candidato atendeu ou não em cada momento.
     */
    private static boolean atender()
    {
        return new Random().nextInt(3) == 1;
    }
}

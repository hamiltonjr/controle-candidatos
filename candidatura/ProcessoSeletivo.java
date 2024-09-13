package candidatura;

public class ProcessoSeletivo
{
    // salário usado como base para contratação de candidatos
    private static final double SALARIO_BASE = 2000.00;

    public static void main(String[] args) {
        System.out.println("Processo seletivo");
        analisarCandidato(1900.00);
        analisarCandidato(2200.00);
        analisarCandidato(2000.00);
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

}

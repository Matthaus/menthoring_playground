package br.com.matthaus.playground06

class Turma(
    val materia: String,
    val horario: String,
    val numeroMaximoAlunos: Int
) {

    //Criando na memoria uma lista de pares de (String, String)
    //Mutable para poder permitir que os itens sejam modificados
    //Privado para não permitir que alunos sejam adicionados fora das regras
    //Regras são criadas dentro de cada comportamento que manipula a classe
    private val alunosMatriculados = mutableListOf<Pair<String, String>>()

    fun matricularAluno(nome: String, documento: String) : Boolean {
        if (nome.isNotEmpty() && documento.isNotEmpty()) {
            //A quantidade de alunos matriculados (que estão na lista) é menor do que o máximo?
            if (alunosMatriculados.size < numeroMaximoAlunos) {
                //Executar a matricula
                //Adicionando o novo aluno a lista de alunos matriculados
                alunosMatriculados.add(Pair(nome, documento))

                //Sucesso caso a matricula tenha sido realizada (adicionado na lista)
                return true
            } else {
                //Falso caso a turma já esteja cheia
                return false
            }
        } else {
            //Falso caso não tenha sido possivel matricular o aluno
            return false
        }
    }

    fun getAlunosMatriculados() : List<Pair<String, String>> {
        return alunosMatriculados
    }

}
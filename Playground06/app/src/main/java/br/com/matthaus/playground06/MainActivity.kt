package br.com.matthaus.playground06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var turma : Turma = Turma("Android", "15:00", 10)

    private var btnMatricular : Button? = null
    private var rvListaAlunos : RecyclerView? = null
    private var adaptadorListaAlunos : TurmaAdapter? = null

    //onCreate é executado quando a tela é criada (ela é chamada pelo Android)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Buscamos a referência de cada componente na tela (View).
        btnMatricular = findViewById(R.id.button_matricular)
        rvListaAlunos = findViewById(R.id.rv_lista_alunos)

        //Configuramos o comportamento de cada um desses componentes
        configurarBotaoMatricular()
        configurarListaAlunos()
    }

    //É interessante que uma função tenha responsabilidade única
    //Funções que determinam o comportamento da tela devem ser privadas, até que seja que necessário
    //o contrário. Então, por padrão, declarar como private :)
    private fun configurarBotaoMatricular() {
        btnMatricular?.setOnClickListener {
            val nome = "Matthaus"
            val documento = "MG123456"
            executarMatricula(nome, documento)
        }
    }

    private fun configurarListaAlunos() {

        //Instanciando TurmaAdapter usando "named arguments"
        adaptadorListaAlunos = TurmaAdapter(
            listaAlunos = emptyList(),
            onDesmatricular = { nome, documento, posicao ->
                executarDesmatricula(nome, documento, posicao)
            }
        )

        rvListaAlunos?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvListaAlunos?.adapter = adaptadorListaAlunos
    }

    private fun executarMatricula(nome: String, documento: String) {
        val sucessoMatricula = turma.matricularAluno(nome, documento)
        if (sucessoMatricula) {
            //Mostrar uma mensagem de sucesso
            Toast.makeText(this, "Aluno matriculado com sucesso", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Erro ao matricular aluno", Toast.LENGTH_SHORT).show()
        }
        atualizarListaAlunos()
    }

    private fun executarDesmatricula(nome: String, documento: String, posicao: Int) {
        val sucessoDesmatricula = turma.desmatricularAluno(posicao)
        if (sucessoDesmatricula) {
            Toast.makeText(this, "Aluno desmatriculado com sucesso", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Erro ao desmatricular aluno", Toast.LENGTH_SHORT).show()
        }
        atualizarListaAlunos()
    }

    private fun atualizarListaAlunos() {
        //Busca a lista de alunos atualizada da turma
        val lista_alunos_turma = turma.getAlunosMatriculados()
        //Passamos a lista atualizada de alunos para o adaptador através da sua função
        //atualizarListaAlunos()
        adaptadorListaAlunos?.atualizaAlunosTurma(lista_alunos_turma)
    }

}
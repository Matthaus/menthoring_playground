package br.com.matthaus.playground06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val turmaUm = Turma("Android", "15:00", 5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonMatricular = findViewById<Button>(R.id.button_matricular)
        val recyclerViewListaAlunos = findViewById<RecyclerView>(R.id.rv_lista_alunos)

        buttonMatricular.setOnClickListener {
            executarMatricula(recyclerViewListaAlunos)
        }
    }

    fun executarMatricula(recyclerViewListaAlunos: RecyclerView) {
        //Buscar o nome e o documento digitado
        val nome = "Matthaus"
        val documento = "MG123456"

        val matriculadoSucesso = turmaUm.matricularAluno(nome, documento)

        if (matriculadoSucesso) {
            Toast.makeText(this, "Aluno matriculado com sucesso", Toast.LENGTH_SHORT).show()

            //Criar um adaptador para mostrar a lista de alunos matriculados
            val turmaAdapter = TurmaAdapter(turmaUm.getAlunosMatriculados()) { nome, documento, posicao ->
                executarDesmatricular(nome, documento, posicao, recyclerViewListaAlunos)
            }
            //Definir que tipo de disposição de itens vai ser utilizado
            recyclerViewListaAlunos.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            //Passar para o recyclerview qual o adaptador vai ser utilizado, ou seja, o criado anteriormente (instanciado)
            recyclerViewListaAlunos.adapter = turmaAdapter
        } else {
            Toast.makeText(this, "Erro ao matricular aluno", Toast.LENGTH_SHORT).show()
        }

    }

    fun executarDesmatricular(nome: String, documento: String, posicao: Int, recyclerViewListaAlunos: RecyclerView) {
        val sucesso = turmaUm.desmatricularAluno(posicao)
        if (sucesso) {
            Toast.makeText(this, "Desmatricula com sucesso: " + nome + " / " + documento + " / " + posicao.toString(), Toast.LENGTH_SHORT).show()

            val turmaAdapter = TurmaAdapter(turmaUm.getAlunosMatriculados()) { nome, documento, posicao ->
                executarDesmatricular(nome, documento, posicao, recyclerViewListaAlunos)
            }

            recyclerViewListaAlunos.adapter = turmaAdapter

        } else {
            Toast.makeText(this, "Desmatricula não realizada", Toast.LENGTH_SHORT).show()
        }
    }

}
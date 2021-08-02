package br.com.matthaus.playground06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val turmaUm = Turma("Android", "15:00", 5)

    var recyclerViewListaAlunos: RecyclerView? = null
    var adapterListaAlunos: TurmaAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonMatricular = findViewById<Button>(R.id.button_matricular)
        recyclerViewListaAlunos = findViewById<RecyclerView>(R.id.rv_lista_alunos)

        buttonMatricular.setOnClickListener {
            executarMatricula()
        }
    }

    fun configurarAdapter(listaAlunos: List<Pair<String, String>>) {
        //Criar um adaptador para mostrar a lista de alunos matriculados
        adapterListaAlunos = TurmaAdapter(listaAlunos) { nome, documento, posicao ->
            executarDesmatricular(nome, documento, posicao)
        }
        recyclerViewListaAlunos?.let {
            //Definir que tipo de disposição de itens vai ser utilizado
            it.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            //Passar para o recyclerview qual o adaptador vai ser utilizado, ou seja, o criado anteriormente (instanciado)
            it.adapter = adapterListaAlunos
        }
    }

    fun executarMatricula() {
        //Buscar o nome e o documento digitado
        val nome = "Matthaus"
        val documento = "MG123456"

        val matriculadoSucesso = turmaUm.matricularAluno(nome, documento)

        if (matriculadoSucesso) {
            Toast.makeText(this, "Aluno matriculado com sucesso", Toast.LENGTH_SHORT).show()
            configurarAdapter(turmaUm.getAlunosMatriculados())
        } else {
            Toast.makeText(this, "Erro ao matricular aluno", Toast.LENGTH_SHORT).show()
        }

    }

    fun executarDesmatricular(nome: String, documento: String, posicao: Int) {
        val sucesso = turmaUm.desmatricularAluno(posicao)
        if (sucesso) {
            Toast.makeText(this, "Desmatricula com sucesso: " + nome + " / " + documento + " / " + posicao.toString(), Toast.LENGTH_SHORT).show()
            configurarAdapter(turmaUm.getAlunosMatriculados())
        } else {
            Toast.makeText(this, "Desmatricula não realizada", Toast.LENGTH_SHORT).show()
        }
    }

}
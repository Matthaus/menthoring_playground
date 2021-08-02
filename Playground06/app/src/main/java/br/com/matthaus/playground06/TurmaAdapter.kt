package br.com.matthaus.playground06

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//O que eu preciso para criar uma lista no recycler view?
//RecyclerView componente no layout da tela
//Adapter para determinar as regras para montagem da lista
//ViewHolder para representar cada uma das linhas da lista

class TurmaAdapter(val listaAlunos : List<Pair<String, String>>, val onClicarLinha: (String, String) -> Unit) : RecyclerView.Adapter<TurmaAdapter.AlunoViewHolder>() {

    //Esta função é chamada para construir o ViewHolder e atribuir o layout correto
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlunoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_linha_aluno, parent, false)
        val viewHolderAluno = AlunoViewHolder(view, onClicarLinha)
        return viewHolderAluno
    }

    //Esta função é chamada para preencher cada linha (ViewHolder) com as informações respectivas
    //Cada linha da lista chama esta função uma vez para obter os dados
    override fun onBindViewHolder(holder: AlunoViewHolder, position: Int) {
        val aluno = listaAlunos.get(position)
        holder.preencherDadosAluno(aluno.first, aluno.second)
    }

    //Esta função é chamada para informar quantos itens esta lista tem
    //Ela é chamada uma vez no início do RecyclerView e a cada vez que ele é atualizado
    override fun getItemCount(): Int {
        return listaAlunos.size
    }

    class AlunoViewHolder(itemView: View, val onClicarLinha: (String, String) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val tvNomeAluno = itemView.findViewById<TextView>(R.id.tv_nome_aluno)
        val tvDocumentoAluno = itemView.findViewById<TextView>(R.id.tv_documento_aluno)

        fun preencherDadosAluno(nome: String, documento: String) {
            tvNomeAluno.text = nome
            tvDocumentoAluno.text = documento

            itemView.setOnClickListener {
                onClicarLinha(nome, documento)
            }

        }

    }

}
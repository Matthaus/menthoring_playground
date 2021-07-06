package br.com.matthaus.playground04

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MusicaAdaptador : RecyclerView.Adapter<MusicaAdaptador.MusicaViewHolder>() {

    val musicas = listOf(
        Musica("Nome da musica 1", "Artista 1"),
        Musica("Nome da musica 2", "Artista 2"),
        Musica("Nome da musica 3", "Artista 3"),
        Musica("Nome da musica 4", "Artista 4"),
        Musica("Nome da musica 5", "Artista 5"),
        Musica("Nome da musica 6", "Artista 6"),
        Musica("Nome da musica 7", "Artista 7"),
        Musica("Nome da musica 8", "Artista 8"),
        Musica("Nome da musica 9", "Artista 9"),
        Musica("Nome da musica 10", "Artista 10"),
        Musica("Nome da musica 11", "Artista 11"),
        Musica("Nome da musica 12", "Artista 12"),
        Musica("Nome da musica 13", "Artista 13"),
        Musica("Nome da musica 14", "Artista 14"),
        Musica("Nome da musica 15", "Artista 15"),
        Musica("Nome da musica 16", "Artista 16"),
        Musica("Nome da musica 17", "Artista 17"),
        Musica("Nome da musica 18", "Artista 18"),
        Musica("Nome da musica 19", "Artista 19"),
        Musica("Nome da musica 20", "Artista 20")
    )

    //Funcao que retorna quantos items tem na sua lista
    override fun getItemCount(): Int = musicas.size

    //Função que cria a view de uma linha (pegar o XML do layout e carregar ele na memoria)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MusicaAdaptador.MusicaViewHolder {
        val view_da_linha = LayoutInflater.from(parent.context)
            .inflate(R.layout.linha_lista, parent, false)

        // Neste momento a variavel linha contém o layout do arquivo linha_lista.xml em memoria.

        return MusicaViewHolder(view_da_linha)
    }

    //Função que pega os dados da lista e coloca nos campos do layout
    override fun onBindViewHolder(viewHolder: MusicaAdaptador.MusicaViewHolder, position: Int) {
        //Retorna a musica que está na posição recebida pela variavel position
        val musicaDaPosicaoAtual = musicas[position]

        viewHolder.preencherDadosDaMusica(musicaDaPosicaoAtual)
    }

    class MusicaViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val campoNomeDaMusica = itemView.findViewById<TextView>(R.id.nome_musica)
        val campoNomeDoArtista = itemView.findViewById<TextView>(R.id.nome_artista)

        fun preencherDadosDaMusica(musica: Musica) {
            campoNomeDaMusica.text = musica.nome
            campoNomeDoArtista.text = musica.artista
        }

    }

}
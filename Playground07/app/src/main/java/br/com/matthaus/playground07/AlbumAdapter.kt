package br.com.matthaus.playground07

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AlbumAdapter(val albums: List<Album>) : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_album, parent, false)
            .let {
                return AlbumViewHolder(it)
            }
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.preencherDadosAlbum(albums[position])
    }

    override fun getItemCount(): Int = albums.size

    class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomeAlbum = itemView.findViewById<TextView>(R.id.nome_album)
        val nomeArtista = itemView.findViewById<TextView>(R.id.nome_artista)
        val numeroFaixas = itemView.findViewById<TextView>(R.id.numero_faixas)

        fun preencherDadosAlbum(album: Album) {
            nomeAlbum.text = album.collectionName
            nomeArtista.text = album.artistName
            numeroFaixas.text = "Faixas: " + album.trackCount.toString()
        }

    }

}
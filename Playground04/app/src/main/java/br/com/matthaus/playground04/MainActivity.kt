package br.com.matthaus.playground04

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listaMusicas = findViewById<RecyclerView>(R.id.lista_musicas)
        listaMusicas.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        listaMusicas.layoutManager = GridLayoutManager(this, 2)
        listaMusicas.adapter = MusicaAdaptador()




        // A estrutura acima cria uma lista de musica, do jeito Kotlin, similar ao que seria no JS/JSON:
        //        val musicas = [
        //            {
        //                 "nome": "Nome da musica 1",
        //                "artista": "Artista 1"
        //            },
        //            {
        //                "nome": "Nome da musica 2",
        //                "artista": "Artista 2"
        //            },
        //            {
        //                "nome": "Nome da musica 3",
        //                "artista": "Artista 3"
        //            },
        //            {
        //                "nome": "Nome da musica 4",
        //                "artista": "Artista 4"
        //            },
        //            {
        //                "nome": "Nome da musica 5",
        //                "artista": "Artista 5"
        //            }
        //        ]
    }
}
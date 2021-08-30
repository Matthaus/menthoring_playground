package br.com.matthaus.playground07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listaAlbums = findViewById<RecyclerView>(R.id.lista_albums)

        val appleAPI = configurarRetrofit()

        //6 passo: especifica a chamada (call) e os seus parametros
        val callBuscaAlbums = appleAPI.buscarAlbumsPorPalavraChave(
            "jack johson",
            "album"
        )

        callBuscaAlbums.enqueue(object : Callback<ResultadoAlbums> {
            override fun onResponse(
                call: Call<ResultadoAlbums>,
                response: Response<ResultadoAlbums>
            ) {
                //7 passo: avaliar o que fazer quando der sucesso
                val resultado = response.body()

                resultado?.let {
                    val adaptador = AlbumAdapter(it.results)
                    listaAlbums.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                    listaAlbums.adapter = adaptador
                }
            }

            override fun onFailure(call: Call<ResultadoAlbums>, t: Throwable) {
                //8 passo: avaliar o que fazer quando der erro
                Toast.makeText(this@MainActivity, "Erro ao chamar API", Toast.LENGTH_LONG).show()
            }

        })

    }

    fun configurarRetrofit() : AppleAPI {
        //5 passo: inicializar o Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://itunes.apple.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(AppleAPI::class.java)

        return api
    }

}
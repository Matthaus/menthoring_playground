package br.com.matthaus.playground07

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listaAlbums = findViewById<RecyclerView>(R.id.lista_albums)

        val appleAPI = configurarRetrofit()

        CoroutineScope(Dispatchers.IO).launch {
            //6 passo: especifica a chamada (call) e os seus parametros
            val resultadoAlbums = appleAPI.buscarAlbumsPorPalavraChave(
                "jack johson",
                "album"
            )


            withContext(Dispatchers.Main) {
                //android.view.ViewRootImpl$CalledFromWrongThreadException: Only the original thread that created a view hierarchy can touch its views

                val adaptador = AlbumAdapter(resultadoAlbums.albums)
                listaAlbums.layoutManager =
                    LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                listaAlbums.adapter = adaptador
            }
        }
    }

    fun configurarRetrofit(): AppleAPI {
        //5 passo: inicializar o Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://itunes.apple.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(AppleAPI::class.java)

        return api
    }

}
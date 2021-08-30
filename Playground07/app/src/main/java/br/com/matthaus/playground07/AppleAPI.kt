package br.com.matthaus.playground07

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//4 passo: especificar as chamadas de API
interface AppleAPI {

    @GET("/search")
    fun buscarAlbumsPorPalavraChave(
        @Query("term") term: String,
        @Query("entity") entity: String
    ) : Call<ResultadoAlbums>

}
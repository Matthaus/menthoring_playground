package br.com.matthaus.playground07

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//4 passo: especificar as chamadas de API
interface AppleAPI {

    @GET("/search")
    suspend fun buscarAlbumsPorPalavraChave(
        @Query("term") term: String,
        @Query("entity") entity: String
    ) : ResultadoAlbums
    //Quando colocamos suspend na assinatura da função
    //Estamos dizendo que ela é uma função assíncrona (que pode ser suspendida)
    //Similar ao async no javascript

    //Como não vamos mais utilizar callback, podemos remover
    //O tipo Call da resposta

}
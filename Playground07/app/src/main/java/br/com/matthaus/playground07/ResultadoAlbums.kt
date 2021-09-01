package br.com.matthaus.playground07

import com.google.gson.annotations.SerializedName

//3 passo: criar data classes que mapeiam o JSON
data class ResultadoAlbums(
    @SerializedName("resultCount") val qty_albums: Int,
    @SerializedName("results") val albums: List<Album>
)
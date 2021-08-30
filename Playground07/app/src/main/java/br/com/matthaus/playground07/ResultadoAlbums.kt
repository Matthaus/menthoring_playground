package br.com.matthaus.playground07

//3 passo: criar data classes que mapeiam o JSON
data class ResultadoAlbums(
    val resultCount: Int,
    val results: List<Album>
)
package br.com.matthaus.playground07

//3 passo: criar data classes que mapeiam o JSON
data class Album(
    val artistName: String,
    val collectionName: String,
    val artworkUrl100: String,
    val trackCount: Int
)

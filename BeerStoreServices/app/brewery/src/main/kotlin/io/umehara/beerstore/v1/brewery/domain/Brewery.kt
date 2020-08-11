package io.umehara.beerstore.v1.brewery.domain

data class Brewery(val id: Int,
                   val name: String)

data class BreweryDetail(val id: Int,
                         val name: String,
                         val beers: List<Beer>)

package io.umehara.beerstore.v1.brewery.domain

data class Beer(val id: Int,
                val name: String)

data class BeerDetail(val id: Int,
                val name: String,
                val brewery: String)


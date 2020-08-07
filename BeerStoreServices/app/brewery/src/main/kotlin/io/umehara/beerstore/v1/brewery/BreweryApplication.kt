package io.umehara.beerstore.v1.brewery

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BreweryApplication

fun main(args: Array<String>) {
    runApplication<BreweryApplication>(*args)
}

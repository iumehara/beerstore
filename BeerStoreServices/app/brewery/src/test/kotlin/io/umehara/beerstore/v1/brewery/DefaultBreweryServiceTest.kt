package io.umehara.beerstore.v1.brewery

import io.umehara.beerstore.v1.brewery.domain.Beer
import io.umehara.beerstore.v1.brewery.domain.Brewery
import io.umehara.beerstore.v1.brewery.domain.BreweryDetail
import io.umehara.beerstore.v1.brewery.repo.StubSpyBeerRepo
import io.umehara.beerstore.v1.brewery.repo.StubSpyBreweryRepo
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.Arrays.asList

class DefaultBreweryServiceTest {
    @Test
    fun getAll() {
        val breweryRepo = StubSpyBreweryRepo()
        val beerRepo = StubSpyBeerRepo()
        val service = DefaultBreweryService(breweryRepo, beerRepo)


        val beers = service.getAll().collectList().block()


        assertThat(breweryRepo.getAll_called).isEqualTo(true)
        assertThat(beers).isEqualTo(asList(
                Brewery(11, "Stub Brewery A"),
                Brewery(12, "Stub Brewery B"),
                Brewery(13, "Stub Brewery C")
        ))
    }

    @Test
    fun find() {
        val breweryRepo = StubSpyBreweryRepo()
        val beerRepo = StubSpyBeerRepo()
        val service = DefaultBreweryService(breweryRepo, beerRepo)


        val breweryDetail = service.find(1).block()!!


        assertThat(breweryRepo.find_calledWith_id).isEqualTo(1)
        assertThat(beerRepo.getAllForBrewery_calledWith_breweryId).isEqualTo(11)
        assertThat(breweryDetail).isEqualTo(BreweryDetail(
                11,
                "Stub Brewery A",
                listOf(
                        Beer(1, "Stub Beer A"),
                        Beer(2, "Stub Beer B"),
                        Beer(3, "Stub Beer C")
                )
        ))
    }
}
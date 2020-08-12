package io.umehara.beerstore.v1.brewery.repo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType

class DatabaseBeerRepoTest {
    private lateinit var jdbcTemplate: JdbcTemplate
    private lateinit var repo: DatabaseBeerRepo

    @BeforeEach
    fun setUp() {
        val dataSource = EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:db/schema.sql")
                .addScript("classpath:db/seed.sql")
                .build()
        jdbcTemplate = JdbcTemplate(dataSource)
        repo = DatabaseBeerRepo(jdbcTemplate)
    }

    @Test
    fun getAllForBrewery() {
        val beers = repo.getAllForBrewery(1).collectList().block()

        assertThat(beers).isEqualTo(
                listOf(
                        BeerSchema(1, "Nama Lager", 1),
                        BeerSchema(2, "Black", 1)
                )
        )
    }
}

package io.umehara.beerstore.v1.brewery.repo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType

class DatabaseBreweryRepoTest {
    private lateinit var jdbcTemplate: JdbcTemplate
    private lateinit var repo: DatabaseBreweryRepo

    @BeforeEach
    fun setUp() {
        val dataSource = EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:db/test-setup.sql")
                .addScript("classpath:db/migration/V1__Add_breweries_and_beers_tables.sql")
                .addScript("classpath:db/seed.sql")
                .build()
        jdbcTemplate = JdbcTemplate(dataSource)
        repo = DatabaseBreweryRepo(jdbcTemplate)

    }

    @Test
    fun getAll() {
        val breweries = repo.getAll().collectList().block()

        assertThat(breweries).isEqualTo(
                listOf(
                        BrewerySchema(1, "Asahi"),
                        BrewerySchema(2, "Kirin"),
                        BrewerySchema(3, "Sapporo")
                )
        )
    }

    @Test
    fun find() {
        val brewery = repo.find(1).block()

        assertThat(brewery).isEqualTo(BrewerySchema(1, "Asahi"))
    }
}

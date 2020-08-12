package io.umehara.beerstore.v1.brewery.repo

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.sql.ResultSet

@Repository
class DatabaseBreweryRepo(val jdbcTemplate: JdbcTemplate) : BreweryRepo {
    override fun getAll(): Flux<BrewerySchema> {
        val breweries = jdbcTemplate.query(
                "select * from breweries",
                BreweryRowMapper()
        )

        return Flux.fromIterable(breweries)
    }

    override fun find(id: Int): Mono<BrewerySchema> {
        val sql = "select * from breweries where id=?"
        val brewery = jdbcTemplate.queryForObject(
                sql,
                BreweryRowMapper(),
                id
        ) ?: throw Exception()

        return Mono.just(brewery)
    }

    private class BreweryRowMapper : RowMapper<BrewerySchema> {
        override fun mapRow(rs: ResultSet, rowNum: Int): BrewerySchema? {
            return BrewerySchema(
                    rs.getInt("id"),
                    rs.getString("name")
            )
        }
    }
}

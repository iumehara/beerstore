package io.umehara.beerstore.v1.brewery.repo

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import java.sql.ResultSet

@Repository
class DatabaseBeerRepo(val jdbcTemplate: JdbcTemplate) : BeerRepo {
    override fun getAllForBrewery(breweryId: Int): Flux<BeerSchema> {
        val beers = jdbcTemplate.query(
                "select * from beers where brewery_id=?",
                BeerRowMapper(),
                breweryId
        )


        return Flux.fromIterable(beers)
    }

    private class BeerRowMapper : RowMapper<BeerSchema> {
        override fun mapRow(rs: ResultSet, rowNum: Int): BeerSchema? {
            return BeerSchema(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("brewery_id")
            )
        }
    }
}

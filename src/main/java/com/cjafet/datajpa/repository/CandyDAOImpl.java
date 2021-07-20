package com.cjafet.datajpa.repository;

import com.cjafet.datajpa.data.CandyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CandyDAOImpl implements CandyDAO {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    private static final String SELECT_ALL_CANDY = "SELECT * FROM candy";
    private static final String SELECT_ALL_CANDY_BY_DELIVERY_ID = "SELECT * FROM candy_delivery WHERE delivery_id = :deliveryId";
    private static final String INSERT_DELIVERY = "INSERT INTO candy_delivery (candy_id, delivery_id) VALUES (:candyId,:deliveryId)";


    @Override
    public List<CandyData> list() {

        return jdbcTemplate.query(SELECT_ALL_CANDY,
                new BeanPropertyRowMapper<CandyData>());
    }

    @Override
    public void addToDelivery(Long candyId, Long deliveryId) {

        jdbcTemplate.update(
                INSERT_DELIVERY,
                new MapSqlParameterSource()
                        .addValue("candyId", candyId)
                        .addValue("deliveryId", deliveryId)
                );

    }

    @Override
    public List<CandyData> findByDelivery(Long deliveryId) {

        return jdbcTemplate.query(
                SELECT_ALL_CANDY_BY_DELIVERY_ID,
                new MapSqlParameterSource("deliveryId", deliveryId),
                new BeanPropertyRowMapper<CandyData>()
        );
    }
}

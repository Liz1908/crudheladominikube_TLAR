package com.Helados.crudhelado.repositories;
import com.Helados.crudhelado.model.Helado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;



@Repository
public class HeladoRepository {
    
    //declaramos una dependencia
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final HeladoMapper mapper = new HeladoMapper();
    private final SimpleJdbcInsert insert;
    private final String table = "helados";
    //iniciamso constructor
    public HeladoRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource){
        this.jdbcTemplate = namedParameterJdbcTemplate;
        this.insert = new SimpleJdbcInsert(dataSource).withTableName(table)
                .usingGeneratedKeyColumns("id");
    }
    //primera query para leer los helados
    public List<Helado> getAllHelados(){
        String sql = "select * from " + table;
        return jdbcTemplate.query(sql, mapper);
    }

    /**public long createHelados(Helado newHelado){
      return insert.executeAndReturnKey(
                new MapSqlParameterSource("sabor", newHelado.sabor)
      ).longValue();
    }*/
    public long createHelados(Helado newHelado){
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("sabor", newHelado.sabor);
        params.addValue("tvaso", newHelado.tvaso); // Agregar el parámetro tvaso
        params.addValue("precio", newHelado.precio); // Agregar el parámetro precio
        params.addValue("disponibles", newHelado.disponibles); // Agregar el parámetro disponibilidad
    
        return insert.executeAndReturnKey(params).longValue();
    }

    public Helado getHeladoById(Long id) {
        String sql = "SELECT * FROM " + table + " WHERE id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource("id", id);
        return jdbcTemplate.queryForObject(sql, params, mapper);
    }

    public void updateHelado(Long id, Helado updatedHelado) {
        String sql = "UPDATE " + table + " SET sabor = :sabor, tvaso = :tvaso, precio = :precio, disponibles = :disponibles WHERE id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        params.addValue("sabor", updatedHelado.getSabor());
        params.addValue("tvaso", updatedHelado.getTvaso());
        params.addValue("precio", updatedHelado.getPrecio());
        params.addValue("disponibles", updatedHelado.getDisponibles());
        jdbcTemplate.update(sql, params);
    }

    public void deleteHelado(Long id) {
        String sql = "DELETE FROM " + table + " WHERE id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource("id", id);
        jdbcTemplate.update(sql, params);
    }

    private static class HeladoMapper implements RowMapper<Helado> {

        @Override
        public Helado mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id = rs.getLong("id");
            String sabor = rs.getString("sabor");
            String tvaso = rs.getString("tvaso");
            double precio = rs.getDouble("precio");
            int disponibles = rs.getInt("disponibles"); 
            return new Helado(id, sabor, tvaso, precio, disponibles);
        }
    }
}

package org.mahagan.software.service.Dao;

import org.mahagan.software.service.Domain.Project;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectDao {

    private JdbcTemplate jdbcTemplate;

    private final String sqlNoOfRecordFetched = "SELECT *FROM project";

    public ProjectDao(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Project> getAllProjects()
    {
        List<Project> projects = jdbcTemplate.queryForObject(sqlNoOfRecordFetched, new ProjectRowMapper());

        for (Project project:projects){
            System.out.println(project);
        }
        return projects;
    }


    private final class ProjectRowMapper implements RowMapper<List<Project>>{


        /**
         *
         * @param resultSet the ResultSet to map (pre-initialized for the current row)
         * @param rowNum the number of the current row
         * @return
         * @throws SQLException
         */
        @Override
        public List<Project> mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            List<Project> projects = new ArrayList<Project>();
            while (resultSet.next()){

                Project project = new Project();
                project.setProjectNo(resultSet.getInt(1));
                project.setTitle(resultSet.getString(2));
                project.setDescription(resultSet.getString(3));
                project.setDuration(resultSet.getInt(4));
                project.setStatus(resultSet.getString(5));
                projects.add(project);
            }

            return projects;
        }
    }
}

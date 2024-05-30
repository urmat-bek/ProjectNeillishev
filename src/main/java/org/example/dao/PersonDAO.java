package org.example.dao;


import org.example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    //  для показа списков всех людей
    public List<Person> index(){

        return  jdbcTemplate.query("Select * from Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id){
        // with jdbc API
//        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
//        Person person = null;
//
//        try {
//            PreparedStatement preparedStatement =
//                    connection.prepareStatement("Select * from Person where id=?");
//            preparedStatement.setInt(1, id);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            resultSet.next();
//
//            person = new Person();
//
//            person.setId(resultSet.getInt("id"));
//            person.setName(resultSet.getString("name"));
//            person.setAge(resultSet.getInt("age"));
//            person.setEmail(resultSet.getString("email"));
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return person;

        return jdbcTemplate.query("Select * from Person where id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }



    /*
    Добавления нового человека
    */
    public void save(Person person) {

        jdbcTemplate.update("Insert Into Person values (1, ?,?,?)", person.getName(), person.getAge(), person.getEmail());

//        try {
//            PreparedStatement preparedStatement =
//                    connection.prepareStatement("Insert into Person VALUES (1, ?, ?, ?)");
//            preparedStatement.setString(1, person.getName());
//            preparedStatement.setInt(2, person.getAge());
//            preparedStatement.setString(3, person.getEmail());
//
//            preparedStatement.executeUpdate();
//
//
////              Это с помошью обычного Statement
////            Statement statement = connection.createStatement();
////            // Insert into Person Values(1, 'name', age, 'email')
////            String SQL = "Insert into Person Values(" + 1 + ",'" + person.getName() + "', " + person.getAge() + ",'" + person.getEmail() + "')";
////            statement.executeUpdate(SQL);
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE Person set name=?, age=?, email=? WHERE id=?", updatedPerson.getName(),
                updatedPerson.getAge(), updatedPerson.getEmail(), id);

//        try {
//            PreparedStatement preparedStatement =
//                    connection.prepareStatement("UPDATE Person Set name=?, age=?, email=? where id=?");
//            preparedStatement.setString(1, updatedPerson.getName());
//            preparedStatement.setInt(2 ,updatedPerson.getAge());
//            preparedStatement.setString(3, updatedPerson.getEmail());
//            preparedStatement.setInt(4 ,updatedPerson.getId());
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

    }

    public void delete(int id) {

        jdbcTemplate.update("Delete from Person where id=?" ,id);

//        try {
//            PreparedStatement preparedStatement  = connection.prepareStatement("DELETE from Person where id = ?");
//            preparedStatement.setInt(1, id);
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

    }


}

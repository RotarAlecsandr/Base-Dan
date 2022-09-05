package util;
import repository.User;
import java.sql.*;
public class WorkingWithEntities {

    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "erutus91";
    private static final String URL = "jdbc:postgresql://localhost:5432/MB";

    public void  connectJbdc(){
            try {
                Connection connection = DriverManager.getConnection(USERNAME, PASSWORD, URL);
                if (connection == null){
                    System.out.println("Соединение установленно");
                } else {
                    System.out.println("Соединение не установленно");
                }
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    public void tableCreation(){
        try{
        Connection connection = DriverManager.getConnection(USERNAME, PASSWORD, URL);
        String table = "CREATE TABLE userBD (id int, first_name char, last_name char, age int)";
            PreparedStatement preparedStatement = connection.prepareStatement(table);
            preparedStatement.executeUpdate();
            System.out.println("Таблица созданна...");
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void fillingInTheTable(User user, String addUser) {
        try {
            Connection connection = DriverManager.getConnection(USERNAME, PASSWORD, URL);
            PreparedStatement preparedStatement = connection.prepareStatement(addUser);
            preparedStatement.setString(1, String.valueOf(user.getId()));
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, String.valueOf(user.getAge()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public  void viewAllUsers(){
        try {
        Connection connection = DriverManager.getConnection(USERNAME, PASSWORD, URL);
        String viewUsers = "select * from userdb";
        PreparedStatement preparedStatement = connection.prepareStatement(viewUsers);
        ResultSet resultSet = preparedStatement.executeQuery(viewUsers);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int age = resultSet.getInt("age");
                String first = resultSet.getString("first_name");
                String last = resultSet.getString("last_name");

                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", FirstName: " + first);
                System.out.println(", LastName: " + last);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletingUser() {
        try {
            Connection connection = DriverManager.getConnection(USERNAME, PASSWORD, URL);
            String deleteUsers = "DELETE FROM users1 WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteUsers);
            preparedStatement.setInt(1, 4);
            int count = preparedStatement.executeUpdate();
            System.out.println("Удалена " + count + " строка из табллицы данных");
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectAllUsers(){
        try{
            Connection connection = DriverManager.getConnection(USERNAME, PASSWORD, URL);
            String selectUsers = "SELECT id, first_name, last_name, age FROM users1";
            PreparedStatement preparedStatement = connection.prepareStatement(selectUsers);
            ResultSet resultSet= preparedStatement.executeQuery(selectUsers);
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                int age = resultSet.getInt("age");
                String first = resultSet.getString("first_name");
                String last = resultSet.getString("last_name");

                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", FirstName: " + first);
                System.out.println(", LastName: " + last);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectUser(){
        try{
            Connection connection = DriverManager.getConnection(USERNAME, PASSWORD, URL);
            String selUsers = "select * from users1 where id in (2)";
            PreparedStatement preparedStatement = connection.prepareStatement(selUsers);
            ResultSet resultSet = preparedStatement.executeQuery(selUsers);
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                int age = resultSet.getInt("age");
                String first = resultSet.getString("first_name");
                String last = resultSet.getString("last_name");

                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", FirstName: " + first);
                System.out.println(", LastName: " + last);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateUser(){
        try{
            Connection connection = DriverManager.getConnection(USERNAME, PASSWORD, URL);
            String updateUsers = "UPDATE users1 SET age =  30  where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateUsers);
            preparedStatement.setInt(1, 1);
            int count = preparedStatement.executeUpdate();
            System.out.println("Внесено " + count + " изменений в табллицу данных");
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAllUsers(){
        try {
            Connection connection = DriverManager.getConnection(USERNAME, PASSWORD, URL);
            String delUsers = "DELETE FROM users1";
            PreparedStatement preparedStatement = connection.prepareStatement(delUsers);
            int count = preparedStatement.executeUpdate();
            System.out.println("Удалена " + count + " строки из табллицы данных");
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

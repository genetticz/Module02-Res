package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DbConnection {


    /**
     *
     * This is a helper class to interact with MySQL Database tables
     * You are free to enhance this class as needed
     *
     * */


   static Connection connect = null;
   static Statement statement = null;
   static ResultSet resultSet = null;
   static PreparedStatement ps = null;


   public static Properties loadProperties() throws IOException {

       InputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/modul_02_java_test_b2001/module_02_test/src/main/resources/secret.properties");

       Properties properties = new Properties();
       properties.load(inputStream);
       inputStream.close();
       return properties;
   }

    public static void connectPsql() throws ClassNotFoundException, SQLException, IOException {


        Properties properties = loadProperties();

        String url = properties.getProperty("POSTGRES.url");
        String userName = properties.getProperty("POSTGRES.userName");
        String passWord = properties.getProperty("POSTGRES.password");

        Class.forName("org.postgresql.Driver");

        connect = DriverManager.getConnection(url,userName,passWord);

        System.out.println("Database Connected");

    }
    /**
     * Read database
     *
     * */

    public static List<String> readDatabase(String tableName, String nameOfColumn1) throws SQLException, ClassNotFoundException, IOException {

        List<String> list;

        connectPsql();
        statement = connect.createStatement();
        resultSet = statement.executeQuery("select * from "+ tableName);
        list = getResultSetData(nameOfColumn1);
        closeConnection();
        return list;
    }

    public static List<String> getResultSetData(String nameOfColumn1) throws SQLException {

        List<String> dataList = new ArrayList<>();

        while (resultSet.next()){

            String cell1 = resultSet.getString(nameOfColumn1);

            dataList.add(cell1);
        }

        return dataList;

    }

    public static List<String> readDatabase(String tableName, String desiredColumn, String nameOfColumn1,String nameOfColumn2, String name, String lastName)  {

        List<String> list = null;

        try {
            connectPsql();
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select " + desiredColumn + " from "
                    + tableName + " where " + nameOfColumn1 + " = '" + name + "' and " + nameOfColumn2 + " = '" + lastName+"'");
            list = getResultSetData();
        } catch(SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        catch (ClassNotFoundException classNotFoundException){
            System.out.println(classNotFoundException.getMessage());
        }
        catch (IOException ioException){
            System.out.println(ioException.getMessage());
        }
        return list;
    }

    public static List<String> getResultSetData() throws SQLException {

        List<String> dataList = new ArrayList<>();

        while (resultSet.next()){

            String cell1 = resultSet.getString(1);
//            String cell2 = resultSet.getString(nameOfColumn2);

            dataList.add(cell1);
//            dataList.add(cell2);

        }

        return dataList;

    }

    /**
     *
     * Create Table
     *
     * */

    public static void createTableFromStringToPsql(String tableName, String columnName1, String columnName2, String columnName3, String columnName4) throws SQLException {
        try {
            connectPsql();
            ps = connect.prepareStatement("DROP TABLE IF EXISTS "+tableName+"");
            ps.executeUpdate();
            ps = connect.prepareStatement("CREATE TABLE "+tableName+" ("+columnName1+" int," +
                    " "+columnName2+" varchar(2500), "+columnName3+" varchar(2500), " +
                    ""+columnName4+" float, PRIMARY KEY (ID) )");
            ps.executeUpdate();
            System.out.println("Created " + tableName + " table");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection();
        }

    }

    /**
     *
     * Insert data to a existing table
     *
     * */
    public static void insertDataFromArrayListToPsql(List<String> list, String tableName, String columnName1, String columnName2, String columnName3, String columnName4) throws SQLException {
        try {
            connectPsql();
            int counter = 1;
            int columnCounter = 1;
            int min = 15;
            int end = 50;
            int range = end-min;
            double price;
            String firstName;
            String lastName;
            for(String st:list){

                ps = connect.prepareStatement("INSERT INTO "+tableName+" " +
                        "("+columnName1+","+columnName2+","+columnName3+","+columnName4+") " +
                        "values(?,?,?,?)");

                firstName = st.split(" ")[0];
                lastName  = st.split(" ")[1];
                price = round(min + (double) (Math.random() * range),2);
                ps.setObject(columnCounter,counter);
                ps.setObject(columnCounter+=1,firstName);
                ps.setObject(columnCounter+=1,lastName);
                ps.setObject(columnCounter+=1,price);
                counter++;
                columnCounter =1;
                ps.executeUpdate();
            }

            System.out.println("Inserted into database");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection();
        }
    }

    public static void insertDataFromArrayListToPsql(Iterable list, String tableName, String columnName1) throws SQLException {
        try {
            connectPsql();

            for(Object st : list){

                ps = connect.prepareStatement("INSERT INTO "+tableName + " ("+columnName1+") values(?)");
                ps.setObject(1,st);
                ps.executeUpdate();
            }

            System.out.println("Inserted into database");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection();
        }
    }

    public static void insertDataFromArrayListToPsql(Map<String,Integer> map, String tableName, String columnName1, String columnName2) throws SQLException {
        try {
            connectPsql();

            for(Map.Entry<String,Integer> st: map.entrySet()){

                ps = connect.prepareStatement("INSERT INTO "+tableName + " ("+columnName1+","+columnName2+") values(?,?)");
                ps.setObject(1, st.getKey());
                ps.setObject(2,st.getValue());
                ps.executeUpdate();
            }

            System.out.println("Inserted into database");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection();
        }
    }


    public static void closeConnection () throws SQLException {

        connect.close();
        System.out.println("Connection closed");
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


}


import java.sql.*;

class Main{
    public static void main(String ss[]){
        try{

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","user_id","password");
            Statement statement = con.createStatement();
            long i = statement.executeUpdate("insert into employees values(7,'kuldeep',5,24)");
            if(i>0){
                System.out.println("Record inserted.....");
            }else {
                System.out.println("Something went wrong....");
            }

            ResultSet res = statement.executeQuery("select * from employees");

            while (res.next()){
                int eid = res.getInt("id");
                String emName = res.getString("name");
                int exp = res.getInt("experience");
                int age = res.getInt("Age");

                System.out.println(eid+" "+emName+" "+exp+" "+age);
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
}

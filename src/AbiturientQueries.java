import java.sql.*;

public class AbiturientQueries {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/university";
    static final String USER = "root";
    static final String PASS = "Password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();


            String queryA = "SELECT * FROM Abiturient ORDER BY average_score DESC";
            ResultSet resultA = stmt.executeQuery(queryA);

            System.out.println("Список абітурієнтів із вказаним іменем, в порядку спадання середнього балу:\n");
            while (resultA.next()) {
                System.out.println(resultA.getString("last_name") + " " + resultA.getString("first_name") +
                        " " + resultA.getString("patronymic") + " " + resultA.getDouble("average_score"));
            }
            System.out.println();


            double targetAverageScore = 80.0;
            String queryB = "SELECT * FROM Abiturient WHERE average_score > " + targetAverageScore;
            ResultSet resultB = stmt.executeQuery(queryB);

            System.out.println("Список абітурієнтів, середній бал у яких вище заданого:\n");
            while (resultB.next()) {
                System.out.println(resultB.getString("last_name") + " " + resultB.getString("first_name") +
                        " " + resultB.getString("patronymic") + " " + resultB.getDouble("average_score"));
            }
            System.out.println();


            int topN = 5;
            String queryC = "SELECT * FROM Abiturient ORDER BY average_score DESC LIMIT " + topN;
            ResultSet resultC = stmt.executeQuery(queryC);

            System.out.println("Вибрати задане число n абітурієнтів, що мають найвищий середній бал:\n");
            while (resultC.next()) {
                System.out.println(resultC.getString("last_name") + " " + resultC.getString("first_name") +
                        " " + resultC.getString("patronymic") + " " + resultC.getDouble("average_score"));
            }
            System.out.println();


            String queryD = "SELECT * FROM Abiturient ORDER BY last_name, first_name";
            ResultSet resultD = stmt.executeQuery(queryD);

            System.out.println("Список абітурієнтів в порядку алфавіту за прізвищем, при збігу прізвищ – за іменами:\n");
            while (resultD.next()) {
                System.out.println(resultD.getString("last_name") + " " + resultD.getString("first_name") +
                        " " + resultD.getString("patronymic") + " " + resultD.getDouble("average_score"));
            }
            System.out.println();


            String queryE = "SELECT DISTINCT birth_year FROM Abiturient ORDER BY birth_year";
            ResultSet resultE = stmt.executeQuery(queryE);

            System.out.println("Список років народження абітурієнтів в порядку зростання без повторів:\n");
            while (resultE.next()) {
                System.out.println(resultE.getInt("birth_year"));
            }
            System.out.println();


            String queryF = "SELECT birth_year, COUNT(*) as count FROM Abiturient GROUP BY birth_year";
            ResultSet resultF = stmt.executeQuery(queryF);

            System.out.println("Визначити кількість абітурієнтів кожного року народження:\n");
            while (resultF.next()) {
                System.out.println(resultF.getInt("birth_year") + ": " + resultF.getInt("count") + " абітурієнтів");
            }
            System.out.println();

        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}

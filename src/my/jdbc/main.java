package my.jdbc;

public class main {
    public static void main(String[] args) {
        DBWorker db = new DBWorker();
        db.getRows();
        db.close();
    }
}

package my.jdbc;

public class main {
    public static void main(String[] args) {

//        String login = "any@mail.com";
//        String password = "123";
//        String name = "Lena";
//        String age = "18";
//        String gender = "M";
//        String address = "Ukraine";
//        String comment = "1";

        DBWorker db = new DBWorker();
//        db.getUsers();
//        System.out.println(db.checkUserByLogin("admin@itea.ua"));
//        db.registerUser(login,password,name,age,gender,address,comment);
        db.close();
    }
}

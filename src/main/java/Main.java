import repository.User;
import util.WorkingWithEntities;

public class Main {


    public static void main(String[] args) {

        User user = new User(1, "Kozlov", "Ivan", 23);
        User user1 = new User(2, "Petrov", "Petr", 22);
        User user2 = new User(3, "Stepanov", "Stepan", 32);
        User user3 = new User(1, "Nikolaev", "Niklay", 45);

        WorkingWithEntities workingWithEntities = new WorkingWithEntities();
           workingWithEntities.connectJbdc();
            //workingWithEntities.tableCreation();
       // workingWithEntities.viewAllUsers();
       // workingWithEntities.updateUser();


    }
}

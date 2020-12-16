package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User findUsr = null;
        for (int index = 0; index < users.length; index++) {
            if (users[index].getUsername().equals(login)) {
                findUsr = users[index];
                break;
            }
        }
        if (findUsr == null) {
            throw new UserNotFoundException("User Not Found Exception!!!!!!!");
        }
        return findUsr;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException(user + " User does not have access!!!!!!!!");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Ruslan Faiziev", true),
                new User("Petr Arsentev", true),
                new User("AN", true),
        };

        try {
            User user1 = findUser(users, "Ruslan Faiziev");
            User user2 = findUser(users, "Petr Arsentev");
            User user3 = findUser(users, "AN");
            if (validate(user1)) {
                System.out.println(user1 + " This user has an access");
            }
            if (validate(user2)) {
                System.out.println(user2 + " This user has an access");
            }
            if (validate(user3)) {
                System.out.println(user3 + " This user has an access");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
//        } catch (UserInvalidException ui) {
//            ui.printStackTrace();
//        } catch (UserNotFoundException un) {
//            un.printStackTrace();
//        }
    }
}
package collectiondemos;

public class ChangePassword {
    private String password;

    //inner class
    private class HashPassword {
        public void encrypt(String password) {
            System.out.println("Encrypt password ");
        }
    }
            //static inner classes
        static class DecodePassword
        {

        }
        public void checkPassword(){
            //local inner class
            class  A{

            }
        }

    public static void main(String[] args) {
        ChangePassword obj = new ChangePassword();
        ChangePassword.HashPassword hp = obj.new HashPassword();
        hp.encrypt("neha@123");
    }
}




package dz4;

public class z1 {
    public static class WrongPasswordException extends RuntimeException {
        private int correntLength;
        private boolean matchConfirm;

        public WrongPasswordException(int correntLength, boolean matchConfirm) {
            super();
            this.correntLength = correntLength;
            this.matchConfirm = matchConfirm;
        }

        @Override
        public String getMessage() {
            boolean badlen = correntLength <= 20;
            return String.format("пароль не верный", ((badlen) ? "in" : ""), ((badlen) ? "> 20" : ","), correntLength, (matchConfirm) ? "" : "not");
        }
    }

    public static class WrongLoginException extends RuntimeException {
        private int correntLength;

        public WrongLoginException(int correntLength) {
            super();
            this.correntLength = correntLength;
        }

        @Override
        public String getMessage() {
            return String.format("Логин не правильный");
        }
    }

    public static boolean checkinfo(String login, String password, String confirm) {
        boolean conf = password.equals(confirm);
        int llen = login.length();
        int plen = password.length();
        if (llen >= 20) {
            throw new WrongLoginException(llen);
        } else if (plen < 20 || !conf)
            throw new WrongPasswordException(plen, conf);
        else return true;
    }

    public static void main(String[] args) {
        String[][] input = {{"David", "a1111111111111111111", "a1111111111111111111"}, {"12312321", "", ""}};
        for (int i = 0; i < input.length; i++) {
            try {
                System.out.println(checkinfo(input[i][0],input[i][1],input[i][2]));
            } catch (WrongLoginException e){
                e.printStackTrace();
            }catch (WrongPasswordException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
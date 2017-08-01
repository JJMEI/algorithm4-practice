//package cn.meijunjie.innerclass;
//
//public class TestInnerClass {
//
//    private String hello = new String();
//    private static String string = "I fuck you";
//
//    public String getHello() {
//        return hello;
//    }
//
//    static  class testStaticInnerClass
//    {
//        public void test()
//        {
//            System.out.println(stringå);
//        }
//    }
//    class User
//    {
//        private String username;
//        private String password;
//        public void setHello()
//        {
//            hello = "I can get Outter's field";
//        }
//
//        public TestInnerClass getTestInnerClass()
//        {
//            return TestInnerClass.this;
//        }
//
//        public String getUsername() {
//            return username;
//        }
//
//        public void setUsername(String username) {
//            this.username = username;
//        }
//
//        public String getPassword() {
//            return password;
//        }
//
//        public void setPassword(String password) {
//            this.password = password;
//        }
//
//
//
//        @Override
//        public String toString() {
//            return "User{" +
//                    "username='" + username + '\'' +
//                    ", password='" + password + '\'' +
//                    '}';
//        }
//    }
//
//    public User getUser()
//    {
//        return new User();
//    }
//
//    public static void main(String[] args)
//    {
////        User user = new User();  //这样写是访问不到内部类的 必须要以OutterClassName.InnerClassName的形式来访问内部类
//
//        TestInnerClass innerClass = new TestInnerClass();
//
////        TestInnerClass.User user = innerClass.getUser();
//
//        TestInnerClass.User user = innerClass.new User();
//
//        user.setPassword("3232");
//        user.setUsername("dasdasd");
//        user.setHello();
//
//        System.out.println(user.toString());
//
//        System.out.println(innerClass.getHello());
//    }
//}

package cn.meijunjie.testng;

public class TestHelloWorld {

    @Test
    public void testEmailGenerator()
    {
        RandomEmailGenerator randomEmailGenerator = new RandomEmailGenerator();
        String email = randomEmailGenerator.generate();


    }
}

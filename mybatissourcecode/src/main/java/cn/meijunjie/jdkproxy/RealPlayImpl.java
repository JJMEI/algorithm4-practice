package cn.meijunjie.jdkproxy;

public class RealPlayImpl implements Play {

    @Override
    public String playGame(String gameName) {
        return "Play "+gameName;
    }

    @Override
    public String playBall(String ballName) {
        return "Play " + ballName;
    }
}

package lotto;

import java.util.Arrays;
import java.util.Collections;

public enum Result {
    RANK1(6, 1, 2000000000), //6개 당첨 -> 1등
    RANK2(10, 2, 30000000), //5개 당첨 + 보너스번호 성공 시 5를 추가하도록 설정해놨으므로 winning이 10이면 2등
    RANK3(5, 3, 1500000),  //5개 당첨 + 보너스번호 실패 -> 3등
    RANK4(4, 4, 50000),    //4개 당첨 -> 4등
    RANK5(3, 5, 5000),     //3개 당첨 -> 5등
    NOLUCK(-1,0, 0);      //3개 미만 당첨 -> 꽝

    private final int winning;
    private final int rank;
    private final long prizeMoney;

    Result(int winning, int rank, long prizeMoney) {
        this.winning = winning;
        this.rank = rank;
        this.prizeMoney = prizeMoney;
    }

    public static Result getResult(int winning) {
        return Arrays.stream(Result.values())
                .filter(x -> x.winning == winning)
                .findAny()
                .orElse(NOLUCK);


    }

    public long getPrizeMoney() {
        return this.prizeMoney;
    }

    public int getRank() {
        return this.rank;
    }

    public static long getReward(int winningNum) {
        return getResult(winningNum).getPrizeMoney();
    }
    public static int getRanking(int winningNum) {
        return getResult(winningNum).getRank();
    }
}

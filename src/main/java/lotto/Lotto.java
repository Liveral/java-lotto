package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> winningNumbers;
    private int bonusNumber;

    public List<Integer> getNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public Lotto(List<Integer> numbers) {
        sizeCheck(numbers);
        duplicateCheck(numbers);
        for (int inputNumber : numbers) {
            rangeCheck(inputNumber);
        }

        this.winningNumbers = numbers;
    }

    private void sizeCheck(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public void duplicateCheck(List<Integer> numbers) {
        Set<Integer> OneAndOnlyNumbers = new HashSet<>(numbers);    //HashSet<>()은 중복저장을 허용하지 않습니다.

        if (OneAndOnlyNumbers.size() != Constants.LOTTO_NUMBER_SIZE) {  //Set의 길이가 LOTTO_NUMBER_SIZE와 다르다면 중복되는 숫자가 있어서 변했다는 뜻
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }

    }

    public void rangeCheck(int number) {
        if (number < Constants.MIN_NUMBER || number > Constants.MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public void setBonusNumber(int inputNumber){
        rangeCheck(inputNumber);

        this.bonusNumber=inputNumber;
    }

    public void bonusDuplicateCheck(int bonusInput){
        if(winningNumbers.contains(bonusInput)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 기존 당첨 번호와 중복될 수 없습니다.");
        }
    }

}



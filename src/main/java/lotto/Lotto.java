package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        sizeCheck(numbers);
        duplicateCheck(numbers);
        rangeCheck(numbers);
        this.numbers = numbers;
    }

    private void sizeCheck(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public void duplicateCheck(List<Integer> numbers) {
        Set<Integer> OneandOnlyNumbers = new HashSet<>(numbers);    //HashSet<>()은 중복저장을 허용하지 않습니다.

        if (OneandOnlyNumbers.size() != Constants.LOTTO_NUMBER_SIZE) {  //Set의 길이가 LOTTO_NUMBER_SIZE와 다르다면 중복되는 숫자가 있어서 변했다는 뜻
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }

    }

    public void rangeCheck(List<Integer> numbers){
        for (int number : numbers){
            if(number<Constants.MIN_NUMBER||number>Constants.MAX_NUMBER){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }




}

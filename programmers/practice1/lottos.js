function solution(lottos, win_nums) {
    let answer = [];
    
    const correct = lottos.filter(lotto => win_nums.includes(lotto)).length;
    
    const zeros = lottos.filter(lotto => lotto === 0).length;
    
    
    let min = 7-correct >= 6 ? 6 : 7-correct;
    let max = min-zeros < 1 ? 1 : min-zeros;
    
    answer = [max, min]
    return answer;

}

solution([44, 1, 0, 0, 31, 25],[31, 10, 44, 1, 7, 25])
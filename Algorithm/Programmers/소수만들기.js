function solution(nums) {
    var answer = 0;
    
    for(let i = 0; i < nums.length-2; i++){
        for(let j = i+1; j < nums.length-1; j++){
            for(let k = j+1; k < nums.length; k++){
                let sum = nums[i] + nums[j] + nums[k]
                answer++;
                for(let n = 2 ; n <= Math.sqrt(sum); n++){
                    if(sum % n === 0){
                        answer--;
                        break;
                    }
                } 
                
            }
        }
    }
    
    return answer;
}
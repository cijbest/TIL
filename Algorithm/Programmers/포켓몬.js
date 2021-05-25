function solution(nums) {

    let choice = nums.length/2;
    const newArr = new Set(nums);
    //console.log(newArr.size);
    /*
    let newArr = nums.filter((element, index) => {
        return nums.indexOf(element) === index;
    });*/
    /*
    let newArr = [];
    nums.forEach((element) => {
        if (!newArr.includes(element)) {
            newArr.push(element);
        }
    });
    */
    
    
    if(choice >= newArr.size){
        return newArr.size;
    }else{
        return choice;
    }
    

}
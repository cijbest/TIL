// <1>
var a = 5;
//a = 'hello'; // 에러
a = 10;
// <2>
var student = {
    name: 'Jake',
    course: 'Gettin Started with TypeScript',
    codingIQ: 80,
    code: function () {
        console.log('brain is working hard');
    }
};
// student.name = 10; // 에러
student.name = 'Ella';
// <3>
function claculateCodingIQ(lostPoints) {
    return 100 - lostPoints;
}

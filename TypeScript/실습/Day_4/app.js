var studentID = 12345;
//let studentID:number = 'hello'; // 에러
var studentName = 'Jenny Kim';
var age = 21;
var gender = 'female';
var subject = 'Javascript';
var courseCompleted = false;
var student1 = {
    studentID: 121212,
    studentName: 'Jane',
    age: 30,
    gender: 'female',
    subject: 'Mongo DB',
    courseCompleted: false
};
function getStudentDetails(studentID) {
    return {
        studentID: 123456,
        studentName: 'Mark',
        //age: 20,
        gender: 'male',
        subject: 'Node JS',
        courseCompleted: true
    };
}
function saveStudentDetails(student) {
    student.studentID = 112233;
}
saveStudentDetails(student1);

var studentID = 12345;
//let studentID:number = 'hello'; // 에러
var studentName = 'Jenny Kim';
var age = 21;
var gender = 'female';
var subject = 'Javascript';
var courseCompleted = false;
var GenderType;
(function (GenderType) {
    GenderType["Male"] = "male";
    GenderType["Female"] = "female";
    GenderType["genderNeutral"] = "genderNeutral";
})(GenderType || (GenderType = {}));
/*
enum GenderType { // Numeric Enum (숫자형 열거형)
    Male,
    Female,
    genderNeutral
}
*/
var student1 = {
    studentID: 121212,
    studentName: 'Jane',
    age: 30,
    //gender: GenderType.Female,
    gender: 'female',
    subject: 'Mongo DB',
    courseCompleted: false
};
function getStudentDetails(studentID) {
    return {
        studentID: 123456,
        studentName: 'Mark',
        //age: 20,
        //gender: GenderType.Male,
        gender: 'male',
        subject: 'Node JS',
        courseCompleted: true
    };
}
function saveStudentDetails(student) {
}
saveStudentDetails(student1);

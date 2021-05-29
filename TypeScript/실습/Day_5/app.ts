let studentID:number = 12345;
//let studentID:number = 'hello'; // 에러
let studentName:string = 'Jenny Kim';
let age:number = 21;
let gender:string = 'female';
let subject:string = 'Javascript';
let courseCompleted:boolean = false;


enum GenderType { // String Enum (문자형 열거형)
    Male = 'male',
    Female = 'female',
    genderNeutral = 'genderNeutral'
}

/*
enum GenderType { // Numeric Enum (숫자형 열거형)
    Male,
    Female,
    genderNeutral
}
*/

let student1: Student = {
    studentID: 121212,
    studentName: 'Jane',
    age: 30,
    //gender: GenderType.Female,
    gender: 'female',
    subject: 'Mongo DB',
    courseCompleted: false
}

interface Student {
    readonly studentID: number;
    studentName: string;
    age?: number; // 있어도 되고 없어도 됨
    //gender: GenderType;
    gender: 'male'|'female'|'genderNeutral';
    subject: string;
    courseCompleted: boolean;
    //addComment (comment: string): string;
    addComment?: (comment: string) => string;
}

function getStudentDetails(studentID: number): Student{
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

function saveStudentDetails (student: Student): void{
    
}

saveStudentDetails(student1)
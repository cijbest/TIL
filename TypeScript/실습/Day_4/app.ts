let studentID:number = 12345;
//let studentID:number = 'hello'; // 에러
let studentName:string = 'Jenny Kim';
let age:number = 21;
let gender:string = 'female';
let subject:string = 'Javascript';
let courseCompleted:boolean = false;

let student1 = {
    studentID: 121212,
    studentName: 'Jane',
    age: 30,
    gender: 'female',
    subject: 'Mongo DB',
    courseCompleted: false
}

interface Student {
    readonly studentID: number;
    studentName: string;
    age?: number; // 있어도 되고 없어도 됨
    gender: string;
    subject: string;
    courseCompleted: boolean;
    //addComment (comment: string): string;
    addComment?: (comment: string) => string;
}

function getStudentDetails(studentID: number)
: Student{
    return {
        studentID: 123456,
        studentName: 'Mark',
        //age: 20,
        gender: 'male',
        subject: 'Node JS',
        courseCompleted: true
    }; 
}

function saveStudentDetails (student: Student): void{
    student.studentID = 112233;
}

saveStudentDetails(student1)
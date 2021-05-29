/* 함수의 반환타입 지정 */
function sendGreeting(message, userName): void {
    console.log(`${message}, ${userName}`);
}

sendGreeting('Hello', 'Mark');
/*
function sendGreeting(message, userName): string {
    return 'Hello, Mark';
}

function sendGreeting(message, userName): string[] {
    return ['Hello', 'Mark'];
}
*/

/* 함수의 매개변수 타입 지정 */
function sendGreeting1(message: string, userName: string): void {
    console.log(`${message}, ${userName}`);
}

sendGreeting1('Hello', 'Mark'); // Hello, undefined

/* 함수의 선택적 매개변수 */
function sendGreeting2(message: string, userName?: string): void {
    console.log(`${message}, ${userName}`);
}

sendGreeting2('Hello'); // Hello, undefined

/* 함수의 기본 매개변수 */
function sendGreeting3(message = 'Hello', userName ='there'): void {
    console.log(`${message}, ${userName}`);
}
const sendGreeting3 = (message = 'Hello', userName ='there'): void => console.log(`${message}, ${userName}`);


sendGreeting3(); // Hello, there
sendGreeting3('Good morning'); // Good morning, there
sendGreeting3('Good afternoon', 'Jenny'); // Good after, Jenny

/* 화살표 함수(Arrow Function) */
// 기존 함수
function add (num1, num2) {
    return num1 + num2;
}
// 화살표 함수
const add = (num1, num2) => num1 + num2;

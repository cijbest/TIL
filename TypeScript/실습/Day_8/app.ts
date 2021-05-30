/* 클래스 */
class Employee {
    // 프로퍼티(Property)
    fullName: string;
    age: number;
    jobTitle: string;
    hourlyRate: number;
    workingHourPerWeek: number;

    // 메소드(Method)
    printEmployeeDetails = (): void => {
        console.log(`${this.fullName}의 직업은 ${this.jobTitle}이고 일주일의 수입은 ${this.hourlyRate * this.workingHourPerWeek}달러 이다.`);
    }
}

/* 인스턴스 = 객체 만들기 */
let employee1 = new Employee();
employee1.fullName = '미래';
employee1.age = 20;
employee1.jobTitle = '주니어 웹개발자';
employee1.hourlyRate = 40;
employee1.workingHourPerWeek = 35;
employee1.printEmployeeDetails();
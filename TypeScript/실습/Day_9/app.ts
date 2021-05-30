/* 클래스 */
class Employee {
    /*
    // 프로퍼티(Property)
    private _fullName: string;
    age: number;
    jobTitle: string;
    hourlyRate: number;
    workingHourPerWeek: number;
    
    // 생성자(Constructor)
    constructor(fullName: string, age: number, jobTitle?: string, 
        hourlyRate?: number, workingHourPerWeek?: number) {
            this.fullName = fullName;
            this.age = age;
            this.jobTitle = jobTitle;
            this.hourlyRate = hourlyRate;
            this.workingHourPerWeek = workingHourPerWeek;
    }
    */
    // Constructor의 매개변수에 Access Modifiers 직접 적용
    constructor(
        private _fullName: string, 
        private _age: number, 
        private _jobTitle?: string, 
        private _hourlyRate?: number, 
        public workingHourPerWeek?: number) {
    }
    

    // Getter
    get fullName () {
        return this._fullName;
    }

    // Setter
    set fullName (value: string) {
        this._fullName = value;
    }

    // 메소드(Method)
    // public 메소드
    printEmployeeDetails = (): void => {
        console.log(`${this.fullName}의 직업은 ${this.jobTitle}이고 일주일의 수입은 ${this.hourlyRate * this.workingHourPerWeek}달러 이다.`);
    }
}

/* 인스턴스 = 객체 만들기 */
//let employee1 = new Employee();
let employee1 = new Employee('미래', 20, '주니어 웹개발자', 40, 35);
// employee1.fullName = '미래';
// employee1.age = 20;
// employee1.jobTitle = '주니어 웹개발자';
// employee1.hourlyRate = 40;
// employee1.workingHourPerWeek = 35;
employee1.printEmployeeDetails();

/* 생성자 선택적 매개변수 */
let employee2 = new Employee('미래', 20); // 미래의 직업은 undefined이고 일주일의 수입은 NaN달러 이다.
//let employee2 = new Employee('미래', 20, '주니어 웹개발자'); // 미래의 직업은 주니어 웹개발자이고 일주일의 수입은 NaN달러 이다. 
employee2.printEmployeeDetails();


/* 접근 제한자 */
let employee3 = new Employee('하나', 28, '프로젝트 매니저', 55, 35);
employee3.printEmployeeDetails() // 하나의 직업은 프로젝트 매니저이고 일주일의 수입은 1925달러 이다. 
employee3.fullName = '우주';
console.log(employee3.fullName);
employee3.printEmployeeDetails(); //우주의 직업은 프로젝트 매니저이고 일주일의 수입은 1925달러 이다.  
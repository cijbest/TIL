/* 클래스 */
var Employee = /** @class */ (function () {
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
    function Employee(_fullName, _age, _jobTitle, _hourlyRate, workingHourPerWeek) {
        var _this = this;
        this._fullName = _fullName;
        this._age = _age;
        this._jobTitle = _jobTitle;
        this._hourlyRate = _hourlyRate;
        this.workingHourPerWeek = workingHourPerWeek;
        // 메소드(Method)
        // public 메소드
        this.printEmployeeDetails = function () {
            console.log(_this.fullName + "\uC758 \uC9C1\uC5C5\uC740 " + _this.jobTitle + "\uC774\uACE0 \uC77C\uC8FC\uC77C\uC758 \uC218\uC785\uC740 " + _this.hourlyRate * _this.workingHourPerWeek + "\uB2EC\uB7EC \uC774\uB2E4.");
        };
    }
    Object.defineProperty(Employee.prototype, "fullName", {
        // Getter
        get: function () {
            return this._fullName;
        },
        // Setter
        set: function (value) {
            this._fullName = value;
        },
        enumerable: false,
        configurable: true
    });
    return Employee;
}());
/* 인스턴스 = 객체 만들기 */
//let employee1 = new Employee();
var employee1 = new Employee('미래', 20, '주니어 웹개발자', 40, 35);
// employee1.fullName = '미래';
// employee1.age = 20;
// employee1.jobTitle = '주니어 웹개발자';
// employee1.hourlyRate = 40;
// employee1.workingHourPerWeek = 35;
employee1.printEmployeeDetails();
/* 생성자 선택적 매개변수 */
var employee2 = new Employee('미래', 20); // 미래의 직업은 undefined이고 일주일의 수입은 NaN달러 이다.
//let employee2 = new Employee('미래', 20, '주니어 웹개발자'); // 미래의 직업은 주니어 웹개발자이고 일주일의 수입은 NaN달러 이다. 
employee2.printEmployeeDetails();
/* 접근 제한자 */
var employee3 = new Employee('하나', 28, '프로젝트 매니저', 55, 35);
employee3.printEmployeeDetails(); // 하나의 직업은 프로젝트 매니저이고 일주일의 수입은 1925달러 이다. 
employee3.fullName = '우주';
console.log(employee3.fullName);
employee3.printEmployeeDetails(); //우주의 직업은 프로젝트 매니저이고 일주일의 수입은 1925달러 이다.  

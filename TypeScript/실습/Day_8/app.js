/* 클래스 */
var Employee = /** @class */ (function () {
    function Employee() {
        var _this = this;
        // 메소드(Method)
        this.printEmployeeDetails = function () {
            console.log(_this.fullName + "\uC758 \uC9C1\uC5C5\uC740 " + _this.jobTitle + "\uC774\uACE0 \uC77C\uC8FC\uC77C\uC758 \uC218\uC785\uC740 " + _this.hourlyRate * _this.workingHourPerWeek + "\uB2EC\uB7EC \uC774\uB2E4.");
        };
    }
    return Employee;
}());
/* 인스턴스 = 객체 만들기 */
var employee1 = new Employee();
employee1.fullName = '미래';
employee1.age = 20;
employee1.jobTitle = '주니어 웹개발자';
employee1.hourlyRate = 40;
employee1.workingHourPerWeek = 35;
employee1.printEmployeeDetails();

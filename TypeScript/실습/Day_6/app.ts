/* any 타입 */
let someValue: any = 5; // 어떠한 타입이든 모두 ok
someValue = 'hello';
someValue = true;

/* 유니언 타입 */
let price: number | string = 5;
price = 'free';
price = true;

/* 타입 별칭 */
type StrOrNum = number | string;
let totalCost: number;
let orderID: StrOrNum;

const calculateTotalCost = (price: StrOrNum, qty: number): 
void => {

};

const findOrderID = (customer: { constomerId: StrOrNum, name: string}, 
    productID: StrOrNum): StrOrNum => {
        return orderID;
};

/* 타입 가드 */
type StringOrNum = string | number;
let itemPrice: number;

/*
const setItemPrice = (price: StringOrNum): void => {
    if(typeof price === 'string'){
        itemPrice = 0;
    } else{
        itemPrice = price;
    } 
};*/
const setItemPrice = (price: StringOrNum): void => {
    itemPrice = price;
};

setItemPrice(50);
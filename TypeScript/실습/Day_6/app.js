/* any 타입 */
var someValue = 5; // 어떠한 타입이든 모두 ok
someValue = 'hello';
someValue = true;
/* 유니언 타입 */
var price = 5;
price = 'free';
price = true;
var totalCost;
var orderID;
var calculateTotalCost = function (price, qty) {
};
var findOrderID = function (customer, productID) {
    return orderID;
};
var itemPrice;
/*
const setItemPrice = (price: StringOrNum): void => {
    if(typeof price === 'string'){
        itemPrice = 0;
    } else{
        itemPrice = price;
    }
};*/
var setItemPrice = function (price) {
    itemPrice = price;
};
setItemPrice(50);

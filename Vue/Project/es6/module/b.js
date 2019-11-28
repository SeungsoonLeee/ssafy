function hello(){
    console.log('하이!')
}

function sum(num1, num2){
    return num1 + num2
}

let person = {name:'싸피', age:2};

export {hello, sum, person};

export default{ // 기본으로 내보낼 애들
    name : '서유리'
    ,gender : 'F'
}
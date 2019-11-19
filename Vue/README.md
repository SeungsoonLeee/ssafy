# Vue

## 1. Vue  
Front-End에 적용할 수 있는 프레임워크.  
jQuery 등이 작업했던 화면의 데이터나 동적 처리 기능(함수) 등을 컴포넌트화 하여 제공.  
※ <b>Component</b> : UI를 구성하는 각각의 부품의 개념. UI상에 같은 부분을 재사용하고 싶은 경우 component화 하여 재사용 할 수 있다.  

### 1.1. Vue 폴더 구조  
>[Project]  
>> [node_modules] 외부 모듈  
>>> xxx.js  

>> [public] 싱글 페이지  
>>> index.html  

>> [src]  
>>> [component] 각각의 컴포넌트 파일  
>>>> xxx.vue  

>>> App.vue  
>>> Main.js  


## 2. Vue 컴포넌트 간 데이터통신

### 2.1. Event Bus  
모든 component들이 공유해서 사용
- on() : 수신할 이벤트 버스 연결 => $on.('이벤트 명', callback 할 함수)  
- emit() :   송신할 이벤트 버스 연결 => $emit.('이벤트 명')  

### 2.2. parent - child 통신  
Parent component와 Child component가 event를 주고 받음.
- Parent -> Child : props()로 데이터 전달  
- Child -> Parent : emit()로 이벤트를 발생시켜 전달. 자기 자신에게 emit하면 부모에게 이벤트를 보낸다는 의미.  
ex) this.$emit('이벤트명', [송신할 데이터])

### 2.2. parent - VueX  

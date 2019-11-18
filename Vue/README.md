# VUe

## 1. Vue  

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

### 1.2. Event Bus  
모든 component들이 공유해서 사용
- on() : 수신할 이벤트 버스 연결 => $on.('이벤트 명', callback 할 함수)  
- emit() :   송신할 이벤트 버스 연결 => $emit.('이벤트 명')  

### 1.3. parent - child 통신  
Parent component와 Child component가 event를 주고 받음.
- Parent -> Child : props()로 데이터 전달  
- Child -> Parent : emit()로 이벤트를 발생시켜 전달  


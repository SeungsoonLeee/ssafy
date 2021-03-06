## 해싱(Hashing)  
특정 항목을 검색하고자 할때, 탐색키를 이용한 산술적 연산을 이용해 키가 있는 위치를 계산하여 바로 찾아가는 방법  
- 해시 함수(hash function) : 탐색키를 항목의 위치로 변환  
- 해시 테이블(hash table) : 해싱 함수에 의해 변환된 주소의 위치에 항목을 저장한 표  

### 해시 검색 과정  
1. 해시 함수에 탐색키를 입력  
2. 주소를 구함  
3. 해시테이블로 이동  
4. 해당주소에 원하는 항목이 있으면 검색 성공, 없으면 실패  

### 충돌(Collision)  
- 서로 다른 탐색키를 해시 함수에 정용하였는데, 반환된 해시 주소는 동일한 경우  
- 해시 함수가 아무리 해시 주소를 다르게 분배하려고 해도, 해시 테이블에 저장되는 자료의 수가 증가하면 충돌은 불가피하다.  

### 충돌 해결방법
**1. 개발 주소법  (open addressing)**

```
- 해시 함수로 구한 주소에 빈 공간이 없어 충돌이 발생하면, 그 다음 공간에 빈 공간이 있는지 조사  
- 빈 공간이 있으면 탐색키에 대한 항목 저장, 없으면 공간이 나올때까지 탐색 반복
```
  
**2. 체이닝(chaining)**

```
- 해시 테이블의 구조를 변경하여 각 버킷에 하나 이상의 키 값을 가지는 자료가 저장될 수 있도록 하는 방법  
- 하나의 버킷에 여러개의 키값을 저장하기 위해 연결리스트를 활용  
```


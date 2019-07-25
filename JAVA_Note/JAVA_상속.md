##상속(Inheritance)
class 설계 시 특정 class를 상속받아 그 class의 data와 method를 사용할 수 있다.<br>
- 모든 속성과 모든 메서드를 상속받음
- 단일 상속만 지원
- 생성자는 상속되지 않지만 호출은 가능
- 재사용과 변경(속성 추가, 기능 추가 등)이 가능

**1. class 상속**

```
class명 extends [상속할 class명] {
 . . .
}
```

**2. interface 상속**

```
class명 implements [상속할 class명1], [상속할 class명2] . . . {
 . . .
}
```
ThreadLocal을 사용할 경우 다른 Thread에게 값을 전달할 수 없다.

이럼 문제를 해결하려면 InheritableThreadLocal 을 사용한다.

스프링에서 제공하는 NamedInheritableThreadLocal 을 사용할 수 있으며,

예제코드는 LocaleContextHolder 을 참고하면 좋다.

Spring Security에서 @Async 에서 정보를 접근하려면 다음과 같이 명령을 수행한다.

https://www.baeldung.com/spring-security-async-principal-propagation?fbclid=IwAR0N-MV1XbtUBrwWHfd0lxHaH-v5iIbEJe5hz-_W3IZtHRHxfDSI_XiU7XA
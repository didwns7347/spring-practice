package com.bit;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters =  @Filter(type = FilterType.ANNOTATION, classes =
                Configuration.class)
)
/*
컴포넌트 스캔을 사용하면 @Configuration 이 붙은 설정 정보도 자동으로 등록이 된다.
AppConfig, TestConfig 등 앞서 만들어 두었던 설정 정보도 함깨 등록되고, 실행되어 버린다.
그래서 excludeFilters를 이용해서 설정정보는 컴포넌트 스켄 대상에서 제외했다. 보통 설정 정보를 컴포넌트
스켄 대상에서 제외하지 않지만, 기존 예제 코드를 최대한 남기고 유지하기 위해서 이 방법을 선택했다.
 */
public class AutoAppConfig {
}

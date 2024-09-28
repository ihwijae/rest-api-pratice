package com.restapi_practice.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseEntity {

    /**
     * private로 선언하면 스프링 데이터 jpa가 접근 할 수 없다
     * protected: 하위 클래스에서 접근 가능하고, JPA도 접근 가능
     */

    @CreationTimestamp
    @Column(updatable = false)
    protected LocalDateTime createAt;

    @UpdateTimestamp
    protected LocalDateTime updateAt;

    @Enumerated(value = EnumType.STRING)
    protected Status status = Status.valueOf(Status.ACTIVE.name());


    // enum은 상수로 정의해서 Status의 타입 안정성을 지킬 수 있다.
    public enum Status  {
        ACTIVE,
        DELETE
    }

    // 타 클래스에서 상태 수정의 가능성이 있으니 public
    public void updateStatus(Status status) {
        this.status = status;
    }
}

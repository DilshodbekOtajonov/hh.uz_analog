package com.example.resume_service.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/20/2022 6:46 PM (Thursday)
 * Resume_service/IntelliJ IDEA
 */

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @MappedSuperclass
    @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
    public class Auditable {
        protected Timestamp createdAt = Timestamp.valueOf ( LocalDateTime.now () );
        protected Timestamp updatedAt;
        protected Long createdBy;
        protected Long updatedBy;
        protected boolean deleted = false;


}

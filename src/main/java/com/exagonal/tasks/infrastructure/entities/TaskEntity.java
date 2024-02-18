package com.exagonal.tasks.infrastructure.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {

    @EmbeddedId
    private EntityId id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private boolean completed;
}

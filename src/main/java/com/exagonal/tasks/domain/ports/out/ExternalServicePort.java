package com.exagonal.tasks.domain.ports.out;

import com.exagonal.tasks.domain.model.AdditionalTaskInfo;

public interface ExternalServicePort {
    AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);
}

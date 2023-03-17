package com.exagonal.tasks.domain.ports.in;

import com.exagonal.tasks.domain.model.AdditionalTaskInfo;

public interface GetAdditionalTaskInfoUseCase {
    AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);
}

package com.exagonal.tasks.application.usecases;

import com.exagonal.tasks.domain.model.AdditionalTaskInfo;
import com.exagonal.tasks.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.exagonal.tasks.domain.ports.out.ExternalServicePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase {

    private final ExternalServicePort externalServicePort;

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
        return externalServicePort.getAdditionalTaskInfo(taskId);
    }
}

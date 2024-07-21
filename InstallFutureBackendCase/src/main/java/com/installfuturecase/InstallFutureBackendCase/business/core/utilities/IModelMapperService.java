package com.installfuturecase.InstallFutureBackendCase.business.core.utilities;

import org.modelmapper.ModelMapper;

public interface IModelMapperService {
    ModelMapper forResponse();
    ModelMapper forRequest();
}

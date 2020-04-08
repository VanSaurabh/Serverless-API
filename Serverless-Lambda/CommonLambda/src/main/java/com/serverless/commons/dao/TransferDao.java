package com.serverless.commons.dao;

import com.serverless.commons.model.TransferDetail;
import org.springframework.data.repository.CrudRepository;

public interface TransferDao extends CrudRepository<TransferDetail, Long> {
}

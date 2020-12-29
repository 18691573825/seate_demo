package cn.cloud.sample.service;

import cn.cloud.sample.dao.StorageDao;
import io.seata.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author IT云清
 */
@Service("storageServiceImpl")
public class StorageServiceImpl implements StorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Autowired
    private StorageDao storageDao;

    /**
     * 扣减库存
     * @param productId 产品id
     * @param count 数量
     * @return
     */
    @Override
    public void decrease(Long productId, Integer count, String xid) {
        Object xid1 = RootContext.getXID();
        LOGGER.info("------->扣减库存开始:Xid={}", xid1);
        storageDao.decrease(productId,count);
        LOGGER.info("------->扣减库存结束:Xid={}", xid1);
    }
}

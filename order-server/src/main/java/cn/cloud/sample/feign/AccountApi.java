package cn.cloud.sample.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author IT云清
 */
@FeignClient(value = "account-server")
public interface AccountApi {

    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 金额
     * @param xid
     * @return
     */
    @RequestMapping("/account/decrease")
    String decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money,@RequestParam("xid")String xid);
}

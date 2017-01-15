package com.tesobe.obp.api;

import com.tesobe.obp.domain.ATM;
import com.tesobe.obp.domain.Bank;
import com.tesobe.obp.domain.Branch;
import lombok.Data;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name="bank", url="${obp.api.versionedUrl}")
public interface ObpBankMetaApiClient {

    @RequestMapping(method = RequestMethod.GET, value = "banks")
    Banks getBanks();

    @RequestMapping(method = RequestMethod.GET, value = "banks/{bankId}/branches")
    Branches getBranches(@PathVariable("bankId") String bankId);

    @RequestMapping(method = RequestMethod.GET, value = "banks/{bankId}/branches/{branchId}")
    Branch getBranch(@PathVariable("bankId") String bankId, @PathVariable("branchId") String branchId);

    @RequestMapping(method = RequestMethod.GET, value = "banks/{bankId}/atms")
    ATMs getAtms(@PathVariable("bankId") String bankId);

    @RequestMapping(method = RequestMethod.GET, value = "banks/{bankId}/branches/{branchId}/atms/{atmId}")
    Branch getAtm(@PathVariable("bankId") String bankId, @PathVariable("branchId") String branchId, @PathVariable("atmId") String atmId);

    @Data
    class Banks {
        private List<Bank> banks;
    }

    @Data
    class ATMs {
        private List<ATM> atms;
    }

    @Data
    class Branches {
        private List<Branch> branches;
    }

}

package com.cainiao.exclusive.dubbo.manage;

import com.bestpay.voucher.manage.api.model.DistributeVoucherResult;
import com.bestpay.voucher.manage.api.model.VoucherResponse;
import com.cainiao.exclusive.dubbo.util.AbstractServiceMock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangkecheng on 2018/5/28.
 */
public class RecvCouponImpl extends AbstractServiceMock {
    @Override
    public Object mockerDefiniton(String s, String[] strings, Object[] objects) {
        VoucherResponse<List<DistributeVoucherResult>> response = new VoucherResponse<>();

        List<DistributeVoucherResult> list = new ArrayList<>();

        DistributeVoucherResult distributeVoucherResult = new DistributeVoucherResult();
        distributeVoucherResult.setVoucherType("1");
        distributeVoucherResult.setVoucherNo("20180529202023");
        distributeVoucherResult.setVoucherDistributeDate("2018-05-29 20:20:23");
        distributeVoucherResult.setVoucherStartDate("2018-05-29 20:20:23");
        distributeVoucherResult.setVoucherEndDate("2018-06-29 20:20:23");

        DistributeVoucherResult distributeVoucherResult1 = new DistributeVoucherResult();
        distributeVoucherResult1.setVoucherType("1");
        distributeVoucherResult1.setVoucherNo("20180529202024");
        distributeVoucherResult1.setVoucherDistributeDate("2018-05-29 20:20:24");
        distributeVoucherResult1.setVoucherStartDate("2018-05-29 20:20:23");
        distributeVoucherResult1.setVoucherEndDate("2018-06-29 20:20:23");
        distributeVoucherResult1.setVoucherName("自测");

        list.add(distributeVoucherResult);
        list.add(distributeVoucherResult1);
        //response.setErrorCode("000024");
        response.setResult(list);
        return response;
    }
}

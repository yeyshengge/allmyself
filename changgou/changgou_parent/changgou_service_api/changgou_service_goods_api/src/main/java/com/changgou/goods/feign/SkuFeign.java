package com.changgou.goods.feign;

import com.changgou.entity.Result;
import com.changgou.goods.pojo.Sku;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zps on 2020/1/12 9:00
 */
@FeignClient(name = "goods")
public interface SkuFeign {

    /**
     * 跟据spuId查询sku信息
     *
     * @param spuId
     * @return
     */
    @GetMapping(value = "/sku/spu/{spuId}")
    public List<Sku> findList(@PathVariable("spuId") String spuId);

    /**
     * 根据skuId查询sku信息
     *
     * @param id
     * @return
     */
    @GetMapping("/sku/{id}")
    public Result<Sku> findById(@PathVariable String id);

    /**
     * 扣减库存数增加销量
     *
     * @param username
     * @return
     */
    @PostMapping("/sku/decr/count")
    public Result decrCount(@RequestParam(value = "username") String username);

    /**
     * 回滚库存
     *
     * @param skuId
     * @param num
     * @return
     */
    @RequestMapping("/sku/resumeStockNum")
    public Result resumeStockNum(@RequestParam("skuId") String skuId, @RequestParam("num") Integer num);


}

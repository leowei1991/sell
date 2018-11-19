package com.xinyan.sell.controller;

import com.xinyan.sell.po.ProductCategory;
import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.service.ProductCategoryService;
import com.xinyan.sell.service.ProductService;
import com.xinyan.sell.utils.ResultVOUtil;
import com.xinyan.sell.vo.ProductInfoVO;
import com.xinyan.sell.vo.ProductVO;
import com.xinyan.sell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 王宸
 * 2018/11/14 18:35
 *
 * 买家端商品
 */
@RequestMapping("/buyer/product")
@RestController
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService categoryService;

    /**买家商品列表
     * @return
     */
    @GetMapping("/list")
    public ResultVO list(){
        //商品信息
        List<ProductInfo> productInfoList = productService.findAll();

        //商品类目
        /**传统方法
        List<Integer> categoryTypeList = new ArrayList<>();
        for (ProductInfo productInfo: productInfoList){
            categoryTypeList.add(productInfo.getCategoryType());
        }*/

        //精简方法（java8才能用）
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType()).collect(Collectors.toList());

        List<ProductCategory> productCategoryList = categoryService
                .findAll(categoryTypeList);

        //拼装数据
        ResultVO resultVO = new ResultVO();
        List<ProductVO> productVOList = new ArrayList<>();

        for (ProductCategory productCategory:productCategoryList){
            ProductVO productVO = new ProductVO();
            //BeanUtils 进行属性的拷贝
//            BeanUtils.copyProperties(productCategory, productVO);

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo: productInfoList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
//                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }

            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

//        resultVO.setCode(0);
//        resultVO.setMsg("成功");
//        resultVO.setData(productVOList);

        return ResultVOUtil.success(productVOList);
    }
}

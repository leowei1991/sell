package com.xinyan.sell.controller;


import com.xinyan.sell.VO.ProductInfoVO;
import com.xinyan.sell.VO.ProductVO;
import com.xinyan.sell.VO.ResultVO;
import com.xinyan.sell.po.ProductCategory;
import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.service.CategoryService;
import com.xinyan.sell.service.ProductService;
import com.xinyan.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * Administrator
 * 2018/11/13 0013
 * 买家端商品展示
 *
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController{
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 买家端商品列表
     * @return
     */
    @RequestMapping("/list")
    public ResultVO list(){
        //测试最外层resultVO
        ResultVO resultVO = new ResultVO();
//        resultVO.setCode(0);
//        resultVO.setMsg("成功");
//
//        //将商品类目和商品信息设置到第二层ResultVO中测试
//        ProductVO productVO = new ProductVO();
//        resultVO.setData(Arrays.asList(productVO));
//
//
//        //将第三层商品信息放在商品类目里面
//        ProductInfoVO productInfoVO = new ProductInfoVO();
//        productVO.setProductInfoVOList(Arrays.asList(productInfoVO));

        //1.查询所有上架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2.查询所有的类目
        //根据上架商品查询类目id
        List<Integer> categoryTypeList = new ArrayList();
        for (ProductInfo productInfo : productInfoList) {
            categoryTypeList.add(productInfo.getCategoryType());
        }
        //查询所有上架商品的类目
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3.数据拼装
        //两层for循环拼装上架商品类目和商品信息
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            //第二层for循环拼接商品信息
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);

        }

        //4.将拼装好的数据放入resultVO对象中
//        resultVO.setCode(0);
//        resultVO.setMsg("成功");
//        resultVO.setData(productVOList);

        //resultvo 单独封装出一个util

        return ResultVOUtil.success(productVOList);
    }

}

package com.netcracker.onlinestore2.domain;

import com.netcracker.onlinestore2.domain.ProductInfo;

import java.util.ArrayList;
import java.util.List;

public class order {
    private List<ProductInfo> productInfoList = new ArrayList<>();
    private int cost;

    public order(List<ProductInfo> productInfoList, int cost) {
        this.productInfoList = productInfoList;
        this.cost = cost;
    }

    public order() {
    }

    public List<ProductInfo> getProductInfoList() {
        return productInfoList;
    }

    public void addProduct(ProductInfo productInfo){
        if (productInfoList.contains(productInfo)){
            int productInd = productInfoList.indexOf(productInfo);
            ProductInfo curProduct = productInfoList.get(productInd);
            int curOrderCount = curProduct.getOrderCount();
            int newOrderCount = curOrderCount + productInfo.getOrderCount();

            curProduct.setOrderCount(curOrderCount + productInfo.getOrderCount());
        }
        else
            productInfoList.add(productInfo);
    }

    public int getCost() {
        calculateTheCost();
        return cost;
    }

    private void calculateTheCost(){
        this.cost = 0;

        if(!productInfoList.isEmpty()){

            for(ProductInfo productInfo: productInfoList){
                int curCost = productInfo.getPrice() * productInfo.getOrderCount();
                this.cost += curCost;
            }
        }
    }
}

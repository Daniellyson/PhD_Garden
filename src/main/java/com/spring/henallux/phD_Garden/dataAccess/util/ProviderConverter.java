package com.spring.henallux.phD_Garden.dataAccess.util;

import com.spring.henallux.phD_Garden.dataAccess.entity.*;
import com.spring.henallux.phD_Garden.model.*;

import java.util.ArrayList;
import java.util.List;

public class ProviderConverter {
    public static UserEntity userModelToUserEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setAuthorities(user.getAuthorities());
        userEntity.setAccountNonExpired(user.isAccountNonExpired());
        userEntity.setAccountNonLocked(user.isAccountNonLocked());
        userEntity.setCredentialsNonExpired(user.isCredentialsNonExpired());
        userEntity.setEnabled(user.isEnabled());
        userEntity.setEmail(user.getEmail());
        userEntity.setFirstname(user.getFirstname());
        userEntity.setLastname(user.getLastname());
        userEntity.setStreet(user.getStreet());
        userEntity.setHouse_number(user.getHouse_number());
        userEntity.setBirthdate(user.getBirthdate());
        userEntity.setLocality(user.getLocality());
        userEntity.setPostalCode(user.getPostalCode());
        userEntity.setPhone(user.getPhone());
        userEntity.setGender(user.getGender());
        return userEntity;
    }

    public static User userEntityToUserModel(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setUsername(userEntity.getUsername());
        user.setPassword(userEntity.getPassword());
        user.setAuthorities(userEntity.getAuthorities());
        user.setAccountNonExpired(userEntity.getAccountNonExpired());
        user.setAccountNonLocked(userEntity.getAccountNonLocked());
        user.setCredentialsNonExpired(userEntity.getCredentialsNonExpired());
        user.setEnabled(userEntity.getEnabled());
        user.setEmail(userEntity.getEmail());
        user.setFirstname(userEntity.getFirstname());
        user.setFirstname(userEntity.getFirstname());
        user.setStreet(userEntity.getStreet());
        user.setHouse_number(userEntity.getHouse_number());
        user.setBirthdate(userEntity.getBirthdate());
        user.setLocality(userEntity.getLocality());
        user.setPostalCode(userEntity.getPostalCode());
        user.setPhone(userEntity.getPhone());
        user.setGender(userEntity.getGender());
        return user;
    }

    public static Product productEntityToProductModel(ProductEntity productEntity) {
        Product product = new Product();
        product.setId(productEntity.getId());
        product.setPrice(productEntity.getPrice());
        product.setStock(productEntity.getStock());
        product.setUrl_image(productEntity.getUrl_image());
        product.setTranslationProducts(translationProductEntityToTranslationProduct(productEntity.getTranslationProductsEntity()));
        product.setDiscounts(discountEntityToDiscount(productEntity.getDiscounts()));

        return product;
    }

    public static ProductEntity productModelToProductEntity(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(product.getId());
        productEntity.setPrice(product.getPrice());
        productEntity.setStock(product.getStock());
        productEntity.setDiscounts(discountToDiscountEntity(product.getDiscounts()));

        return productEntity;
    }

    public static List<TranslationProduct> translationProductEntityToTranslationProduct(List<TranslationProductEntity> translationProductEntities) {
        List<TranslationProduct> translationProducts = new ArrayList<>();

        translationProducts.forEach(translationProduct -> {
            translationProductEntities.forEach(translationProductEntity -> {
                translationProduct.setDescription(translationProductEntity.getDescription());
                translationProduct.setLanguage(languageEntityToLanguage(translationProductEntity.getTranslationProductLanguageEntityID()));
                translationProduct.setProduct_name(translationProductEntity.getProduct_name());
            });
        });

        return translationProducts;
    }

    public static List<TranslationProductEntity> translationProductToTranslationProductEntity(List<TranslationProduct> translationProducts) {
        List<TranslationProductEntity> translationProductEntities = new ArrayList<>();

        translationProductEntities.forEach(translationProductEntity -> {
            translationProducts.forEach(translationProduct -> {
                translationProductEntity.setDescription(translationProduct.getDescription());
                translationProductEntity.setTranslationProductEntityID(productModelToProductEntity(translationProduct.getProduct()));
                translationProductEntity.setTranslationProductLanguageEntityID(languageToLanguageEntity(translationProduct.getLanguage()));
                translationProductEntity.setProduct_name(translationProduct.getProduct_name());
            });
        });

        return translationProductEntities;
    }

    public static List<Discount> discountEntityToDiscount(List<DiscountEntity> discountEntities) {
        List<Discount> discounts = new ArrayList<>();

        discounts.forEach(discount -> {
            discountEntities.forEach(discountEntity -> {
                discount.setId(discountEntity.getId());
                discount.setEndDate(discountEntity.getEndDate());
                discount.setPercentage(discountEntity.getPercentage());
                discount.setStartDate(discountEntity.getStartDate());
            });
        });
        return discounts;
    }

    public static List<DiscountEntity> discountToDiscountEntity(List<Discount> discounts) {
        List<DiscountEntity> discountEntities = new ArrayList<>();

        discountEntities.forEach(discountEntity -> {
            discounts.forEach(discount -> {
                discountEntity.setId(discount.getId());
                discountEntity.setEndDate(discount.getEndDate());
                discountEntity.setPercentage(discount.getPercentage());
                discountEntity.setStartDate(discount.getStartDate());
                discountEntity.setProductEntity(productModelToProductEntity(discount.getProduct()));
            });
        });
        return discountEntities;
    }

    public static Language languageEntityToLanguage(LanguageEntity languageEntity) {
        Language language = new Language();

        language.setId(languageEntity.getId());
        language.setCode(languageEntity.getCode());
        language.setName(languageEntity.getName());
        return  language;
    }

    public static LanguageEntity languageToLanguageEntity(Language language) {
        LanguageEntity languageEntity = new LanguageEntity();

        languageEntity.setId(language.getId());
        languageEntity.setCode(language.getCode());
        languageEntity.setName(language.getName());
        return  languageEntity;
    }


    public static Order orderEntityToOrderModel(OrderEntity orderEntity) {
        Order order = new Order();
        order.setId(orderEntity.getOrderId());
        order.setOrderDate(orderEntity.getCreationDate());
        order.setUser(userEntityToUserModel(orderEntity.getUser()));
        order.setPaid(orderEntity.getPaid());
        return order;
    }

    public static OrderEntity orderModelToOrderEntity(Order order) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(order.getId());
        orderEntity.setCreationDate(order.getOrderDate());
        orderEntity.setUser(userModelToUserEntity(order.getUser()));
        orderEntity.setPaid(order.getPaid());
        return orderEntity;
    }

    public static OrderLine orderLineEntityToOrderLineModel(OrderLineEntity orderLineEntity) {
        OrderLine orderLine = new OrderLine();
        orderLine.setId(orderLineEntity.getOrderLineId());
        orderLine.setOrder(orderEntityToOrderModel(orderLineEntity.getOrder()));
        orderLine.setProduct(productEntityToProductModel(orderLineEntity.getProduct()));
        orderLine.setQuantity(orderLineEntity.getQuantity());
        orderLine.setUnitPrice(orderLineEntity.getUnitPrice());
        return orderLine;
    }

    public static OrderLineEntity orderLineModelToOrderLineEntity(OrderLine orderLine) {
        OrderLineEntity orderLineEntity = new OrderLineEntity();
        orderLineEntity.setOrderLineId(orderLine.getId());
        orderLineEntity.setOrder(orderModelToOrderEntity(orderLine.getOrder()));
        orderLineEntity.setProduct(productModelToProductEntity(orderLine.getProduct()));
        orderLineEntity.setQuantity(orderLine.getQuantity());
        orderLineEntity.setUnitPrice(orderLine.getUnitPrice());
        return orderLineEntity;
    }
}

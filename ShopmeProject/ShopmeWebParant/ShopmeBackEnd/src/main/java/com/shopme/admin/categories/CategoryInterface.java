package com.shopme.admin.categories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.shopme.common.entity.Category;

public interface CategoryInterface extends PagingAndSortingRepository<Category, Integer> {

}

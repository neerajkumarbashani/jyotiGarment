package com.shopme.admin.categories;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.shopme.common.entity.Category;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CategoriesRepositoriesTests {

	@Autowired
CategoryInterface categoriesReposiroty;
	
	List<Category> list=new ArrayList<>();
	
	
	@Test
	public void TestGetXData() {
		
		
		Category cate=new Category("Computers");
				list.add(cate );
		
		
	Category data= (Category) categoriesReposiroty.findAll();
		System.out.println(data);
	}

	
}

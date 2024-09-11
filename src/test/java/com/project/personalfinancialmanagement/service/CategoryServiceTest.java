//package com.project.personalfinancialmanagement.service;
//
//import com.project.personalfinancialmanagement.dto.CategoryDTO;
//import com.project.personalfinancialmanagement.entity.Category;
//import com.project.personalfinancialmanagement.mapper.CategoryMapper;
//import com.project.personalfinancialmanagement.repository.CategoryRepository;
//import com.project.personalfinancialmanagement.repository.UserRepository;
//import com.project.personalfinancialmanagement.service.impl.CategoryServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//
//public class CategoryServiceTest {
//    @Mock
//    private CategoryRepository categoryRepository;
//
//
//    private CategoryService categoryService;
//    private UserRepository userRepository;
//    private CategoryMapper categoryMapper;
//
//
//    @BeforeEach
//    public void setUp() {
//        categoryService = new CategoryServiceImpl(categoryRepository, categoryMapper, userRepository);
//    }
//
////    @Test
////    void testCreate(){
////        CategoryDTO category = new CategoryDTO();
////        category.setCategoryName("Payment");
////        categoryService.create(category);
////        verify(categoryRepository, times(1)).save(any());
////        //verify(categoryRepository, times(1)).save(category);
////    }
////    @Test
////    void testGetCategories(){
////        Category category = new Category();
////        category.setCategoryName("Payment");
////        category.setCategoryId(1L);
////
////        when(categoryRepository.findAll()).thenReturn(new ArrayList<Category>());
////
////        // Act: Calling the service method
////        List<Category> categories = categoryService.getCategories();
////
////        // Assert: Verifying that the returned list is empty
////        assertNotNull(categories);
////        assertTrue(categories.isEmpty());
////
////        // Verify that findAll was called exactly once
////        verify(categoryRepository, times(1)).findAll();
////    }
//
////    @Test
////    void testGetCategoriesWithItems() {
////        // Arrange: Creating a sample category
////        Category category = new Category();
////        category.setCategoryName("Payment");
////        category.setCategoryId(1L);
////
////        List<Category> mockCategories = new ArrayList<>();
////        mockCategories.add(category);
////
////        // Mocking the repository to return a list with one category
////        when(categoryRepository.findAll()).thenReturn(mockCategories);
////
////        // Act: Calling the service method
////        List<Category> categories = categoryService.getCategories();
////
////        // Assert: Verifying that the returned list has one item and it matches the mock data
////        assertNotNull(categories);
////        assertEquals(1, categories.size());
////        assertEquals("Payment", categories.get(0).getCategoryName());
////        assertEquals(1L, categories.get(0).getCategoryId());
////
////        // Verify that findAll was called exactly once
////        verify(categoryRepository, times(1)).findAll();
////    }
//}

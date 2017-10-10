package com.pss.example;

import org.broadleafcommerce.common.classloader.release.ThreadLocalManager;
import org.broadleafcommerce.common.presentation.AdminPresentationAdornedTargetCollection;
import org.broadleafcommerce.core.catalog.domain.CategoryProductXref;
import org.broadleafcommerce.core.catalog.domain.CategoryProductXrefImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductImpl;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class Examples {
    private static ThreadLocal<String> THREAD_LOCAL = ThreadLocalManager.createThreadLocal(String.class, true);
    protected String a;

    @AdminPresentationAdornedTargetCollection(targetObjectProperty = "product")
    @OneToMany(targetEntity = CategoryProductXrefImpl.class)
    protected List<CategoryProductXref> xrefs = new ArrayList<>();

    public void init() throws NoSuchFieldException {
        ProductImpl.class.getDeclaredField("productAttributes");
    }
}

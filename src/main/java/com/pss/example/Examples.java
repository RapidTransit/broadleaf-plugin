package com.pss.example;

import org.broadleafcommerce.common.classloader.release.ThreadLocalManager;
import org.broadleafcommerce.common.presentation.AdminPresentation;
import org.broadleafcommerce.common.presentation.AdminPresentationAdornedTargetCollection;
import static org.broadleafcommerce.common.presentation.client.SupportedFieldType.*;

import org.broadleafcommerce.common.presentation.AdminPresentationMap;
import org.broadleafcommerce.core.catalog.domain.CategoryProductXref;
import org.broadleafcommerce.core.catalog.domain.CategoryProductXrefImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductImpl;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class Examples {
    private static final String A = "product";
    private static ThreadLocal<String> THREAD_LOCAL = ThreadLocalManager.createThreadLocal(String.class, true);
    protected String a;

    @AdminPresentation(fieldType = ADDITIONAL_FOREIGN_KEY)

    @AdminPresentationAdornedTargetCollection(targetObjectProperty = "a")
    @AdminPresentationMap()
    @OneToMany(targetEntity = CategoryProductXrefImpl.class)
    protected List<CategoryProductXref> xrefs = new ArrayList<>();

    public void init() throws NoSuchFieldException {
        ProductImpl.class.getDeclaredField("products");
    }
}

package com.pss.example;

import org.broadleafcommerce.common.classloader.release.ThreadLocalManager;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.AdminPresentation;
import org.broadleafcommerce.common.presentation.AdminPresentationAdornedTargetCollection;
import static org.broadleafcommerce.common.presentation.client.SupportedFieldType.*;

import org.broadleafcommerce.common.presentation.AdminPresentationMap;
import org.broadleafcommerce.core.catalog.domain.*;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.service.handler.CustomPersistenceHandlerAdapter;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Examples extends CustomPersistenceHandlerAdapter {
    private static final String A = "product";
    private static ThreadLocal<String> THREAD_LOCAL = ThreadLocalManager.createThreadLocal(String.class, true);
    protected String a;

    @AdminPresentation(fieldType = ADDITIONAL_FOREIGN_KEY)

    @AdminPresentationAdornedTargetCollection(gridVisibleFields = {"a", "b"})
    @AdminPresentationMap()
    @OneToMany(targetEntity = CategoryProductXrefImpl.class)
    protected List<CategoryProductXref> xrefs = new ArrayList<>();

    public void init(String a) throws NoSuchFieldException {
        // @type
        ProductImpl.class.getDeclaredField("products");
    }

    @Override
    public Boolean canHandleAdd(PersistencePackage persistencePackage) {
        isAssignableFrom(persistencePackage.getCeilingEntityFullyQualifiedClassname(), Sku.class) ;
        return !(!isAssignableFrom(persistencePackage.getCeilingEntityFullyQualifiedClassname(), Sku.class)&& persistencePackage.isTreeCollection())&& persistencePackage.isTreeCollection();
    }

    @Override
    public Entity add(PersistencePackage persistencePackage, DynamicEntityDao dynamicEntityDao, RecordHelper helper) throws ServiceException {
        Map<String, FieldMetadata> map = new HashMap<>();
        map.get("");
        map.get(1);
        return super.add(persistencePackage, dynamicEntityDao, helper);
    }
}

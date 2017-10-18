
import org.broadleafcommerce.common.BroadleafEnumerationType;
import org.broadleafcommerce.common.admin.domain.AdminMainEntity;
import org.broadleafcommerce.common.classloader.release.ThreadLocalManager;
import org.broadleafcommerce.common.extension.ExtensionHandler;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.presentation.*;
import org.broadleafcommerce.common.presentation.override.*;
import org.broadleafcommerce.common.presentation.client.*;
import java.math.*;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
@Entity
public class AdornedReferenceGrid {

    protected Long id;

    @AdminPresentationAdornedTargetCollection(targetObjectProperty="basicEntity", maintainedAdornedTargetFields = {"date"}, gridVisibleFields={"da<caret>"})
    protected List<AdornedEntity> adornedEntity;

}

@Entity
class AdornedEntity{
    protected Long id;
    protected BasicEntity basicEntity;
    protected AdornedReferenceTarget adornedReference;
    protected Date date;

}

@Entity
class BasicEntity {
    protected String name;
    protected String dascription;
}
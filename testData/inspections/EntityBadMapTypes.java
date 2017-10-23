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
public class EntityBadMapTypes {

    @AdminPresentation(fieldType=SupportedFieldType.BOOLEAN)
    protected <warning descr="admin.presentation.supported-field-type.BOOLEAN">short</warning> s1;

    @AdminPresentation(fieldType=SupportedFieldType.BOOLEAN)
    protected <warning descr="admin.presentation.supported-field-type.BOOLEAN">Short</warning> s2;

    @AdminPresentation(fieldType=SupportedFieldType.BOOLEAN)
    protected <warning descr="admin.presentation.supported-field-type.BOOLEAN">int</warning> s3;

    @AdminPresentation(fieldType=SupportedFieldType.BOOLEAN)
    protected <warning descr="admin.presentation.supported-field-type.BOOLEAN">Integer</warning> s4;

    @AdminPresentation(fieldType=SupportedFieldType.BOOLEAN)
    protected <warning descr="admin.presentation.supported-field-type.BOOLEAN">long</warning> s5;

    @AdminPresentation(fieldType=SupportedFieldType.BOOLEAN)
    protected <warning descr="admin.presentation.supported-field-type.BOOLEAN">Long</warning> s6;

    @AdminPresentation(fieldType=SupportedFieldType.BOOLEAN)
    protected <warning descr="admin.presentation.supported-field-type.BOOLEAN">float</warning> s7;

    @AdminPresentation(fieldType=SupportedFieldType.BOOLEAN)
    protected <warning descr="admin.presentation.supported-field-type.BOOLEAN">Float</warning> s8;

    @AdminPresentation(fieldType=SupportedFieldType.BOOLEAN)
    protected <warning descr="admin.presentation.supported-field-type.BOOLEAN">double</warning> s9;

    @AdminPresentation(fieldType=SupportedFieldType.BOOLEAN)
    protected <warning descr="admin.presentation.supported-field-type.BOOLEAN">Double</warning> s10;

    @AdminPresentation(fieldType=SupportedFieldType.BOOLEAN)
    protected <warning descr="admin.presentation.supported-field-type.BOOLEAN">BigDecimal</warning> s11;

    @AdminPresentation(fieldType=SupportedFieldType.BOOLEAN)
    protected <warning descr="admin.presentation.supported-field-type.BOOLEAN">BasicEntity</warning> s12;

    <warning descr="admin.mismatch.presentation">@AdminPresentation(fieldType=SupportedFieldType.BOOLEAN)
    protected <warning descr="admin.presentation.supported-field-type.BOOLEAN">List</warning> s13;</warning>

    <warning descr="admin.mismatch.presentation">@AdminPresentation(fieldType=SupportedFieldType.BOOLEAN)
    protected <warning descr="admin.presentation.supported-field-type.BOOLEAN">Map</warning> s14;</warning>

    @AdminPresentation(fieldType=SupportedFieldType.BOOLEAN)
    protected <warning descr="admin.presentation.supported-field-type.BOOLEAN">Boolean[]</warning> s15;

    <warning descr="admin.mismatch.presentation">@AdminPresentation(fieldType=SupportedFieldType.BOOLEAN)
    protected <warning descr="admin.presentation.supported-field-type.BOOLEAN">List<Boolean></warning> s16;</warning>

    @AdminPresentationMap(forceFreeFormKeys = true, keyClass = String.class, keys =
    @AdminPresentationMapKey(keyName = "A", friendlyKeyName = "a")
    )
    protected <warning descr="admin.presentation.supported-field-type.BOOLEAN">Map<Boolean, Boolean></warning> s17;</warning>

    @AdminPresentation(fieldType=SupportedFieldType.BOOLEAN)
    protected <warning descr="admin.presentation.supported-field-type.BOOLEAN">CharSequence</warning> s18;

    @AdminPresentation(fieldType=SupportedFieldType.BOOLEAN)
    protected <warning descr="admin.presentation.supported-field-type.BOOLEAN">String</warning> s19;

    @AdminPresentation(fieldType=SupportedFieldType.BOOLEAN)
    protected <warning descr="admin.presentation.supported-field-type.BOOLEAN">char</warning> s20;

    @AdminPresentation(fieldType=SupportedFieldType.BOOLEAN)
    protected <warning descr="admin.presentation.supported-field-type.BOOLEAN">Character</warning> s21;

    @AdminPresentation(fieldType=SupportedFieldType.BOOLEAN)
    protected boolean s22;

    @AdminPresentation(fieldType=SupportedFieldType.BOOLEAN)
    protected Boolean s23;
}

@Entity
class BasicEntity {

}
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
public class EntityBadPasswordTypes {

    @AdminPresentation(fieldType=SupportedFieldType.PASSWORD)
    protected <warning descr="admin.presentation.supported-field-type.PASSWORD">short</warning> s1;

    @AdminPresentation(fieldType=SupportedFieldType.PASSWORD)
    protected <warning descr="admin.presentation.supported-field-type.PASSWORD">Short</warning> s2;

    @AdminPresentation(fieldType=SupportedFieldType.PASSWORD)
    protected <warning descr="admin.presentation.supported-field-type.PASSWORD">int</warning> s3;

    @AdminPresentation(fieldType=SupportedFieldType.PASSWORD)
    protected <warning descr="admin.presentation.supported-field-type.PASSWORD">Integer</warning> s4;

    @AdminPresentation(fieldType=SupportedFieldType.PASSWORD)
    protected <warning descr="admin.presentation.supported-field-type.PASSWORD">long</warning> s5;

    @AdminPresentation(fieldType=SupportedFieldType.PASSWORD)
    protected <warning descr="admin.presentation.supported-field-type.PASSWORD">Long</warning> s6;

    @AdminPresentation(fieldType=SupportedFieldType.PASSWORD)
    protected <warning descr="admin.presentation.supported-field-type.PASSWORD">float</warning> s7;

    @AdminPresentation(fieldType=SupportedFieldType.PASSWORD)
    protected <warning descr="admin.presentation.supported-field-type.PASSWORD">Float</warning> s8;

    @AdminPresentation(fieldType=SupportedFieldType.PASSWORD)
    protected <warning descr="admin.presentation.supported-field-type.PASSWORD">double</warning> s9;

    @AdminPresentation(fieldType=SupportedFieldType.PASSWORD)
    protected <warning descr="admin.presentation.supported-field-type.PASSWORD">Double</warning> s10;

    @AdminPresentation(fieldType=SupportedFieldType.PASSWORD)
    protected <warning descr="admin.presentation.supported-field-type.PASSWORD">BigDecimal</warning> s11;

    @AdminPresentation(fieldType=SupportedFieldType.PASSWORD)
    protected <warning descr="admin.presentation.supported-field-type.PASSWORD">BasicEntity</warning> s12;

    <warning descr="admin.mismatch.presentation">@AdminPresentation(fieldType=SupportedFieldType.PASSWORD)
    protected <warning descr="admin.presentation.supported-field-type.PASSWORD">List</warning> s13;</warning>

    <warning descr="admin.mismatch.presentation">@AdminPresentation(fieldType=SupportedFieldType.PASSWORD)
    protected <warning descr="admin.presentation.supported-field-type.PASSWORD">Map</warning> s14;</warning>

    @AdminPresentation(fieldType=SupportedFieldType.PASSWORD)
    protected <warning descr="admin.presentation.supported-field-type.PASSWORD">String[]</warning> s15;

    <warning descr="admin.mismatch.presentation">@AdminPresentation(fieldType=SupportedFieldType.PASSWORD)
    protected <warning descr="admin.presentation.supported-field-type.PASSWORD">List<String></warning> s16;</warning>

    <warning descr="admin.mismatch.presentation">@AdminPresentation(fieldType=SupportedFieldType.PASSWORD)
    protected <warning descr="admin.presentation.supported-field-type.PASSWORD">Map<String, String></warning> s17;</warning>

    @AdminPresentation(fieldType=SupportedFieldType.PASSWORD)
    protected <warning descr="admin.presentation.supported-field-type.PASSWORD">CharSequence</warning> s18;

    @AdminPresentation(fieldType=SupportedFieldType.PASSWORD)
    protected String s19;

    @AdminPresentation(fieldType=SupportedFieldType.PASSWORD)
    protected <warning descr="admin.presentation.supported-field-type.PASSWORD">char</warning> s20;

    @AdminPresentation(fieldType=SupportedFieldType.PASSWORD)
    protected <warning descr="admin.presentation.supported-field-type.PASSWORD">Character</warning> s21;

    @AdminPresentation(fieldType=SupportedFieldType.PASSWORD)
    protected <warning descr="admin.presentation.supported-field-type.PASSWORD">boolean</warning> s22;

    @AdminPresentation(fieldType=SupportedFieldType.PASSWORD)
    protected <warning descr="admin.presentation.supported-field-type.PASSWORD">Boolean</warning> s23;
}

@Entity
class BasicEntity {

}
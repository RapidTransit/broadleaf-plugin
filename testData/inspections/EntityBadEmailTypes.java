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
public class EntityBadEmailTypes {

    @AdminPresentation(fieldType=SupportedFieldType.EMAIL)
    protected <warning descr="admin.presentation.supported-field-type.EMAIL">short</warning> s1;

    @AdminPresentation(fieldType=SupportedFieldType.EMAIL)
    protected <warning descr="admin.presentation.supported-field-type.EMAIL">Short</warning> s2;

    @AdminPresentation(fieldType=SupportedFieldType.EMAIL)
    protected <warning descr="admin.presentation.supported-field-type.EMAIL">int</warning> s3;

    @AdminPresentation(fieldType=SupportedFieldType.EMAIL)
    protected <warning descr="admin.presentation.supported-field-type.EMAIL">Integer</warning> s4;

    @AdminPresentation(fieldType=SupportedFieldType.EMAIL)
    protected <warning descr="admin.presentation.supported-field-type.EMAIL">long</warning> s5;

    @AdminPresentation(fieldType=SupportedFieldType.EMAIL)
    protected <warning descr="admin.presentation.supported-field-type.EMAIL">Long</warning> s6;

    @AdminPresentation(fieldType=SupportedFieldType.EMAIL)
    protected <warning descr="admin.presentation.supported-field-type.EMAIL">float</warning> s7;

    @AdminPresentation(fieldType=SupportedFieldType.EMAIL)
    protected <warning descr="admin.presentation.supported-field-type.EMAIL">Float</warning> s8;

    @AdminPresentation(fieldType=SupportedFieldType.EMAIL)
    protected <warning descr="admin.presentation.supported-field-type.EMAIL">double</warning> s9;

    @AdminPresentation(fieldType=SupportedFieldType.EMAIL)
    protected <warning descr="admin.presentation.supported-field-type.EMAIL">Double</warning> s10;

    @AdminPresentation(fieldType=SupportedFieldType.EMAIL)
    protected <warning descr="admin.presentation.supported-field-type.EMAIL">BigDecimal</warning> s11;

    @AdminPresentation(fieldType=SupportedFieldType.EMAIL)
    protected <warning descr="admin.presentation.supported-field-type.EMAIL">BasicEntity</warning> s12;

    <warning descr="admin.mismatch.presentation">@AdminPresentation(fieldType=SupportedFieldType.EMAIL)
    protected <warning descr="admin.presentation.supported-field-type.EMAIL">List</warning> s13;</warning>

    <warning descr="admin.mismatch.presentation">@AdminPresentation(fieldType=SupportedFieldType.EMAIL)
    protected <warning descr="admin.presentation.supported-field-type.EMAIL">Map</warning> s14;</warning>

    @AdminPresentation(fieldType=SupportedFieldType.EMAIL)
    protected <warning descr="admin.presentation.supported-field-type.EMAIL">String[]</warning> s15;

    <warning descr="admin.mismatch.presentation">@AdminPresentation(fieldType=SupportedFieldType.EMAIL)
    protected <warning descr="admin.presentation.supported-field-type.EMAIL">List<String></warning> s16;</warning>

    <warning descr="admin.mismatch.presentation">@AdminPresentation(fieldType=SupportedFieldType.EMAIL)
    protected <warning descr="admin.presentation.supported-field-type.EMAIL">Map<String, String></warning> s17;</warning>

    @AdminPresentation(fieldType=SupportedFieldType.EMAIL)
    protected <warning descr="admin.presentation.supported-field-type.EMAIL">CharSequence</warning> s18;

    @AdminPresentation(fieldType=SupportedFieldType.EMAIL)
    protected String s19;

    @AdminPresentation(fieldType=SupportedFieldType.EMAIL)
    protected <warning descr="admin.presentation.supported-field-type.EMAIL">char</warning> s20;

    @AdminPresentation(fieldType=SupportedFieldType.EMAIL)
    protected <warning descr="admin.presentation.supported-field-type.EMAIL">Character</warning> s21;

    @AdminPresentation(fieldType=SupportedFieldType.EMAIL)
    protected <warning descr="admin.presentation.supported-field-type.EMAIL">boolean</warning> s22;

    @AdminPresentation(fieldType=SupportedFieldType.EMAIL)
    protected <warning descr="admin.presentation.supported-field-type.EMAIL">Boolean</warning> s23;
}

@Entity
class BasicEntity {

}
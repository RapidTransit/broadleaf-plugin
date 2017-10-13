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
public class EntityBadStringTypes {

    @AdminPresentation(fieldType=SupportedFieldType.STRING)
    protected <warning descr="admin.presentation.supported-field-type.STRING">short</warning> s1;

    @AdminPresentation(fieldType=SupportedFieldType.STRING)
    protected <warning descr="admin.presentation.supported-field-type.STRING">Short</warning> s2;

    @AdminPresentation(fieldType=SupportedFieldType.STRING)
    protected <warning descr="admin.presentation.supported-field-type.STRING">int</warning> s3;

    @AdminPresentation(fieldType=SupportedFieldType.STRING)
    protected <warning descr="admin.presentation.supported-field-type.STRING">Integer</warning> s4;

    @AdminPresentation(fieldType=SupportedFieldType.STRING)
    protected <warning descr="admin.presentation.supported-field-type.STRING">long</warning> s5;

    @AdminPresentation(fieldType=SupportedFieldType.STRING)
    protected <warning descr="admin.presentation.supported-field-type.STRING">Long</warning> s6;

    @AdminPresentation(fieldType=SupportedFieldType.STRING)
    protected <warning descr="admin.presentation.supported-field-type.STRING">float</warning> s7;

    @AdminPresentation(fieldType=SupportedFieldType.STRING)
    protected <warning descr="admin.presentation.supported-field-type.STRING">Float</warning> s8;

    @AdminPresentation(fieldType=SupportedFieldType.STRING)
    protected <warning descr="admin.presentation.supported-field-type.STRING">double</warning> s9;

    @AdminPresentation(fieldType=SupportedFieldType.STRING)
    protected <warning descr="admin.presentation.supported-field-type.STRING">Double</warning> s10;

    @AdminPresentation(fieldType=SupportedFieldType.STRING)
    protected <warning descr="admin.presentation.supported-field-type.STRING">BigDecimal</warning> s11;

    @AdminPresentation(fieldType=SupportedFieldType.STRING)
    protected <warning descr="admin.presentation.supported-field-type.STRING">BasicEntity</warning> s12;

    <warning descr="admin.mismatch.presentation">@AdminPresentation(fieldType=SupportedFieldType.STRING)
    protected <warning descr="admin.presentation.supported-field-type.STRING">List</warning> s13;</warning>

    <warning descr="admin.mismatch.presentation">@AdminPresentation(fieldType=SupportedFieldType.STRING)
    protected <warning descr="admin.presentation.supported-field-type.STRING">Map</warning> s14;</warning>

    @AdminPresentation(fieldType=SupportedFieldType.STRING)
    protected <warning descr="admin.presentation.supported-field-type.STRING">String[]</warning> s15;

    <warning descr="admin.mismatch.presentation">@AdminPresentation(fieldType=SupportedFieldType.STRING)
    protected <warning descr="admin.presentation.supported-field-type.STRING">List<String></warning> s16;</warning>

    <warning descr="admin.mismatch.presentation">@AdminPresentation(fieldType=SupportedFieldType.STRING)
    protected <warning descr="admin.presentation.supported-field-type.STRING">Map<String, String></warning> s17;</warning>

    @AdminPresentation(fieldType=SupportedFieldType.STRING)
    protected <warning descr="admin.presentation.supported-field-type.STRING">CharSequence</warning> s18;

    @AdminPresentation(fieldType=SupportedFieldType.STRING)
    protected String s19;

    @AdminPresentation(fieldType=SupportedFieldType.STRING)
    protected <warning descr="admin.presentation.supported-field-type.STRING">char</warning> s20;

    @AdminPresentation(fieldType=SupportedFieldType.STRING)
    protected <warning descr="admin.presentation.supported-field-type.STRING">Character</warning> s21;

    @AdminPresentation(fieldType=SupportedFieldType.STRING)
    protected <warning descr="admin.presentation.supported-field-type.STRING">boolean</warning> s22;

    @AdminPresentation(fieldType=SupportedFieldType.STRING)
    protected <warning descr="admin.presentation.supported-field-type.STRING">Boolean</warning> s23;
}

@Entity
class BasicEntity {

}
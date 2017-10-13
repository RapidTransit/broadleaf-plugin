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
public class EntityBadDecimalTypes {

    @AdminPresentation(fieldType=SupportedFieldType.DECIMAL)
    protected <warning descr="admin.presentation.supported-field-type.DECIMAL">short</warning> s1;

    @AdminPresentation(fieldType=SupportedFieldType.DECIMAL)
    protected <warning descr="admin.presentation.supported-field-type.DECIMAL">Short</warning> s2;

    @AdminPresentation(fieldType=SupportedFieldType.DECIMAL)
    protected <warning descr="admin.presentation.supported-field-type.DECIMAL">int</warning> s3;

    @AdminPresentation(fieldType=SupportedFieldType.DECIMAL)
    protected <warning descr="admin.presentation.supported-field-type.DECIMAL">Integer</warning> s4;

    @AdminPresentation(fieldType=SupportedFieldType.DECIMAL)
    protected <warning descr="admin.presentation.supported-field-type.DECIMAL">long</warning> s5;

    @AdminPresentation(fieldType=SupportedFieldType.DECIMAL)
    protected <warning descr="admin.presentation.supported-field-type.DECIMAL">Long</warning> s6;

    @AdminPresentation(fieldType=SupportedFieldType.DECIMAL)
    protected float s7;

    @AdminPresentation(fieldType=SupportedFieldType.DECIMAL)
    protected Float s8;

    @AdminPresentation(fieldType=SupportedFieldType.DECIMAL)
    protected double s9;

    @AdminPresentation(fieldType=SupportedFieldType.DECIMAL)
    protected Double s10;

    @AdminPresentation(fieldType=SupportedFieldType.DECIMAL)
    protected BigDecimal s11;

    @AdminPresentation(fieldType=SupportedFieldType.DECIMAL)
    protected <warning descr="admin.presentation.supported-field-type.DECIMAL">BasicEntity</warning> s12;

    <warning descr="admin.mismatch.presentation">@AdminPresentation(fieldType=SupportedFieldType.DECIMAL)
    protected <warning descr="admin.presentation.supported-field-type.DECIMAL">List</warning> s13;</warning>

    <warning descr="admin.mismatch.presentation">@AdminPresentation(fieldType=SupportedFieldType.DECIMAL)
    protected <warning descr="admin.presentation.supported-field-type.DECIMAL">Map</warning> s14;</warning>

    @AdminPresentation(fieldType=SupportedFieldType.DECIMAL)
    protected <warning descr="admin.presentation.supported-field-type.DECIMAL">Double[]</warning> s15;

    <warning descr="admin.mismatch.presentation">@AdminPresentation(fieldType=SupportedFieldType.DECIMAL)
    protected <warning descr="admin.presentation.supported-field-type.DECIMAL">List<Double></warning> s16;</warning>

    <warning descr="admin.mismatch.presentation">@AdminPresentation(fieldType=SupportedFieldType.DECIMAL)
    protected <warning descr="admin.presentation.supported-field-type.DECIMAL">Map<Double, Double></warning> s17;</warning>

    @AdminPresentation(fieldType=SupportedFieldType.DECIMAL)
    protected <warning descr="admin.presentation.supported-field-type.DECIMAL">CharSequence</warning> s18;

    @AdminPresentation(fieldType=SupportedFieldType.DECIMAL)
    protected <warning descr="admin.presentation.supported-field-type.DECIMAL">String</warning> s19;

    @AdminPresentation(fieldType=SupportedFieldType.DECIMAL)
    protected <warning descr="admin.presentation.supported-field-type.DECIMAL">char</warning> s20;

    @AdminPresentation(fieldType=SupportedFieldType.DECIMAL)
    protected <warning descr="admin.presentation.supported-field-type.DECIMAL">Character</warning> s21;

    @AdminPresentation(fieldType=SupportedFieldType.DECIMAL)
    protected <warning descr="admin.presentation.supported-field-type.DECIMAL">boolean</warning> s22;

    @AdminPresentation(fieldType=SupportedFieldType.DECIMAL)
    protected <warning descr="admin.presentation.supported-field-type.DECIMAL">Boolean</warning> s23;
}

@Entity
class BasicEntity {

}
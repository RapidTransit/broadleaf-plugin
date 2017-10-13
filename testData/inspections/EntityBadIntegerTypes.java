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
public class EntityBadIntegerTypes {

    @AdminPresentation(fieldType=SupportedFieldType.INTEGER)
    protected <warning descr="admin.presentation.supported-field-type.INTEGER">short</warning> s1;

    @AdminPresentation(fieldType=SupportedFieldType.INTEGER)
    protected <warning descr="admin.presentation.supported-field-type.INTEGER">Short</warning> s2;

    @AdminPresentation(fieldType=SupportedFieldType.INTEGER)
    protected int s3;

    @AdminPresentation(fieldType=SupportedFieldType.INTEGER)
    protected Integer s4;

    @AdminPresentation(fieldType=SupportedFieldType.INTEGER)
    protected long s5;

    @AdminPresentation(fieldType=SupportedFieldType.INTEGER)
    protected Long s6;

    @AdminPresentation(fieldType=SupportedFieldType.INTEGER)
    protected float s7;

    @AdminPresentation(fieldType=SupportedFieldType.INTEGER)
    protected <warning descr="admin.presentation.supported-field-type.INTEGER">Float</warning> s8;

    @AdminPresentation(fieldType=SupportedFieldType.INTEGER)
    protected double s9;

    @AdminPresentation(fieldType=SupportedFieldType.INTEGER)
    protected <warning descr="admin.presentation.supported-field-type.INTEGER">Double</warning> s10;

    @AdminPresentation(fieldType=SupportedFieldType.INTEGER)
    protected <warning descr="admin.presentation.supported-field-type.INTEGER">BigDecimal</warning> s11;

    @AdminPresentation(fieldType=SupportedFieldType.INTEGER)
    protected <warning descr="admin.presentation.supported-field-type.INTEGER">BasicEntity</warning> s12;

    <warning descr="admin.mismatch.presentation">@AdminPresentation(fieldType=SupportedFieldType.INTEGER)
    protected <warning descr="admin.presentation.supported-field-type.INTEGER">List</warning> s13;</warning>

    <warning descr="admin.mismatch.presentation">@AdminPresentation(fieldType=SupportedFieldType.INTEGER)
    protected <warning descr="admin.presentation.supported-field-type.INTEGER">Map</warning> s14;</warning>

    @AdminPresentation(fieldType=SupportedFieldType.INTEGER)
    protected <warning descr="admin.presentation.supported-field-type.INTEGER">Long[]</warning> s15;

    <warning descr="admin.mismatch.presentation">@AdminPresentation(fieldType=SupportedFieldType.INTEGER)
    protected <warning descr="admin.presentation.supported-field-type.INTEGER">List<Long></warning> s16;</warning>

    <warning descr="admin.mismatch.presentation">@AdminPresentation(fieldType=SupportedFieldType.INTEGER)
    protected <warning descr="admin.presentation.supported-field-type.INTEGER">Map<Long, Long></warning> s17;</warning>

    @AdminPresentation(fieldType=SupportedFieldType.INTEGER)
    protected <warning descr="admin.presentation.supported-field-type.INTEGER">CharSequence</warning> s18;

    @AdminPresentation(fieldType=SupportedFieldType.INTEGER)
    protected <warning descr="admin.presentation.supported-field-type.INTEGER">String</warning> s19;

    @AdminPresentation(fieldType=SupportedFieldType.INTEGER)
    protected <warning descr="admin.presentation.supported-field-type.INTEGER">char</warning> s20;

    @AdminPresentation(fieldType=SupportedFieldType.INTEGER)
    protected <warning descr="admin.presentation.supported-field-type.INTEGER">Character</warning> s21;

    @AdminPresentation(fieldType=SupportedFieldType.INTEGER)
    protected <warning descr="admin.presentation.supported-field-type.INTEGER">boolean</warning> s22;

    @AdminPresentation(fieldType=SupportedFieldType.INTEGER)
    protected <warning descr="admin.presentation.supported-field-type.INTEGER">Boolean</warning> s23;
}

@Entity
class BasicEntity {

}
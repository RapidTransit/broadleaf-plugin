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
import org.hibernate.annotations.Type;
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
public class EntityBadDescriptionTypes {

    @AdminPresentation(fieldType=SupportedFieldType.DESCRIPTION)
    protected <warning descr="admin.presentation.supported-field-type.DESCRIPTION.type">short</warning> s1;

    @AdminPresentation(fieldType=SupportedFieldType.DESCRIPTION)
    protected <warning descr="admin.presentation.supported-field-type.DESCRIPTION.type">Short</warning> s2;

    @AdminPresentation(fieldType=SupportedFieldType.DESCRIPTION)
    protected <warning descr="admin.presentation.supported-field-type.DESCRIPTION.type">int</warning> s3;

    @AdminPresentation(fieldType=SupportedFieldType.DESCRIPTION)
    protected <warning descr="admin.presentation.supported-field-type.DESCRIPTION.type">Integer</warning> s4;

    @AdminPresentation(fieldType=SupportedFieldType.DESCRIPTION)
    protected <warning descr="admin.presentation.supported-field-type.DESCRIPTION.type">long</warning> s5;

    @AdminPresentation(fieldType=SupportedFieldType.DESCRIPTION)
    protected <warning descr="admin.presentation.supported-field-type.DESCRIPTION.type">Long</warning> s6;

    @AdminPresentation(fieldType=SupportedFieldType.DESCRIPTION)
    protected <warning descr="admin.presentation.supported-field-type.DESCRIPTION.type">float</warning> s7;

    @AdminPresentation(fieldType=SupportedFieldType.DESCRIPTION)
    protected <warning descr="admin.presentation.supported-field-type.DESCRIPTION.type">Float</warning> s8;

    @AdminPresentation(fieldType=SupportedFieldType.DESCRIPTION)
    protected <warning descr="admin.presentation.supported-field-type.DESCRIPTION.type">double</warning> s9;

    @AdminPresentation(fieldType=SupportedFieldType.DESCRIPTION)
    protected <warning descr="admin.presentation.supported-field-type.DESCRIPTION.type">Double</warning> s10;

    @AdminPresentation(fieldType=SupportedFieldType.DESCRIPTION)
    protected <warning descr="admin.presentation.supported-field-type.DESCRIPTION.type">BigDecimal</warning> s11;

    @AdminPresentation(fieldType=SupportedFieldType.DESCRIPTION)
    protected <warning descr="admin.presentation.supported-field-type.DESCRIPTION.type">BasicEntity</warning> s12;

    <warning descr="admin.mismatch.presentation">@AdminPresentation(fieldType=SupportedFieldType.DESCRIPTION)
    protected <warning descr="admin.presentation.supported-field-type.DESCRIPTION.type">List</warning> s13;</warning>

    <warning descr="admin.mismatch.presentation">@AdminPresentation(fieldType=SupportedFieldType.DESCRIPTION)
    protected <warning descr="admin.presentation.supported-field-type.DESCRIPTION.type">Map</warning> s14;</warning>

    @AdminPresentation(fieldType=SupportedFieldType.DESCRIPTION)
    protected <warning descr="admin.presentation.supported-field-type.DESCRIPTION.type">String[]</warning> s15;

    <warning descr="admin.mismatch.presentation">@AdminPresentation(fieldType=SupportedFieldType.DESCRIPTION)
    protected <warning descr="admin.presentation.supported-field-type.DESCRIPTION.type">List<String></warning> s16;</warning>

    <warning descr="admin.mismatch.presentation">@AdminPresentation(fieldType=SupportedFieldType.DESCRIPTION)
    protected <warning descr="admin.presentation.supported-field-type.DESCRIPTION.type">Map<String, String></warning> s17;</warning>

    @AdminPresentation(fieldType=SupportedFieldType.DESCRIPTION)
    protected <warning descr="admin.presentation.supported-field-type.DESCRIPTION.type">CharSequence</warning> s18;

    @AdminPresentation(fieldType=SupportedFieldType.DESCRIPTION)
    protected <warning descr="admin.presentation.supported-field-type.DESCRIPTION.lob"><warning descr="admin.presentation.supported-field-type.DESCRIPTION.user-type">String</warning></warning> s19;

    @AdminPresentation(fieldType=SupportedFieldType.DESCRIPTION)
    protected <warning descr="admin.presentation.supported-field-type.DESCRIPTION.type">char</warning> s20;

    @AdminPresentation(fieldType=SupportedFieldType.DESCRIPTION)
    protected <warning descr="admin.presentation.supported-field-type.DESCRIPTION.type">Character</warning> s21;

    @AdminPresentation(fieldType=SupportedFieldType.DESCRIPTION)
    protected <warning descr="admin.presentation.supported-field-type.DESCRIPTION.type">boolean</warning> s22;

    @AdminPresentation(fieldType=SupportedFieldType.DESCRIPTION)
    protected <warning descr="admin.presentation.supported-field-type.DESCRIPTION.type">Boolean</warning> s23;

    @Type(type = "StringClobType")
    @Lob
    @AdminPresentation(fieldType=SupportedFieldType.DESCRIPTION)
    protected String s50;
}

@Entity
class BasicEntity {

}
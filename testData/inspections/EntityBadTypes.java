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

@Entity
public class EntityBadTypes {

    @AdminPresentation(fieldType=SupportedFieldType.STRING)
    protected <warning descr="admin.presentation.supported-field-type.STRING">Long</warning> lw;

    @AdminPresentation(fieldType=SupportedFieldType.STRING)
    protected <warning descr="admin.presentation.supported-field-type.STRING">long</warning> l;

    @AdminPresentation(fieldType=SupportedFieldType.STRING)
    protected <warning descr="admin.presentation.supported-field-type.STRING">BigDecimal</warning> bd;

    @AdminPresentation(fieldType=SupportedFieldType.STRING)
    protected <warning descr="admin.presentation.supported-field-type.STRING">Float</warning> flw;

    @AdminPresentation(fieldType=SupportedFieldType.STRING)
    protected <warning descr="admin.presentation.supported-field-type.STRING">float</warning> fl;

    @AdminPresentation(fieldType=SupportedFieldType.STRING)
    protected String str;

    @AdminPresentation(fieldType=SupportedFieldType.BOOLEAN)
    protected <warning descr="admin.presentation.supported-field-type.BOOLEAN">Long</warning> lw1;

    @AdminPresentation(fieldType=SupportedFieldType.BOOLEAN)
    protected <warning descr="admin.presentation.supported-field-type.BOOLEAN">long</warning> l1;

    @AdminPresentation(fieldType=SupportedFieldType.BOOLEAN)
    protected <warning descr="admin.presentation.supported-field-type.BOOLEAN">BigDecimal</warning> bd1;

    @AdminPresentation(fieldType=SupportedFieldType.BOOLEAN)
    protected <warning descr="admin.presentation.supported-field-type.BOOLEAN">Float</warning> flw1;

    @AdminPresentation(fieldType=SupportedFieldType.BOOLEAN)
    protected <warning descr="admin.presentation.supported-field-type.BOOLEAN">float</warning> fl1;

    @AdminPresentation(fieldType=SupportedFieldType.BOOLEAN)
    protected <warning descr="admin.presentation.supported-field-type.BOOLEAN">String</warning> str1;

    @AdminPresentation(fieldType=SupportedFieldType.BOOLEAN)
    protected Boolean bool1;

    @AdminPresentation(fieldType=SupportedFieldType.BOOLEAN)
    protected boolean bool2;

    @AdminPresentationToOneLookup()
    protected Dummy dummy;

}

interface Dummy {

    Long getId();

    void setId(Long id);

    String getFirstName();

    void setFirstName(String firstName);


}

@Entity
class DummyImpl implements Dummy {


    @Id
    protected Long id;

    @AdminPresentation(fieldType = SupportedFieldType.STRING)
    protected String firstName;


    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }


}

@Entity
class BiggerDummy extends DummyImpl {

    @AdminPresentation(fieldType = SupportedFieldType.BOOLEAN)
    protected Boolean crashTestDummy;

    public Boolean getCrashTestDummy() {
        return crashTestDummy;
    }

    public void setCrashTestDummy(Boolean crashTestDummy) {
        this.crashTestDummy = crashTestDummy;
    }
}

@Entity
class SmarterDummy extends DummyImpl {

    @AdminPresentation(fieldType = SupportedFieldType.STRING)
    protected String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
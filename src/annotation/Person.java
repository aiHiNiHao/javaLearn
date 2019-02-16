package annotation;

import java.lang.annotation.Target;

@Table("lijing")//上面我们提到了，@Table这个注解是给类用的（ElementType.TYPE),是不是解除了上面的疑惑
public class Person {
    @Column("name")
    private String name;

    @Column("address")
    private String address;

    @Column("email")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
